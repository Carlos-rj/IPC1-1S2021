#PARA NO PERDER LA REFERENCIA A JAVA USAMOS CLASES
class Persona:
    # NUESTRO NUEVO CONSTRUCTO
    # __init__ sera nuestro metodo que se ejecuta al crear un objeto
    # self, hace referencia al objeto actual    
    def __init__(self,nombre,apellido,edad):
        self.nombre = nombre
        self.apellido = apellido
        self.edad = edad

    # METODOS GET
    # Creamos nuestros metodos para obtener la informacion, usando self
    def getNombre(self):
        return self.nombre
    
    def getApellido(self):
        return self.apellido
    
    def getEdad(self):
        return self.edad

    # METODOS SET
    # Creamos nuestros metodos para setear la informacion, usando el self y el parametro
    def setNombre(self, nombre):
        self.nombre = nombre
    
    def setApellido(self, apellido):
        self.apellido = apellido
    
    def setEdad(self, edad):
        self.edad = edad
