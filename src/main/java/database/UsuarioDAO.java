package database;

import config.DBConn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Usuario;

public class UsuarioDAO {
    
    private Connection connection;
    
    public UsuarioDAO(){
        DBConn conn = new DBConn();
        connection = conn.getConnection("basededatos", "root", "admin");
    }
    
    public boolean login(String userInput, String passInput) throws SQLException {
        PreparedStatement ps;
        ResultSet rs;
                
        ps = connection.prepareStatement("SELECT username, password FROM personas WHERE username = ? AND password = ?;");

        ps.setString(1, userInput);
        ps.setString(2, passInput);

        rs = ps.executeQuery();
                
        return rs.next();
    }
    
    public Usuario getUser(String userInput) throws SQLException {
        PreparedStatement ps;
        ResultSet rs;
        Usuario u = null;
        
            ps = connection.prepareStatement("SELECT * FROM personas WHERE username = ?");
            ps.setString(1, userInput);
            
            rs = ps.executeQuery();
            
            if(rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String name = rs.getString("name");
                String last_name = rs.getString("last_name");
                String email = rs.getString("email");
                
                u = new Usuario(id, username, password, name, last_name, email);
            }
            
            return u;
    }
    
    
    public int createUser(String username, String password, String name, String last_name, String email) throws SQLException {
        PreparedStatement ps;
        int lineasAfectadas;
        
        String pQuery = "INSERT INTO personas (username, password, name, last_name, email) VALUES(?, ?, ?, ?, ?);";

        
        ps = connection.prepareStatement(pQuery);
        
        ps.setString(1, username);
        ps.setString(2, password);
        ps.setString(3, name);
        ps.setString(4, last_name);
        ps.setString(5, email);
         
        lineasAfectadas = ps.executeUpdate();
        return lineasAfectadas;
    }
 
    
public int modUser(String username, String name, String last_name, String email, String id) throws SQLException {
    PreparedStatement ps;
    int status = 0;
    String pQuery = "update personas set username = ?, name = ?, last_name = ?, email = ? where id = ?;";
    
    ps = connection.prepareStatement(pQuery);
    ps.setString(1, username);
    ps.setString(2, name);
    ps.setString(3, last_name);
    ps.setString(4, email);
    ps.setString(5, id);
    
    status = ps.executeUpdate();
    return status;
}

public int deleteUser(String id) throws SQLException {
    PreparedStatement ps;
    int status = 0;
    
    ps = connection.prepareStatement("DELETE FROM personas WHERE id = ?");
    ps.setString(1, id);
    
    status = ps.executeUpdate();
    return status;
    }   
}
 