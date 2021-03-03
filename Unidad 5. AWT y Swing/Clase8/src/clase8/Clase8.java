package clase8;

/*
    En este caso, vamos a tener la clase Main donde vamos a manejar todos
    los arreglos que necesita nuestra interfaz grafica, es decir que nuestra
    clase main, va a tener los arreglos declarados como static y los metodos
    para manejar esta informacion
*/

public class Clase8 {
    // EN ESTE APARTADO DEBEN DE IR TODOS LOS ARREGLOS QUE VAMOS A UTILIZAR
    static Usuarios[] users = new Usuarios[5];
    static int cUsers = 0;
        // Se recomienda utilizad un contador por cada arreglo, para llevar un mejor manejo
        // de la informacion.

    public static void main(String[] args) {
        //Al final de cuentas, nuestra Ventana es un objeto y dentro de este objeto
        //Nosotros declaramos todo lo necesario para trabajar con este objeto como 
        //Si de una ventana se tratara.
       Ventana nueva = new Ventana();
    }
    
    // TODOS LOS METODOS PARA MANEJAR LA INFORMACION
    
    // METODO PARA AGREGAR UN USUARIO AL ARREGLO
    //  Le mandamos como parametro un objeto del tipo que queremos almacenar
    public static void AgregarUsuario(Usuarios user){
        if(cUsers < users.length){
            users[cUsers] = user;
            cUsers++;
        }else{
            System.out.println("Ya no hay espacio para mas usuarios");
        }
    }
    
    // METODO PARA LEER LA INFORMCION DE LOS USUARIOS EN UN ARREGLO
    public static void LeerUsuarios(){
        for (int i = 0; i < cUsers; i++) {
            System.out.println("------ Users en el sistema -------");
            System.out.println("User: " + users[i].getUsuario()); 
        }
    }
    
    // METODO PARA VERIFICAR EL USUARIO
    //  Se utiliza para el inicio de sesion, verificamos el usuario y la contraseña.
    public static Usuarios VerificarUsuario(String usuario, String contraseña){
        for (int i = 0; i < cUsers; i++) {
            // Hacemos un recorrido y segun los parametros hacemos match
            if(users[i].getUsuario().equals(usuario)){
                // Como son dos parametros, serian dos if o como ustedes prefieran
                if(users[i].getPassword().equals(contraseña)){
                    // En este caso, yo quiero que me retorne el usuario, ya que lo usare luego
                    return users[i];
                }
            }
        }
        // En este caso, si termina el for significa que no encontro el usuario, entonces
        // me devolvera un dato null y con esto ya puedo hacer validaciones en donde use el metodo
        
        return null;
    }
    
}
