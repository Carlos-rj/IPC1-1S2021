package practica1;

import java.util.Scanner;
import java.io.*;

public class Practica1 {

    static int [][] MatrizA, MatrizB, MatrizC, MatrizM;
    static double [][] GaussA, InversaA, MatrizR, MatrizD;
    static Scanner sc = new Scanner(System.in);
    static Scanner lector = new Scanner(System.in);
    
    public static void main(String[] args) {
        int opcion = 0;
        do {
            System.out.println("--- PRACTICA 1 ---");
            System.out.println("1. Encriptar");
            System.out.println("2. Desencriptar");
            System.out.println("3. Ataque de texto plano");
            System.out.println("4. Salir");
            System.out.print("Ingrese la opcion que desea realizar: ");
            opcion = sc.nextInt();
            switch(opcion){
                case 1:
                    Encriptado();
                    break;
                case 2:
                    Desencriptado();
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("Gracias por utilizar el programa.");
                    break;
            }
        } while (opcion != 4);
    }

    public static void Encriptado(){
        System.out.println("--- MENU DE ENCRIPTADO ---");
        int opcion = 0;
        do {
            System.out.println("1. Ingresar Mensaje");
            System.out.println("2. Ingresar Matriz A");
            System.out.println("3. Ingtesar Matriz B");
            System.out.println("4. Mostrar mensaje encriptado");
            System.out.println("5. Regresar");
            System.out.print("¿Que opcion vamos a realizar? ");
            opcion = sc.nextInt();
            switch(opcion){
                case 1:
                    LeerMensaje();
                    break;
                case 2:
                    LeerMatrizA();
                    break;
                case 3:
                    LeerMatrizB();
                    break;
                case 4:
                    Encriptar();
                    break;
                case 5:
                    System.out.println("REGRESANDO AL MENU PRINCIPAL");
                    break;
                default:
                    System.out.println("La opcion no es valida :)");
            }
        } while (opcion != 5);
    }
    
    public static void LeerMensaje(){
        String Mensaje;
        System.out.println("Ingresar el mensaje que se quiere encriptar");
        Mensaje = lector.nextLine();
        char[] Caracteres = Mensaje.toUpperCase().toCharArray();
        int Tamaño = Caracteres.length;
        int Aproximado = 0;
        System.out.println("Cantidad Real: " + Tamaño);
        if(Tamaño % 3 == 1){
            Aproximado = Tamaño + 2;
        }else if(Tamaño % 3 == 2){
            Aproximado = Tamaño + 1;
        }else{
            Aproximado = Tamaño;
        }
        System.out.println("Cantidad aproximada: " + Aproximado);
        int Columnas = Aproximado / 3;
        MatrizM = new int[3][Columnas];
        int indice = 0;

        for (int i = 0; i < Columnas; i++) {
            for (int j = 0; j < 3; j++) {
                if(indice < Tamaño){
                    MatrizM[j][i] = ConvertirLetras(Caracteres[indice]);
                    indice++;
                }else{
                    MatrizM[j][i] = 27;
                }
            }
        }

        VerMatriz(MatrizM);
    }
    
    public static int ConvertirLetras(char caracter){
        switch (caracter){
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
    
    public static void VerMatriz(int[][] matriz){
                for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(" [ " + matriz[i][j] + " ] ");
            }
            System.out.println("");
        }
    }
    
    public static void LeerMatrizA(){
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            System.out.println("Ingrese la ruta del archivo que desea leer: ");
            String ruta = lector.nextLine();
            archivo = new File(ruta);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea;
            int contadorFilas = 0;
            MatrizA = new int[3][3];
            while ((linea = br.readLine()) != null) {
                String[] numeros = linea.split(",");
                for (int i = 0; i < numeros.length; i++) {
                    MatrizA[contadorFilas][i] = Integer.parseInt(numeros[i]);
                }
                contadorFilas++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            VerMatriz(MatrizA);
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
    
    public static void LeerMatrizB(){
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            System.out.println("Ingrese la ruta del archivo que desea leer: ");
            String ruta = lector.nextLine();
            archivo = new File(ruta);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea;
            int contadorFilas = 0;
            int contadorColumnas = 0;
            while ((linea = br.readLine()) != null){
                String[] numeros = linea.split(",");
                contadorColumnas = numeros.length;
                contadorFilas++;
            }
            MatrizB = new int[contadorFilas][contadorColumnas];
            contadorFilas = 0;
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            while ((linea = br.readLine()) != null) {
                String[] numeros = linea.split(",");
                for (int i = 0; i < numeros.length; i++) {
                    MatrizB[contadorFilas][i] = Integer.parseInt(numeros[i]);
                }
                contadorFilas++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            VerMatriz(MatrizB);
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }   
    }
    
    public static void Encriptar(){
        MatrizC = new int[MatrizA.length][MatrizM[0].length];
        System.out.println("MULTIPLICACION DE A*M");
        int[][] a = MatrizA;
        int[][] b = MatrizM;
        MatrizC = new int[a.length][b[0].length];

        if (a[0].length == b.length) {
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < b[0].length; j++) {
                    for (int k = 0; k < a[0].length; k++) {
                        MatrizC[i][j] += a[i][k] * b[k][j];
                    }
                }
            }
        }
        VerMatriz(MatrizC);
        
        System.out.println("SUMAR LA MATRIZ (A*M)+B");
        for (int i = 0; i < MatrizC.length; i++) {
            for (int j = 0; j < MatrizC[0].length; j++) {
                MatrizC[i][j] += MatrizB[i][j];
            }
        }
        VerMatriz(MatrizC);
        
        System.out.println("MENSAJE CIFRADO");
        for (int i = 0; i < MatrizC[0].length; i++) {
            for (int j = 0; j < MatrizC.length; j++) {
                System.out.print(MatrizC[j][i]+" ");
            }
        }
        System.out.println("\n-----------------------------------------");
    }
    
