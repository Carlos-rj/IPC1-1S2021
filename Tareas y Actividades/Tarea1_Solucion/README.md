# Introduccion a la Programacion y Computacion 1

_Fecha de entrega: 02/02/2021_
_Fecha de publicacion: 03/02/2021_

## Resumen de la tarea

_Un programa desarrollado en lenguaje JAVA que funcione como un MENU, este menu tiene diversas opciones y el chiste es que el MENU se este repitiendo hasta que el usuario le indique la salida._

### Conceptos aplicados de la clase
- Declaracion de variables
- Mostrar mensajes en consola
- Leer datos desde la consola
- Sentencias de Control
	- Sentencias If
	- Sentencias If-Else
- Bucles
	- Do-While 
	- For
- Metodos
	- Creacion
	- Llamadas
- Funciones
	- Creacion
	- Llamadas
- Excepciones
	- Try-Catch
- Logica de Programacion

### PROBLEMA 1: Verificar numeros primos
_Unicamente tenemos que hacer una validacion y en base a esta validacion dar una respuesta_

1. INICIO
2. Leer un numero
3. Verificar si el numero es mayor a 0
	1. Si es mayor a 0, seguir en 4
	2. Si es menor a 0, mostrar el mensaje "Numero no valido" y seguir en 5
4. Usar modulo entre 2
	1. Si el resultado es 0, mostrar mensaje "Es numero par".
	2. Si el resutlado es diferente de 0, mostrar mensaje "Es numero impar"
5. FIN

### PROBLEMA 2: Tablas de potenciacion
_Teniamos que recolectar dos numeros para nuestros datos, hacer un recorrido para mostrar la tabla como tal, pero antes de mostrar el resultado, tenemos que hallar el valor de la potencia._

1. INICIO
2. Leer numero base
3. Leer numero limite
4. Verificar si ambos numeros son mayor a 0.
	1. Si es mayor a 0, seguir en 5
	2. Si es menor a 0, mostrar el mensaje "Numero no valido" y seguir en 5
4. HACER DESDE base HASTA limite
	1. Encontrar la potencia correspondiente (Ver ejemplo).
	2. IMPRIMIR base + "^" + potencia + "=" + resultado.
	3. REPETIR hasta llegar a limite
5. FIN

### PROBLEMA 3: Numeros primos en un rango
_Seguramente el problema mas dificil de los 3, puesto que hay que hacer varios recorridos, entonces lo que teniamos que hacer es estar en un rango de numeros y encontrar la manera de saber si el numero era primo o no._

_Recorrido7: Indice de ese ciclo_
_Recorrido7.2: Indice del ciclo dentro del ciclo_

1. INICIO
2. Leer numero **inicio**.
3. Leer numero **fin**.
4. Declarar una variable llamada **contador**.
5. Verificar si ambos numeros son mayor a 0.
6. Verificar si inicio es menor que fin
7. HACER DESDE inicio HASTA fin
	1. Declarar una variable llamada **multiplos**
	2. HACER DESDE 1 hasta **Numero_actual**
		1. Realizar Recorrido7 MODULO Recorrido7.2
			1. Si resultado = 0, aumentar en uno la variable **multiplo**
			2. Si resultado diferente de 0, no hacer nada.
		2. REPETIR hasta llegar a **Numero_actual**
	3. Verificar si multiplos es igual a 2
		1. Si **multiplos** = 2, aumentar en uno la variable **contador**
		2. Si **multiplos** es diferente, no hacer nada.
	4. REPETIR hasta llegar a **fin**
8. IMPRIMIR "La cantidad de numeros primos es" **contador**
5. FIN

### PROBLEMA 4: Calculadora
_No se explicara el algoritmo de esta funcion, por que es muy "basico" pero si les puedo aclarar que se debia de realizar como si de otro menu se tratara, entonces en el programa teniamos un menu dentro de otro menu._