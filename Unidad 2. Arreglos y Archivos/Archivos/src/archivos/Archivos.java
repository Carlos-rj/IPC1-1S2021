package archivos;

// LIBRERIAS PARA LEER ARCHIVOS
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

// LIBRERIAS PARA ESCRIBIR ARCHIVOS
import java.io.FileWriter;
import java.io.PrintWriter;

// LIBRERIA PARA USAR NUESTRO SCANNER
import java.util.Scanner;

public class Archivos {
    // Nuestras variables globales porque las usaremos en todo el programa
    static Scanner sc = new Scanner(System.in);
    // En este caso sabemos cuanto vale la Matriz A, por que es fijo.
    static int[][] MatrizA = new int[3][3];
    // En este caso no sabemos su tamaño, entonces
    static int[][] MatrizB;
            

    public static void main(String[] args) {
        // LECTURA DE ARCHIVOS
        LeerArchivos();
        // MOSTRAR MATRIZ
        MostrarMatriz(MatrizA);
        // CREACION DE ARCHIVOS
        CrearArchivos();        
    }
    
    // NOTA: Este codigo lo encontramos en internet.
    public static void LeerArchivos(){
        // File = Es para abrir el archivo
        File archivo = null;
        // FileReader = Es para almacenar el texto del archivo
        FileReader fr = null;
        // BufferedReader = Es para leer el texto almacenado
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            
            /* NO UTILIZAR RUTAS ABSOLUTAS.
            Con rutas absolutas nos referimos a las rutas completas del archivo
            por ejemplo: C:\Users\carlo\Documents\NetBeansProjects\Archivos
            */
            
            /* UTILIZAR RUTAS RELATIVA. 
            La ruta relativa es que estamos posicionados en la carpeta actual
            En este caso estamos en la carpeta de nuestros documentos
            NetBeansProjects/NombreProyectoJava/
            
            El programa por defecte sabe que estamos en esa ubicacion.
            */
            
            // En este caso, ingresaremos la ruta desde la consola
            System.out.println("Ingrese la ruta del archivo que desea leer: ");
            String ruta = sc.nextLine();
            // Usamos nextLine() para guardar toda la cadena antes del enter.
            
            // LECTURA DEL ARCHIVO
            
            // Este archivo lo igualamos a File (Ruta del archivo) en este caso
            // la variable ruta, guarda la ruta que escribioms en consola
            archivo = new File(ruta);
            
            // FileReader es que leimos el contenido del archivo de texto y lo tenemos
            // ya almacenado en esa variable.
            fr = new FileReader(archivo);
            
            // BufferedReader, nos sirve para leer de manera mas dinamica y nos permite
            // leer el contenido del FileReader y lo podemos leer por linea.
            br = new BufferedReader(fr);

            // Variable para guardar la linea que almacena el BufferedReader.
            String linea;
            
            // PROCESO PARA LEER LINEA POR LINEA E INTERPRETAR EL DATO
            // En este caso, leeremos un texto con comas separando caracteres
            int contadorFilas = 0;
            
            // Usamos un While para definir que mientras hayan filas con texto
            // este se almacenara en la variable linea.
            while ((linea = br.readLine()) != null) {
                 System.out.print("Fila #" + contadorFilas + " - ");
                 System.out.println(linea);
                 // Para este punto tenemos la linea guardada
                 // Y queremos hacer la separacion por comas, entonces usamos el Split.
                String[] numeros = linea.split(",");
                
                // Ahora hacemos un recorrido, para saber cada caracter separado de la coma.
                for (int i = 0; i < numeros.length; i++) {
                     System.out.print("[" + contadorFilas + "][" + i + "]=");
                     System.out.println(numeros[i]);
                    /* PARSEOS
                     Utilizamos los parseos para convertir un dato a otro tipo de dato
                     en este caso usaremos un metodo para convertir un String a Entero
                     Pero cabe destacar que estos metodos son solo validos para el String.
                     
                     Los tipos de datos primitivos trabajan con otra forma de Parsearse
                     Que se vera mas adelante.
                    */
                    
                    MatrizA[contadorFilas][i] = Integer.parseInt(numeros[i]);
                    // Para parsear una cadena a cualquier tipo de dato seria.
                    // TipoDato.parseTipoDato(cadena);
                }
                System.out.println("---------------------");
                contadorFilas++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
    
    // Usamos un metodo para mostrar la Matriz
    // Podemos mandar una matriz como parametros sin ningun problema
    public static void MostrarMatriz(int[][] matriz){
        // Usamos el recorrido normal que se mostro en el laboratorio del dia martes.
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("["+matriz[i][j]+"]");
            }
            System.out.println("");
        }
    }

