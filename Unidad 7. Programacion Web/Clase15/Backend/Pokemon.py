# Creamos nuestra clase Pokemon, con fines practicos.
class Pokemon:
    def __init__(self,codigo,nombre,tipo):
        self.codigo = codigo
        self.nombre = nombre
        self.tipo = tipo 

    def getNombre(self):
        return self.nombre
    
    def getCodigo(self):
        return self.codigo
    
    def getTipo(self):
        return self.tipo

    def setNombre(self, nombre):
        self.nombre = nombre
    
    def setCodigo(self, codigo):
        self.codigo = codigo
    
    def setTipo(self, tipo):
        self.tipo = tipo
