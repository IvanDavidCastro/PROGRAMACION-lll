/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author ivanCastro
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
     * @return the contraseña
     */
    public String getclave() {
        return clave;
    }

    /**
     * @param clave the contraseña to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * @return the rol
     */
    public String getRol() {
        return rol;
    }
    
    /**
     * @param rol el rol del usuario
     */
    public void setRol(String rol) {
        this.rol = rol;
    }

    public Usuarios(String nom, String apell, String email, String username, String clave, String rol) {
        this.nombre = nom;
        this.apellido = apell;
        this.email = email;
        this.username = username;
        this.clave = clave;
        this.rol = rol;
        Conector con = new Conector();
        conexion = con.getConexion();
    }
    
    public Usuarios() {
        Conector con = new Conector();
        conexion = con.getConexion();
    }
    
    public Usuarios validarUsuario(String username, String clave) {
        Usuarios user = null;
        String sql = "SELECT * FROM usuario WHERE username = ? AND clave = ?";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, clave);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new Usuarios();
                user.setNombre(rs.getString("nombre"));
                user.setApellido(rs.getString("apellido"));
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("username"));
                user.setClave(rs.getString("clave"));
                user.setRol(rs.getString("rol"));
            }

            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al validar usuario: " + e.getMessage());
        }

        return user;
    }

    public boolean registrarUsuario(String nombre, String apellido, String email, String username, String clave, String rol) {
        String sql = "INSERT INTO usuario (nombre, apellido, email, username, clave, rol) VALUES (?, ?, ?, ?, ?, ?)";
        boolean registrado = false;

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, email);
            ps.setString(4, username);
            ps.setString(5, clave);
            ps.setString(6, rol);

            int filas = ps.executeUpdate();

            if (filas > 0) {
                registrado = true;
                System.out.println("Usuario registrado correctamente.");
            }

            ps.close();
        } catch (Exception e) {
            System.out.println("Error al registrar usuario: " + e.getMessage());
        }

        return registrado;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }
  
    private String nombre;
    private String apellido;
    private String email;
    private String username;
    private String clave;
    private String rol;
    private Connection conexion;
      
}