    // NOTA: Se modifico el metodo para dar la informacion necesaria unicamente.
    public static void ConocerDimensiones(){
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            System.out.println("Ingrese la ruta del archivo que desea leer: ");
            String ruta = sc.nextLine();
            archivo = new File(ruta);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            // Declaramos dos variables que funcionan como contadores
            int contadorFilas = 0;
            int contadorColumnas = 0;
            while ((linea = br.readLine()) != null){
                // Utilizamos un Split, porque sabemos que esta separado por comas
                // Y que una fila es igual a la otra, entonces la cantidad de
                // columnas sera la misma en todas las filas.
                String[] numeros = linea.split(",");
                contadorColumnas = numeros.length;
                contadorFilas++;
            }

            System.out.println("Cantidad de lineas: " + contadorFilas);
            System.out.println("Cantidad de Columnas: " + contadorColumnas);
            
            MatrizB = new int[contadorFilas][contadorColumnas];            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
    
    // NOTA: Metodo para crear archivos de texto plano
    public static void CrearArchivos(){
        // FileWriter: es el que nos ayudara a crear archivos vacios.
        FileWriter fichero = null;
        // PrintWritter: es el que nos ayudara a escribir en el archivo de FileWriter.
        PrintWriter pw = null;
        try
        {
            // Supondremos que trabajamos ciertas partes del codigo y ahora 
            // queremos mostrar el resultado en un archivo HTML.
            LeerArchivos();
            MostrarMatriz(MatrizA);
            // Creamos un archivo con el FileWrites y lo que va dentro de los parentesis
            // Es la ruta donde queremos crear el archivo.
            // Recordemos de usar rutas relativas.
            fichero = new FileWriter("Escritura.html");
            
            // Y usamos el PrintWriter para escribir en el archivo, entre parentesis
            // pondremos el fichero que acabamos de crear.
            pw = new PrintWriter(fichero);
            
            // Utilizamos la variable PrintWriter y el metodo println para escribir una
            // linea en nuetro archivo de texto plano.
            
            // Cualquier println que usemos sera escrito en nuetro archivo.
            
            // Creamos la estructura basica de un reporte HTML
            pw.println("<HTML>");
            pw.println("<title> Reporte HTML </title>");
            pw.println("<body style=\"background-color: #E6E6FA;\">");
            pw.println("<h1> MATRIZ A: </h1>");
            
            /* 
            Y para este punto usamos variables definidas en nuestro codigo
            Para mostrarlas en nuestro reporte, es tan simple como agregarlas
            al metodo println
            */
            pw.println("<table class=\"default\">");
            for (int i = 0; i < MatrizA.length; i++) {
                pw.println("<tr>");
                for (int j = 0; j < MatrizA[i].length; j++) {
                    pw.println("<td>" + MatrizA[i][j] + "</td>");
                }
                pw.println("</tr>");
            }
            pw.println("</table>");
            pw.println("</body>");
            pw.println("</HTML>");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
    //Pequeño hack: Escribir un reporte HTML es como si escribieramos en la consola
    /*
    System.out.println() es equivalente a pw.println()
    Es como si el archivo fuera una consola gigante y es lo que queremos mostrar
    Siempre basandonos en una estructura HTML.
    */
}
