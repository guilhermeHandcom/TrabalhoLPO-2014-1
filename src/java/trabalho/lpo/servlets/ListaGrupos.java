/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.lpo.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import trabalho.lpo.classes.Grupo;
import trabalho.lpo.db.ConexaoDB;
import trabalho.lpo.db.GrupoDAO;

/**
 *
 * @author taiany.coelho
 */
 @WebServlet(name = "ListaGrupos", urlPatterns = {"/lista-grupo.html"})
public class ListaGrupos extends HttpServlet {

    private static Connection conexao = null;
    private static SimpleDateFormat sdf = null;
    
    public ListaGrupos() throws ServletException 
    {

        try {
            conexao = ConexaoDB.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(trabalho.lpo.servlets.ListaGrupos.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServletException(ex);   //mensagem de erro problema no drive         

        } catch (SQLException ex) {
            Logger.getLogger(trabalho.lpo.servlets.ListaGrupos.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServletException(ex);//msg erro problema conexao
        }

    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Grupo> listaGrupos = getListaGrupos();
        //envia para o jsp exibir as informaçoes para o usuario
        RequestDispatcher despachante = request.getRequestDispatcher("/lista-grupo.jsp");
        request.setAttribute("grupos", listaGrupos);//passando a lista para poder pegar no jsp
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
    
    private List<Grupo> getListaGrupos() throws ServletException
    {
        List<Grupo> listaGrupos = new ArrayList<Grupo>();
        
        try {
            GrupoDAO dao = new GrupoDAO();
            listaGrupos = dao.listTodosGrupos();
        } catch (Exception ex) {
            throw new ServletException("Erro ao executar a operação SQL\n" + ex.getLocalizedMessage());
        }
        
        return listaGrupos;
    }

    }

