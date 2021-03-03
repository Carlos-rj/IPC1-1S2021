package practica2;

public class Entrenador {
    // ATRIBUTOS
    private int id;
    private String nombre;
    // A diferencia de la Pokeball, este tiene un arreglo de Objetos de tipo Pokeball
    // Entonces como atributo se recomienda solo declarar el arreglo y tener su confiable contador
    private Pokeball[] pokeballs;
    private int cPokeball;

    // METODO CONSTRUCTOR
    public Entrenador(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        // Ya dentro del constructor se inicializa el Arreglo y su contador en 0, asi para asegurar que
        // cuando se crea un "Entrenadore" este tiene un arreglo vacio de Pokeballs
        this.pokeballs = new Pokeball[5];
        this.cPokeball = 0;
    }

    // METODO PARA MOSTRAR LA INFROMACION
    public void MostrarInformacion(){
        System.out.println("Hola, mi nombre es: " + nombre);
        System.out.println("Yo tengo " + cPokeball + " pokemon y son: ");
        // En este caso, como tiene un arreglo de Pokeball, podemos mostrar la informacion de cada Pokeball
        for (int i = 0; i < cPokeball; i++) {
            // Hagamos de cuenta lo siguiente.
            // pokeballs -> Arreglo de Pokeballs
            // pokeballs[i] -> Objeto Pokeball
            // pokeballs[i].getPokemon() -> Objeto Pokemon
            
            // Podemos ver como se relacionan los objetos y segun sus metodos podemos acceder a los objetos dentro de los objetos
            pokeballs[i].getPokemon().MostrarInfo();
        }
        System.out.println("------------------------------------------");
    }
    
    /* METODO PARA ASIGNAR UN DATO AL ARREGLO
        Este metodo es muy utilizado y al final de cuenta, lo usamos para validar que la informacion llegue hasta el contador que tenemos
        es decir que no se agregara mas informacion si el contador es mayor o igual al tamaño del arreglo.
    
    HACK: Este metodo puede ser muy util y funcional para otras situaciones, guiño guiño
    */
    public void AsignarPokeball(Pokeball pokeball){
        if(cPokeball < pokeballs.length){
            pokeballs[cPokeball] = pokeball;
            cPokeball++;
        }else{
            System.out.println("Este entrenador ya tiene 5 Pokeball.");
        }
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}
