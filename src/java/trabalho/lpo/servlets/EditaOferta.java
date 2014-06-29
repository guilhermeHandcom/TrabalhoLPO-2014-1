
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
import trabalho.lpo.classes.Oferta;
import trabalho.lpo.db.OfertaDAO;

/**
 *
 * @author guilhermecortes
 */
@WebServlet(name = "EditaOferta", urlPatterns = {"/edita-oferta.do"})
public class EditaOferta extends HttpServlet {
    
    //Conexão com o banco
    private static Connection conexao = null;
    private PreparedStatement comando = null;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        
        Integer cod_oferta = Integer.valueOf(request.getParameter("cod_oferta"));
        OfertaDAO dao = new OfertaDAO();
        Oferta oferta = new Oferta();
        oferta = dao.buscaPorCodOferta(cod_oferta);
        
        RequestDispatcher despachante = request.getRequestDispatcher("/edita-oferta.jsp");
        request.setAttribute("oferta", oferta);//passando a lista para poder pegar no jsp
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
            Logger.getLogger(EditaOferta.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(EditaOferta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
