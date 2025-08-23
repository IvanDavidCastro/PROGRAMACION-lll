
from Clases.Padre import *

class Hija(Padre):
def__imnit__(self, nombre, edad):
    super().__init__(nombre)
    self.edad=edad