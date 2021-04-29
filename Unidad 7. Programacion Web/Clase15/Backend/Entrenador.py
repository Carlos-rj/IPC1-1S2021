# En este caso, vamos a guardar un objeto dentro de otro objeto
# Como Python no es tipado, no hay que declarar que es un objeto del tipo o algo por el estilo
# Unicamente debemos de almacenar una nueva variable, ya que Python la va a guardar sea como sea
class Entrenador:
    def __init__(self,nombre,Pokemon):
        self.nombre = nombre
        self.Pokemon = Pokemon
        # En este caso estamos creando el entrenador directamente con su listado de Pokemon,
        # en dado caso que la creacion sea aparte, debemos declararla como vacio

    def getNombre(self):
        return self.nombre

    def setNombre(self, nombre):
        self.nombre = nombre 

    def getPokemon(self):
        return self.Pokemon

    def setPokemon(self, Pokemon):
        self.Pokemon = Pokemon 