# MI PRIMERA APLICACION SERVER CON PYTHON
# Vamos a hacer uso de Flask, que es una libreria que funciona con Python para darnos un entorno
# donde podemos realizar una aplicacion que en base de rutas haga funcionalidades

# PRIMERO LO PRIMERO, TENER INSTALADO PYTHON.
# SEGUNDO, INSTALAR LAS LIBRERIAS
    #pip install flask, flask_cors
# Estas librerias son las necesarias para levantar un servidor con Flask.

# IMPORTAMOS LOS ARCHIVOS NECESARIOS PARA CORRER NUESTRO SERVIDOR
from flask import Flask, jsonify, request
#Flask -> Nos sirve para crear la aplicacion servidor
#jsonify -> Nos sirve para mostrar la salida JSON mas ordenada
#request -> Nos sirve para obtener el body de la peticion HTTP

from flask_cors import CORS
#CORS -> Nos sirve para habilitar los origenes cruzados, es decir un origen diferente.

# IMPORTAMOS LAS "CLASES" CREADAS
# Para no perder el concepto de JAVA, los objetos los manejaremos como clases
# utilizamos from nombreArchivo import nombreClase para obtener accesoa nuestro "Objeto"
from Persona import Persona

# IMPORTAMOS JSON, PUESTO QUE LOS ENTRADAS Y SALIDAS SON TIPOS JSON
import json

# CREACION DE LISTAS PARA ALMACENAR INFORMACION
# A diferencia de JAVA, Python maneja una Lista para almacenar informacion, con memoria dinamica
# Declaramos nuestra variable como una lista con la siguiente sintaxis.
# Variable = [], podemos tener las listas que nosotros querramos
Personas = []
# DATO IMPORTANTE: Python no es tipado, es decir que las variables son tratadas como objetos.
# por lo tanto, las listas pueden almacenar cualquier variable que nosotros agreguemos

# METODO APPEND -> Agregar hasta el final
# En este caso, queremos guardar nuestro objeto Persona, entonces creamos
# Persona(valor, valor, valor, valor) segun nuestro metodo __init__ en la clase Persona
Personas.append(Persona('Carlos','Jimenez',22))
Personas.append(Persona('Roberto','Perez',22))
Personas.append(Persona('Ana','Solorzano',21))
Personas.append(Persona('Pancha','Lopez',23))
# PARA ESTE PUNTO TENEMOS 4 OBJETOS EN Personas, estos objetos representan a Persona.


# CREACION DE LA APLICACION FLASK
# Necesitamos crear una variable que le indique como trabaja Flask, en este caso esta variable puede tener cualquier nombre
# Variable = Flask(__name__).
app = Flask(__name__)
# Agregamos el CORS para que esto no nos de problemas a la hora de comunicarnos con el FRONTEND
CORS(app)


# CREACION DE RUTAS
# Como habiamos mencionado las APIs se basan en rutas que hacen acciones.
# Podemos definir una ruta con los 4 verbos del HTTPS, es decir una ruta puede tener 4 metodos:
# GET - OBTENER, POST - GUARDAR, PUT - ACTUALIZAR, DELETE - ELIMINAR 

# SINTAXIS
# Usamos la variable que definimos como Flask seguido de .route
# Esto le da a entender la ruta que tendremos que acceder para ejecutar el metodo
# Le definimos un methods con uno de los 4 verbos, por defecto toma el valor del GET.
@app.route('/', methods=['GET'])
# Seguido de definir la ruta, agregamos un def para declara una funcion en python y el nombre de la funcion
# Todo lo que hagamos dentro de esta funcion es lo que se ejecutara cuando utilicemos esta ruta.
def rutaInicial():
    # Todo metodo deberia de devolver un JSON para que sea entendido en el Frontend.
    return("<h1>Hola alumnos</h1>")

# MISMA RUTA - DIFERENTE METODO
@app.route('/', methods=['POST'])
def rutaPost():
    # En este caso creamos un Diccionario de Python, los diccionarios son listas de clave-valor
    # Si lo comparamos, puede adaptarse perfectamente como un objeto JSON.
    objeto = {"Mensaje":"Se hizo el POST correctamente"}
    # Utilizamos el jsonify para devolver el objeto JSON de manera ordenada
    return(jsonify(objeto))

# METODOS DEL CRUD
# Normalmente las APIs nos sirven para manejar informacion, es decir, crear, leer, actualizar y eliminar
# Se crearan los 4 metodos principales con una ruta y estos pueden ser probados en Postman

# POSTMAN: Aplicacion para hacer peticiones HTTPs, ver el video para entender mejor su funcion.

# METODO - OBTENER TODOS
@app.route('/Personas', methods=['GET'])
def getPersonas():
    # Tenemos nuestra lista en el entorno global, por eso hacemos referencia a ella con la palabra global
    global Personas
    # Creamos un arreglo de Python para almacenar la informacion
    Datos = []
    # Hacemos un recorrido de nuestro arreglo
    for persona in Personas:
        # Por cada objeto en nuestro arreglo, escribimos un objeto JSON, es decir clave-valor
        objeto = {
            'Nombre': persona.getNombre(),
            'Apellido': persona.getApellido(),
            'Edad': persona.getEdad()
        }
        # Agregamos el dato encontrado a la lista creada anteriormente.
        Datos.append(objeto)
    # Le mandamos la informacion como respuesta, para este punto recorrio el arreglo y creo objetos JSON.    
    return(jsonify(Datos))

