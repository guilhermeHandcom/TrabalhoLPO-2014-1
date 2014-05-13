/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalho.lpo.db;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author LARISSA
 */
public class ConexaoDB {
    
     private static Connection conexao = null;
     
    public static Connection getConnection() throws ClassNotFoundException, SQLException
    {
        if(conexao == null)
        {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        System.out.println("Driver carregado com sucesso!"); 
  
        conexao = java.sql.DriverManager.getConnection("jdbc:derby://localhost:1527/trabalholpo", "trabalholpo", "trabalholpo");
        System.out.println("A conexão ao SGBD foi bem sucedida!");    
        }    
        return conexao;
        
    }
    
}
