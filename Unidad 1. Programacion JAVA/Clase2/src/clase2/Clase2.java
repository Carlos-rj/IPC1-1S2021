package clase2;

// Como vamos a guardar datos de la consola, usamos nuestro 
// Siempre util y confiable Scanner
import java.util.Scanner;

public class Clase2 {

    // Metodo main, es el primer metodo a ejecutar
    public static void main(String[] args) {
        // EXCEPCIONES
            /*
            Java maneja ciertas excepciones y para que el programa las reconozca
            se recomienda que se utilice un Try - Catch donde en el try
            iran todas las sentencias de nuestro codigo y el catch
            tendra el codigo por si llegara a ocurrir un error.
            */
        try{
            // En este ejemplo nuestra variable Scanner se llama sc
            // El nombre de esta variable no importa, ustedes sabran
            // Como identificarla mas adelante
            Scanner sc = new Scanner(System.in);
            
            // MENU EXPLICANDO FUNCIONES Y METODOS
            
            /*
            Utilizamos un Do-While para hacer un menu como se explico
            en el ejemplo anterior, esto por que nos da la posibilidad
            de que se repitan las acciones hasta que hagamos nuestra opcion
            de salir.
            */
            int opcion = 0;
            do{
                System.out.println("--- MENU ---");
                System.out.println("1. Ejemplo Funcion");
                System.out.println("2. Ejemplo Funcion con Parametros");
                System.out.println("3. Ejemplo Metodo");
                System.out.println("4. Ejemplo Metodo con Parametros");
                System.out.println("5. Salir");
                System.out.print("Escoger una opcion: ");
                opcion = sc.nextInt();
                switch(opcion){
                    case 1:    
                        // FUNCIONES SIN PARAMETROS
                        /*
                        La descripcion mas basica que les puedo decir:
                        Una funcion es una variable la cual ejecuta cierta porcion
                        de codigo para retornar un resultado, en este caso no mandamos
                        ningun parametro, por lo tanto no mandamos nada entre parentesis
                        
                        Esta puede ser almacenada en otra variable, como bien sabemos
                        al final de cuentas una funcion tiene un valor.
                        */
                        int resultado;
                       
                        // En este caso le estamos diciendo que la variable resultado
                        // Tendra el valor que se encuentre en la funcion Sumar
                        // Ver funcion Sumar en la parte de abajo
                        resultado = Sumar();
                        System.out.println("El resultado de la suma es: " + resultado);
                        break;
                    case 2:
                        // FUNCIONES CON PARAMETROS
                        /*
                        Resulta que hay porciones de codigo que necesitan de datos que van
                        cambiando con el tiempo y para eso nos sirve trabajar con parametros
                        para no tener un dato exacto si no que este cambie segun los datos que se
                        le envian.
                        
                        Como la funcion anterior, al final de realizar la funcion, esta queda
                        con el valor que le retornamos.
                        
                        En este caso, la suma va a recibir dos numeros y la forma que los estamos enviando
                        Es como los va a recibir la funcion donde la tenemos declarada, por ejemplo
                        Vamos a mandar Sumar2(n1, n2) y tambien Sumar2(n2, n1) y veremos el desglose
                        Donde esta declarada la funcion.
                        */
                        double n1, n2, r;
                        System.out.print("Ingresar el primer numero: ");
                        n1 = sc.nextDouble();
                        System.out.print("Ingresar el segundo numero: ");
                        n2 = sc.nextDouble();
                        r = Sumar2(n1, n2);
                        System.out.println("El resultado de la suma es: " + r);
                        break;
                    case 3:
                        // METODOS O PROCEDIMIENTOS SIN PARAMETROS
                        /*
                        Podemos decir que un metodo o procedimiento
                        Es una porcion de codigo que puede ser llamada en cualquier
                        momento, hacemos esto por que sabemos que hay ciertas partes
                        del codigo que se van a repetir y lo hacemos para que el codigo
                        quede mas ordenado
                        */
                        SaludarAlumnos();   
                        SumarNumeros();
                        break;
                    case 4:
                        // METODOS O PROCEDMIENTOS CON PARAMETROS
                        /*
                        Una vez que manejamos los anteriores conceptos, es facil darnos cuenta
                        que estos son muy parecidos, la unica diferencia es que este metodo
                        no va a retornar un valor, si no que estamos llamando una pocion de codigo
                        y mandandole valores iniciales.
                        
                        Ver el desglose mas abajo de las dos llaamdas
                        */
                        RestarNumeros(10,5);
                        RestarNumeros(5,10);
                        break;
                    case 5:
                        System.out.println("Gracias por utilizar el programa");
                        break;
                    default:
                        System.out.println("La opcion escogida no es valida");
                        break;
                }
                }while(opcion != 5);
            
        }catch(Exception e){
            //System.out.println("Nos ha dado un error chavales :(");
            //System.out.println(e.toString());
            //System.out.println();
            e.printStackTrace();
        }
        
    }
    
