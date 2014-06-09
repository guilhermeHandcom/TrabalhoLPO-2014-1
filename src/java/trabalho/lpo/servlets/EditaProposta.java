
package trabalho.lpo.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
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
@WebServlet(name = "EditaProposta", urlPatterns = {"/editar-proposta.do"})
public class EditaProposta extends HttpServlet {
    
    
    private static SimpleDateFormat sdf = null;
    public static PropostaDAO dao = null;

    public EditaProposta() throws Exception{
        
         if(sdf == null)
        {
            sdf = new SimpleDateFormat("d/M/y h:m");
        }
          try {
          dao = new PropostaDAO();
             
        } catch (Exception ex) {
            throw new ServletException("Erro ao criar o comando SQL"+ex);
        }
    }
    

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        
        Integer cod_proposta = Integer.valueOf(request.getParameter("cod_proposta"));
        Proposta proposta = new Proposta();
        proposta = dao.buscaPorCodProposta(cod_proposta);
        
        RequestDispatcher despachante = request.getRequestDispatcher("/edita-proposta.jsp");
        request.setAttribute("proposta", proposta);//passando a lista para poder pegar no jsp
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
            Logger.getLogger(EditaProposta.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(EditaProposta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
