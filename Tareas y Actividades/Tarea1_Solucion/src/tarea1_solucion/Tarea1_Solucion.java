package tarea1_solucion;

// Importamos las librerias necesarias para realizar la tarea
import java.util.Scanner;

public class Tarea1_Solucion {

    /* 
        Puedo declarar el Scanner global, ya que es el mismo que utilizare para todo el programa, en este caos no hay palabras
        Entonces no tendremos problema o eso es lo que se espera.
        Recordando la explicacion del dia martes, tenemos que declarar static
    */
    static Scanner lector = new Scanner(System.in);

    // NOTA: El cambio de color significa que es una variable global y se puede usar
    // En cualquier ambito de la clase actual, Clase = Archivo.java
    public static void main(String[] args) {
        /* 
            Como lo primero que nos dice es "un menu" sabemos que corresponde a varias opciones y eso lo hemos trabajado con un do-while
            Creamos una variable int, para guardar la opcion. 
            Esta debe de ir declarada arriba del todo, ya que la utilizamos en todo el bloque de codigo. 
        */

        int opcion = 0;
        do {
            System.out.println("--- MENU: TAREA 1 ---");
            System.out.println("1) Verificacion de Numero");
            System.out.println("2) Potenciacion");
            System.out.println("3) Numeros Primos");
            System.out.println("4) Calculadora Basica");
            System.out.println("5) Cerrar Programa");
            // Cuando terminamos nuestro menu escrito, tenemos que pedir una opcion
            System.out.print("Ingrese la opcion que desea ejecutar: ");
            opcion = lector.nextInt();
            // Recordemos que todo Scanner tiene un next para cada tipo de dato
            // Por ejemplo, si queremos guardar un Double, usamos nextDouble
            // Por ejemplo, si queremos guardar una cadena, usamos nextLine

            /* 
                En este caso podriamos usar un if, sin ningun problema, pero sabemos que
                nuestra opcion son valores puntuales, por lo tanto se utiliza Switch-Case 
            */
            
            // NOTA: Si lo hacen con if, el mismo NetBeans le recomienda hacerlo con Switch
            switch (opcion) {
                /* 
                    Cada case representa un mini-programa y podriamos escribir todo el codigoo dentro del case y no esta mal
                    Pero lo mas recomendable es hacer metodos por cada programa  Y asi, si tuvieramos algun inconveniente 
                    sabemos que cada metodo hace una cosa en especifico. Entonces, declaramos nuestros metodos y funciones mas abajo.
                */

                // NOTA: Metodo o Procedimiento = Porcion de Codigo a llamar.
                // NOTA: Funcion = Variable que ejecuta codigo para llegar a un resultado.
                // NOTA: Cada Case tiene que llevar su Break;
                case 1:
                    Verificacion();
                    break;
                case 2:
                    Potenciacion();
                    break;
                case 3:
                    NumerosPrimos();
                    break;
                case 4:
                    CalculadoraBasica();
                    break;
                case 5:
                    //Nuestro case 5, es la opcion de salida entonces lo mas recomendable es
                    //Mostrar un mensaje de salida, siempre siendo un programa intuitivo
                    System.out.println("Gracias por utilizar nuestro programa, adios :D");
                    break;
                default:
                    //Default = Las opciones que no estan definidas en el Case
                    System.out.println("La opcion que ingreso no esta en el listado");
            }
            /* 
                NOTA: Lo mas recomendable es indexar el codigo, que es lo que hacemos con los tabs.
                Si nos damos cuenta, cada tab es como una porcion de codigo dentro del codigo
                Para lograr que salga asi y ordenar el codigo, que no se vea todo amontonado
                Seleccionamos todo el codigo, click derecho y buscamos la opcion de Format
            */
            
            /* 
            NOTA: Para el menu hacemos un do-while y dentro de este un Switch, entonces lo que hacmoes a nivel grafico es:
            Do
                Switch
                Termina Switch
            While
            Recordemos que el Do-While repite el codigo que esta dentro, entonces repetira el Switch siempre que entre
            */
            
            // Con esto terminariamos el codigo del menu, lo que nos falta es "programar" cada una de las opciones, todos los metodos
        } while (opcion != 5);
    }
    
    // DECLARANDO LOS METODOS Y FUNCIONES PARA REALIZAR LA TAREA
    // NOTA: En el archivo README estara el algoritmo con el que yo trabaje estos programas.
    
