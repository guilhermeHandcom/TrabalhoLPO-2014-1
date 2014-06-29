/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
//import trabalho.lpo.db.OfertasDAO;
import trabalho.lpo.classes.Oferta;
import trabalho.lpo.db.OfertaDAO;

/**
 *
 * @author LARISSA
 */
@WebServlet(name = "CriaOferta", urlPatterns = {"/criar-oferta.html"})
public class CriaOferta extends HttpServlet {

    private static OfertaDAO dao = null;
    
    public CriaOferta() throws ServletException {
        
        try
        {
            dao = new OfertaDAO();
        }
        catch(Exception ex)
        { 
           throw new ServletException("Erro ao criar o comando SQL"+ex);
        }
    }

    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastro-oferta.jsp");
        dispatcher.forward(request, response);
      
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try{
           
        Oferta oferta = new Oferta(); 
        oferta.setNome_usuario(request.getParameter("nome_usuario"));
        oferta.setNome_oferta(request.getParameter("nome_oferta"));
        oferta.setNome_produto(request.getParameter("nome_produto"));
        oferta.setDesejo(request.getParameter("desejo"));
        
        
        dao.criarOferta(oferta);
        response.sendRedirect("lista-oferta.html");
       } catch(Exception ex){
           
           throw new ServletException(ex);      
       }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
