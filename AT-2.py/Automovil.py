from Vehiculo import Vehiculo 

class Automovil(Vehiculo):
    def __init__(self, fecha_fabricacion, vin_chasis, vin_motor,
                 marca, modelo, precio):
        super().__init__(fecha_fabricacion, vin_chasis, vin_motor)
        self.marca = marca
        self.modelo = modelo
        self.precio = precio

    def get_marca(self):
        return self.marca

    def get_modelo(self):
        return self.modelo

    def get_precio(self):
        return self.precio

    def mostrar_datos(self):
        print(f"Su Fecha de fabricación: {self.get_fecha_fabricacion()}")
        print(f"Su VIN Chasis: {self.get_vin_chasis()}")
        print(f"Su VIN Motor: {self.get_vin_motor()}")
        print(f"Su Marca: {self.get_marca()}")
        print(f"Su Modelo: {self.get_modelo()}")
        print(f"Su Precio: ${self.get_precio()}")
