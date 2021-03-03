package practica2;

public class Pokeball {
    // ATRIBUTOS
    private int id;
    private String tipo;
    private Pokemon pokemon;
    
    // METODO CONSTRUCTOR
    public Pokeball(int id, String tipo) {
        this.id = id;
        this.tipo = tipo;
        // En este caso, sabemos que el Pokemon de la Pokeball esta vacio cuando esta se "crea".
        this.pokemon = null;
    }
    
    // METODO PARA MOSTRAR INFORMACION
    public void MostrarInfo(){
        System.out.println("Soy la Pokeball numero: " + id + " y soy una: " + tipo);
        // Por cuestiones de la practica, pueden existir Pokeball que no tenga un pokemon asignado, entonces
        // Hacemos la respectiva validacion y el comportamiento segun el Pokemon
        if(pokemon == null){
            System.out.println("Aun no me han asignado un Pokemon :(");
        }else{
            System.out.println("Yo ya tengo un Pokemon asignado y es: " + pokemon.getNombre());
        }
    }

    
    // ENCAPSULAMIENTO
    /*
        Tomando en cuenta que hay un atributo de tipo Pokemon, tambien podemos hacer el encapsulamiento para esto :)
    */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }
    
    
}