    // PROGRAMA 1: Verificacion de Numeros Primos
    public static void Verificacion() {
        try {
            // NOTA: Recomendable que todas las variables las pongan arriba del todo
            int numero;
            System.out.println("--> VERIFICACION DE UN NUMERO");
            System.out.print("Se le solicita un numero entero positivo para su verificacion: ");
            numero = lector.nextInt();
            /*
            VERIFICAR SI ES POSITIVO 
            Si el numero es mayor a 0, imprime el mensaje correspondiente
            Si el numero no es mayor a 0, imprime un mensaje indicando que no es valido
            */

            /*
            VERIFICAR SI ES ENTERO
            Para este caso, podemos usar el try-catch en el metodo, ya que cada metodo
            tiene su propia "Excepcion" entonces el try agarra todo el metodo, esto no siempre es asi.
            */
            if (numero > 0) {
                /* 
                Una de las formas para realizar este programa es usar el modulo
                Modulo = El residuo de una division
                Ejemplo: 4 % 2 = 0, 5 % 3 = 2
                 */
                
                //NOTA: Si un numero es multiplo de 2, significa que es Par.
                if (numero % 2 == 0) {
                    System.out.println("El numero ingresado es Par");
                } else {
                    System.out.println("El numero ingresado es Impar");
                }
            } else {
                System.out.println("El numero ingresado no es Positivo");
            }

            // Normalmente en clase, teniamos la restriccion de no usar el modulo.
            // TIP: Traten de hacerlo con un ciclos para practicar
        } catch (Exception e) {
            System.out.println("Ocurrio un problema al ingresar datos");
            // e.printStackTrace();
            // Utilizamos este, para que nos muestre en consola donde esta el error
            // Pero en la version final, no se recomienda dejarlo.
            
            /* 
             NOTA: Para este tipo de problemas, hay que limpiar el Scanner.
             El Scanner almaceno un tipo y no pudo ejecutarse correctamente, por lo tanto
             Cuando queremos agregar otro valor, este quedo almacenado y no nos deja avanzar
             Por eso es que se limpia
            */
            lector.nextLine();
        }
        // Esto es lo ultimo que hara nuestro metodo, si realiza bien el try o si entra al Catch.
        System.out.println("\n--- REGRESANDO AL MENU PRINCIPAL ---\n");
        
        // Como estamos trabajando con Metodos, recordemos que un metodo es una porcion de Codigo, si lo vemos en una vista mas "general"
        /*
        Switch(opcion)
            Case1:
                int numero;
                LINEAS DE CODIGO DEL METODO Verificacion()
                System.out.println("--> VERIFICACION DE UN NUMERO");
                ...
                System.out.println("\n--- REGRESANDO AL MENU PRINCIPAL ---\n");
                break;
            Case2:
            ...
        Y asi sucesivamente, por eso es que no hay que llamar al menu de nuevo, si no que dejar que el programa fluta
        */
    }
    
    // PROGRAMA 2: Tablas de Potenciacion
    public static void Potenciacion(){
        // Las validaciones son las mismas que el metodo Verificacion, ver la explicacion en ese metodo.
        try{
            int base, potencia, resultado;
            System.out.println("--> TABLA DE POTENCIACION ");
            System.out.print("Ingresar un numero positivo como la base de la tabla: ");
            base = lector.nextInt();
            System.out.print("Ingresar un numero positivo como el limite de la tabla: ");
            potencia = lector.nextInt();
            // Como vamos a imprimir n cantidad de cosas, podemos usar un for o un while
            // NOTA: Usar for + tab sirve para completar la sentencia de for

            // i = Variable que va cambiando dentro del for
            // i debe de empezar en 1, porque queremos las tablas de multiplicar
            // i debe de terminar en potencia, porque es el limite establecido

            if(base > 0 && potencia > 0){
                for (int i = 1; i <= potencia; i++) {
                    // Para este punto ya tenemos la escritura, pero nos falta el resultado
                    // facilmente se podria usar Math.Pow, pero por cuestiones de funcionalidad
                    // Vamos a crear una funcion que me retorne el valor de la potencia.
                    resultado = Potencia(base, i);
                    // Para este punto, resultado ya llamo a la funcion y tiene el valor de la Potencia, si nuestra funcion esta bien hecha
                    // Solo nos queda imprimir la tabla
                    System.out.println(base + " ^ " + i + " = " + resultado);
                }                            
            }else{
                System.out.println("Solo se pueden ingresar numeros positivos");
            }
        }catch(Exception e){
            System.out.println("Ocurrio un error en el ingreso de datos");
            lector.nextLine();
        }
        System.out.println("\n--- REGRESANDO AL MENU PRINCIPAL ---\n");
    }
    
