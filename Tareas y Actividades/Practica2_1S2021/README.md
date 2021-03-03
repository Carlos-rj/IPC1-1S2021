# Introduccion a la Programacion y Computacion 1

_Fecha de entrega: 27/01/2021_
_Fecha de publicacion: 03/03/2021_

## Resumen de la actividad

_Un MENU desarrollado en JAVA que tenga las opciones de CARGAR los datos que vienen de un archivo CSV, interpretarlos y almacenarlos en objetos de JAVA para su respectiva visualizacion en reportes HTML._

### Conceptos aplicados de la clase
- Creacion de Clases
	- Abastraccion
		- Atributos
		- Metodos
- Manejo de Objetos
- Manejo de Arreglos de Objetos
	- Crear un dato
	- Recorrer un arreglo
	- Buscar datos en un arreglo
- Relacion entre objetos
	- Objeto dentro de Objetos
	- Arreglo de Objetos dentro de Objetos

### Observaciones
**El codigo fue comentado en todos sus metodos y acciones, el archivo.java tiene todo el codigo en una sola clase y esta dividido por secciones, cada seccion representa una accion de las que habia que realizar en la practica y debajo de ellas, todos los metodos utilizados en esa seccion.**

### Relacion entre Objetos

#### Pokemon - Pokeball

##### Como asignar el Pokemon a la Pokeball
![Alt text](Explicaciones/P2.png?raw=true "Objeto Pokeball")
En este caso tenemos una Pokeball, con sus atributos basicos que seria el ID, el Tipo y un Pokemon, si nosotros creamos n cantidad de Pokeball, cada Pokeball puede tener un Pokemon dentro, por lo tanto si lo miramos como un arreglo, cada posicion es un objeto diferente y cada objeto dentra un valor diferente de Pokemon.

Cuando nosotros hacemos un **Pokeball.getPokemon** para ese momento, nosotros tenemos un objeto Pokemon, no un objeto Pokeball y por lo tanto, podemos acceder a todos los metodos de ese Pokemon.

##### Como asignar el Pokemon a la Pokeball
![Alt text](Explicaciones/P1.png?raw=true "Asignar Pokemon a Pokeball")

Para la practica, la asignacion debiamos de hacer una lectura de ids por lo tanto buscabamos la Pokeball y si esta existia, buscabamos el Pokemon y con eso, solo agregamos la informacion a nuestro objeto como tal.

#### Entrenador - Pokeball

##### Como asignar el Pokemon a la Pokeball
![Alt text](Explicaciones/E1.png?raw=true "Objeto Entrenador")
Ahora bien el Entrenador, tenemos que sus atributos son el ID y el nombre y acompañado de estos, tenemos un **Array de Pokeball** que no es lo mismo que una Pokeball normal, en este caso podemos almacenar hasta un maximo de 5 Pokeballs y como estas Pokeballs dentro de tiene un objeto **Pokemon** podemos hacer alusion de que un Entrenador tiene una Pokeball que dentro de tiene un Pokemon y por cada Entrenador estas Pokeballs seran distintas.


##### Como asignar la Pokeball al Entrenador
![Alt text](Explicaciones/E2.png?raw=true "Asignar Pokeball a Entrenador")

En este caso tenemos nuestras Pokeballs "regadas" sin algun dueño, solo un arreglo de Pokeball donde cada una tiene asignado un Pokemon, entonces el archivo para asignar era parecido al anterior, un IdEntrenador y un IdPokebola, buscamos al entrenador y si este existe se busca la Pokeball para agregarla a su arreglo de Pokeball.

**NO ES LO MISMO UN ARREGLO QUE UN UNICO OBJETO**, En conclusion el arreglo del Entrenador de Pokeball iba a tomar el valor de cada Pokeball asignadad y vamos a lo mismo que se explico anteriormente, nosotros podemos acceder al arreglo de Entrenadores, luego por cada Entrenador podemos acceder a su arreglo de Pokeball y dentro de cada Pokeball podemos acceder a la informacion de cada Pokemon dentro de.

En conclusion tenemos que:
- Entrenadores -> Arreglo de Entrenadores
	- Entrenadores[i] -> Objeto Entrenador
		- Entrenadores[i].Pokeball -> Arreglo de Pokeballs
			- Entrenadores[i].Pokeball[0] -> Objeto Pokeball
				- Entrenadores[i].Pokeball[0].Pokemon -> Objeto Pokemon
