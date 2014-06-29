/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalho.lpo.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import trabalho.lpo.classes.Proposta;

/**
 *
 * @author LARISSA
 */
public class PropostaDAO {
    
    public static Connection conexao = null;
    private static PreparedStatement comandoCriarProposta;
    private final PreparedStatement comandoListarProposta;
    private final PreparedStatement comandoBuscaPorCodProposta;
    private final PreparedStatement comandoSalvarProposta;
    private final PreparedStatement comandoExcluirProposta;

    public PropostaDAO() throws Exception{
        
        conexao = ConexaoDB.getConnection();
        comandoCriarProposta = conexao.prepareStatement("INSERT INTO proposta (nome_user,desejo) VALUES(?,?)");
        comandoListarProposta = conexao.prepareStatement("SELECT * FROM proposta");
        comandoBuscaPorCodProposta = conexao.prepareStatement("SELECT * FROM proposta WHERE cod_proposta = ?");
        comandoSalvarProposta = conexao.prepareStatement("UPDATE proposta SET nome_user=?, desejo=? WHERE cod_proposta=?");
        comandoExcluirProposta = conexao.prepareStatement("DELETE FROM proposta WHERE cod_proposta = ?");
    }
    
    //Criar uma Proposta
    
    public void criarProposta(Proposta novaProposta) throws Exception{
        
        comandoCriarProposta.setString(1, novaProposta.getNome_user());
        comandoCriarProposta.setString(2, novaProposta.getDesejo());
        comandoCriarProposta.executeUpdate();
    }
    
    //Listar Propostas
    
    public List<Proposta> listarTodas() throws Exception{
        
        List<Proposta> propostas = new ArrayList<Proposta>(); //criação de uma nova lista de propostas
        ResultSet rs = comandoListarProposta.executeQuery();
        System.out.println("Comando Executado!");
        
        while(rs.next()){
            
            propostas.add(new Proposta(rs.getInt("cod_proposta"),rs.getString("nome_user"),rs.getString("desejo")));    
        }
   
        return propostas;       
    }
    
        //Salvar após editar a Proposta
        public void salvarProposta(Proposta proposta) throws Exception
    {
        comandoSalvarProposta.setString(1, proposta.getNome_user());
        comandoSalvarProposta.setString(2, proposta.getDesejo());
        comandoSalvarProposta.setInt(3, proposta.getCod_proposta());
        comandoSalvarProposta.executeUpdate();
    }
        
    //Excluir proposta
    public void excluirProposta(Proposta novaProposta) throws Exception
    {
        comandoExcluirProposta.setInt(1, novaProposta.getCod_proposta());
        comandoExcluirProposta.executeUpdate();
    }

        //Busca proposta pelo cod_proposta
    public Proposta buscaPorCodProposta(Integer cod_proposta) throws Exception
    {
        Proposta proposta = null;
        comandoBuscaPorCodProposta.setInt(1, cod_proposta);
        ResultSet rs = comandoBuscaPorCodProposta.executeQuery();
        if(rs.next())
        {
            proposta = new Proposta();
            proposta.setCod_proposta(rs.getInt("cod_proposta"));
            proposta.setNome_user(rs.getString("nome_user"));
            proposta.setDesejo(rs.getString("desejo"));
        } else
        {
            throw new Exception("Não existe proposta com o cod_proposta: " + cod_proposta);
        }
        return proposta;
    } 
    

   
}
