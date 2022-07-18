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
                <h1>Modificar Usuario</h1>
        <form method="POST" action="/usuario/modUser">
            <label for="username">Usuario actual: "<%=uf.getUsername()%>"</label>
            <input type="text" id="username" name="username" placeholder="Nuevo Usuario">
            <br>
            <br>
            <label for="name">Nombre actual: "<%=uf.getName()%>"</label>
            <input type="text" id="name" name="name" placeholder="Nuevo Nombre">
            <br>
            <label for="last_name">Apellido actual: "<%=uf.getLast_name()%>"</label>
            <input type="text" id="last_name" name="last_name" placeholder="Nuevo Apellido">
            <br>
            <label for="email">Email actual: "<%=uf.getEmail()%>"</label>
            <input type="email" id="email" name="email" placeholder="Nuevo Email">
            <br>
            <button type="submit">Modificar</button>
                                 
        </form>
          
            <h1>Su id es: <%=uf.getID()%></h1>
            <h1></h1>
            
            
            
            
            
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
