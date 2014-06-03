/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalho.lpo.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import trabalho.lpo.classes.Proposta;

/**
 *
 * @author LARISSA
 */
public class PropostaDAO {
    
    public static Connection conexao = null;
    private static PreparedStatement comandoCriarProposta;

    public PropostaDAO() throws Exception{
        
        conexao = ConexaoDB.getConnection();
        comandoCriarProposta = conexao.prepareStatement("INSERT INTO proposta (nome_user,desejo) VALUES(?,?)");
        
        
    }
    
    //Criar uma Proposta
    
    public void criarProposta(Proposta novaProposta) throws Exception{
        
        comandoCriarProposta.setString(1, novaProposta.getNome_user());
        comandoCriarProposta.setString(2, novaProposta.getDesejo());
        comandoCriarProposta.executeUpdate();
    }
    
    
    
}
