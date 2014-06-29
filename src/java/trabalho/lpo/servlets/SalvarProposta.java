
package trabalho.lpo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "SalvarProposta", urlPatterns = {"/salvar-proposta.do"})
public class SalvarProposta extends HttpServlet {
    
    
    public static PropostaDAO dao = null;

    public SalvarProposta() throws Exception{
        
               try {
           dao = new PropostaDAO();
             
        } catch (Exception ex) {
            throw new ServletException("Erro ao criar o comando SQL");
        }
    }
    
    
 

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
 
        Proposta proposta = new Proposta();
        proposta.setCod_proposta(Integer.parseInt(request.getParameter("cod_proposta")));
        proposta.setNome_user(request.getParameter("nome_user"));
        proposta.setDesejo(request.getParameter("desejo"));
        dao.salvarProposta(proposta);
        
        RequestDispatcher despachante = request.getRequestDispatcher("/salvar-proposta.jsp");
        request.setAttribute("proposta", proposta);//passando a lista para poder pegar no jsp
        despachante.forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(SalvarProposta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(SalvarProposta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    
}
