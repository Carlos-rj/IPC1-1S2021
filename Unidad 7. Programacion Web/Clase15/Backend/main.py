# IMPORTACIONES QUE NO PUEDEN FALTAR
from flask import Flask, jsonify, request
from flask_cors import CORS
# LLAMANDO A NUESTROS "OBJETOS"
    # Nuestros objetos en Python son unicamente colecciones de atributos, no tienen tipo y van a guardar lo que le mandemos
from Pokemon import Pokemon
from Entrenador import Entrenador

import json

# Declaramos nuestros arreglos globales
Pokemons = []
Entrenadores = []
# Agregamos unos Pokemon, en este caso, nuestro arreglo esta almacenando objetos Pokemon
Pokemons.append(Pokemon(1,'Bulbasaur','Planta'))
Pokemons.append(Pokemon(2,'Ivysaur','Planta'))
Pokemons.append(Pokemon(3,'Venasour','Planta'))
Pokemons.append(Pokemon(4,'Charmander','Fuego'))

# Es decir, nuestro "objeto" Pokemon, va a guardar 3 valores y estos son codigo, nombre y tipo
# Esto no es lo mismo que nosotros digamos:
# Objeto = {'codigo': 1, 'nombre': 'Bulbasaur', 'tipo': planta}
# Los podemos interpretar igual si, pero no podemos trabajarlos igual, ya que uno es un arreglo
# Y el otro es un "Objeto".

# MAS VARIABLES IMPORTANTES QUE SI O SI DEBEN DE IR
app = Flask(__name__)
CORS(app)

# RUTA: Obtener los pokemon
@app.route('/Pokemon', methods=['GET'])
def getPersonas():
    global Pokemons
    Datos = []
    for pokemon in Pokemons:
        # Podemos observar que aqui si estamos construyendo nuestro objeto, es decir que estamos
        # pasando nuestro objeto Pokemon a un objeto JSON (Esto se debe por la forma que lo estamos trabajando)
        objeto = {
            'codigo': pokemon.getCodigo(),
            'nombre': pokemon.getNombre(),
            'tipo': pokemon.getTipo()
        }
        Datos.append(objeto)
    # Para este punto, Datos esta lleno de objetos {}, estos objetos tienen la informacion que seteamos en el for.
    return(jsonify(Datos))

# RUTA: Obtener un Pokemon
@app.route('/<int:codigo>', methods=['GET'])
def getPokemon(codigo):
    global Pokemons
    for poke in Pokemons:
        if (poke.getCodigo() == codigo):
            # Se repite la historia, no estamos mandando un objeto tipo Pokemon, estamos mandando un arreglo de datos
            objeto = {
                'codigo': poke.getCodigo(),
                'nombre': poke.getNombre(),
                'tipo': poke.getTipo()
                }
            return(jsonify(objeto))

# RUTA: Obtener un entrenador
@app.route('/Entrenador/<string:nombre>', methods=['GET'])
def getEntrenador(nombre):
    global Entrenadores
    for entrenador in Entrenadores:
        if(entrenador.getNombre() == nombre):
            # Como sabemos que el entrenador tiene un atributo que guarda Pokemon
            # Python no es tipado, es decir que sus variables puede guardar lo que le mandemos
            # Y a la hora de guardarlo, nosotros le mandamos un arreglo de datos, es decir un []

            # Para el manejo interno de memoria, si deberiamos de trabajarlo como Pokemon, pero en este caso
            # Solo estamos retornando la informacion. (Esto depende del tipo de progama por supuesto)
            Pokemones = entrenador.getPokemon()
            objeto = {
                'entrenador': entrenador.getNombre(),
                'pokemon': Pokemones
            }
    return(jsonify(objeto))

# RUTA: Guardar entrenador
@app.route('/Entrenador', methods=['POST'])
def agregarEntrenador():
    global Entrenadores
    nombre = request.json['nombre']
    pokemon = request.json['pokemons']
    # No hay nada nuevo o diferente, puesto que estamos almanecenando los datos en variables
    # Si quisieramos que fuera un objeto tipo Pokemon, tendriamos que construirlo antes de mandarlo a guardar
    # Pero, no es necesario.

    # No es necesario ya que el atributo pokemon guarda un [] y dentro de ese [] esta toda la informacion del Pokemono
    # REPITO: Si quisieramos manejarlo como un objeto Pokemon, tendriamos que construirlo de tal manera, en este caso solo guardamos un []
    nuevo = Entrenador(nombre,pokemon)
    Entrenadores.append(nuevo)
    return jsonify({'Mensaje':'Se agrego el usuario exitosamente'})

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=3000, debug=True)