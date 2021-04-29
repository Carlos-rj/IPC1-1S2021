# Introduccion a la Programacion y Computacion 1

_Fecha: 06/04/2021_

## Clase 13 - Backend - Horario de Laboratorio

_Cambiando todo el entorno de trabajo, nos toca un tema muy interesante que es la Programacion web, para entender estos temas primero se tocaron ciertos puntos sobre redes y tipos de redes. Luego se tocaron los temas de la Programacion web, empezando del lado del servidor, que es una aplicacion servidor, como funciona el backend y como se maneja la informacion por medio de peticiones HTTPs que vienen de una API REST que forma parte del backend._

**Grabacion de la clase:** https://drive.google.com/file/d/1UAtkXQbeVh_R0D72CfM5aLdRB-u7X5zj/view?usp=sharing

### Contenido 📋

- Redes de computadoras
	- Redes por su alcance
	- Redes publicas
	- Redes privadas
	- Localhost
- Programacion Web - Backend
	- Aplicacion servidor
	- Aplicaciones REST
	- API REST
	- Objetos JSON
		- Estructura de un JSON
- Mi primer servidor con Flask
	- Instalar las librerias
	- Definir variables del server
	- Correr el server en 0.0.0.0
	- Creacion de una clase
		- Metodo constructor
		- Metodos GET y SET
	- Rutas
		- Respuestas
	- Metodos CRUD
		- GET - Obtener informacion
		- POST - Guardar informacion
		- PUT - Actualizar informacion
		- DELETE - Eliminar informacion
	- Como mandar parametros por rutas.
	- Como leer el request

_NOTA: Si el manejo de Flask no quedo del todo claro, pueden ver el siguiente video, fue el video en el que me base para hacer el ejemplo:_ https://www.youtube.com/watch?v=Esdj9wlBOaI


_Fecha: 13/04/2021_

## Clase 14 - Frontend - Horario de Laboratorio

_Una vez que hemos trabajado con los entornos del backend, podemos migrarnos al entorno de la aplicacion cliente y empezar a ver como es que funcionan los frameworks de desarrollo para frontend, existen muchas alternativas para trabajar frontend pero en este caso, se decidio trabajar con **Boostrap** y asi realizar la conexion al backend por medio de un **fetch**._

**Grabacion de la clase:** https://drive.google.com/file/d/1OcD4lHFLm-wbtcH3AmQiNuqb57WJWeCW/view?usp=sharing

### Contenido 📋

- TCP / IP
	- Definicion
	- Protocolo TCP
	- Protocolo IP
- Puertos logicos
	- Puertos reservados
- Protocolos de Red
	- Tipos de Protocolos
- HTTP - HTTPS
	- Definicion
	- Diferencias
	- Implementacion con Programacion Web
	- Mensajes/Peticiones HTTP
- Programacion Web - FrontEnd
	- Aplicacion cliente
	- Lenguajes recomendados
	- Comparaciones con el Backend
	- Framework
	- Conexion Cliente - Servidor
		- Fetchs: https://developer.mozilla.org/es/docs/Web/API/Fetch_API/Using_Fetch
		- Axios: https://desarrolloweb.com/articulos/axios-ajaxcliente-http-javascript.html
	- Boostrap
		- Definicion
		- Estructura
		- Como funciona
		- Documentacion: https://getbootstrap.com/
	- Aplicacion Frontend
		- Plantilla Bootstrap
		- Contenedores "div"
			- Cambiar tamaño
			- Cambiar posicion
			- Agregar un espaciado
		- Formularios
			- Tipos de Entradas
		- Botones
			- Agregar funciones
		- Tablas
			- Cargar informacion desde un metodo
		- Etiqueta "script"
			- Crear Metodos
			- Asignar metodos
			- Metodos con parametros
			- Redireccionar paginas
			- sessionStorage
		

_Fecha: 20/04/2021_

## Clase 15 - Cloud Computing - Horario de Laboratorio

