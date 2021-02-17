//LA FINALIDAD DE ESTE PROYECTO ES REALIZAR LA PRACTICA 1, DE FORMA EXPLICADA
//PARA LAS PERSONAS QUE NO PUDIERON REALIZARA, SE DEN UNA IDEA DE QUE ERA LO QUE HABIA QUE HACER
package practica1_1s2021;

// Tenemos los import que vamos agregando para que funcione bien el programa

// LIBRERIAS DE LECTURAS DE ARCHIVOS
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

// LIBRERIA PARA OBTENER DATOS DE LA CONSOLA
import java.util.Scanner;


public class Practica1_1S2021 {
    // VARIABLES GLOBALES
    // Estas variables las declaramos globales, por lo mismo que las queremos usar en todo momento
    // Y envarias partes del codigo
    static int [][] matrizA, matrizB, matrizM, matrizC; // Encriptado
    static double [][] GaussA, InversaA, MatrizD, MatrizR; // Desencriptado
    static int [][] matrizOri, matrizCif, matrizMadre; // Ataque
    static int [][] clave = new int[3][3];

    public static void main(String[] args) {
    // EL METODO MAIN VA A HACER LA LLAMADA DE LAS 3 ACCIONES DE LA PRACTICA
    // No se hara un menu, ya que esos son conceptos que ya manejamos.
    // Puede descomentarse cualquier metodo y ver como funciona.
    
        // Encriptar();
        
        // Desencriptado();
        
        // Ataque();
    }
    
    // METODOS PARA REALIZAR EL ENCRIPTADO
    
        /*
            Este metodo es el metodo principal, que hace el proceso y dentro de el se haran los llamados
            a los demas metodos.
        */
    public static void Encriptar() {
        // LECTURA DEL MENSAJE PARA CONVERTIRLO EN UNA MATRIZ
        Scanner lector = new Scanner(System.in);
        String mensaje, ruta;
        char[] letras;
        
        System.out.println("Ingresar una frase para encriptar: ");
        mensaje = lector.nextLine();
        // Para este punto mensaje ya tiene guardado lo que se pidio en consola.
        letras = mensaje.toUpperCase().toCharArray();
        // Utilizamos toUpperCase() porque queremos que el mensaje este en todo mayuscula
        // Tambien podiamos utilizar toLowerCase() sin ningun problema
        // Tambien utilizamos el toCharArray() y eso para convertir nuestra cadena en un arreglo de char
            // LEVE EXPLICACION DEL toCharArray().
                // mensaje = "hola";
                // letras[0] = 'h';
                // letras[1] = 'o';
                // letras[2] = 'l';
                // letras[3] = 'a';
            // Esto lo hace con cualquier String.
                
        // Necesitamos que el tamaño de columnas sea un multiplo de 3 entonces guardamos el tamaño de char[]
        double cantidad_real = letras.length;
        // Utilizamos double, para que nos devuelva el resultado con puntos decimales.
        double cantidad_aproximada = cantidad_real / 3;
        // Para este punto tenemos el tamaño real de columnas 
        System.out.println("Tamaño real: " + cantidad_real);
        // Utilizamos una conversion explicita para quedarnos con la parte entera
        // Y para eso usamos un Math.ceil que hace una aproximacion al numero mayor
        // Por ejemplo, si el resultado es 8.33 el ceil va a aproximar a 9.0
        int columnas = (int) Math.ceil(cantidad_aproximada);
        System.out.println("Cantidad de columnas: " + columnas);
        
        
        // COMO LLENAR LA MATRIZ MENSAJE
        /*
            Lo que queremos es llenar una matriz por columnas, es decir de la siguiente manera
            Nuestro mensaje tiene 15 caracteres, es decir 14 posiciones.
            |0|3|6| 9|12|
            |1|4|7|10|13|
            |2|5|8|11|14|
        
            Entonces usamos dos for, porque queremos que el primer recorrido sea por la columna
            es decir:
            - Voy a ver la columna 0
            - Voy a ver la columna 1
            - Voy a ver la columna 2
            Y asi sucesivamente, queremos que por cada columna haga vaya en la posicion
            - En la columna 0, voy a ver la posicion 0
            - En la columna 0, voy a ver la posicion 1
            - En la columna 0, voy a ver la posicion 2
            - En la columna 1, voy a ver la posicion 3
            - En la columna 1, voy a ver la posicion 4
            - En la columna 1, voy a ver la posicion 5
        
            Utilizamos un contador, por que este va a ir llnenado posicion por posicion la
            matriz.
        */
        
        int contador = 0;
        matrizM = new int[3][columnas];
        for (int i = 0; i < matrizM[0].length; i++) {
            for (int j = 0; j < 3; j++) {
                if (contador < letras.length) {
                    matrizM[j][i] = ConvertirLetras(letras[contador]);
                    contador++;
                } else {
                    matrizM[j][i] = 27;
                }
            }
        }
        System.out.println("Matriz del mensaje");
        MostraMatriz(matrizM);
        // Para este punto, ya tenemos almacenada nuestra Matriz Mensaje
        
        // MATRIZ A
        /*
            La ventaja de esta matriz, es que era una matriz fija de 3x3 por lo tanto
            la definimos
        */
        matrizA = new int[3][3];
        System.out.println("Ingresar la ruta de la matriz A: ");
        ruta = lector.nextLine();
        GuardarMatrizArchivo(ruta, matrizA);
        MostraMatriz(matrizA);
        // Para este punto ya tenemos guardada la matrizA desde una ruta
        // Hicimos un metodo que guarde la matriz que le mandemos.
        // Ver el metodo "GuardarMatrizArchivo" para entender el proceso
        
        // MATRIZ B
        /*
            En este caso sabemos que la matriz B, iba a tener las mismas dimensiones
            que la matriz M, entonces podemos darle las mismas variables como tamaño.
        */
        matrizB = new int[3][columnas];
        System.out.println("Ingresar la ruta de la matriz B: ");
        ruta = lector.nextLine();
        GuardarMatrizArchivo(ruta, matrizB);
        MostraMatriz(matrizB);
        // Para este punto ya tenemos almanecenada la matriz B

        // PROCESO DE MATRICES
        EncriptarMatrices();
    }

