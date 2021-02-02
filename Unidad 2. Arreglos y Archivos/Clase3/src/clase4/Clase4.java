package clase4;

// El siempre confiable Scanner
import java.util.Scanner;

public class Clase4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
    // ARREGLOS o VECTORES
        /*
        Resulta que un arreglo es una variable que tiene el detalle de que podemos
        almacenar varios valores segun una posicion, entonces recordemos que el posicion
        y el indice es distinto.
            Indice: Numero con el que accedemos a la posicion.
            Posicion: El elemento que queremos acceder
        valor de indice = posicion - 1;
        */
        
        // Declarando arreglo de Int
        int[] numeros = new int [10];
        // Declarando arreglo de Double
        double[] decimales = new double[10];
        // Declarando arreglo de Char
        char[] caracteres = new char[25];
        // Declarando arreglo de String
        String[] cadenas = new String[100];
        
        /*
        En general, para declarar un arreglo es:
        TipoDato NombreArreglo = new TipoDato[ tamaño ];
        
        La ventaja de usar un arreglo es que podemos tener una variable para guardar varios
        datos, en vez de hacer lo siguiente
            int numero1;
            int numero2;
            int numero3;
            int numero4;
            int numero5;
        */
        
    // GUARDAR VALORES EN UNA POSICION
        numeros[0] = 1;
        numeros[4] = 5;
        numeros[9] = 10;
        /*
        Para guardar una posicion en especifico es:
        NombreArreglo[indice que queremos acceder] = valor;
        El valor debe de ser del mismo tipo que el tipo del arreglo
        No podemos acceder a un indice mayor a lo que declaramos anteriormente
        Es decir, si el arreglo tiene tamaño 10, ese es su capacidad maxima.
        
        El valor por defecto de los arreglos tipo de dato numerico = 0
        El valor por defecto de los arreglos char = ''
        El valor por defecto de los arreglos String = ""
        El valor por defecto de los arreglos boolean = false
        */
        
    // RECORRIENDO UN ARREGLO
        /*
            Resulta que es la forma mas sencilla para almacenar o acceder a los
            valores de un arreglo, depende del tipo de programa, pero este es la forma
            estnadar para hacerlo.
        */
    
        // Pequeño Hack: Si escriben for + tab, se complementa la sentencia        
        // ALMACENAR VALORES EN UN ARREGLO
        /*
        Si necesitamos guardar un valor en todas las posiciones, lo mas recomendable
        es hacer un for.
        
        Si utilizamos un arreglo podemos utilizar el nombre.length, esta instruccion
        equivale al tamaño del arreglo
        */
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Ingrese un numero para guardar en la posicion " + i);
            // Queremos guardar el valor en la posicion i, ya que i va aumentando dentro del for
            numeros[i] = sc.nextInt();
        }
        
        // VER LOS VALORES DE UN ARREGLO
        /*
        La logica es la misma, utilizamos un for, para ver todos los valores, en este caso
        Solo vamos a imprimir el dato
        */
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Posicion " + i + " = " + numeros[i]);
        }

    // CADENAS COMO ARREGLOS
        /*
        Podemos convertir una cadena como un arreglo y hay dos formas de hacerlo
        */
        
        String palabra;
        System.out.print("Ingresar una palabra cualquiera: ");
        palabra = sc.nextLine();
        
        // CADENA COMO UN ARREGLO DE CARACTERES
        /*
        Usamos el metodo variable.toCharArray() lo que hacemos aqui es que declaramos
        un nuevo char[] y el valor es ese metodo, lo que hace el metodo es tomar la cadena
        ver el tamaño para declararlo en el char[] y cada posicion va a tomar un caracter de la cadena
        
        Por ejemplo: palabra= "Hola";
            char[] letras = new char[palabra.length];
            letras[0] = 'H';
            letras[1] = 'o';
            letras[2] = 'l';
            letras[3] = 'a';
        
        Recordemos que cada caracter se puede interpretar como un numero.
        Si almacenamos un char en una variable int obtendremos su valor ASCII.
        */
        char[] letras = palabra.toCharArray();
        // Para este punto, letras tiene en cada posicion un caracter de la cadena.
        for (int i = 0; i < letras.length; i++) {
            System.out.println("Letra " + (i+1) + " = " + letras[i]);
            int ascii = letras[i];
            System.out.println("Valor ascii de la letra: " + ascii);
            System.out.println("-----------------------------------");
        }
        
       
        // UTILIZANDO EL METOOD charAt(i);
        /*
        A diferencia de este metodo, estamos accediendo directamente a un caracter
        de la cadena, entonces el valor de i = a la posicion que queremos accedoer.
        Por ejemplo: palbara = Hola;
        palabra.charAt(0) = 'H';
        palabra.charAt(1) = 'o';
        palabra.charAt(2) = 'l';
        palabra.charAt(3) = 'a';
        
        No podemos acceder a un indice que no este definido, como si de un arreglo se tratara.
        */
        // A diferencia de una cadena el metodo .length() tiene que llevar parentesis
        // En el caso de un Arreglo o vector, es un dato.
        // En el caso de una Cadena, es un metodo, por eso usa parentesis.
        for (int i = 0; i < palabra.length(); i++) {
            // Este codigo lo unico que hace es imprimir el valor en la posicion i.
            System.out.println(palabra.charAt(i));  
        }
        
    // SEPARANDO UNA CADENA POR UN CARACTER EN ESPECIFICO
        /*
        Nos surge la necesidad de que tenemos una cadena muy grande y la necesitamos
        Separar segun un caracter, imaginamos que tenemos un conjunto de numeros separados
        Por coma, podriamos usar esa cadena y separarla por comas.
    
        En este ejeplo ingresaremos una frase y la separaremos por el caracter espacio.
        */
        String frase;
        System.out.print("Ingresar una frase cualquiera: ");
        frase = sc.nextLine();
        // Declaramos un arreglo de tipo String, porque queremos almacenar cadenas
        // Utilizamos el metodo variable.split(caracter por separar)
        // Lo que hace es recorrer la frase y cuando encuentra el caracter
        // Lo guarda en una posicion del String[]
        String[] palabras = frase.split(" ");
        // Con un arreglo de palabras podemos recorrer cada palabra en un for
        for (int i = 0; i < palabras.length; i++) {
            System.out.println("La palabra " + (i+1) + " = " + palabras[i]);
            // CONCLUSION, si queremos separar una cadena por un caracter usamos Split();
            // Si queremos saber los caracteres de una cadena, usamos toCharArray();
        }

    // SI QUISIERAMOS SABER QUE LETRAS CONFORMAN CADA PALABRA, PODEMOS HACER LO SIGUIENTE    
        System.out.print("Ingresar una frase cualquiera: ");
        frase = sc.nextLine();
        palabras = frase.split(" ");
        for (int i = 0; i < palabras.length; i++) {
            System.out.println("La palabra " + (i+1) + " = " + palabras[i]);
            // Ya tenemos un algoritmo de como saber las letras de una palabra, entonces
            char[] letras2 = palabras[i].toCharArray();
            // Incluso si quisieramos podemos declarar la palabra en una nueva variable
            // String palabra_actual = palabras[i]
            // char[] letras2 = palabra_actual.toCharArra();
            // es equivalente a la linea de arriba, depende de como quieran trabajarlo.
            for (int j = 0; j < letras2.length; j++) {
            System.out.println("Letra " + (j+1) + " = " + letras2[j]);
            System.out.println("-----------------------------------");
        }
        }
        // Para este punto mezclamos los dos conceptos, separamos una cadena por un caracter
        // Y esa cadena separada, encontramos cada caracter en es palabra, todo esto
        // usando dos fors.
    
    // ARREGLOS MULTIDIMENSIONALES - MATRICES
        /*
        A diferencia de un arreglo o vector, lo que tenemos es que podemos tener varias
        dimensiones, las dimensiones estan medidas por la cantidad de corchetes que tenemos
        por ejemplo
        [][] -> dos dimensiones
        [][][] -> tres dimensiones
    
        Para este caso solo necesitamos dos dimensiones y podemos trabajarlo como
        int[][] matriz = new int[3][3];
        donde el primer corchete identifica las filas
        donde el segundo corchete identifica las columnas
        ver imagenes en la presentacion para guiarse.
        */

        int[][] matriz = new int[3][3];

        // Como acceder a las posiciones de la matriz
        // Al igual que el vector, tenemos que ingresar al indice, en este caso
        // Tenemos dos indices y ambos cumplen las mismas reglas de los vectores.

        // Llenando la primera fila
        matriz[0][0] = 0;
        matriz[0][1] = 1;
        matriz[0][2] = 2;
        // Llenando la segunda fila
        matriz[1][0] = 4;
        matriz[1][1] = 5;
        matriz[1][2] = 6;
        // Llenando la tercera fila
        matriz[2][0] = 0;
        matriz[2][1] = 1;
        matriz[2][2] = 2;

        // Pero que pasa si solo trabajamos con una dimension de la matriz
        // Es decir matriz[] -> esto significa que podemos asignar los valores de un vector
        // Si asi lo desearamos, por ejemplo

        int [] numeros2 = new int[3];
        numeros2[0] = 9;
        numeros2[1] = 8;
        numeros2[2] = 7;
        
        matriz[2] = numeros2;
        // Numeros es un arreglo y la posicion [2] de nuestra matriz tambien es un arreglo
        // Entonces nuestra matriz no es nada mas que un arreglo de arreglos.
        // Ver imagenes de la presentacion para guiarse.
        
    // RECORRIENDO UNA MATRIZ
        /*
        Si para recorrer un vector, utilizamos un for, entonces para recorrer una matriz
        utilizaremos dos for.
        */
        System.out.println("VIENDO POSICION POR POSICION");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.println("La posicion (" +i+","+j+") = " + matriz[i][j]);
            }
        }
        System.out.println("\n RECORRIENDOO POR FILAS");
        /*
        Para este caso, queremos que nos muestre el contenido fila a fila, es decir
        matriz[0][0] , matriz[0][1] , matriz[0][2]
        matriz[1][0] , matriz[1][1] , matriz[1][2]
        matriz[2][0] , matriz[2][1] , matriz[2][2]
        Entonces hacemos un recorrido normal:
        */
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");      
            }
            System.out.println("");
        }
        System.out.println("RECORRIDO POR COLUMNAS");
        /*
        Para este caso, queremos que nos muestre el contenido fila a fila, es decir
        matriz[0][0] , matriz[1][0] , matriz[2][0]
        matriz[0][1] , matriz[1][1] , matriz[2][1]
        matriz[0][2] , matriz[1][2] , matriz[2][2]
        Entonces lo que cambiamos es la posicion de como hacemos el recorrido:
        */
          for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[j][i] + " ");
            }
            System.out.println("");
        }
    }
}
