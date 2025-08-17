/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import Clases.Animal;
import java.time.LocalDate;

/**
 *
 * @author LENOVO
 */
public class Main {
   public static void main(String[] args) {
       
        LocalDate Fecha_cumpleaños = LocalDate.of(2020, 1, 20); 
        LocalDate Fecha_ultima_vacuna = LocalDate.of(2022, 1, 20); 
        
         //objeto Animal
        Animal A = new Animal("Sony", 12, "Ivan Castro", Fecha_cumpleaños, Fecha_ultima_vacuna);
        
        //usamos los get
        System.out.println("El nombre del animal es: "+ A.getNombre() + "\n Su peso es: "+ A.getPeso() + "\n El propietario es: "+ A.getPropietario() + "\n Su fecha de cumpleaños es: "+ A.getFecha_cumpleaños() + "\n Su fecha de vacunacion es: "+ A.getFecha_ultima_vacuna());
        
        
    }
}
