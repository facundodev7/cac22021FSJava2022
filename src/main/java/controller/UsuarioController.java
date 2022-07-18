package controller;

import database.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Usuario;


@WebServlet(name = "UsuarioController", urlPatterns = {"/usuario/*"})
public class UsuarioController extends HttpServlet {

        
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String action = request.getPathInfo();
            UsuarioDAO udao = new UsuarioDAO();
            HttpSession session = request.getSession();
            
            switch (action) {
                case "/loginUser":
                    String username = request.getParameter("username");
                    String password = request.getParameter("password");
                    
                    boolean existeUsuario = udao.login(username, password);
                    session.setAttribute("existeusuario", existeUsuario);
                    
                    Usuario u = new Usuario(username, password);
                    session.setAttribute("usuario", u);
                    
                    response.sendRedirect("/views/user.jsp");
                    break;
                    
                case "/createUser":
                    username = request.getParameter("username");
                    password = request.getParameter("password");
                    String name = request.getParameter("name");
                    String last_name = request.getParameter("last_name");
                    String email = request.getParameter("email");   
                    int uCreado = udao.createUser(username, password, name, last_name, email);
                    session.setAttribute("uCreado", uCreado);
                    response.sendRedirect("/views/userCreado.jsp");
                    break;
                case "/modUser":
                    Usuario uN = (Usuario) session.getAttribute("usuario");
                    Usuario uNF = udao.getUser(uN.getUsername());
                    username = request.getParameter("username");
                    name = request.getParameter("name");
                    last_name = request.getParameter("last_name");
                    email = request.getParameter("email");
                    String id = String.valueOf(uNF.getID());
                    int uMod = udao.modUser(username, name, last_name, email, id);
                    session.setAttribute("uMod", uMod);
                    response.sendRedirect("/views/userModded.jsp");
                    break;
                case "/delUser":
                    Usuario uD = (Usuario) session.getAttribute("usuario");
                    Usuario uDF = udao.getUser(uD.getUsername());
                    String idD = String.valueOf(uDF.getID());
                    int uDel = udao.deleteUser(idD);
                    session.setAttribute("uDel", uDel);
                    response.sendRedirect("/views/userDel.jsp");
                    break;
                    

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
        processRequest(request, response);
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

}
