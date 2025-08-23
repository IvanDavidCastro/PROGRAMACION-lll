/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Estudiantes
 */
public class Hija extends Padre {

    int edad;

    public Hija(String nombre, int edad) {
        super(nombre);
        this.edad = edad;
        System.out.println("Tiene una hija de" + edad + "anios");
    }
}
