/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Estudiantes
 */
public class hija extends padre{

    int edad;

    public hija(String nombre, int edad) {
        super(nombre);
        this.edad = edad;
        System.out.println("Tiene una hija de" + edad + "anios");
    }
} 