_Con los entornos de trabajo ya definimos, tanto el backend como el frontend, ya podemos proseguir a subirlo a un servidor de nube, actualmente existen muchos servidores de nubes, entre ellos tenemos **AWS** y **Google Cloud Platform** pero la desventaja es que son de pago y necesitamos una tarjeta de credito para acceder a ellos, sin embargo existen servidores de nube que cuentan con una capa gratuita entre ellos esta **Heroku** que es la que se utilizara para levantar nuestras aplicaciones **backend** y **frontend**._

**Grabacion de la clase:** https://drive.google.com/file/d/1IOJVDV_OwQLLIIDDJYsrThjAgTLP2VQ8/view?usp=sharing


### Contenido 📋

- Cloud Computing
	- Que es
	- Caracteristicas
	- Ventajas y Desventadas
	- Tipos de Modelos
		- IAAS
		- PAAS
		- SAAS
	- Proveedores de nube
		- AWS
		- Google Cloud
		- Azure
- Git
	- Que es
	- Comandos basicos
		- Git Clone
		- Git add
		- Git commit
		- Git push
		- Git pull
	- Subir los proyectos desde la terminal
- GitHub
	- Repositorios
	- Como crear un repositorio
	- El archivo README
- Heroku
	- Como funciona Heroku
	- Conectar Heroku - Repositorio Github
	- Despliegue automatico
		- Tomar los cambios del Repositorio
	- Despliegue manual de las aplicaciones
	- Visualizar aplicaciones
- Backend
	- Gunicorn: Levanta el servidor haciendo replicas en varios puertos.
		- pip install gunicorn
	- Freeze: Obtener los requerimientos de la app
		- pip install freeze
		- pip freeze > requirements
	- Creacion del Procfile
		- Levantarlo con gunicorn
			- web: gunicorn -w 1 main:app 
				- -w 1 para indicarle que solo levante una vez el servidor
				- main:app donde main es el nombre de mi archivo py
		- Si ustedes quieren pueden correr el python normal y deberia de funcionar
			- python main.py
- Frontend
	- Consumir el backend de Heroku
		- Cambiar la IP de **localhost** a la de heroku
	- Crear archivo php
		- index.php
			- '?php include_once("Pagina.html"); ?'
			- Pagina.html: hace referencia a mi pagina principal
		
#### Recomendaciones
La decision de la nube a utilizar fue de cada auxiliar, entonces en mi caso utilizamos **Heroku** pero pueden averiguar con otros auxiliares que nube utilizaron y si les pueden compartir la grabacion para saber como funcionan las nubes que van a implementar, por ejemplo Abner creo que usaria **AWS**, en la seccion A tambien usaran **AWS** con la cuenta de estudiante, esto es por si ustedes quieren saber un poco mas del mundo del cloud.

_Fecha: 27/04/2021_

## Clase 16 - Arreglos en Javascript - Horario de Laboratorio

_Puesto que los temas relacionados al proyecto se concluyeron con la clase anterior, lo unico que quedaba era hacer un repaso de lo que se ha estado trabajando, entre las funcionalidades de la pagina, existe la opcion de que se debe guardar informacion de una entidad dentro de otra entidad, para eso manejamos lo que son arreglos y los objetos JSON nos da la facilidad de guardar arreglos dentro de arreglos, entonces con esta base, decidimos hacer un ejemplo en el cual un **entrenador** tenga un arreglo para manejar sus **Pokemon** y la manera de trabajarlo tanto en el backend como en el frontend._

**Grabacion de la clase:** https://drive.google.com/file/d/1uciwNA7AJW_4CPy31RRA0LiFR-qM2vpo/view?usp=sharing


### Contenido 📋

- Backend
	- Arreglos
	- Un arreglo dentro de un objeto
		- Arreglos []
		- Arreglos de Objetos
	- Almacenar el arreglo
	- Retornar el objeto
- Frontend
	- Variables globales
	- Arreglos
	- Manejo de datos en arreglos
		- Push
		- Pop
		- Shift
		- Unshift
	- Recorrer arreglos
		- foreach
		- map
	- Construir un arreglo de JSONs
