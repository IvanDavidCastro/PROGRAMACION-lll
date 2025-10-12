/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Clases;
import java.sql.*;
/**
 *
 * @author IvanCastro
 */
public class Clientes {

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
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }
    private String nombre;
    private String apellido;
    private String username;
    private String email;
    private String direccion;
    private String clave;
    
    
       // Método para verificar las credenciales del usuario
    public boolean verificarCredenciales(String pUsername, String pPassword) {
        Conector db = new Conector();
        
        try {
            db.conectar();
            String query = "SELECT * FROM clientes WHERE username = ? AND clave = ?";
            ResultSet rs = db.executeSelect(query, pUsername, pPassword);
            return rs.next();
            
        }catch (SQLException e) {
            System.err.println("Error al verificar las credenciales: " + e.getMessage());
            return false;
        }finally {
           db.desconectar();
        }
       
    }
    
    // Metodo para listar
   public ResultSet listarClientes() {
    Conector db = new Conector();
    ResultSet rs = null;

    try {
        db.conectar();
        String query = "SELECT * FROM clientes";
        rs = db.executeSelect(query);
    } catch (SQLException e) {
        System.err.println("Error al listar los clientes Metodo: " + e.getMessage());
    }

    return rs;
}
   
    // Método para insertar un nuevo cliente en la base de datos
    public int guardarCliente(String nombre, String apellido, String username, String email, String clave) throws SQLException {
        Conector db = new Conector();
        db.conectar();
        String query = "INSERT INTO clientes (nombre, apellido, username, email, clave) VALUES (?, ?, ?, ?, ?)";
        int resultado = db.executeUpdate(query, nombre, apellido, username, clave, getDireccion(), email);
        db.desconectar();
        return resultado; }

    // Método para actualizar un cliente existente en la base de datos
    public int actualizarCliente(int id,String nombre, String apellido, String username, String email, String clave) throws SQLException {
        Conector db = new Conector();
        db.conectar();
        String query = "UPDATE clientes SET nombre = ?, apellido = ?, direccion = ?, telefono = ? WHERE id = ?";
         int resultado = db.executeUpdate(query, nombre, apellido, username, clave, getDireccion(), email, id);
        db.desconectar();
        return resultado;}

    // Método para eliminar un cliente de la base de datos
    public int eliminarCliente(int id) throws SQLException {
        Conector db = new Conector();
        db.conectar();
        String query = "DELETE FROM clientes WHERE id = ?";
        int resultado = db.executeUpdate(query, id);
        db.desconectar();
        return resultado;} 
   
}
