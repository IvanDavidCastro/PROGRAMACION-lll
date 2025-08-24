class Animal:
    def __init__(self, nom, peso, prop, fecha_cump, fecha_ult_v):
        self.__nombre = nom
        self.__peso = peso
        self.__propietario = prop
        self.__fecha_cumpleanios = fecha_cump
        self.__fecha_ultima_vacuna = fecha_ult_v

    # GET
    def get_nombre(self):
        return self.__nombre

    def get_peso(self):
        return self.__peso

    def get_propietario(self):
        return self.__propietario

    def get_fecha_cumpleanios(self):
        return self.__fecha_cumpleanios

    def get_fecha_ultima_vacuna(self):
        return self.__fecha_ultima_vacuna

    # SET
    def set_nombre(self, nom):
        self.__nombre = nom

    def set_peso(self, peso):
        self.__peso = peso

    def set_propietario(self, prop):
        self.__propietario = prop

    def set_fecha_cumpleanios(self, fecha_cump):
        self.__fecha_cumpleanios = fecha_cump

    def set_fecha_ultima_vacuna(self, fecha_ult_v):
        self.__fecha_ultima_vacuna = fecha_ult_v
