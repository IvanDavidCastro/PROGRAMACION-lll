/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import Clases.Persona;

/**
 *
 * @author ivand
 */
public class Main {
    public static void main(String[]arg){
       //instaciar la clase
       //definimos tipo de dato como Persona
       //Llamado al comstructor sin argumentos
        Persona p = new Persona();
        
       //asignamos nombre o cedula a objeto persona
        p.setCedula(12345678);
        System.out.println("El valor asignado a la cedula es: " + p.getCedula() );
        
       //Llamado al comstructor con argumentos
        Persona p2 = new Persona(12345, "Ivan");
    }
}