    // ABRIR UN ARCHIVO, LEERLO Y GUARDAR SU VALOR EN UNA MATRIZ
    public static void GuardarMatrizArchivo(String ruta, int[][] matriz) {
        // Este metodo es el conocido de las clases anteriores
        // Usamos un File, para guardar el archivo
        // Usamos un FileReader, para obtener el contenido del archivo
        // Usamos un BufferedReader, para leer el contenido del archivo
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            // Guardamos los datos que necesitamos
            // En este caso, le decimos File(ruta) que es la ruta que le mandamos como parametro
            archivo = new File(ruta); 
            fr = new FileReader(archivo); 
            br = new BufferedReader(fr); 

            
            // LEYENDO EL ARCHIVO
            /*
                Sabemos que la estructura del archivo esta por lineas, entonces el BufferReader
                nos da un metodo para leer linea por linea, ese metodo lo metemos dentro de un while
                y asi tendremos un while que vaya leyendo fila por fila del archiov.
            */
            String linea;
            
            // Usamos un contador de filas, que nos dira la fila actual que estamos leyendo
            int contadorFilas = 0;
            while ((linea = br.readLine()) != null) {
                // Sabemos que "linea" tiene los valores separados por comas, entonces
                // Usamos el metodo split para separar la cadena por un caracter en especifico
                String[] numeros = linea.split(",");
                /*
                    EJEMPLO DE UN SPLIT
                    linea.split(",") => 3,2,1
                        numeros[0] = 3
                        numeros[1] = 2
                        numeros[2] = 1
                */   
                
                // ALMACENANDO EN LA MATRIZ LOS VALORES DE LAS FILAS
                /*
                    Para este punto, tenemos que por cada fila que se lea, se va a crear un arreglo
                    llamado "numeros" y estos numeros, tendra el valor de cada numero separado por coma
                
                    Hacemos un for, porque sabemos que la cantidad de numeros es la cantidad de valores a
                    guardar por cada fila.
                */
                for (int i = 0; i < numeros.length; i++) {
                    // Para esto nos sirve nuestro contador, para ir aumentado fila por fila
                    // Cada vez que sea lea una linea.
                    matriz[contadorFilas][i] = Integer.parseInt(numeros[i]);
                    // en este caso numeros es un arreglo de String, no podemos almacenar este valor
                    // entonces usamos un parseo, el parseo nos permite convertir un valor string
                    // a un valor de tipo de dato primitivo, en este caso convertimos a un Int
                }
                // Como queremos que este contador vaya subiendo, por cada fila leida con el while
                // Sabemos que va una fila nueva.
                contadorFilas++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }

    // MOSTRAR EL VALRO DE UNA MATRIZ, METODO GENERICO PARA MOSTRAR LAS POSICIONES DE LA MATRIZ
    public static void MostraMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println("");
        }
    }

    // CONVERTIR LA LETRA A SU VALOR NUMERICO, SEGUN EL ENUNCIADO
    public static int ConvertirLetras(char caracter) {
        /*
            En este caso, cada letra tiene un valor numerico especifico, entonces lo mas
            facil era hacer una funcion, que te retorne un entero, mandando como parametro
            un caracter.
        
            El caracter mandado entra el Switch y los Case son las letras que vamos a utilizar
            cada caso es un return diferente ya que es una funcion.
        */
        switch (caracter) {
            case 'A':
                return 0;
            case 'B':
                return 1;
            case 'C':
                return 2;
            case 'D':
                return 3;
            case 'E':
                return 4;
            case 'F':
                return 5;
            case 'G':
                return 6;
            case 'H':
                return 7;
            case 'I':
                return 8;
            case 'J':
                return 9;
            case 'K':
                return 10;
            case 'L':
                return 11;
            case 'M':
                return 12;
            case 'N':
                return 13;
            case 65533:
                return 14;
            case 'O':
                return 15;
            case 'P':
                return 16;
            case 'Q':
                return 17;
            case 'R':
                return 18;
            case 'S':
                return 19;
            case 'T':
                return 20;
            case 'U':
                return 21;
            case 'V':
                return 22;
            case 'W':
                return 23;
            case 'X':
                return 24;
            case 'Y':
                return 25;
            case 'Z':
                return 26;
            default:
                return 27;
        }
    }

    // OPERACION ENTRE MATRICES
    public static void EncriptarMatrices() {
        /*
            En este metodo es el que sucede toda la magia y operamos entre matrices
        */
        
        // MULTIPLICACION DE MATRICES
        System.out.println("MULTIPLICACION DE A*M");
        // Declaramos unas variables para ayudarnos :)
        int[][] a = matrizA;
        int[][] b = matrizM;
        // Sabemos que el tamaño de la nueva matriz, depende de la multiplicacion
        // Entonces, sabemos que tendra las filas de la primera matriz y las columnas de la segunda matriz.
        matrizC = new int[a.length][b[0].length];

        // La multiplicacion no es nada mas que una operacion repetitiva entre filas y columnas
        // NOTA: Guiarse con videos de matematicas como funciona la multiplicacion de matrices y asi entender
        // como es que funcionan estos 3 fors.
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < a[0].length; k++) {
                    matrizC[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        MostraMatriz(matrizC);

        // SUMA DE LA MATRIZ
        // Despues de hacer una multiplicacion, tenemos que sumar la matriz B
        // La suma es mas sencilla que la multiplicacion, ya que cada posicion se suma con la posicion de la otra matriz
        // Es decir:
        //  M[0,0] = M[0,0] + B[0,0]
        //  M[0,1] = M[0,1] + B[0,1]
        //  M[0,2] = M[0,2] + B[0,2]
        // Entonces no es nada mas que hacer un recorrido entre las matrices y sumar las posiciones que vamos recorriendo.
        System.out.println("SUMAR LA MATRIZ (A*M)+B");
        for (int i = 0; i < matrizC.length; i++) {
            for (int j = 0; j < matrizC[0].length; j++) {
                matrizC[i][j] += matrizB[i][j];
            }
        }
        MostraMatriz(matrizC);

        // Para este punto, tenemos que la matriz C tiene el resutlado de (A*M) + B
        // Y nosotros tenemos que imprimirlo todo de corrido, para eso hacemos un recorrido por columnas
        
        /* Para hacer un recorrido por columnas hacemos lo siguiente:
         El primer for debe de ser menor al tamaño de columnas -> iterador i
         El segundo for debe de ser menor al tamaño de las filas -> iterador j
         La posicion a mostrar va a ser Matriz[j][i]
         Ya que j -> la fila actual y la i -> la columna actual
         El recorrido esta para recorrer todas las filas de la columna.
        */
        System.out.println("MENSAJE CIFRADO");
        for (int i = 0; i < matrizC[0].length; i++) {
            for (int j = 0; j < matrizC.length; j++) {
                System.out.print(matrizC[j][i] + " ");
            }
        }
        System.out.println("\n-----------------------------------------");
    }
    
    // SE ACABARON LOS METODOS DEL ENCRIPTADO :)

    
    // METODOS PARA REALIZAR EL DESENCRIPTADO
    
        /*
            Este es un metodo mas corto, ya que todos los valores los toma del encriptado
            tecnicamente si no hay encriptado, no podriamos desencriptar, por lo tanto explicaremos
            los metodos con valores ya almacenados.
        */
    
    public static void Desencriptado(){

            // ENCONTRANDO LA MATRIZ INVERSA DE A
        System.out.println("INVERSA DE A");

        // Encontrando la matriz inversa con Gauss-Jordan
        /*
            Gauss jordan es un proceso "sencillo" donde tenemos la matriz valor y la matriz identidad
            es decir:
            1 2 3 | 1 0 0
            4 5 6 | 0 1 0
            7 8 9 | 0 0 1
            Donde queremos que la matriz identidad quede de lado izquierdo y el lado derecho quedaria
            como el valor inverso de la matriz izquierda, para eso hacemos un conjunto de operciones entre
            filas.
        */
        
        // Declaramos nuestra matriz, como es una matriz de 3x3, sabemos que el resultado de la inversa
        // Esta del otro lado, entonces la hacemos de 3x(2N) donde N es el numero de columnas
        GaussA = new double[3][6];
        
        // Llenando los valores de Gauss con la matrizA
        // Solo necesitamos replicar los valores, entonces hacemos un recorrido de la matriz A
        // que nos guarde los valores en nuestra nueva matriz.
        for (int i = 0; i < matrizA.length; i++) {
            for (int j = 0; j < matrizA[i].length; j++) {
                GaussA[i][j] = matrizA[i][j];
            }
        }
        
        // Como la matriz Gauss es una nueva matriz, esta llena de 0, entonces solo necesitamos cambiar
        // las columnas que necesitamos para que tenga la matriz identidad
        // Estas 3 posiciones indican la matriz identidad del lado derecho.
        GaussA[0][3] = 1;
        GaussA[1][4] = 1;
        GaussA[2][5] = 1;

        // PARA ESTE PUNTO YA TENEMOS PLANTEADA NUESTRA MATRIZ AUMENTADA
        
        // PROCESO PARA REALIZAR GAUSS:
        // En el siguiente video: https://youtu.be/91xUg1L7O7s
        // Podemos ver como Julio Profe resuleve una matriz por Gauss Jordan
        // Pues con el analisis de este video realizamos este algoritmo
        
        // Guardamos las 3 filas, por las operaciones que tenemos que estar haciendo
        // No usamos la fila directamente, ya que esta va a ir cambiando, es mejor tener una
        // variable "auxiliar"
        double[] F1, F2, F3;
        F1 = GaussA[0];
        F2 = GaussA[1];
        F3 = GaussA[2];
        
        /* ALGORITMO DEL VIDEO
            Segun JulioProfe el procedimiento correcto es hacer 0 las siguientes posiciones
            [3,1] -> [2,1] -> [3,2] -> [1,3] -> [2,3] -> [1,2]
            Con este algoritmo iremos paso a paso.
            Recomienda utilizar las filas que comparten las posicion.
        */
        
        
        // CONVERTIR EN 0 LA POSICION [3,1]
        // Guardamos el valor de la columna actual, es decir la primera columna de cada fila a utilizar
        double val1 = F1[0];
        double val2 = F3[0];
        // En este caso, vamos a operar toda la fila donde esta la posicion que queremos cambiar
        // Asegurandonos que tendremos como resultado 0 en la posicion 3,1
        for (int i = 0; i < 6; i++) {
            // La fila 3, significa la posicion 2 y esta recorre toda la fila
            // Aplicando una multiplicacion cruzada entre sus valores, para que
            // La posicion 3,1 sea igual a 0.
        GaussA[2][i] = val1*F3[i] - val2*F1[i];
        }
        
        // CONVERTIR EN 0 LA POSICION [2,1]
        // Repetir el proceso anterior con las demas posiciones.
        
        // Guardamos el valor de la columna actual de cada fila
        val1 = F1[0];
        val2 = F2[0];
        // Hacemos el recorrido para cambiar toda la fila, asegurandonos que la posicion [2,1] = 0
        for (int i = 0; i < 6; i++) {
        GaussA[1][i] = val1*F2[i] - val2*F1[i];
        }
        
        // CONVERTIR EN 0 LA POSICION [3,2]
        val1 = F2[1];
        val2 = F3[1];
        for (int i = 0; i < 6; i++) {
        GaussA[2][i] = val1*F3[i] - val2*F2[i];
        }
        
        // CONVERTIR EN 0 LA POSICION [1,3]
        val1 = F3[2];
        val2 = F1[2];
        for (int i = 0; i < 6; i++) {
        GaussA[0][i] = val1*F1[i] - val2*F3[i];
        }
                
        // CONVERTIR EN 0 LA POSICION [2,3]
        val1 = F2[2];
        val2 = F3[2];
        for (int i = 0; i < 6; i++) {
        GaussA[1][i] = val1*F3[i] - val2*F2[i];
        }     
                
        // CONVERTIR EN 0 LA POSICION [1,2]
        val1 = F1[1];
        val2 = F2[1];
        for (int i = 0; i < 6; i++) {
        GaussA[0][i] = val1*F2[i] - val2*F1[i];
        } 
        
        // LUEGO DE VOLVER 0 el resto, solo nos queda volver 1 la diagonal principal
        // Ya que es el valor que nos falta para lograr la matriz identidad.
        
        // Para volver 1 cada posicion, vamos a dividir cada fila por el valor de la posicion
        double pos1,pos2,pos3;
        pos1 = GaussA[0][0];
        pos2 = GaussA[1][1];
        pos3 = GaussA[2][2];
        // DIVIVDIENDO LA FILA 1 CON EL VALOR DE 1,1
        for (int i = 0; i < 6; i++) {
        GaussA[0][i] = GaussA[0][i] / pos1;
        } 
        // DIVIVDIENDO LA FILA 2 CON EL VALOR DE 2,2
        for (int i = 0; i < 6; i++) {
        GaussA[1][i] = GaussA[1][i] / pos2;
        } 
        // DIVIVDIENDO LA FILA 3 CON EL VALOR DE 3,3
        for (int i = 0; i < 6; i++) {
        GaussA[2][i] = GaussA[2][i] / pos3;
        }    
        
        // PARA ESTE PUNTO, YA TENEMOS LA MATRIZ IDENTIDAD DEL LADO IZQUIERDO, POR LO TANTo
        // SOLO NOS QUEDA OBTENER EL VALOR DE LA MATRIZ DERECHA Y ESE SERIA NUESTRA MATRIZ INVERSA DE A
        System.out.println("------------------------------");
        // Declaramos la nueva matriz de 3x3
        InversaA = new double[3][3];
        // Y hacemos un recorrido para llenar la Inversa con la matriz anteriormente efectuada
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // Usamos un j+3, porque sabemos que los valores quedaron en las columnas 3,4,5.
                InversaA[i][j] = GaussA[i][j+3];
            }
        }
        
        // PARA ESTE MOMENTO YA TENEMOS UNA MATRIZ CON EL VALOR INVERSO
        // Para mostrarla no es nada mas que un recorrido de dicha matriz
        MostraMatrizDouble(InversaA);

        // AHORA EFECTUAREMOS LA RESTA DE MATRICES, ESTE PUNTO SE TRABAJA IGUAL QUE LA SUMA
        // SOLO QUE CON DIFERENTE SIGNO, ES DECIR A[0,0] = A[0,0] - B[0,0]
        System.out.println("LLENANDO MATRIZ R CON C-B");
        // Declaramos una matriz R que tendra el resultado de dicha resta.
        MatrizR = new double[InversaA.length][matrizC[0].length];
        for (int i = 0; i < MatrizR.length; i++) {
            for (int j = 0; j < MatrizR[0].length; j++) {
                MatrizR[i][j] = (matrizC[i][j] - matrizB[i][j]);
            }
        }
        
        MostraMatrizDouble(MatrizR);
        
        // PARA ESTE PUNTO LO QUE NOS FALTA ES MULTIPLICAR LA INVERSA DE A * EL RESULTADO DE LA RESTA
        // La multiplicacion se hace igual que el caso anterior, solo nos aseguramos que las matrices sean
        //  las correctas.
        System.out.println("INVERSA DE A * R");
        MatrizD = new double[InversaA.length][MatrizR[0].length];
        double[][] a = InversaA;
        double[][] b = MatrizR;
        if (a[0].length == b.length) {
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < b[0].length; j++) {
                    for (int k = 0; k < a[0].length; k++) {
                        MatrizD[i][j] += a[i][k] * b[k][j];
                    }
                }
            }
        }
        
        // Y para este punto tenemos los valores efectuados
        // Hacemos un recorrido para mostrar el valor de la matriz resultantes despues de la multiplicacion
        System.out.println("VALORES DEL MENSAJE");
        for (int i = 0; i < MatrizD.length; i++) {
            for (int j = 0; j < MatrizD[0].length; j++) {
                // En este caso usamos un Math.Round para redondear el resultado de la multiplicacion de la inversa
                System.out.print(Math.round(MatrizD[i][j])+" ");
            }
            System.out.println("");
        }
        
        // Y solo nos queda mostrar el mensaje, en este caso sabemos que cada numero equivale a una letra
        System.out.println("MENSAJE DESCIFRADO");
        for (int i = 0; i < MatrizD[0].length; i++) {
            for (int j = 0; j < MatrizD.length; j++) {
                // En este caso no usamos un salto de linea, porque queremos que salga todo de corrido
                // Llamamos a nuestra funcion y le mandamos el Math.Round(valor de la matriz)
                // Siempre un recorrido en columnas, ya que asi fue como se almaceno el mensaje
                System.out.print(ConvertirNumeros(Math.round(MatrizD[j][i]))+" ");
            }
        }
        
        System.out.println("\n-----------------------------------------");
    }
       
    //MOSTRAR EL VALOR DE UNA MATRIZ, METODO GENERICO PARA MOSTRAR LAS POSICIONES DE UNA MATRIZ DOUBLE
    public static void MostraMatrizDouble(double[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println("");
        }
    }
    
    
    // METODO UTILIZADO PARA DEVOLVER LA LETRA SEGUN EL NUMERO, CON LA LOGICA DEL ENUNCIADO
    public static char ConvertirNumeros(double numero){
        // En este caso recibimos el numero y como solo queremos su parte entera
        // Le hacemos un casteo explicito, para que del double que mandamos
        // Unicamente trabaje con el valor entero y eso validarlo con el Switch - Case
        switch ((int)numero){
            case 0:
                return 'A';
            case 1:
                return 'B';
            case 2:
                return 'C';
            case 3:
                return 'D';
            case 4:
                return 'E';
            case 5:
                return 'F';
            case 6:
                return 'G';
            case 7:
                return 'H';
            case 8:
                return 'I';
            case 9:
                return 'J';
            case 10:
                return 'K';
            case 11:
                return 'L';
            case 12:
                return 'M';
            case 13:
                return 'N';
            case 14:
                return 'Ñ';
            case 15:
                return 'O';
            case 16:
                return 'P';
            case 17:
                return 'Q';
            case 18:
                return 'R';
            case 19:
                return 'S';
            case 20:
                return 'T';
            case 21:
                return 'U';
            case 22:
                return 'V';
            case 23:
                return 'W';
            case 24:
                return 'X';
            case 25:
                return 'Y';
            case 26:
                return 'Z';
            case 27:
                return ' ';
            default:
                return ' ';
        }
    }
    
    // SE ACABARON LOS METODOS DEL DESENCRIPTADO :
    
    
    // METODOS PARA REALIZAR EL ATAQUE
    
        /*
            En este caso, vamos a tener las dos formas de ataque una explicada paso a paso y la otra
            viendolo en forma de ciclo, pero ambas trabajan de la misma forma.
        */
    
    public static void Ataque(){
      // Utilizamos la programacion necesaria para pedir la ruta de los archivos
      Scanner lector = new Scanner(System.in);  
      String  ruta;
      System.out.println("Ingrese la direccion de la matriz original ");
      ruta = lector.nextLine();
      // A diferencia de los casos anteriores, necesitamos saber la cantidad de filas del archivo para darle un tamaño a la matriz
      // Todo esto se hace dentro del metodo LeerMatrizArchivo
      matrizOri = LeerMatrizArchivo(ruta);
      MostraMatriz(matrizOri);
      System.out.println("Ingrese la direccion de la matriz cifrada ");
      ruta = lector.nextLine();
      matrizCif = LeerMatrizArchivo(ruta);
      MostraMatriz(matrizCif);
      
      // Para este punto ya tenemos nuestras dos matrices, tanto la cifrada como la original, entonces lo que nos toca es construir la matriz madre
      // La matriz madre no es nada mas que unir las dos matrices en una matriz mas grande.
      // Inicializamos la matriz con los valores necesarios
      matrizMadre = new int[matrizOri.length][6];
      System.out.println("Matriz madre generada");
      
      // Llamamos nuestro metodo para llenar esta matriz
      LlenarMadre(matrizOri, matrizCif);
      MostraMatriz(matrizMadre);
      
      // Procedemos a realizar nuestros metodos de ataque
      // Se puede ver los metodos cada uno con su explicacion mas abajo.
      // AtaqueNormal();
      AtaqueTuneado();

      // Una vez con el ataque realizado, debemos obtener la clave de la matriz.
      System.out.println("MATRIZ CLAVE OBTENIDA");
      MatrizClave();
      MostraMatriz(clave);
      // Sabemos que el resultado esperado es la matriz transpuesta de lo que encontramos por lo tanto
      // hacemos un metood para recorrer de manera distinta nuestra matriz clave
      System.out.println("MATRIZ TRANSPUESTA DE LA CLAVE");
      Transpuesta();
    }
    
    // LEER UNA MATRIZ DE UN ARCHIVO DEL CUAL NO SE SABE SUS DIMENSIONES
    public static int[][] LeerMatrizArchivo(String ruta){
         //Este metodo trabaja igual que los demas de lectura, solo que la logica cambia al momento de leerlo
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        int[][] matriz = null;
        try {
            archivo = new File(ruta); 
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Primero debemos de saber cuantas filas tiene el archivo, ya que sabemos que la matriz sera de N x 3
            // Entonces la forma mas facil es leer el archivo y ver cuantas filas tiene por medio de un contador
            int contadorFilas = 0;
            String linea;
            while ((linea = br.readLine()) != null) {
                contadorFilas++;
            }            
            // Una vez leido, podemos declarar nuestra matriz
            matriz = new int[contadorFilas][3];
            
            // Volvemos a llenar los datos para hacer de nuevo la lectura y con las dimensiones esta vez podemos asignarle los valores a la matriz
            // Es decir una lectura normal
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            contadorFilas = 0;
            while ((linea = br.readLine()) != null) {
                String[] numeros = linea.split(",");
                for (int i = 0; i < numeros.length; i++) {
                    matriz[contadorFilas][i] = Integer.parseInt(numeros[i]);
                }
                contadorFilas++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                    // Y por ultimo, vamos a retornar el valor de la matriz que inicializamos dentro de la funcion, pero al retornarla es el valor que se almanceara en la matriz global
                    return matriz;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return matriz;
    }
    
    // LEER DOS MATRICES Y ASIGNARLAS A LA MATRIZ MADRE
    public static void LlenarMadre(int[][] matrizIzq, int[][] matrizDer){
        // Lo unico que hace este metodo es recorrer las dos matrices cada una por separado
        // Y asignar los valores de la matriz madre para que tengamos la representacion de una matriz de N X 6
        for (int i = 0; i < matrizIzq.length; i++) {
            for (int j = 0; j < matrizIzq[i].length; j++) {
                matrizMadre[i][j] = matrizIzq[i][j];
            }
        }
        // Para la segunda matriz, solo empezamos a guardar los valores desde 3 hasta 6.
        for (int i = 0; i < matrizDer.length; i++) {
            for (int j = 0; j < matrizDer[i].length; j++) {
                matrizMadre[i][j+3] = matrizDer[i][j];
            }
        }
    }

    // METODO PARA REALIZAR EL ATAQUE HECHO PASO A PASO
    public static void AtaqueNormal(){
        /*
        Para hacer este metodo, nos fuimos resolviendo paso a paso, puede ser que le haga falta una que otra validacion
        pero el resultaod es el esperado
        */

        // PRIMER PASO: CONVERTIR LA POSICION 1,1 EN 1
            // Guardamos la posicion 0,0
        int posicion = matrizMadre[0][0];
            // Calculamos el InversoModular
        int inverso = InversoModular(posicion);
        System.out.println("CAMBIANDO LA COLUMNA 1");
        System.out.println(posicion);
        System.out.println(inverso);
           
        // Tenemos la situacion que si el inverso modular es 0, entonces vamos a cambiar filas hasta que encontremos uno diferente de 0
        // Podemos usar un while 
        int numero_fila = 0; // La fila, seria la fila actual, porque estamos en la posicion 0
        while (inverso == 0){
            // Iremos cambiando la posicion de la fila, es decir por cada vez que entre al While va a aumentar una fila
            // Y calcular el inverso modular de la posicion actual
            posicion = matrizMadre[numero_fila++][0];
            inverso = InversoModular(posicion);
        }
        // Verificamos si se cambio la fila, es decir si el numero de fila es diferente que la columna
        if(numero_fila != 0){
            MostraMatriz(matrizMadre);
            System.out.println("--- TOCO HACER UN CAMBIO DE FILA ---");
            // Si es diferente, toca realizar el cambio de fila, esto lo hacemos para asegurarnos que tendremos
            // en la posicion correcta la matriz tal y como queremos, es decir la identidad

            // Usamos dos auxiliares, la fila actual y la fila por la que hay que cambiar, como usamos un while
            // El ultimo valor de fila, aumento uno mas de lo que esperabamos, entonces hay que restarle uno
            int[] actual = matrizMadre[0];
            int[] aux1 = matrizMadre[(numero_fila)-1];
            
            // Y ahora estos valores hay que hacer el cambio
            matrizMadre[0] = aux1;
            matrizMadre[numero_fila-1] = actual;
            // Se recomienda utilizar variables auxiliares siempre para hacer este tipo de cambios
        }
        MostraMatriz(matrizMadre);

        // PARA ESTE PUNTO YA TENEMOS NUESTRO INVERSO MODULAR CORRECCTO
        // Toca cambiar los valores de la Fila1 para que la posicion 0,0 -> 1
        
        // Usamos nuestro auxiliar fila, para ir cambiando los valores
        int[] fila = matrizMadre[0];
        // Recorremos la fila 1, es decir en la posicion 0
        for (int i = 0; i < matrizMadre[0].length; i++) {
            // Segun el enunciado es la posicion actual * inverso de la posicion 0,0 MOD 27 y ese es el resultado de la fila
            matrizMadre[0][i] = (fila[i] * inverso) % 27;
        }
        
        System.out.println("CAMBINADO LA FILA 1");
        MostraMatriz(matrizMadre);
        System.out.println("---------------------------------");
        // PARA ESTE PUNTO NUESTRA POSICION 0,0 ES IGUAL A 1, ENTONCES NOS QUEDA VOLVER CERO LAS DEMAS POSICIONES DE LA COLUMNA
        // ES DECIR QUE EL RESTO DE FILAS EN LA COLUMNA 0, DEBE DE SER = 0
        posicion = fila[0];
        // Guardamos nuestra posicion en la fila 1, es decir el 1
        
        // Para hacer esto, hacemos un recorrido por filas, este recorrido va ir fila a fila haciendo la multiplicacion explicada en el enunciado
        for (int i = 1; i < matrizMadre.length; i++) {
            // Para este proceso, la fila 1 no la debemos de modificar, por lo tanto la vamos a obviar diciendo que si i es diferente a la fila 0
            // que haga la operacion.
            if(i != 0){
                // Usamos nuestras variables auxiliares porque vamos a modificar posiciones de la fila actual, entonces
                // Aux va a guardar la fila actual
                int[] aux = matrizMadre[i];
                // Pos_aux va a guardar la posicion [i][0] donde i es el numero de fila
                int pos_aux = aux[0];
                
                // Con estos datos guardados ya podemos operar las columnas, entonces
                for (int j = 0; j < matrizMadre[i].length; j++) {
                    // HACEMOS EL RECORRIDO PARA VER CADA COLUMNA DE LA FILA Y OPERAMOS EL NUEVO VALOR
                    // El nuevo valor sera fila_actual[j] - fila_actual[j] * fila1[j] MOD 27
                    // Esta operacion salio del enunciado
                    int guardar = (aux[j] - pos_aux*fila[j])%27;
                    // Y hacemos la validacion de que si es menor a 0, se le sumara 27 por su modulo 27.
                    if(guardar < 0){
                        guardar += 27;
                    }
                    // Una vez calculado el valor, en la posicion actual de la fila actual, guardaremos el valor calculado
                    matrizMadre[i][j] = guardar;
                }
                
            }
        }
        
        System.out.println("CAMBIANDO A 0 LAS DEMAS POSICIONES");
        MostraMatriz(matrizMadre);
        System.out.println("---------------------------------------");
        // PARA ESTE PUNTO, TENEMOS QUE LA COLUMNA 1, EN SU POSICION 1 ES 1 Y LAS DEMAS ES 0
        // AHORA TENEMOS QUE HACER LO MISMO CON LA COLUMNA 2
        // Es decir, que la posicion 2,2 = 1 y el resto sean 0, el proceso es el mismo de arriba, solo que cambiamos el numero de columnas.
        

        // SEGUNDO PASO: CONVERTIR LA POSICION 2,2 EN 1
        posicion = matrizMadre[1][1];
        inverso = InversoModular(posicion);
        System.out.println("CAMBIANDO LA COLUMNA 2");
        System.out.println(posicion);
        System.out.println(inverso);
        numero_fila = 1; // La fila seria 1, porque estamos en la posicion 1,1
        while (inverso == 0){
            posicion = matrizMadre[numero_fila++][1];
            inverso = InversoModular(posicion);
        }
        if(numero_fila != 1){
            MostraMatriz(matrizMadre);
            System.out.println("--- TOCO HACER UN CAMBIO DE FILA ---");
            int[] actual = matrizMadre[1];
            int[] aux1 = matrizMadre[(numero_fila)-1];
            
            matrizMadre[1] = aux1;
            matrizMadre[numero_fila-1] = actual;
        }
        MostraMatriz(matrizMadre);
            
        fila = matrizMadre[1];
        for (int i = 0; i < matrizMadre[1].length; i++) {
            matrizMadre[1][i] = (fila[i] * inverso) % 27;
        }
        
        System.out.println("CAMBINADO LA FILA 2");
        MostraMatriz(matrizMadre);
        System.out.println("---------------------------------");
        
        // CONVIRTIENDO EN 0 LAS DEMAS POSICIONES
        fila = matrizMadre[1];
        posicion = fila[1];
        for (int i = 0; i < matrizMadre.length; i++) {
            if(i != 1){
            int[] aux = matrizMadre[i];
            int pos_aux = aux[1];
            for (int j = 0; j < matrizMadre[i].length; j++) {
                int guardar = (aux[j] - pos_aux*fila[j])%27;
                if(guardar < 0){
                    guardar += 27;
                }
                matrizMadre[i][j] = guardar;
            }                
            }
        }
        System.out.println("CAMBIANDO A 0 LAS DEMAS POSICIONES");
        MostraMatriz(matrizMadre);
        System.out.println("---------------------------------------");
        // PARA ESTE PUNTO, LA COLUMNA 1 Y 2 FUERON EFECTUADAS DE MANERA CORRECTA, SOLO QUEDA REALIZAR LO MISMO PARA LA 3RA



        // TERCER PASO: CONVERTIR LA POSICION 3,3 EN 1
        posicion = matrizMadre[2][2];
        inverso = InversoModular(posicion);
        System.out.println("CAMBIANDO LA COLUMNA 3");
        System.out.println(posicion);
        System.out.println(inverso);
        numero_fila = 2;
        while (inverso == 0){
            posicion = matrizMadre[numero_fila++][2];
            inverso = InversoModular(posicion);
        }
        if(numero_fila != 3){
            MostraMatriz(matrizMadre);
            System.out.println("--- TOCO HACER UN CAMBIO DE FILA ---");
            int[] actual = matrizMadre[2];
            int[] aux1 = matrizMadre[(numero_fila)-1];
            
            matrizMadre[2] = aux1;
            matrizMadre[numero_fila-1] = actual;
        }
        MostraMatriz(matrizMadre);


        fila = matrizMadre[2];
        for (int i = 0; i < matrizMadre[2].length; i++) {
            matrizMadre[2][i] = (fila[i] * inverso) % 27;
        }
        System.out.println("CAMBINADO LA FILA 3");
        MostraMatriz(matrizMadre);
        System.out.println("---------------------------------");

        posicion = fila[2];
        for (int i = 0; i < matrizMadre.length; i++) {
            if(i != 2){
            int[] aux = matrizMadre[i];
            int pos_aux = aux[2];
            for (int j = 0; j < matrizMadre[i].length; j++) {
                int guardar = (aux[j] - pos_aux*fila[j])%27;
                if(guardar < 0){
                    guardar += 27;
                }
                matrizMadre[i][j] = guardar;
            }    
            }
        }
        System.out.println("CAMBIANDO A 0 LAS DEMAS POSICIONES");
        MostraMatriz(matrizMadre);
        System.out.println("---------------------------------------");
    }
    
    // METODO PARA REALIZAR EL ATAQUE HECHO CON FORS
    public static void AtaqueTuneado(){
        
        /*
            Si analizamos el codigo anterior, podemos ver que la secuencia se repite y solo cambia una variable, entonces
            implementamos ese cambio para relizarlo en un for de 0 a 2, para que simule las columnas
        */

    // RECORRIDO DE COLUMNAS
        for (int columnas = 0; columnas < 3; columnas++) {
            // IMPRIMIMOS LA COLUMNA ACTUAL
            System.out.println("COLUMNA: " + columnas);
            // SABEMOS QUE LA POSICION DEBE DE SER EQUIVALENTE ES DECIR, LA MISMA FILA QUE LA COLUMA
            int posicion = matrizMadre[columnas][columnas];
            System.out.println("Convertir 1, el siguiente valor: " + posicion);
            // ENCONTRAMOS EL INVERSO MULTIPLICATIVO
            int inverso = InversoModular(posicion);
            System.out.println("Inverso modular del valor: " + inverso );
            // DECLARAMOS LA FILA = COLUMNA, PORQUE ES LA POSICION DE LA DIAGONAL ES DECIR DEBEN DE SER IGUALES
            int fila = columnas;
            
            // MIENTRAS QUE EL INVERESO SEA DIFERENTE DE 0, HAY QUE HACER UN CAMBIO DE FILA
            while (inverso == 0){
                System.out.println("HAY QUE CAMBIAR LA FILA");
                // OBTENEMOS LA NUEVA POSICION Y EL NUEVO INVERSO PARA CADA FILA HASTA ENCONTRAR EL VALOR CORRECTO
                posicion = matrizMadre[fila][columnas];
                inverso = InversoModular(posicion);
                System.out.println("Nuevo inverso: " + inverso);
                fila++;
                // LA ULTIMA ITERACION, PODEMOS ENCONTRAR EL INVERSO SI, PERO SIEMPRE NOS AUMENTARA LA FILA EN 1, ENTONCES HAY QUE RESTARLA
            }
            
            // COMO SABEMOS SI SE HIZO UN CAMBIO DE FILAS, VERIFICANDO SI LA FILA NO ES IGUAL A LA COLUMNA
            if(fila != columnas){
                // SI NO ES IGUAL, CREAMOS NUESTROS AUXILIARES Y HACEMOS EL CAMBIO DE FILA
                int[] fila_arriba = matrizMadre[columnas];
                int[] fila_cambiar = matrizMadre[fila-1];
                matrizMadre[columnas] = fila_cambiar;
                matrizMadre[fila-1] = fila_arriba;
                System.out.println("--- CAMBIO DE FILA ---");
                MostraMatriz(matrizMadre);
                fila = columnas;
            }
            
            // AHORA BIEN, TENEMOS QUE CAMBIAR LA FILA ACTUAL PARA QUE LA POSICION DONDE SON IGUALES ES DECIR LA [0][0] O [1][1] O [2][2]
            // ESTAS POSICIONES TIENEN QUE TENER SU VALOR 1
            int[] auxiliar = matrizMadre[fila];
            for (int i = 0; i < matrizMadre[fila].length; i++) {
                // APLICAMOS LA OPERACIONI DEL ENUNCIADO
                matrizMadre[fila][i] = (inverso * auxiliar[i]) % 27;
            }
            
            // PARA ESTE MOMENTO LA POSICION IDENTIDAD, TIENE EL VALOR DE 1 Y LOS DEMAS NUMEROS CAMBIADOS
            System.out.println(" RESULTADO DE CAMBIAR LA FILA");
            MostraMatriz(matrizMadre);
            System.out.println("-------------------------------------------------");
            
            // AHORA NOS QUEDA CONVERTIR EN 0 EL RESTO DE LAS POSICIONES DE LA COLUMNA
            System.out.println("CONVIRTIENDO 0 LAS DEMAS FILAS DE LA COLUMNA");
            auxiliar = matrizMadre[fila];
            for (int i = 0; i < matrizMadre.length; i++) {
                if(i != fila){
                    int valor = matrizMadre[i][columnas];
                    int[] fila_aux = matrizMadre[i];
                    for (int j = 0; j < matrizMadre[i].length; j++) {
                        int resultado = (fila_aux[j] - (valor * auxiliar[j])) % 27;
                        if (resultado < 0){
                            resultado += 27;
                        }
                        matrizMadre[i][j] = resultado;
                    }
                }
            }

            MostraMatriz(matrizMadre);
            System.out.println("-------------------------------------------------");
        }
        
        // NOTA: RECORDEMOS QUE TODO ESTO SE VA A HACER PRIMERO PARA LA COLUMNA 0, LUEGO PARA LA COLUMNA 1, LUEGO PARA LA COLUMNA 2
    }
    
    // METODO QUE REPRESENTA COMO CALCULAR EL INVERSO MODULAR 27 DE CUALQUIER NUMERO
    public static int InversoModular(int numero){
        int valor = 0;
        while(valor < 27){
            if((numero * valor) % 27 == 1){
                return valor;
            }
            valor++;
        }
        return 0;
    }

    // METODO PARA OBTENER LA CLAVE
     public static void MatrizClave(){
         // Es un recorrido para llenar una matriz conocida como clave, con el detalle
         // que recorremos la matriz madre en las columnas 3,4,5 porque ahi esta la respuesta que queremos
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                clave[i][j] = matrizMadre[i][j+3];
            }
        }
    }

    // METODO PARA SACAR LA TRANSPUESTA DE UNA MATRIZ CUADRADA DE 3X3
    public static void Transpuesta(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(clave[j][i]+"\t");
            }
            System.out.println("");
        }        
    }
    
    
    
    
   
    

}
