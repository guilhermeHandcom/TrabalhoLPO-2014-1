
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
import trabalho.lpo.classes.Oferta;
import trabalho.lpo.db.OfertaDAO;

/**
 *
 * @author guilhermecortes
 */
@WebServlet(name = "SalvarOferta", urlPatterns = {"/salvar.do"})
public class SalvarOferta extends HttpServlet {
 

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
 
        OfertaDAO dao = new OfertaDAO();
        Oferta oferta = new Oferta();
        oferta.setNome_usuario(request.getParameter("nome_usuario"));
        oferta.setNome_oferta(request.getParameter("nome_oferta"));
        oferta.setNome_produto(request.getParameter("nome_produto"));
        oferta.setDesejo(request.getParameter("desejo"));
        oferta.setCod_oferta(Integer.parseInt(request.getParameter("cod_oferta")));
        dao.salvarOferta(oferta);

        RequestDispatcher despachante = request.getRequestDispatcher("/salvar-oferta.jsp");
        request.setAttribute("oferta", oferta);//passando a lista para poder pegar no jsp
        despachante.forward(request, response);        
        
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(SalvarOferta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(SalvarOferta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    
}