    // Por cuestiones de orden, es recomendable que cualquier
    // metodo o funcion que declaremos lo hagamos abajo del metodo main
    
    
    // FUNCIONES SIN PARAMETROS
    /*
    Una funcion tiene un tipo de acceso: public
    Como estamos trabajando en el main debemos agregarle el static
    Seguido de eso tiene un tipo de dato, este puede ser
        boolean, int, char, double, String, etc
    Y seguido de va el nombre de la funcion y parentesis
    */
    public static int Sumar(){
        // En este caso, solo queremos una funcion que le pida
        // al usuario dos numeros y que le retorne la suma
        
        Scanner sc = new Scanner(System.in);
        int numero1, numero2, resultado;
        System.out.print("Ingresar el primer numero: ");
        numero1 = sc.nextInt();
        System.out.print("Ingresar el segundo numero: ");
        numero2 = sc.nextInt(); 
        resultado = numero1 + numero2;
        // El return es la palabra reservada para decirle a la funcion
        // que se termino, es decir que lo que esta abajo de la misma
        // ya no se va a realizar y el valor que esta acompañando al return
        // es el valor que tomara cuando lo mandemos a llamar
        return resultado;
    }
      
    
    // FUNCION CON PARAMETROS
    /*
    A diferencia de la funcion anterior, se declaran exactamente igual
    Solo que en los parentesis van una lista de variables si queremos verlo asi
    
    -La lista de variables puede ser: uno o mas variables.
    -El tipo de dato de estas variables no deben de ser igual al de la funcion
    */

    public static double Sumar2(double numero1, double numero2){
        return numero1 + numero2;
    }
    
    // COMO FUNCIONAN LOS PARAMETROS ENTONCES:
    // Supongamos que los parametros son las variables que estamos declarando
    // dentro de nuestra porcion de codigo con el valor que le mandamos desde
    // la llamada, es decir:
    
    /* Llamada de Sumar(n1, n2)
       La funcion quedaria asi:
        double numero1 = n1;
        double numero2 = n2;
        return numero1 + numero2;
    */
    
    /* Llamada de Sumar(n2, n1)
        La funcion quedaria asi:
        double numero1 = n2;
        double numero2 = n1;
        return numero1 + numero2;
    */
    
    // La diferencia mas notable es el orden de como se almacena la informacion
    // Por lo tanto es importante recordar que:
    // En el orden que se mandan los parametros es como se guardaran en la funcion.
    // Podemos ver el ejemplo anterior para entender este caso.
    
    // Nota: Se que el ejemplo es muy basico, pero es para que se den una idea de como funciona
    
        
    //METODO SIN PARAMETROS
    /*
    Un metodo tiene un tipo de acceso: public
    Como estamos trabajando en el main debemos agregarle el static
    a diferencia de las funciones, estas no retornan un valor.
    por lo tanto el tipo de dato es void que es equivalente a vacio.
    */
    
    public static void SaludarAlumnos(){
        System.out.println("HOLA ALUMNOS");
        System.out.println("BIENVENIDOS AL PRIMER LAB EXTRA");
        System.out.println("¿ESTAN ENTENDIENDO?");
        System.out.println("--------------------------------");
    }
    
    public static void SumarNumeros(){
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        System.out.println("EL RESULTADO DE LA SUMA ES: " + (n1 + n2));
    }
    
    //METODOS CON PARAMETROS
    
    /*
    Al igual que una funcion con parametros, se declaran entre parentesis despues
    del nombre y como recalque anteriormente, los parametros no tienen que tener
    un tipo de dato especifico, veanlo como variables que se van a declarar
    al inicio del codigo
    */
    public static void RestarNumeros(int numero1, int numero2){
        System.out.println("El primer numero es: " + numero1);
        System.out.println("El segundo numero es: " + numero2);
        System.out.println("La resta de los numeros es: "+ (numero1 - numero2));
    }
    
    /* Llamada de RestarNumeros(10,5)
    Lo primero que vamos a hacer, como es una funcion con parametro es declarar esas varaibles
        int numero 1 = 10;
        int numero 2 = 5;
    y luego ya seguimos con el codigo dentro del metodo, es decir.
        System.out.println("El primer numero es: " + numero1); -> 10
        System.out.println("El segundo numero es: " + numero2); -> 5
        System.out.println("La resta de los numeros es: "+ (numero1 - numero2)); -> 5
    */
    
    /* Llamada de RestarNumeros(5,10)
    Lo primero que vamos a hacer, como es una funcion con parametro es declarar esas varaibles
        int numero 1 = 5;
        int numero 2 = 10;
    y luego ya seguimos con el codigo dentro del metodo, es decir.
        System.out.println("El primer numero es: " + numero1); -> 5
        System.out.println("El segundo numero es: " + numero2); -> 10
        System.out.println("La resta de los numeros es: "+ (numero1 - numero2)); -> -5
    */
    
    // La diferencia mas notable es de la forma que como se recibe los parametros
    // afectaran al codigo dentro del metodo, pero mas alla de, sigue siendo una
    // porcion de codigo que se ejecutara cuando la llamemos

    }
    

