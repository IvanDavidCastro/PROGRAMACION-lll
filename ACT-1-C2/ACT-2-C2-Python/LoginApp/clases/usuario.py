
from clases.conector import Conector

class Usuario:
    def __init__(self):
        self.db = Conector()

    def validar_usuario(self, username, clave):
        sql = "SELECT nombre, apellido, email, username, rol FROM usuario WHERE username = %s AND clave = %s"
        values = (username, clave)
        result = self.db.select(sql, values)
        if result and len(result) > 0:
            return result[0]
        else:
            return None

    def registrar_usuario(self, nombre, apellido, email, username, clave, rol):
        sql = """
            INSERT INTO usuario (nombre, apellido, email, username, clave, rol)
            VALUES (%s, %s, %s, %s, %s, %s)
        """
        values = (nombre, apellido, email, username, clave, rol)
        return self.db.execute_query(sql, values)
