/*
 Crear una clase hija llamada Automóvil que herede de la clase Vehículo y que tenga 
   los atributos marca, modelo y precio, crear sus respectivas funciones para obtener 
   los datos y mostrar datos. 
 */
package Hija;
import Padre.Vehiculo;

/**
 *
 * @author LENOVO
 */
public class Automovil extends Vehiculo {
    
    String marca;
    String modelo;
    int precio;

    public Automovil(String fecha_Fbn, String vin_Chas, String vin_Motor,
            String marca, String modelo, int precio) {
        
        super(fecha_Fbn, vin_Chas, vin_Motor);
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getPrecio() {
        return precio;
    }
    
    public void mostrarDatos() {
  
        System.out.println("Su Fecha de fabricacion: " + getFechaFabricacion());
        System.out.println("Su VIN Chasis: " + getVinChasis());
        System.out.println("Su VIN Motor: " + getVinMotor());
        System.out.println("Su Marca: " + getMarca());
        System.out.println("Su Modelo: " + getModelo());
        System.out.println("Su Precio: $" + getPrecio());
    }
}
