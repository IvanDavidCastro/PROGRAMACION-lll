/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;
    private String apellido;
    private String email;
    private String nickname;
    private String clave;

    private static List<Usuario> listaUsuario = new ArrayList<>();

    public Usuario(String nom, String apell, String email, String nick, String clave) {
        this.nombre = nom;
        this.apellido = apell;
        this.email = email;
        this.nickname = nick;
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public static void guardarUsuario(String nombre, String apellidos, String email, String nickname, String clave) {
        Usuario nuevoUsuario = new Usuario(nombre, apellidos, email, nickname, clave);
        listaUsuario.add(nuevoUsuario);
    }

    public static Usuario validarUsuario(String nickname, String clave) {
        for (Usuario u : listaUsuario) {
            if (u.getNickname().equals(nickname) && u.getClave().equals(clave)) {
                return u;
            }
        }
        return null; 
    }

    public static List<Usuario> getListaUsuarios() {
        return listaUsuario;
    }
}
