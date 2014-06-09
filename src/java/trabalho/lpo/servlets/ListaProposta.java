
package trabalho.lpo.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "ListaProposta", urlPatterns = {"/lista-proposta.html"})
public class ListaProposta extends HttpServlet {

    private static SimpleDateFormat sdf = null;
    
    public ListaProposta() throws ServletException 
    {
          if(sdf == null)
        {
            sdf = new SimpleDateFormat("d/M/y h:m");
        }

    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Proposta> listaProposta = getListaProposta();
        //envia para o jsp exibir as informaçoes para o usuario
        RequestDispatcher despachante = request.getRequestDispatcher("/lista-proposta.jsp");
        request.setAttribute("propostas", listaProposta);//passando a lista para poder pegar no jsp
        despachante.forward(request, response);
    }
   
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    private List<Proposta> getListaProposta() throws ServletException
    {
        List<Proposta> listaProposta = new ArrayList<Proposta>();
        
        try {
            PropostaDAO dao = new PropostaDAO();
            listaProposta = dao.listarTodas();
        } catch (Exception ex) {
            throw new ServletException("Erro ao executar a operação SQL\n" + ex.getLocalizedMessage());
        }
        
        return listaProposta;
    }
    
}
