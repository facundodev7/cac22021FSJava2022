<%@page import="database.UsuarioDAO"%>
<%@page import="model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
            <%
            UsuarioDAO udao = new UsuarioDAO();
            Usuario u = (Usuario) session.getAttribute("usuario");
            
            Usuario uf = udao.getUser(u.getUsername());

            boolean existe = udao.login(u.getUsername(), u.getPassword());

            if (existe) {
            %>
                <h2>Bienvenido</h2>
                <h2>Su usuario es: "<%=uf.getUsername()%>"</h2>
                <h2>Su nombre es: "<%=uf.getName()%>"</h2>
                <h2>Su apellido es: "<%=uf.getLast_name()%>"</h2>
                <h2>Su email es: "<%=uf.getEmail()%>"</h2><br>
                <a href="/views/moduser.jsp">Modificar usuario</a>
                <a href="/views/borrar.jsp">Borrar usuario</a>
                
                
                
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
