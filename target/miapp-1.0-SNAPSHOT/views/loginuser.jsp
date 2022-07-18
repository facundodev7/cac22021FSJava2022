<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="POST" action="/usuario/loginUser">
            <label for="username">Usuario</label>
            <input type="text" id="username" name="username">
            <br>
            <label for="password">Contraseña</label>
            <input type="password" id="password" name="password">
            <br>
            <button type="submit">Ingresar</button>
                       
        </form>
        
        <a href="/views/registro.jsp">Registrarme</a>
        
    </body>
</html>