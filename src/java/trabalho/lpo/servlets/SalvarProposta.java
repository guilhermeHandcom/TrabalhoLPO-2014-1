
package trabalho.lpo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
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

        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SalvarOferta</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SalvarProposta at " + request.getContextPath() + "</h1>");
            out.println("Usuário: " + proposta.getNome_user());
            out.println("</br>Desejo: " + proposta.getDesejo());
            out.println("</br><a href='lista-proposta.html'>Listar</a>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
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
