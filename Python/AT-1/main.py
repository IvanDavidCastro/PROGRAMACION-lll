
from Clases.Animal import Animal
def main():
    
    #instancia 
    mi_mascota = Animal("SONY", 12, "IVAN CASTRO", "2020-05-10", "2025-05-10")


    #Mostrar datos 
    print("Nombre:", mi_mascota.get_nombre())
    print("Peso:", mi_mascota.get_peso(), "kg")
    print("Propietario:", mi_mascota.get_propietario())
    print("Cumpleaños:", mi_mascota.get_fecha_cumpleanios())
    print("Última vacuna:", mi_mascota.get_fecha_ultima_vacuna())

if __name__ == "__main__":
    main()
