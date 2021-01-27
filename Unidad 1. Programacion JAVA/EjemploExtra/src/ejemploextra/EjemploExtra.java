package ejemploextra;

import java.util.Scanner;

public class EjemploExtra {
    
    public static void main(String[] args) {
        // Un ejemplo rapido de como usar metodos y funciones en un programa mas normal
        // Como siempre, nuestro bonito y confiable menu
        Scanner sc = new Scanner(System.in);
        int opcion=0;
        do{
            try{
                System.out.println("--- MENU PRINCIPAL ---");
                System.out.println("1. Rango de numeros");
                System.out.println("2. Tablas de Potencia");
                System.out.println("3. Salir");
                System.out.print("Ingresar la opcion que desea: ");
                opcion = sc.nextInt();
                switch(opcion){
                    case 1:
                        RangoNumeros();
                        break;
                    case 2:
                        TablasMultiplicar();
                        break;
                    case 3:
                        System.out.println("Gracias por utilizar el programa");
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        break;
                }
            }catch(Exception e)
            {
                System.out.println(e.toString());
            }
        }while(opcion != 3);
    }
    
    // Tenemos nuestro codigo en el metodo main, de una manera ordenada y es lo unico que
    // debemos de escribir en el, de aqui en adelante estara nuestro "chirmol" de metodos
    // Tambien explicaremos el uso del Try - Catch en un metodo, al final la logica es la misma para todos
    
    public static void RangoNumeros(){
        Scanner sc = new Scanner(System.in);
        
        // ESTO ES EL CODIGO QUE VAS A PROBAR HACER
        try{
            System.out.println("-> RANGO DE NUMEROS");
            int inicio, fin;
            System.out.print("Ingresar el numero de inicio: ");
            inicio = sc.nextInt();
            System.out.print("Ingresar el numero de final: ");
            fin = sc.nextInt();
        // En este caso podemos hacerlo de dos maneras con un For o un While
        // Descomentar uno de los dos para ver que funcionan igual
            RangosWhile(inicio, fin);
            //RangosFor(inicio, fin);
         // Para que usarmos \n, es equivalente a un salto de linea
            System.out.println("\n------------------------------------------------\n");
        }
        // Y SI HAY UN ERROR QUIERO QUE ENTRES AQUI
        catch(Exception e){
            // Para imprimir el error en consola de una manera mas "entendible" para la vista del programador
            // utilizamos el siguiente comando
            e.printStackTrace();
            
            // Pero no es del todo factible, mas que todo usenlo para reconocer sus errores y corregirlos
            
        }
    }
    
    public static void TablasMultiplicar(){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("-> TABLA DE POTENCIA");
        int base, fin, potencia;
        System.out.print("Ingresar el numero de base: ");
        base = sc.nextInt();
        System.out.print("Ingresar el numero de fin: ");
        fin = sc.nextInt();


        // Si quisieramos saber la potencia, sin usar una libreria
        // Por concepto sabemos que es multiplicar el numero base la cantidad de veces a la que
        // es elevada, es decir 2^5= 2*2*2*2*2
        
        // Entonces el multiplicar una variable resulta un proceso que se repite varias veces, es decir
        // un Bucle, para eso podemos utilizar un for o un while.
        
        // Pero para hacerlo mas intuitivo, utilizaremos una funcion que recibe de parametros
        // El numero base y el limite que tiene que hacer la potencia.
        
        int i;
        for(i=1; i <= fin; i++){
            // Guardamos el valor en una variable, esto no es necesario, podemos llamar la funcion directamente
            // y el resultado sera el mismo
            int resultado = Potencia(base, i);
            System.out.println(base + " ^ " + i + " = " + resultado);
            //System.out.println(base + " ^ " + i + " = " + Potencia(base,i));
        }
                
    }
    
    // Las porciones de condigo dentro de los metodos tambien pueden llamar metodos
    
    /* 
    En este caso, son dos metodos que reciben parametros pero que funcionan igual.
    */
    public static void RangosFor(int n1, int n2){
        int i = 0;
        System.out.println("Los numeros en el rango de numeros son: ");
        for(i = n1; i <= n2; i++){
            System.out.print(i + " ");
        }
    }
    
    public static void RangosWhile(int n1, int n2){
        System.out.println("Los numeros en el rango de numeros son: ");
        while (n1 <= n2){
            System.out.print(n1 + " ");
            n1++;
        }
    }
    
    public static int Potencia(int base, int potencia){
        // Usamos i, que es nuestro iterador por excelencia
        int i, resultado;
        resultado = base;
        
        // Segun la logica, queremos multiplicar el numero n veces, es decir potencia
        // Lo que estamos haciendo es un recorrido de 1 hasta la potencia y en la variable
        // resultado, vamos guardando la multiplicacion, es decir que cada iteracion se multiplica la variable         
        for(i = 1; i < potencia; i++){
            resultado = resultado * base; 
            // esto es equivalente a decir
            // resultado *= base
        }
        // Solo nos queda retornar el valor ya que actualmente su valor es la potencia.
        return resultado;
    }
    
    
    // Espero que con estos ejemplos haya quedado un poco mas claro el uso de metodos y funciones
    // Al final de cuentas, este puede ser el que nosotros querramos
}