# METODO - OBTENER UN DATO
# Existen sitauciones que vamos a tener que mandar el parametro por medio de la ruta, esto es por cuestion de gustos
# Porque tambien podria hacer un metodo POST que reciba el usuario, pero no esta de mas aprenderlo.
# Seguido de nuestra ruta, agregamos los siguiente <tipoDato: nombreVar>
@app.route('/Personas/<string:nombre>', methods=['GET'])
# Luego para definir el metodo, hay que agregar el nombreVar como parametro del metodo
def ObtenerPersona(nombre): 
    # Referencia al arreglo global
    global Personas
    # Recorrido del arreglo
    for persona in Personas:
        # Si el objeto actual tiene el nombre que le mandamos como parametro entonces
        if persona.getNombre() == nombre:
            # Crear el objeto
            objeto = {
            'Nombre': persona.getNombre(),
            'Apellido': persona.getApellido(),
            'Edad': persona.getEdad()
            }
            # Como ya no necesitamos buscar mas, aplicamos el return para este punto
            return(jsonify(objeto))
    # Si llega a este punto, quiere decir que nunca entro al for, entonces creamos un objeto        
    salida = { "Mensaje": "No existe el usuario con ese nombre"}
    # Retornamos el objeto creado
    return(jsonify(salida))

# METODO - GUARDAR UN DATO
# Que pasa en este metodo, que necesitamos recibir la informacion que nos manda el cliente, entonces hacemos uso del request

# NOTA: LOS METODOS POST, PUT Y DELETE RECIBEN UN REQUEST, GET NO RECIBE UN REQUEST
# Por eso el GET lo trabajamos con parametros.
@app.route('/Personas', methods=['POST'])
def AgregarUsuario():
    # Referencia a la lista global
    global Personas
    # Como mencioamos anteriormente, el cliente se debe de encargar de mandarle un body a la API para que
    # pueda manejar esta informacion, Flask almacena esta informacion en el request.
    # Para obtener la informacion usamos la siguiente sintaxis.
    # request.json['clave'], donde clave es un campo recibido del body mandado por el cliente
    # NOTA: Esta clave debe coincidir con el body del cliente, si no, nos dara error.
    nombre = request.json['nombre']
    apellido = request.json['apellido']
    edad = request.json['edad']
    # Creamos nuestro nuevo objeto con la informacion recolectada del request
    nuevo = Persona(nombre,apellido,edad)
    # Agregamos la persona
    Personas.append(nuevo)
    # Retornamos nuestro objeto JSON con la salida esperada
    return jsonify({'Mensaje':'Se agrego el usuario exitosamente',})

# METODO - ACTUALIZAR UN DATO
# En este caso, vamos a unir los dos conceptos que trabajamos anteriormente para actualizar un dato
# actualizaremos el dato que le mandaremos por el parametro y la nueva informacion se mandara en el body
# NOTA: NO ES OBLIGATORIO USAR UN METODO PUT PARA ACTUALIZAR, SOLO ES POR REFERENCIA
@app.route('/Personas/<string:nombre>', methods=['PUT'])
def ActualizarPersona(nombre):
    # Hacemos referencia a nuestro usuario global
    global Personas
    # Como queremos actualizar un dato en especifico, haremos un for un poco diferente
    # En este caso, si trabajaremos con el indice, donde range nos devuelve los numero de 0 hasta donde le indiquemos
    # En este caso, la longitud del arreglo
    for i in range(len(Personas)):
        # Validamos si el nombre que le mandamos como parametro es el que queremos actualizar
        if nombre == Personas[i].getNombre():
            # Con ayuda de los metodos SET creados en la clase, le asignamos el valor del request
            Personas[i].setNombre(request.json['nombre'])
            Personas[i].setApellido(request.json['apellido'])
            Personas[i].setEdad(request.json['edad'])
            # Mandamos el mensaje de informacion actualizada
            return jsonify({'Mensaje':'Se actualizo el dato exitosamente'})
    # Si llega a este punto, quiere decir que salio del for
    return jsonify({'Mensaje':'No se encontro el dato para actualizar'})

# METODO - ELIMINAR UN DATO
# En este caso, como trabajaremos con un solo dato, podemos mandar la informacion como parametro.
# NOTA: NO ES NECESARIO UTILIZAR EL METHOD DELETE, ES REFERENCIA UNICAMENTE
@app.route('/Personas/<string:nombre>', methods=['DELETE'])
def EliminarPersona(nombre):
    # Referencia al arreglo global
    global Personas
    # Usamos un for para manejar por medio del indice
    for i in range(len(Personas)):
        # Validamos si es el nombre que queremos
        if nombre == Personas[i].getNombre():
            # Usamos del para eliminar el objeto
            del Personas[i]
            # Mandamos el mensaje de la informacion eliminada
            return jsonify({'Mensaje':'Se elimino el dato exitosamente'})
    # Si llega a este punto, quiere decir que salio del for        
    return jsonify({'Mensaje':'No se encontro el dato para eliminar'})
    
# NOTA IMPORTANTE: Cabe destacar que el dato que mandamos como parametro debe de ser el identificador del objeto
# Si trabajaramos con un Usuarios, mandamos username, si trabajamos con Recetas, mandamos el correlativo.

# Y POR ULTIMO, CORRER LA APLICACION
# Una vez definido todas nuestras rutas para ser consumidas por un cliente solo nos queda correr la aplicacion
if __name__ == "__main__":
    # Le decimos que el host es 0.0.0.0 para que corra en Localhost
    # Le indicamos el puerto (Tema pendiente por ver) para indicarle en que puerto levantara la aplicacion
    app.run(host="0.0.0.0", port=3000, debug=True)