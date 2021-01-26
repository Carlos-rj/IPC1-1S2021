package clase1;

// IMPORTAR LIBRERIAS
/* 
    Utilizamos la palabra reservada import
    Java trae varias librerias incluidas de por si
    Para la lectura de informacion por consola, utilizamos
    La libreria de Scanner, esta es la forma de importarla
*/
import java.util.Scanner;

public class Clase1 {
    /* 
        Este es el metodo principal, es decir el primer metodo
        a ejecutar cuando se inicie el programa, este se escribe de
        manera automatica 
    */
    public static void main(String[] args) {
        /* 
            No es obligatorio, pero se recomienda que se usen dos
            Scanner uno para el texto y otro para los demas tipos de datos
        */
        
    // UN ESCANER PARA CADENAS
        Scanner texto = new Scanner(System.in);
        
    // UN ESCANER PARA LOS DEMAS DATOS
        Scanner numeros = new Scanner(System.in);
        
    // DECLARACION DE VARIABLES PRIMITIVAS
        /* 
            En el siguiente apartado hablamos de los posibles
            valores que tienen los tipos de datos mas comunes 
        */
               
    // VARIABLES BOOLEAN: Verdadero/Falso
        boolean valor;
        valor = true;
        valor = false;
        
    // VARIABLES CHAR: Caracteres o valor ASCII
        char caracter;
        caracter = 'A';
        caracter = 65;
        
    // VARIABLES INT: Enteros positivos y negativos
        int entero;
        entero = 100;
        entero = -100;
        
    // VARIABLES DOUBLE: Decimales positivos y negativos
        double decimal;
        decimal = 100.25;
        decimal = -100.25;
        
    // VARIABLES STRING: Cadenas de texto
        String cadenas;
        cadenas = "Hola mundo :)";
        
    // IMPRIMIR EN CONSOLA
        /* Para imprimir en consola usamos las instrucciones: 
           -System.out.println(expresion) 
            Imprime el valor de expresion con un salto de linea al final 
        
           -System.out.print(expresion)
            Imprime el valor de expresion sin un salto de linea al final
        */
        
    // IMPRIMENDO UNA CADENA
        System.out.println("Hola laboratorio IPC1");
        
    // IMPRIMIENDO VARIABLES
        System.out.println(cadenas);
        
    // IMPRIMIENDO CADENAS + VARIABLES
        System.out.println(cadenas + " - concatenamos texto");
        System.out.println(cadenas + " " + entero);
        System.out.println(decimal + entero);
        // Pequeño Hack: Si escriben "sout" + tab escribe automaticamente el println
        
    // OBTENER TEXTO DEL TECLADO Y ALMACENARLO
        /* 
            Podemos recibir informacion de la consola por medio del teclado
            para este tipo de operaciones utilizamos el Scanner que se declaro
            anteriormente 
        */
    
        System.out.println("BIENVENIDO AL LABORATORIO DE IPC1");
        // Para guardar cadenas usamos Scanner.nextLine()
        System.out.print("INGRESE SU NOMBRE: ");
        cadenas = texto.nextLine();
        
        // Para guardar enteros usamos Scanner.nextInt()
        System.out.print("INGRESE SU EDAD: ");
        entero = numeros.nextInt();
        
        // Para guardar decimales usamos Scanner.nextDouble()
        System.out.print("¿CUAL ES SU NOTA DE LABORATORIO? - ");
        decimal = numeros.nextDouble();
        
    // MOSTRANDO LA INFORMACION ALMACENADA EN LAS VARIABLES
        /*
            Queremos mostrar la informacion que recolectamos en las variables
            y en el ejemplo se puede ver como el texto va cambiando segun la
            informacion que se va ingresando
        */
        System.out.println("--- RESUMEN DE LOS DATOS ---");
        System.out.println("Nombre: " + cadenas);
        System.out.println("Edad: " + entero);
        System.out.println("Nota: " + decimal);
        
    // SETENCIA IF y ELSE IF
        /*
            En este caso decimal esta guardando la nota segun el texto anterior
            por lo tanto es el ejemplo perfecto para mostrar como funciona un
            if, if-else, if-else if-else
    
            La sentencia IF y ELSE IF, sirve para evaluar una condicion.
        */
        
        if(decimal > 60)
        {
            //Si la condicion es verdadera, se cumple esta porcion de codigo
            System.out.println("Felicidades " + cadenas + " Ganaste laboratorio");
        }
        // Si la condicion anterior es falsa, entonces se va a la segunda condicion
        else if(decimal > 57)
        {
            //Si la condicion es verdadera, se cumple esta porcion de codigo
            System.out.println("Te quedaste por poquitititito");
        }
        // Si la condicion anterior es falsa, se va a la siguiente condicion.
        else{
            // Si entra aqui, significa que ninguna condicion anterior es verdadera
            System.out.println("F, echale ganas :(");
        }
        
    // SENTENCIA SWITCH
        /*
            Esta sentencia se utiliza normalmente cuando hay muchas opciones
            Es decir si las condiciones abarcan igualdad es mas recomendable
            Utilizar un Switch que un If-Else.
    
            El siguiente ejemplo ingresamos un numero del 1 al 7 y el Switch
            verifica la variable para dar un mensaje segun la condicion.
        */
  
        System.out.println("INGRESE UN NUMERO DEL 1 al 7");
        entero = numeros.nextInt();
        /* 
            Switch (variable): Esta variable es la que tiene el valor a evaluar
            Se utiliza case y el valor a comparar
            Dentro de cada case debe de terminar con un break.
        
            Se utiliza un default para indicar que ninguna
            de las opciones anteriores es valida, es decir que el valor
            no cumple ninguna de los casos.
        */
        switch(entero){
            case 1:
                System.out.println("ES EL DIA LUNES");
                break;
            case 2:
                System.out.println("ES EL DIA MARTES");
                break;
            case 3:
                System.out.println("ES EL DIA MIERCOLES");
                break;
            case 4:
                System.out.println("ES EL DIA JUEVES");
                break;
            case 5:
                System.out.println("ES EL DIA VIERNES");
                break;
            case 6:
                System.out.println("ES EL DIA SABADO");
                break;
            case 7:
                System.out.println("ES EL DIA DOMINGO");
                break;                
            default:
                System.out.println("NO ES NINGUN DIA DE LA SEMANA");
                break;
        }
        
    // SENTENCIA WHILE
        /*
            Esta sentencia realizara el codigo dentro del bloque de codigo
            media vez se cumpla la condicion, la cuestion es que debemos de
            tener cuidado, ya que se puede trabar el programa ya que nunca se
            cumple la funcion
        */
        int limite = 10;
        while(limite > 0)
        {
            System.out.print(limite + " DENTRO DEL WHILE");
            limite--;
            // variable--: aqui estamos usando un operador de decremento
            // Tambien pudimos usar las siguiente alternativas
            // limite = limite - 1;
            // limite -= 1;
        }
        System.out.println(limite + " FUERA DEL WHILE");
     
        /*
            Dentro del While podemos ver como va disminuyendo el valor
            y cuando salimos del while podemos ver el valor actual.
        */
    // SENTENCIAS DO-WHILE
    
        /*
            La sentencia DO-WHILE funciona igual que el WHILE a diferencia
            que este hace el codigo al menos una vez, es ideal para realizar
            menus, como podemos ver en el ejemplo
        */
        
        // USAMOS UNA VARIABLE PARA GUARDAR LA OPCION
        int opcion;
        do{
            // ESTE ES EL CODIGO QUE SE VA A REPETIR HASTA QUE SE CUMPLA
            // LA CONDICION DEL WHILE
            System.out.println("--- MENU ---");
            System.out.println("1. Mensaje 1");
            System.out.println("2. Mensaje 2");
            System.out.println("3. Mensaje 3");
            System.out.println("4. Salir");
            System.out.print("Escoger una opcion: ");
            opcion = numeros.nextInt();
            switch(opcion){
                case 1:
                    System.out.println("GRACIAS POR PRESTAR ATENCION");
                    break;
                case 2:
                    System.out.println("ECHELE GANAS");
                    break;
                case 3:
                    System.out.println("MUCHO CONTENIDO POR HOY");
                    break;
                case 4:
                    System.out.println("Gracias por utilizar el programa");
                    break;
                default:
                    System.out.println("La opcion escogida no es valida");
                    break;
            }
        }while(opcion != 4);
        
    // SENTENCIA FOR
        /*
            No hay mucha diferencia entre un for con un while
            la ventaja es que en la forma de escribir el for ya manejamos
            un iterador, el cual nos ayuda a cumplir la condicion
        */
        System.out.println("TABLAS DE MULTIPLICAR");
        int numero;
    
        System.out.print("Ingrese el numero base: ");
        numero = numeros.nextInt();
        
        /* 
            Usamos una variable de tipo entero como iterador
            Si la condicion se cumple, se realiza el codigo 
            Si no se cumple, sigue con el codigo abajo del for
        
            La estructura del for es
            for(VARIABLE ITERADOR; CONDICION; ITERACION){
                CODIGO
            }
            ITERADOR: Variable que maneja el flujo, se puede usar en el codigo
            CONDICION: Si esta condicion es verdadera, se realiza el codigo.
            ITERACION: Accion que hara cada vez que termine el codigo
        */ 
        int i;
        
        // EJEMPLO DE UN FOR EN AUMENTO
        for(i=1; i <= 10; i++)
        {
            System.out.println(numero + " x " + i + " = " + (numero*i));
        }
        
        System.out.println("-----------------------------------");
        
        // EJEMPLO DE UN FOR EN DECREMENTO
        for(i=10; i >= 1; i--)
        {
            System.out.println(numero + " x " + i + " = " + (numero*i));
        }
    }
}
