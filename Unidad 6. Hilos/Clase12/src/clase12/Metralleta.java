package clase12;

import javax.swing.JLabel;

public class Metralleta extends Thread {
    JLabel referencia;
    Ventana vtn;

    public Metralleta(JLabel referencia, Ventana vtn) {
        this.referencia = referencia;
        this.vtn = vtn;
    }
    
    
    
    public void run(){
        try {
            while (true) {
                sleep(200);
                Bala disparo = new Bala(vtn, referencia.getBounds());
                disparo.start();
            }
        } catch (Exception e) {

        }
    }
    
}
