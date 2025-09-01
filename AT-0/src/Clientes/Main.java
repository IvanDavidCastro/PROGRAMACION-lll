/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clientes;

/**
 *
 * @author ivand
 */
public class Main {
     public static void main(String[] args) {
        //Objeto
        Cliente C= new Cliente("Ivan", "Castro", "123456", "3001567", "ivan@mail.com", 
        "Calle 10 #7", "2000/08/11" );

        //Imprimir el mensaje 
        System.out.println("Mi nombre es " + C.getNombre() + " " + C.getApellido() +
                           " y vivo en " + C.getDireccion() +
                           " y tengo " + C.getEdad() + " years de edad");
    }
}
