package clase11;

/* HEREDANDO HILOS
    Tenemos una clase en especifico llamada Thread, tambien podemos usar una interfaz llamada Runnable pero a mi parecer
    es mas sencillo heredar el hilo.

    En este momento nuestro objeto es un hilo y nuestro hilo puede tener todo lo que nosotros creamos conveniente para trabajar
*/

// HACIENDO UN CRONOMETRO
public class Cronometro extends Thread {
    // Trabajamos nuestros atributos para realizar un cronometro sencillo
    private int segundos;
    private int minutos;
    // Es opcional, pero si queremos tambien podemos tener una variable que maneje el intervalo con el que se va a trabajar el hilo
    private int intervalo;
    // El nombre es unicamente estetica, para diferenciar un hilo de otro
    private String nombre;
    
    
    // EN EL CONSTRUCTOR, DEFINIMOS EL ESTADO INICIAL DEL HILO
    public Cronometro(String nombre, int intervalo) {
        // Como es un contador, queremos que empiece en 0 y las demas variables que le mandamos como parametros
        this.segundos = 0;
        this.minutos = 0;
        this.intervalo = intervalo;
        this.nombre = nombre;
    }
    
    
    /*  EL METODO RUN
        El metodo mas importante de todos los hilos, este metodo sera el que haga la magia con nuestro hilo
        todo lo que hagamos aqui, es lo que trabajara como un proceso independiente :) y como necesitamos que sea un proceso que se repita por cierta condicion
        utilizamos un while.
    
        En este caso es un cronometro, por lo tanto queremos que siempre este corriendo, usamos un while true.
    */
    public void run(){
        // SIEMPRE USEMOS EL TRY-CATCH: Porque, porque si :)
        // A veces el uso de varios procesos puede causar conflicto, es normal que tire error de vez en cuando.
        try{
        while(true){
            // En este caso, solo queremos imprimir el nombre de nuestro hilo y cuanto tiempo lleva ejecutado
            System.out.println("Hilo: " + nombre + " - Tiempo: " + minutos + ":" + segundos);
            
            /* EL METODO SLEEP
               De la mano con el metodo RUN, este metodo hace que la magia del run sea mas eficaz :3 con este pequeño metodo, nosotros le vamos a dar
               esa sensacion de pausa o de animacion a los objetos en movimiento, este metodo recibe un Long y es el tiempo en milesimas que se va a detener
                    CONCLUSION: 1000 milesimas = 1 segundo
            */
            sleep(intervalo);
            
            /* COMO FUNCIONA EL CRONOMETRO
                Pues lo unico que hacemos es aumentar nuestro contador de segundos despues de cada cierto tiempo producido por el sleep y si los segundos son 60
                se convierte un minuto, un hechizo simple pero poderoso dijo el Strange :3, esto les va a servir mucho.
            */
            segundos++;
            if(segundos == 60){
                minutos++;
                segundos=0;
            }
        }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    
    // ENCAPSULAMIENTO SOLO PORQUE SI.
    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
