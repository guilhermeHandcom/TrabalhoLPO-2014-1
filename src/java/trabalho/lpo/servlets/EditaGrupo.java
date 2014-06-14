/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.lpo.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import trabalho.lpo.classes.Grupo;
import trabalho.lpo.db.GrupoDAO;

/**
 *
 * @author taiany.coelho
 */

@WebServlet(name = "EditaGrupo", urlPatterns = {"/edita-grupo.do"})
public class EditaGrupo extends HttpServlet {
    
    //Conexão com o banco
    private static Connection conexao = null;
    private PreparedStatement comando = null;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        
        Integer cod_grupo = Integer.valueOf(request.getParameter("cod_grupo"));
        GrupoDAO dao = new GrupoDAO();
        Grupo grupo = new Grupo();
        grupo = dao.buscaPorCodGrupo(cod_grupo);
        
        RequestDispatcher despachante = request.getRequestDispatcher("/edita-grupo.jsp");
        request.setAttribute("grupo", grupo);//passando a lista para poder pegar no jsp
        despachante.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try 
        {
            processRequest(request, response);
        } catch (Exception ex) 
        {
            Logger.getLogger(EditaGrupo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try 
        {
            processRequest(request, response);
        } catch (Exception ex) 
        {
            Logger.getLogger(EditaGrupo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
