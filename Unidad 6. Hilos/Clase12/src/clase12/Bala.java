package clase12;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

// PRIMERO, LO MAS IMPORTANTE, EXTENEDER DEL THREAD
public class Bala extends Thread {
    
    // SEGUNDO, La representacion grafica del hilo, es decir una imagen y su respectivo Rectangle para obtener su "hitbox"
    JLabel imagen;
    Rectangle rctl;

    // TERCERO, Referencia de donde se creo el objeto para saber en donde hacer los cambios
    Ventana vtn;

    // METODO CONSTRUCTOR, Vamos a darle la forma grafica de nuestro hilo.
    public Bala(Ventana vtn, Rectangle rctl) {
        // Inicializamos los valores, para poder usarlos en toda la clase
        this.vtn = vtn;
        this.rctl = rctl;
        
        // CREAMOS NUESTRO OBJETO PARA DARLE UNA REPRESENTACION GRAFICA
        imagen = new JLabel();
        // Le asignamos el tamaño y la posicion a nuestra "BALA" preferiblemente que salga del mismo JLabel que dispara verdad
        imagen.setBounds(rctl.x+25, rctl.y+10, 25, 25);
        // Lo hacemos visible por que si :)
        imagen.setVisible(true);
        
        // AGREGAMOS UNA IMAGEN PARA QUE SE VEA MAS BOMNITO :)
        ImageIcon img = new ImageIcon("shot.png");
        Image nuevo = img.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon render = new ImageIcon(nuevo);
        imagen.setIcon(render);
        
        // Por ultimo, agregamos la representacion grafica de nuestro hilo
        this.vtn.add(imagen);
        // Hacemos un repaint del Frame, para que se posicione el JLabel en donde lo colocamos
        this.vtn.repaint();        
    }
    
    // EL METODO DONDE OCURRE LA MAGIA
    public void run(){
        // Obtenemos la posicion de X de nuestro objeto
        int posx = imagen.getX();
        try{
            while(true){
                // Agregamos un sleep, para darle animacion
                sleep(100);
                // Cambiamos nuestra posicion, para darle movimiento
                posx += 25;
                // Le cambiamos la posicion a la representacion grafica de la bala
                imagen.setLocation(posx, rctl.y+10);
                
                // HACEMOS LA VERIFICACION PARA VER EL LIMITE DE NUESTRA VENTANA
                if(posx >= vtn.getWidth()-25){
                    // Si llegamos al limite de la ventana, se removera el objeto de la ventana
                    vtn.remove(imagen);
                    System.out.println("CHOQUE");
                    // Agregamos un Stop poqrue este hilo ya no lo necesitamos, se murio para nostros
                    this.stop();
                }
                // Agregamos un repaint, para actualizar la ventana
                vtn.repaint();
            }
        }catch(Exception e){
            
        }
    }
    
    
    
}
