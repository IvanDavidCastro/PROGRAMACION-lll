class Vehiculo:
    def __init__(self, fecha_fabricacion, vin_chasis, vin_motor):
        self.fecha_fabricacion = fecha_fabricacion
        self.vin_chasis = vin_chasis
        self.vin_motor = vin_motor

    def get_fecha_fabricacion(self):
        return self.fecha_fabricacion

    def get_vin_chasis(self):
        return self.vin_chasis

    def get_vin_motor(self):
        return self.vin_motor
