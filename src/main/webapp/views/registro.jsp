<%-- 
    Document   : registro
    Created on : 17-jul-2022, 17:35:22
    Author     : ffff
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <form method="POST" action="/usuario/createUser">
            <label for="username">Usuario</label>
            <input type="text" id="username" name="username">
            <br>
            <label for="password">Contraseña</label>
            <input type="password" id="password" name="password">
            <br>
            <label for="name">Nombre</label>
            <input type="text" id="name" name="name">
            <br>
            <label for="last_name">Apellido</label>
            <input type="text" id="last_name" name="last_name">
            <br>
            <label for="email">Email</label>
            <input type="email" id="email" name="email">
            <br>
            <button type="submit">Registarme</button>
                       
        </form>
            
    </body>
</html>
