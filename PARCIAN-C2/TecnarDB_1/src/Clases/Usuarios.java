/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Clases;
import java.sql.*;
/**
 *
 * @author Ing. Narvaez Mejia
 */
public class Usuarios {

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    private String nombre;
    private String apellido;
    private String username;
    private String email;
    private String direccion;
    private String password;
    
       // Método para verificar las credenciales del usuario
    public boolean verificarCredenciales(String pUsername, String pPassword) {
        Conector db = new Conector();
        
        try {
            db.conectar();
            String query = "SELECT * FROM usuarios WHERE username = ? AND clave = ?";
            ResultSet rs = db.executeSelect(query, pUsername, pPassword);
            return rs.next();
            
        }catch (SQLException e) {
            System.err.println("Error al verificar las credenciales: " + e.getMessage());
            return false;
        }finally {
           db.desconectar();
        }
       
    }
    
    
   public ResultSet listarUsuarios() {
    Conector db = new Conector();
    ResultSet rs = null;

    try {
        db.conectar();
        String query = "SELECT * FROM usuarios";
        rs = db.executeSelect(query);
    } catch (SQLException e) {
        System.err.println("Error al listar los usuarios Metodo: " + e.getMessage());
    }

    return rs;
}
   
    // Método para insertar un nuevo cliente en la base de datos
    public int guardarUsuario(String nombre, String apellido, String username, String email, String clave) throws SQLException {
        Conector db = new Conector();
        db.conectar();
        String query = "INSERT INTO usuarios (nombre, apellido, username, email, clave) VALUES (?, ?, ?, ?, ?)";
        return db.executeUpdate(query, nombre, apellido, username, email, clave);
    }

    // Método para actualizar un cliente existente en la base de datos
    public int actualizarUsuario(int id,String nombre, String apellido, String username, String email, String clave) throws SQLException {
        Conector db = new Conector();
        db.conectar();
        String query = "UPDATE usuarios SET nombre = ?, apellido = ?, direccion = ?, telefono = ? WHERE id = ?";
        return db.executeUpdate(query, nombre, apellido, username, email, clave, id);
    }

    // Método para eliminar un cliente de la base de datos
    public int eliminarUsuario(int id) throws SQLException {
        Conector db = new Conector();
        db.conectar();
        String query = "DELETE FROM usuarios WHERE id = ?";
        return db.executeUpdate(query, id);
    } 
   
}
