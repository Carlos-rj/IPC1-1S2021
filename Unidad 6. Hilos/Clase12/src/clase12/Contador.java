package clase12;

/* CLASE CONTADOR EN REVERSA
    Tomando el ejemplo de la clase anterior, en este caso vamos a trabajar un contador pero en la interfaz grafica, como relacionamos nuestra interfaz con el objeto.

    Necesitamos crear un atributo a la ventana que queremos que haga referencia, es decir que mandaremos como parametro la ventana donde estemos llamando al objeto
    para asi poder hacer los cambios necesarios en la ventana donde se esta generando el objeto.
*/
public class Contador extends Thread {
    // Como es un contador, lo hacemos por minutos y segundos
    int segundos;
    int minutos;
    // RECORDAR SIEMPRE HACER REFERENCIA A LA VENTANA DONDE QUEREMOS IMPLEMENTAR LOS OBJETOS CON HILOS
    // ESTE ES EL TRUCO MAGICO, EL HACK, LO NECESARIO PARA ANIMAR VENTANAS
    Ventana vtn;

    public Contador(Ventana vtn) {
        // Nuestro constructor empieza con un tiempo en especifico ya que queremos que usar un temporizador tecnicamente
        segundos = 30;
        minutos = 1;      
        this.vtn = vtn;
    }
    
    // METODO RUN - Metodo donde haremos la ejecucion del proceso, lo que se hara independiente del todo
    public void run(){
        // recordemos usar siempre el try - catch por cuestiones de error que puedan salir a la hora de ejecutar el hilo
        try {
            while (true) {
                // IMPRIMIENDO EN CONSOLA EL CONTADOR
                System.out.println("Cronometro: " + minutos + ":" + segundos);
                // AGREGANDO EL TEXTO EN UN JLABEL
                vtn.jLabel1.setText(minutos + ":" + segundos);
                // SLEEP DE UN MINUTO
                sleep(1000);
                segundos--;
                if(segundos == 0){
                    segundos = 60;
                    minutos--;
                }
            }
        } catch (Exception e) {

        }
    }
    
}
