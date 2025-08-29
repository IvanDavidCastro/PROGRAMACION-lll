/*
 Crear una clase padre llamada Vehículo 
  con los atributos fecha de fabricación, VIN_Chasis, VINMotor. 
  Crear una función para obtener cada atributo. 
 */
package Padre;

/**
 *
 * @author LENOVO
 */
public class Vehiculo {

    String fechaFabricacion;
    String vinChasis;
    String vinMotor;

    public String getFechaFabricacion() {
        return fechaFabricacion;
    }

    public String getVinChasis() {
        return vinChasis;
    }

    public String getVinMotor() {
        return vinMotor;
    }
  
    public Vehiculo(String fecha_Fbn, String vin_Chas, String vin_Motor) {
        this.fechaFabricacion = fecha_Fbn;
        this.vinChasis = vin_Chas;
        this.vinMotor = vin_Motor;
    }
}