    public static void Desencriptado(){
        System.out.println("En este caso, estamos tomando los datos del mensaje encriptado");
        System.out.println("Es decir que la Matriz A,B,C y M son las que ya tenemos guardadas");
        
        System.out.println("INVERSA DE A");
        System.out.println("Encontrando la inversa con Gauss");
        GaussA = new double[3][6];
        for (int i = 0; i < MatrizA.length; i++) {
            for (int j = 0; j < MatrizA[i].length; j++) {
                GaussA[i][j] = MatrizA[i][j];
            }
        }
        GaussA[0][3] = 1;
        GaussA[1][4] = 1;
        GaussA[2][5] = 1;

        double[] F1, F2, F3;
        F1 = GaussA[0];
        F2 = GaussA[1];
        F3 = GaussA[2];

        // POSICION 3,1 -> 0
        double val1 = F1[0];
        double val2 = F3[0];
        for (int i = 0; i < 6; i++) {
        GaussA[2][i] = val1*F3[i] - val2*F1[i];
        }
        
        // POSICION 2,1 -> 0
        val1 = F1[0];
        val2 = F2[0];
        for (int i = 0; i < 6; i++) {
        GaussA[1][i] = val1*F2[i] - val2*F1[i];
        }
        
        // POSICION 3,2 ->
        val1 = F2[1];
        val2 = F3[1];
        for (int i = 0; i < 6; i++) {
        GaussA[2][i] = val1*F3[i] - val2*F2[i];
        }
        
        // VAMOS BIEN POR ACA
        
        // POSICION 1,3 ->
        val1 = F3[2];
        val2 = F1[2];
        for (int i = 0; i < 6; i++) {
        GaussA[0][i] = val1*F1[i] - val2*F3[i];
        }
                
        // POSICION 2,3 ->
        val1 = F2[2];
        val2 = F3[2];
        for (int i = 0; i < 6; i++) {
        GaussA[1][i] = val1*F3[i] - val2*F2[i];
        }     
                
        // POSICION 1,2 ->
        val1 = F1[1];
        val2 = F2[1];
        for (int i = 0; i < 6; i++) {
        GaussA[0][i] = val1*F2[i] - val2*F1[i];
        } 
        
        // VOLVER UNOS
        double pos1,pos2,pos3;
        pos1 = GaussA[0][0];
        pos2 = GaussA[1][1];
        pos3 = GaussA[2][2];
        for (int i = 0; i < 6; i++) {
        GaussA[0][i] = GaussA[0][i] / pos1;
        } 

        for (int i = 0; i < 6; i++) {
        GaussA[1][i] = GaussA[1][i] / pos2;
        } 

        for (int i = 0; i < 6; i++) {
        GaussA[2][i] = GaussA[2][i] / pos3;
        }    
        
        System.out.println("------------------------------");
        InversaA = new double[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                InversaA[i][j] = GaussA[i][j+3];
            }
        }
        
        for (int i = 0; i < InversaA.length; i++) {
            for (int j = 0; j < InversaA[i].length; j++) {
                System.out.print("["+InversaA[i][j]+"]");
            }
            System.out.println("");
        }
        System.out.println("LLENANDO MATRIZ R CON C-B");
        MatrizR = new double[InversaA.length][MatrizC[0].length];

        for (int i = 0; i < MatrizR.length; i++) {
            for (int j = 0; j < MatrizR[0].length; j++) {
                MatrizR[i][j] = (MatrizC[i][j] - MatrizB[i][j]);
            }
        }
        
        
        for (int i = 0; i < MatrizR.length; i++) {
            for (int j = 0; j < MatrizR[i].length; j++) {
                System.out.print("["+MatrizR[i][j]+"]");
            }
            System.out.println("");
        }
        
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
        
        System.out.println("VALORES DEL MENSAJE");
        for (int i = 0; i < MatrizD.length; i++) {
            for (int j = 0; j < MatrizD[0].length; j++) {
                System.out.print(Math.round(MatrizD[i][j])+" ");
            }
            System.out.println("");
        }
        
        System.out.println("MENSAJE DESCIFRADO");
        for (int i = 0; i < MatrizD[0].length; i++) {
            for (int j = 0; j < MatrizD.length; j++) {
                System.out.print(ConvertirNumeros(Math.round(MatrizD[j][i]))+" ");
            }
        }
        
        
        System.out.println("\n-----------------------------------------");
    }
        
    public static char ConvertirNumeros(double numero){
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
 
        
    }
