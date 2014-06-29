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
import trabalho.lpo.classes.Grupo;
import trabalho.lpo.db.ConexaoDB;

/**
 *
 * @author curso
 */
public class GrupoDAO {
    
    
    private static Connection conexao = null;
    private static PreparedStatement comandoListarGrupo;
    private static PreparedStatement comandoCriarGrupo;
    private static PreparedStatement comandoExcluirGrupo;
    private static PreparedStatement comandoSalvar;
    private static PreparedStatement comandoBuscaPorCodGrupo;
    
    public GrupoDAO() throws Exception 
    {
        conexao = ConexaoDB.getConnection();
        
        comandoListarGrupo = conexao.prepareStatement("SELECT * FROM grupo"); 
        comandoCriarGrupo = conexao.prepareStatement("INSERT INTO grupo (titulo, descricao, fase) VALUES(?,?,?)");
        comandoExcluirGrupo = conexao.prepareStatement("DELETE FROM grupo WHERE cod_grupo =?");
        comandoSalvar = conexao.prepareStatement("UPDATE grupo SET titulo=?, descricao=?, fase=? WHERE cod_grupo=?");
        comandoBuscaPorCodGrupo = conexao.prepareStatement("SELECT * FROM grupo WHERE cod_grupo = ?");
        
    }
    

     public void criar(Grupo grupoNovo) throws Exception{
        
            comandoCriarGrupo.setString(1, grupoNovo.getTitulo());
            comandoCriarGrupo.setString(2, grupoNovo.getDescricao());
            comandoCriarGrupo.setInt(3, grupoNovo.getFase());
            comandoCriarGrupo.executeUpdate();
     
    }
     
     
 
    public Grupo buscaPorCodGrupo(Integer cod_grupo) throws Exception
    {
        Grupo grupo = null;
        comandoBuscaPorCodGrupo.setInt(1, cod_grupo);
        ResultSet resultado = comandoBuscaPorCodGrupo.executeQuery();
        if(resultado.next())
        {
            grupo = new Grupo();
            grupo.setCodGrupo(resultado.getInt("cod_grupo"));
            grupo.setDescricao(resultado.getString("descricao"));
            grupo.setTitulo(resultado.getString("titulo"));
            grupo.setFase(resultado.getInt("fase"));
        } else
        {
            throw new Exception("Não existe grupo com esse código: " + cod_grupo);
        }
        return grupo;
    }
    
 
    public void excluirGrupo(Grupo novoGrupo) throws Exception
    {
        comandoExcluirGrupo.setInt(1, novoGrupo.getCodGrupo());
        comandoExcluirGrupo.executeUpdate();
    }
    
    //Listar ofertas
    public List<Grupo> listTodosGrupos() throws Exception
    {
        List<Grupo> grupos = new ArrayList<Grupo>();
        ResultSet resultados = comandoListarGrupo.executeQuery();
        System.out.println("Comando Executado!");
        while (resultados.next())
        {
            grupos.add(new Grupo(resultados.getInt("cod_grupo"), resultados.getString("descricao"), resultados.getString("titulo"), resultados.getInt("fase")));
        }
        return grupos;
    }
    
    
    //Editar Gruoo
    public void salvarGrupo(Grupo grupo) throws Exception
    {
        comandoSalvar.setString(1, grupo.getTitulo());
        comandoSalvar.setString(2, grupo.getDescricao());
        comandoSalvar.setInt(3, grupo.getFase());
        comandoSalvar.setInt(4, grupo.getCodGrupo());
        comandoSalvar.executeUpdate();
    }
    
}