    // PROGRAMA 2: Funcion para sacar la potencia
    // NOTA: Un metodo es tipo Void, una funcion es cualquier tipo de dato
    public static int Potencia(int numero, int potencia){
        // Por ejemplo, si numero = 2 y potencia = 2
        // Queremos simular un 2*2, entonces el resultado tiene como valor inicial el numero
        int resultado = numero;
        // Como queremos hacer este proceso con ciclos, necesitamos simular una multiplicacion varias veces
        // Esto tambien se puede hacer con un for, hacemos un recorrido que se haga las veces equivalente a elevarlo
        // es decir a la potencia que queremos averiguar
        for (int i = 1; i <= potencia; i++) {
            resultado *= numero;
            // NOTA: Esto es equivalente a decir numero = numero * numero
        }
        // Una vez hecho el recorrido, nos queda retornar el dato
        return resultado;
    }
    
    
    // PROGRAMA 3: Cuantos numeros primos hay en un rango de numeros
    public static void NumerosPrimos(){
        // Siendo este el mas dificil de todos, ya que usamos ciclos dentro de ciclos.
        // Las validaciones son las mismas que el metodo Verificacion, ver la explicacion en ese metodo.
        try {
            int inicio, fin; // Limites del Rango
            int contador = 0; // Contador de Numeros Primos
            System.out.println("--> NUMEROS PRIMOS ");
            System.out.print("Ingresar un numero positivo como el inicio del rango: ");
            inicio = lector.nextInt();
            System.out.print("Ingresar un numero positivo como el fin del rango: ");
            fin = lector.nextInt();
            // Aqui agregamos una condicion de que inicio sea menor que fin.
            if (inicio > 0 && fin > 0) {
                // Esta condicion no la indican, pero sabemos que tiene que ser asi
                if (inicio < fin) {
                    // Siempre trabajamos con la variable i, que es la que recorrera el rango de numeros
                    for (int i = inicio; i <= fin; i++) {
                        int multiplos = 0; // Contador de Multiplos
                        /* 
                         Para cada numero dentro del rango, vamos a encontrar la cantidad de multiplos y como hacemos eso
                         Pues, vamos a hacer la division desde un punto "inicial" hasta el punto que estamos evaluando, por ejemplo
                         Queremos saber los multiplos de 4, entonces matematicamente hablando hariamos lo siguiente:
                         4/1 = 4 -> Residuo 0 -> Es multiplo
                         4/2 = 2 -> Residuo 0 -> Es multiplo
                         4/3 = 1 -> Residuo 1 -> No es multiplo
                         4/4 = 1 -> Residuo 0 -> Si es multiplo
                        Lo importantes es saber como mover esto a nivel programacion, podemos ver que se hace un recorrido desde 1 hasta el numero evaluado
                        Y como estamos dentro de un for, donde el numero evaluado va cambiando entonces tendriamos
                         */
                        for (int j = 1; j <= i; j++) {
                            //Hasta este punto, ya tenemos el segundo recorrido, ahora debemos averiguar si es multiplo, viendo el ejemplo sabemos que
                            if (i % j == 0) {
                                //Si el numero evaluado MOD numero del recorrido = 0, entonces si es multiplo
                                //Arriba de todo esto, hicimos una variable llamada multiplos, este multiplos se declara
                                //cada vez que inicia el for, entonces cada valor i, tiene un valor multiplo independeitne
                                multiplos++;
                            }
                        }
                        // Para este punto, terminamos el recorrido y ya sabemos cuantos multiplos tiene ese numero, si observamos bien, seguims dentro del
                        // primer for, entonces antes de salir, debemos verificar si ese numero tiene 2 multiplos o no, es decir
                        if (multiplos == 2) {
                            // Si la cantidad de multiplos = 2 entonces si es primo, de lo contrario no, entonces aumentamos nuestro contador inicial
                            contador++;
                            // Podemos acceder a esta variable porque esta arriba del todo, su valor no se reinicia
                        }
                    }
                    // Para este punto ya hicimos el recorrido y ya deberiamos de saber la cantidad de numeros, entonces decimos
                    System.out.println("La cantidad de numeros primos entre el rango son: " + contador);
                } else {
                    // Hicimos dos validaciones, para dar un mensaje diferente, pero es cuestion del programador
                    System.out.println("El rango de numeros no es valido");
                }
            } else {
                System.out.println("Solo se pueden ingresar numeros positivos");
            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error en el ingreso de datos");
            lector.nextLine();
        }
        System.out.println("\n--- REGRESANDO AL MENU PRINCIPAL ---\n");
    }
    
    // PROGRAMA 4: Calculadora basica:
    public static void CalculadoraBasica(){
        // Nos damos cuenta que este es otro menu, ya que una vez que entramos aqui, tenemos que seguir pidiendo opciones hasta salir
        // Entonces hacemos otro do-whule, que trabaja con opciones

        // AHORA BIEN; SI QUEREMOS AGREGAR UN TRY-CATCH A ESTA CALCULADORA
        // El try debe estar dentro del do y va a abarcar todos las porciones de codigo, entonces
        // En cualquier lado donde exista una excepcion, se ira al Catch que estara antes de cerrar el Do-While
        int opcion = 0;
        do {
            try {
                System.out.println("--- CALCULADORA BASICA ---");
                System.out.println("1. Sumar dos numeros");
                System.out.println("2. Restar dos numeros");
                System.out.println("3. Multiplicar dos numeros");
                System.out.println("4. Dividir dos numeros");
                System.out.println("5. Regresar al menu principal");
                System.out.print("Ingrese la opcion a realizar: ");
                opcion = lector.nextInt();
                // Como sabemos que las variables a utilizar son las mismas, podemos declararlas
                // arriba del switch y por lo tanto las podemos usar en todos los cases
                double n1, n2, resultado;
                switch (opcion) {
                    // Para este menu no vamos a hacer un metodo por cada una.
                    case 1:
                        // A diferencia de los anteriores, aqui podemos ingresar enteros o decimales
                        // Entonces necesitamos los tipos de datos Double.
                        System.out.println("--> SUMA");
                        System.out.println("Ingresar el primer numero: ");
                        n1 = lector.nextDouble();
                        System.out.println("Ingresar el segundo numero: ");
                        n2 = lector.nextDouble();
                        resultado = n1 + n2;
                        System.out.println("--- El valor de la suma es: " + resultado);
                        break;
                    case 2:
                        System.out.println("--> RESTA");
                        System.out.println("Ingresar el primer numero: ");
                        n1 = lector.nextDouble();
                        System.out.println("Ingresar el segundo numero: ");
                        n2 = lector.nextDouble();
                        resultado = n1 - n2;
                        System.out.println("--- El valor de la resta es: " + resultado);
                        break;
                    case 3:
                        System.out.println("--> MULTIPLICACION");
                        System.out.println("Ingresar el primer numero: ");
                        n1 = lector.nextDouble();
                        System.out.println("Ingresar el segundo numero: ");
                        n2 = lector.nextDouble();
                        resultado = n1 * n2;
                        System.out.println("--- El valor de la resta es: " + resultado);
                        break;
                    case 4:
                        System.out.println("--> DIVISION");
                        System.out.println("Ingresar el primer numero: ");
                        n1 = lector.nextDouble();
                        System.out.println("Ingresar el segundo numero: ");
                        n2 = lector.nextDouble();
                        // la unica condicion a evaluar aca es que si n2 es 0, no se puede ejecutar entonces
                        if (n2 != 0) {
                            resultado = n1 / n2;
                            System.out.println("--- El valor de la resta es: " + resultado);
                        } else {
                            System.out.println("--- No se puede realizar esta division");
                        }
                        break;
                    case 5:
                        System.out.println("\n--- REGRESANDO AL MENU PRINCIPAL ---\n");
                        break;
                    default:
                        System.out.println("La opcion escogida no es valida");
                }
            } catch (Exception e) {
                System.out.println("Ocurrio un error al ingresar datos");
                lector.nextLine();
            }
        } while (opcion != 5);
        // PORQUE PARA SALIR NO USAMOS UNA LLAMADA A OTRO METODO
        /* Como se explico en el primer inciso, un metodo es una porcion de codigo por lo tanto lo que tenemos realmente es esto:
        do
            Switch(opcion)
                Case1:
                ...
                Case5:
                // LLAMAMOS A CALCULADORA ES DECIR
                int opcion = 0;
                do
                    try
                        System.out.println("--- CALCULADORA BASICA ---");
                        ...
                    catch
                        System.out.println("Ocurrio un error al ingresar datos");
                while(opcion != 5)
        while(opcion != 4)
        */
        
        // NO HAY NECESIDAD DE RE LLAMARSE, POR QUE CON LA PRIMERA LLAMADA, SEGUIMOS EN EL METODO MAIN Y EL PROGRAMA SEGUIRA SU FLUJO NORMAL
    }
}
