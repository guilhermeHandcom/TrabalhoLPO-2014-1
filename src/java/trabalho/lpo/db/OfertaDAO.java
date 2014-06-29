/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.lpo.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import trabalho.lpo.classes.Oferta;

/**
 *
 * @author guilhermecortes
 */
public class OfertaDAO 
{
    private static Connection conexao = null;
    private static PreparedStatement comandoListarOferta;
    private static PreparedStatement comandoCriarOferta;
    private static PreparedStatement comandoExcluirOferta;
    private static PreparedStatement comandoSalvar;
    private static PreparedStatement comandoBuscaPorCodOferta;
    
    public OfertaDAO() throws Exception 
    {
        conexao = ConexaoDB.getConnection();
        
        comandoListarOferta = conexao.prepareStatement("SELECT * FROM oferta"); 
        comandoCriarOferta = conexao.prepareStatement("INSERT INTO oferta (nome_oferta, nome_usuario, nome_produto, desejo) VALUES(?,?,?,?)");
        comandoExcluirOferta = conexao.prepareStatement("DELETE FROM oferta WHERE cod_oferta = ?");
        comandoSalvar = conexao.prepareStatement("UPDATE oferta SET nome_oferta=?, nome_usuario=?, nome_produto=?, desejo=? WHERE cod_oferta=?");
        comandoBuscaPorCodOferta = conexao.prepareStatement("SELECT * FROM oferta WHERE cod_oferta = ?");
        
    }
    
    //Listar ofertas
    public List<Oferta> listAll() throws Exception
    {
        List<Oferta> ofertas = new ArrayList<Oferta>();
        ResultSet resultados = comandoListarOferta.executeQuery();
        System.out.println("Comando Executado!");
        while (resultados.next())
        {
            ofertas.add(new Oferta(resultados.getInt("cod_oferta"), resultados.getString("nome_oferta"), resultados.getString("nome_usuario"), resultados.getString("nome_produto"), resultados.getString("desejo")));
        }
        return ofertas;
    }
    
    //Criar oferta
    public void criarOferta(Oferta novaOferta) throws Exception
    {
        comandoCriarOferta.setString(1, novaOferta.getNome_oferta());
        comandoCriarOferta.setString(2, novaOferta.getNome_usuario());
        comandoCriarOferta.setString(3, novaOferta.getNome_produto());
        comandoCriarOferta.setString(4, novaOferta.getDesejo());
        comandoCriarOferta.executeUpdate();
    }
 
    //Excluir oferta
    public void excluirOferta(Oferta novaOferta) throws Exception
    {
        comandoExcluirOferta.setInt(1, novaOferta.getCod_oferta());
        comandoExcluirOferta.executeUpdate();
    }
    
    //Editar oferta
    public void salvarOferta(Oferta oferta) throws Exception
    {
        comandoSalvar.setString(1, oferta.getNome_oferta());
        comandoSalvar.setString(2, oferta.getNome_usuario());
        comandoSalvar.setString(3, oferta.getNome_produto());
        comandoSalvar.setString(4, oferta.getDesejo());
        comandoSalvar.setInt(5, oferta.getCod_oferta());
        comandoSalvar.executeUpdate();
    }
    
    
    //Busca oferta pelo cod_oferta
    public Oferta buscaPorCodOferta(Integer cod_oferta) throws Exception
    {
        Oferta oferta = null;
        comandoBuscaPorCodOferta.setInt(1, cod_oferta);
        ResultSet resultado = comandoBuscaPorCodOferta.executeQuery();
        if(resultado.next())
        {
            oferta = new Oferta();
            oferta.setCod_oferta(resultado.getInt("cod_oferta"));
            oferta.setNome_usuario(resultado.getString("nome_usuario"));
            oferta.setNome_oferta(resultado.getString("nome_oferta"));
            oferta.setNome_produto(resultado.getString("nome_produto"));
            oferta.setDesejo(resultado.getString("desejo"));
        } else
        {
            throw new Exception("Não existe oferta com o cod_oferta: " + cod_oferta);
        }
        return oferta;
    }    
    
    
}
