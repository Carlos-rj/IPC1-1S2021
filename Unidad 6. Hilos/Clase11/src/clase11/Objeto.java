package clase11;

// IMPORTANDO LIBRERIAS PARA NUESTRO HILO
import java.awt.Rectangle;
import javax.swing.JLabel;

// Creamos nuestra clase Objeto que funcionara como un Hilo, es decir que este objeto funcionara independiente de la ventana
public class Objeto extends Thread {
    // Le agregamos un label para tener una representacion grafica del hilo y un Rectangle para manejar los intersectos
    JLabel lbl = new JLabel("NUEVO");
    Rectangle rct;
    
    // Y lo mas imporntante, tenemos que crearle un atributo Ventana, este atributo hace referencia al Frame, para saber de que frame fue llamado el objeto
    Ventana vtn;

    // METODO CONSTRUCTOR
    public Objeto(Rectangle bounds, Ventana vtn) {
        /*
            Se puede observar que mandamos un Rectangle inicial, porque en base a ese rectangle crearemos nuestro nuevo objeto y una Ventana, en este caso recibimos la ventana
            donde fue creado este objeto, para tener una referencia directa al objeto.
        */
        this.rct = bounds;
        this.vtn = vtn;
        lbl.setBounds(bounds);
        // Modificamos la posicion inicial, para que el objeto no este encima del Label donde esta haciendo referencia
        lbl.setLocation(lbl.getX(), lbl.getY()-10);
        // Agregamos el label a nuestro objeto vtn, que hace referencia a la ventana donde llamamos el objeto
        vtn.add(lbl);
    }
    
    /* MOVIENDO EL OBJETO
        En este caso, usaremos el hilo para que el objeto generado se mueva hacia el limite superior, sin importarle nada, hasta que encuentre ese limite dejara de ejecutarse
        segun la condicion, necesitamos que los rectangulos no se intercepten todavia.
    */
    public void run(){
        try {
            while (!rct.intersects(vtn.jLabel2.getBounds())) {
                // Agregamos una pausa, para simular una animacion 
                sleep(35);
                // Hacemos el cambio de posicion para que se vea como movimiento en el componente
                lbl.setLocation(rct.x, rct.y-10);
                // Y lo mas importante, hacemos un repintado de nuestra ventana, para que los cambios se vean "fluidos"
                vtn.repaint();
                // Antes de repetir el while, hay que actualizar la posicion de nuestro rectangle tambien
                rct = lbl.getBounds();
            }
            
            // Cuando salimos del while, hay que detener el hilo, puesto que por el while ya no nos va a funcionar a menos que sea dinamico.
            stop();

        } catch (Exception e) {

        }
    }
}
