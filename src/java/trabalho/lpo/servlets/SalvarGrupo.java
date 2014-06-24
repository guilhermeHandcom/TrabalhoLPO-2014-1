/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
import trabalho.lpo.classes.Grupo;
import trabalho.lpo.db.GrupoDAO;

/**
 *
 * @author taiany.coelho
 */
@WebServlet(name = "SalvarGrupo", urlPatterns = {"/salvar-grupo.do"})
public class SalvarGrupo extends HttpServlet {
    
    
    public static GrupoDAO dao = null;

    public SalvarGrupo() throws Exception{
        
               try {
           dao = new GrupoDAO();
             
        } catch (Exception ex) {
            throw new ServletException("Erro ao criar o comando SQL");
        }
    }
    
    
 

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
 
        Grupo grupo = new Grupo();
        GrupoDAO dao = new GrupoDAO();
 
        grupo.setTitulo(request.getParameter("titulo"));
        grupo.setDescricao(request.getParameter("descricao"));
        grupo.setFase(Integer.parseInt(request.getParameter("fase")));
        grupo.setCodGrupo(Integer.parseInt(request.getParameter("cod_grupo")));
        dao.salvarGrupo(grupo);

        
        RequestDispatcher despachante = request.getRequestDispatcher("/salvar-grupo.jsp");
        request.setAttribute("grupo", grupo);//passando a lista para poder pegar no jsp
        despachante.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(SalvarGrupo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(SalvarGrupo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    
}
