<%@page import="database.UsuarioDAO"%>
<%@page import="model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Borrar</title>
    </head>
    <body>
            <%
            UsuarioDAO udao = new UsuarioDAO();
            Usuario u = (Usuario) session.getAttribute("usuario");
            
            Usuario uf = udao.getUser(u.getUsername());
            

            boolean existe = udao.login(u.getUsername(), u.getPassword());

            if (existe) {
            %>
                <h1>Borrar usuario</h1>
                <h2>Desea borrar su usuario?</h2>
        <form method="POST" action="/usuario/delUser">
            <button type="submit">Si</button>             
        </form>
                
        <form method="POST" action="/views/user.jsp">
            <button type="submit">No</button>             
        </form>

            
            
            
            
            
            <%
            }
            else {
            %>
                <h2>Acceso denegado</h2>
                <a href="../">Volver al LOGIN</a>
            <%
            } 
            %>
    </body>
</html>
