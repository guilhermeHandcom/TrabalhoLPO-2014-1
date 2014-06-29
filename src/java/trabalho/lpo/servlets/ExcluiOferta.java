/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.lpo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import trabalho.lpo.classes.Oferta;
import trabalho.lpo.db.ConexaoDB;
import trabalho.lpo.db.OfertaDAO;

/**
 *
 * @author guilhermecortes
 */
@WebServlet(name = "ExcluiOferta", urlPatterns = {"/exclui.do"})
public class ExcluiOferta extends HttpServlet {
    private static PreparedStatement comando = null;
    
    private static Connection conexao = null;

    public ExcluiOferta() throws ServletException 
    {
            try 
            {
                conexao = ConexaoDB.getConnection();
            } catch (ClassNotFoundException ex) 
            {
                Logger.getLogger(ListaOfertas.class.getName()).log(Level.SEVERE, null, ex);
                throw new ServletException(ex);   //mensagem de erro problema no drive         

            } catch (SQLException ex) 
            {
                Logger.getLogger(ListaOfertas.class.getName()).log(Level.SEVERE, null, ex);
                throw new ServletException(ex);//msg erro problema conexao
            }
            
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                            
                    try{
           
        Integer cod_oferta = Integer.valueOf(request.getParameter("cod_oferta"));
                    
        OfertaDAO dao = new OfertaDAO();
        Oferta oferta = new Oferta();
        oferta.setCod_oferta(cod_oferta);
        dao.excluirOferta(oferta);
        
        response.sendRedirect("exclui-oferta-resultado.jsp");
       } catch(Exception ex){
           
           throw new ServletException(ex);      
       }
                    
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                    
        RequestDispatcher dispatcher = request.getRequestDispatcher("exclui-oferta-resultado.jsp");
        dispatcher.forward(request, response);
                    
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
