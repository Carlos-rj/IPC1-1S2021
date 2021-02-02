package ejemplodenoche;

//El buen import Scanner, nada le gana
import java.util.Scanner;

public class EjemploDeNoche {

    public static void main(String[] args) {
        // Hacemos nuestro viejo y confiable menu.
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        do{
            System.out.println("MENU PRINCIPAL");
            System.out.println("1. SUMA");
            System.out.println("2. SUB-MENU");
            System.out.println("3. SALIR");
            System.out.print("Ingresar una opcion: ");
            opcion = sc.nextInt();
            switch(opcion){
                case 1:
                    Suma();
                    break;
                case 2:
                    SubMenu();
                case 3:
                    System.out.println("Gracias por utilizar el programa");
                    break;
                default:
                    System.out.println("No es valida la opcion");
            }
        }while(opcion != 3);
    }
    
    public static void Suma(){
        Scanner sc = new Scanner(System.in);
        int n1, n2;
        n1 = 0;
        n2 = 0;
        do{
            /* El uso de try-catch es bien especial
             para este tipo de problemas lo mas seguro es hacerlo
             dentro del bucle, por si hay un problema que se repita
             el ciclo. */
            
            /*
            Recordemos que si hay un error en el try, se va directamente
            al Catch y seguira con el codigo que esta despues del Catch
            */
            try{
                n1 = sc.nextInt();
                n2 = sc.nextInt();
                if(n1 < 0 || n2 < 0)
                {
                    System.out.println("Los numeros deben de ser positivos");
                }else{
                    System.out.println("El resultado es: " + (n1 + n2));            
                }
            }catch(Exception e){
                System.out.println("Solo son validos los numeros");
                n1 = -1; 
                n2 = -1;
                sc = new Scanner(System.in);
                // Suma();
                /*
                Recuerden no volver a llamar el mismo metodo, por que lo que estamos haciendo es sobreescribiendo codigo.
                */
            }
        /* Supongamos que aqui hay varios escrituras
         Si hubiera un catch va a hacer el codigo que esta debajo de el
         Pero como no hay nada, no ejecuta nada.
         En este caso, el catch esta justo detras de que se termine el
         do while, por lo tanto se va a repetir.
            
         Recuerden que en el catch deben de poner las validaciones para que
         la validacion se cumpla y vuelva a repetir el programa
        */
        }while(n1 < 0 || n2 < 0);
    }
    
    public static void SubMenu(){
       Scanner sc = new Scanner(System.in);
        int opcion = 0;
        do{
            System.out.println("SUB MENU");
            System.out.println("1. SALUDAR");
            System.out.println("2. DESPEDIR");
            System.out.println("3. REGRESAR");
            switch(opcion){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    // RECUERDEN QUE SI HACEMOS UN MENU DENTRO DEL MENU, NO ES NECESARIO LLAMAR DE NUEVO AL METODO DONDE ESTABAMOS
                    // lo que estariamos haciendo es poner codigo encima del codigo, es decir que si llamamos las lineas de codigo para este apartado
                    
                    // Tendriamos algo parecido a esto.
                    // Main
                    //      SubMenu
                    //          Main dentro de SubMenu
                    //          Termina Main dentro de SubMenu
                    //      Termina SubMenu
                    // Termina Main
                    
                    // Estariamos poniendo codigo encima de codigo y al final estamos creando una especie de muñeca rusa entrando mas y mas a fondo.
                    // Y cuando queramos terminar el codigo, nos daremos cuenta que se esta ejecutando el codigo pendiente
                    break;
            }
        }while(opcion != 3);
    }
    
}
