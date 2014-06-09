/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.lpo.servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import trabalho.lpo.classes.Proposta;
import trabalho.lpo.db.PropostaDAO;

/**
 *
 * @author LARISSA
 */
@WebServlet(name = "ExcluiProposta", urlPatterns = {"/exclui-proposta.do"})
public class ExcluiProposta extends HttpServlet {

    
      private static PropostaDAO dao = null;

    public ExcluiProposta() throws ServletException 
    {
         try {
            dao = new PropostaDAO();
             
        } catch (Exception ex) {
            throw new ServletException("Erro ao criar o comando SQL");
        }
            
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                            
                    try{
           
        Integer cod_proposta = Integer.valueOf(request.getParameter("cod_proposta"));
                    
        Proposta proposta = new Proposta();
        proposta.setCod_proposta(cod_proposta);
        dao.excluirProposta(proposta);
        
        response.sendRedirect("exclui-proposta-resultado.jsp");
       } catch(Exception ex){
           
           throw new ServletException(ex);      
       }
                    
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                    
        RequestDispatcher dispatcher = request.getRequestDispatcher("exclui-proposta-resultado.jsp");
        dispatcher.forward(request, response);
                    
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
