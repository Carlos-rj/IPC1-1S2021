package practica2;

// LIBRERIAS PARA LA LECTURA DE ARCHIVOS
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
// LIBRERIA PARA LEER ENTRADAS DE LA CONSOLA
import java.util.Scanner;

public class Practica2 {
    // VARIABLES GLOBALES
    static Scanner sc = new Scanner(System.in);
    static Scanner lector = new Scanner(System.in);
    
    // UN ARREGLO DE POKEMON - TAMAÑO 150
    static Pokemon[] Pokemones = new Pokemon[150];
    static int cPokemon = 0;
    // UN ARREGLO DE POKEBALLS - TAMAÑO X
    static Pokeball[] Pokeballs;
    static int cPokeballs = 0;
    // UN ARREGLO DE ENTRENADORES - TAMAÑO 25
    static Entrenador[] Entrenadores = new Entrenador[25];
    static int cEntrenadores = 0;
    
    // En el Main lo unico que vamos a tener es un Menu, como bien sabran el menu se hace con un
    // do - while y un Switch case, dentro de cada case, mandamos a llamar los metodos
    public static void main(String[] args) {
        int opcion = 0;
        do{
            System.out.println("1. Cargar Pokemon");
            System.out.println("2. Cargar Pokeball");
            System.out.println("3. Cargar Entrenador");
            System.out.println("4. Asignar Pokemon");
            System.out.println("5. Asignar Pokeball");
            System.out.println("6. Ordenar Pokemon");
            System.out.println("7. Salir");
            opcion = sc.nextInt();
            switch(opcion){
                case 1:
                    CargarPokemon();
                    break;
                case 2:
                    CargarPokeball();
                    break;
                case 3:
                    CargarEntrenador();
                    break;
                case 4:
                    AsignarPokemon();
                    break;
                case 5:
                    AsignarPokeball();
                    break;
                case 6:
                    OrdenarPokemon();
                    break;
                case 7:
                    System.out.println("Adios");
                    break;
                default:
                    System.out.println("La opcion que escogiste no fue valida.");
                    break;
            }
        }while(opcion != 6);
    }

    
    // METODOS PARA MANEJAR LOS ARREGLOS
    /* CARGAR POKEMON
        Este metodo es muy repetitivo, asi que se explicara este para los demas que son parecidos
    */
    private static void CargarPokemon() {
        // Necesitamos guardar la ruta en una variable
        String ruta;
        System.out.println("--------CARGA DE POKEMON--------");
        System.out.println("Ingresar la ruta del archivo donde estan los Pokemon");
        ruta = lector.nextLine();
        
        // Aplicamos nuestro siempre util y confiable metodo de leer archivos.
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            archivo = new File(ruta);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Como estos archivos tiene un encabezado, se recomienda hacer un br.readLine();
            // Pero esto solo si el archivo tiene UN ENCABEZADO.
            String linea = br.readLine();
            // Hacemos el tipico while para ir leyendo linea por linea hasta que sea nulo.
            while ((linea = br.readLine()) != null)
            {
                // Vamos ir visualizando la informacio de linea por linea
                System.out.println(linea);
                // Usamos un arreglo de cadenas, para formarlo usamos un String.split("caracter");
                // En este caso nuestro archivo csv es delimitado por comas
                String[] Datos = linea.split(",");
                /* ANALISIS IMPORTANTISIMO: 
                    Sabemos que nuestro archivo ya viene con una estructura por defecto, con eso me refiero que
                    sabemos que el primer dato es id, el segundo es tipo y asi sucesivamente, si hacemos el Split
                    por comas, tenemos que los datos se guardan en la posicion del archivo.
                
                    SIEMPRE HACER UN PARSEO DE LOS DATOS, YA QUE NOSOTROS TENEMOS PURAS CADENAS DE TEXTO
                */ 
                int id = Integer.parseInt(Datos[0]);
                String tipo = Datos[1];
                String nombre = Datos[2];
                double vida = Double.parseDouble(Datos[3]);
                double ataque = Double.parseDouble(Datos[4]);
                boolean capturado, estado;
                if(Datos[5].equalsIgnoreCase("salvaje")){
                    capturado = false;
                }else{
                    capturado = true;
                }
                
                if(Datos[6].equalsIgnoreCase("muerto")){
                    estado = false;
                }else{
                    estado = true;
                }
                
                // Una vez leia la informacion, creamos nuestro nuevo objeto
                Pokemon nuevo = new Pokemon(id,tipo,nombre,vida,ataque,capturado,estado);
                // Y en este caso, agregamos nuestro Pokemon al arreglo de Pokemones con su contador
                // HACK: Para esto se puede hacer un metodo que maneje la cantidad de datos que se pueden guardar
                // Ya ustedes sabran a que metodo me refiero guiño guiño.
                Pokemones[cPokemon] = nuevo;
                cPokemon++;
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
        // Y por ultimo, queremos mostrar la informacion que almacenamos en el arreglo
        RecorrerPokemon();
    }

    // METODO PARA RECORRER LA INFORMACION
    private static void RecorrerPokemon(){
        // Para ver la informacion usamos un simple for, que vaya de 0 hasta el contador
        // HACK: El contador es vida, es la clave, es necesario para no tener NullPointer
        for (int i = 0; i < cPokemon; i++) {
            // En este caso, Pokemon tiene un metodo para mostrar su informacion :)
            Pokemones[i].MostrarInfo();
        }
    }
    
    // CARGAR POKEBALL SE COMPORTA IGUAL QUE CARGAR POKEMON
    private static void CargarPokeball() {
        String ruta;
        System.out.println("--------CARGA DE POKEBALLS--------");
        System.out.println("Ingresar la ruta del archivo donde estan los Pokemon");
        ruta = lector.nextLine();
        
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            archivo = new File(ruta);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea = br.readLine();
            int contador = 0;
            while ((linea = br.readLine()) != null)
            {
                contador++;
            }
            // PARA ESTE PUNTO, YO SE QUE CONTADOR == NUMERO DE FILAS
            Pokeballs = new Pokeball[contador];
            cPokeballs = 0;

            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            linea = br.readLine();
            
            while ((linea = br.readLine()) != null) // LEE LA SIGUIENTE FILA HASTA QUE SEA NULO.
            {
                String[] Datos = linea.split(",");
                int id = Integer.parseInt(Datos[0]);
                String tipo = Datos[1];
                // VERIFICO SI YA EXISTE EL OBJETO
                // IF objeto existe, no lo agrego
                // ELSE, lo agrego
                Pokeball nuevo = new Pokeball(id, tipo);
                Pokeballs[cPokeballs] = nuevo;
                cPokeballs++;
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
        RecorrerPokeballs();
    }
    
    // RECORRER POKEBALL SE COMPORTA IGUAL QUE RECORRER POKEMON
    public static void RecorrerPokeballs(){
        for (int i = 0; i < cPokeballs; i++) {
            Pokeballs[i].MostrarInfo();
        }
    }

    // CARGAR ENTRENADOR SE COMPORTA IGUAL QUE CARGAR ENTRENADOR
    private static void CargarEntrenador() {
         String ruta;
        System.out.println("--------CARGA DE ENTRENADORES--------");
        System.out.println("Ingresar la ruta del archivo donde estan los Entrenadores");
        ruta = lector.nextLine();
        
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            archivo = new File(ruta);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea = br.readLine(); 
            while ((linea = br.readLine()) != null) 
            {
                System.out.println(linea);
                String[] Datos = linea.split(",");
                int id = Integer.parseInt(Datos[0]);
                String nombre = Datos[1];

                Entrenador nuevo = new Entrenador(id, nombre);
                Entrenadores[cEntrenadores] = nuevo;
                cEntrenadores++;
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

    /* ASIGNACIONES DE POKEMON A POKEBALL
        En este caso, tenemos que un Pokemon puede estar dentro de una Pokeball por cuestion de logica de Programacion
        sabemos que podemos guardar un objeto de Pokemon dentro de la Pokeball, en este caso los archivos solo hacen referencia
        a sus identificadores, entonces hay que encontrar la manera de hacer estas asignaciones en nuestro arreglo de informacion.
    
        Ver la clase Pokeball para entender un poco mejor la Pokeball
        Ver la imagen del README para enteneder un poco mejor la asignacion
    */
    private static void AsignarPokemon() {
        // EN SI, EL METODO ES IGUAL HASTA LA PARTE DE LEER LOS DATOS
        String ruta;
        System.out.println("--------ASIGNAR POKEMON A POKEBOLA--------");
        System.out.println("Ingresar la ruta del archivo donde estan las asignaciones");
        ruta = lector.nextLine();
        
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            archivo = new File(ruta);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea = br.readLine(); 
            System.out.println("-------------------------------------");
            while ((linea = br.readLine()) != null) // LEE LA SIGUIENTE FILA HASTA QUE SEA NULO
            {
                System.out.println(linea);
                String[] Datos = linea.split(",");
                int idPokeball = Integer.parseInt(Datos[0]);
                int idPokemon  = Integer.parseInt(Datos[1]);
                // PARA ESTE PUNTO TENEMOS LOS ID, TANTO DE LA POKEBALL COMO DEL POKEMON.
                // entonces lo que debemos de hacer es que a la Poke ball que tenga ese id, le vamos a agregar
                // el Objeto Pokemon, porque una Pokeball puede guardar un Pokemon
                
                // POR LOGICA: Sabemos que esa informacion debe de ser en el arreglo de Objetos que ya tiene almacenada la info
                // No creamos un nuevo objeto, porque ese no hace referencia al objeto princpial donde tenemos la informacion, es decir
                // Al arreglo de Pokeballs
                
                // METODO PARA ENCONTRAR LA POKEBALL SEGUN SU ID.
                int i = EncontrarPokeball(idPokeball);
                // METODO PARA ENCONTRAR EL OBJETO POKEMON EN BASE SU ID
                Pokemon guardar = EncontrarPokemon(idPokemon);
                if( i != cPokeballs){
                    // Como ya tenemos el indice, recordemos que encontramos el indice para asignar este dato en el arreglo
                    // que ya existe, repito, de nada sirve crear un objeto y almacenarlo ahi, si necesitamos que se guarde esa informacion.
                    
                    // COMO LA CLASE POKEBALL TIENE SU ATRIBUTO Pokemon PODEMOS GUARDAR ESE DATO
                    Pokeballs[i].setPokemon(guardar);                                    
                }
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
        RecorrerPokeballs();
    }
    
    /* METODO PARA ENCONTRAR EL INDICE EN EL ARREGLO GLOBAL DE POKEBALLS
        Nosotros queremos asignar el Pokemon en la Pokeball que ya teniamos anteriormente guardada, por lo tanto
        buscamos en nuestro arreglo de Pokeballs y en ese arreglo encontramos la posicion segun su ID.
    
        Si la informacion hace Match, entonces podemos retornar el indice, si no, es porque no existe la Pokeball.
    */
    public static int EncontrarPokeball(int id){
        for (int i = 0; i < cPokeballs; i++) {
            if(Pokeballs[i].getId() == id){
                return i;
            }
        }
        return cPokeballs;
    }
    
    /* METODO PARA ENCONTRAR EL POKEMON EN EL ARREGLO GLOBAL DE POKEMON
        Este caso es diferente, puesto que la Pokeball tiene un atributo de Pokemon, entonces podemos asignar el 
        objeto como tal, en este caso no queremos asignar la posicion (Porque el enunciado no lo dice asi)
        Si no que queremos crear un Objeto que se almacenara dentro de la Pokeball, por eso es que retornamos el objeto
        y no el indice.
    
        La logica es la misma, segun su ID si existe en el arreglo, mandamos la informacion, si no, es null.
    */
    public static Pokemon EncontrarPokemon(int id){
        for (int i = 0; i < cPokemon; i++) {
            if(Pokemones[i].getId() == id){
                return Pokemones[i];
            }
        }
        return null;
    }
    
    
    /* ASIGNACIONES DE POKEBALLS A ENTRENADORES
        En este caso, sabemos que los entrenadores tienen un maximo de 5 Pokeballs, por lo tanto eso se maneja como un arreglo
        no tiene mayor ciencia y la logica que seguimos siempre es la misma, dentro de la clase entrenador podemos encontrar
        un arreglo de objetos de tipo Pokeball y en este caso el objeto Pokeball tiene dentro un objeto tipo Pokemon
    
        Entonces si es necesario podemos acceder al Pokemon que esta dentro de la Pokebola del Entrenador :)
    */
    private static void AsignarPokeball() {
        // LA LECTURA DEL ARCHIVO ES IGUAL HASTA EL MOMENTO DE ANALIZAR LOS DATOS
        String ruta;
        System.out.println("--------ASIGNAR POKEBOLA A ENTRENADOR--------");
        System.out.println("Ingresar la ruta del archivo donde estan las asignaciones");
        ruta = lector.nextLine();
        
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            archivo = new File(ruta);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea = br.readLine(); 
            System.out.println("-------------------------------------");
            while ((linea = br.readLine()) != null) // LEE LA SIGUIENTE FILA HASTA QUE SEA NULO.
            {
                System.out.println(linea);
                String[] Datos = linea.split(",");
                int idEntrenador = Integer.parseInt(Datos[0]);
                int idPokebola  = Integer.parseInt(Datos[1]);
                // PARA ESTE MOMENTO YA TENEMOS LOS ID RECONOCIDOS, SI NOS BASAMOS EN LA MISMA LOGICA DE LA ASIGNACION
                // TENEMOS QUE ENCONTRAR EL ENTRENADOR EN EL ARREGLO GLOBAL Y GUARDAR UNA POKEBOLA ENTONCES
                
                // METODO PARA ENCONTRAR EL INDICE DEL ENTRENADOR
                int i = EncontrarEntrenador(idEntrenador);
                // METODO PARA ENCONTRAR EL OBJETO POKEBALL
                Pokeball guardar = EncontrarPokeballObjeto(idPokebola);
                // METODO PARA ASIGNAR POKEBALL AL ENTRENADOR (Ver en la clase de Entrenadores).
                Entrenadores[i].AsignarPokeball(guardar);
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
        RecorrerEntrenadores();
    }
    
    /* ENCONTRAR EL OBJETO POKEBALL POR SU ID
        En este caso, como el Entrenador puede tener un objeto de Pokeball, necesitamos obtener el objeto como tal
        y sabemos que ese objeto tiene adentro otro objeto que tiene la informacion que necesitamos.
    
        Si, si se pudo haber hecho referencia por ID unicamente, pero es cuestion de como lo quieran desarrollar ustedes.
    */
    public static Pokeball EncontrarPokeballObjeto(int id){
        for (int i = 0; i < cPokeballs; i++) {
            if(Pokeballs[i].getId() == id){
                return Pokeballs[i];
            }
        }
        return null;
    }

    // METODO PARA ENCONTRAR EL INDICE DEL ENTRENADOR
    public static int EncontrarEntrenador(int id){
        for (int i = 0; i < cEntrenadores; i++) {
            if(Entrenadores[i].getId() == id){
                return i;
            }
        }
        return cEntrenadores;
    }
    
    // METODO PARA OBTENER LA INFORMACION DE CADA ENTRENDAOR
    public static void RecorrerEntrenadores(){
        for (int i = 0; i < cEntrenadores; i++) {
            Entrenadores[i].MostrarInformacion();
        }
    }
    
    /* ORDENAMIENTOS DE ARREGLOS
        Estos metodos ya existen de por si, hay varios algoritmos ya implementados para ordenar un arreglo de datos
        pero normalmente estos metodos ya existen para un arreglo de enteros, en este caso vamos a trabajar con un arreglo
        de objetos.
    
        La unica diferencia es que la comparacion si o si, debe de ser un valor numerico, en este caso el valor de Ataque.
    
        Y donde esta el gran cambio, es que el temporal que se crea para hacer el cambio debe de ser del tipo de Objeto por ejemplo
        Si estamos manejando un Arreglo de Entrenadores, el temporal deberia de ser tipo Entrenador.
        Si estamos manejando un Arreglo de Pokeballs, el temporal deberia de ser tipo Pokeball.
    
        En este caso, como es un Arreglo de Pokemons, el temporal debe de ser tipo Pokemon.
    */
    public static void OrdenarPokemon(){
        int n = cPokemon; 
        for (int i = 0; i < n-1; i++) 
            for (int j = 0; j < n-i-1; j++) 
                if (Pokemones[j].getAtaque() < Pokemones[j+1].getAtaque()) 
                { 
                    // swap arr[j+1] and arr[j] 
                    Pokemon temp = Pokemones[j]; 
                    Pokemones[j] = Pokemones[j+1]; 
                    Pokemones[j+1] = temp; 
                } 
        RecorrerPokemon();
    }
}
