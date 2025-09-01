/*
Actividad:
 *1-Crear una clase llamada Clientes con los siguientes atributos:
   cédula, nombre, apellido, teléfono, correo, dirección y fecha_nacimiento.
  
 2- Crear una función que devuelva los valores de cada atributo, 
 3-crear una segunda función que devuelva la edad del cliente basado en su fecha de nacimiento.
    
 4-finalmente instanciar la clase y pasar valores a su constructor, para imprimir el mensaje 
    "Mi nombre es NombreCompleto (nombre y apellido) y vivo en Dirección y tengo XX años de edad"
 */
package Clientes;

/**
 *
 * @author ivand
 */
public class Cliente {
    //atributos
    private String nombre;
    private String apellido;
    private String cedula;
    private String telefono;
    private String correo;
    private String direccion;
    private String fecha_nacimiento;

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
     * @return the cedula
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * @param cedula the cedula to set
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
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
     * @return the fecha_nacimiento
     */
    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    /**
     * @param fecha_nacimiento the fecha_nacimiento to set
     */
    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
   //Funcion que devuelve todos los valores 
    public String toString() {
        return "Cliente {" + "Cedula='" + cedula + '\'' + ", Nombre='" + nombre + '\''
                + ", Apellido='" + apellido + '\'' + ", Telefono='" + telefono + '\''
                + ", Correo='" + correo + '\'' + ", Direccion='" + direccion + '\''
                + ", Fecha de Nacimiento=" + fecha_nacimiento + '}';
    }

    //Función que devuelve la edad 
    public int getEdad() {
        int year = Integer.parseInt(fecha_nacimiento.substring(0, 4));
        int yearActual = 2025;
        return yearActual - year;
    }

    //constructor
    public Cliente(String nom, String apel, String id, String cel, String correo, String casa, String fecha_ncm) {
        this.nombre = nom;
        this.apellido = apel;
        this.cedula = id;
        this.telefono = cel;
        this.correo = correo;
        this.direccion = casa;
        this.fecha_nacimiento = fecha_ncm;
    }
}
