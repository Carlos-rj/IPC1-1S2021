package clase11;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;

/* USO DEL DRAG AND DROP
    Bueno como estamos viendo esta es una clase que hereda del JFrame, es practicamente lo que ya hemos trabajado anteriormete
    pero pues, ya viene con ciertas configuaraciones que realmente no le pondremos mucho rollo porque lo hoacemos con el Drag and Drop
    
    Podemos usar la clase tal y como lo hemos usado, solo hay que especificar para que sirve cada cosa
*/

// DEFINIENDO LA CLASE, COMO SI LO HICIERAMOS NOSOTROS, EXTENDIENDO DE JFRAME
public class Ventana extends javax.swing.JFrame {

    // NUESTRO CONSTRUCTOR
    public Ventana() {
        /* initComponents:
            Este metodo es el que se va generando por todo lo que hagamos en el drag and drop, es nuestro metodo
            donde se crean todos los componentes, como digo, no podemos manejar esta info ya que la usamos con el drag and drop
        */
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jLabel1.setText("OBJETO");

        jLabel2.setText("LIMITE SUPERIOR");
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setText("LIMITE INFERIOR");
        jLabel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setText("LIMITE IZQUIERDO");
        jLabel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setText("LIMITE DERECHO");
        jLabel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(212, 212, 212)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 221, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(103, 103, 103))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jLabel3)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    /* EVENTOS
        Para agregar eventos, en este caso agregamos un evento al Frame en general, para hacer esto nos vamos al Design
        Seleccionamos el frame y usamos el click derecho y en la opcion events, escogemos los eventos que querramos agregarle a nuestro form
    
        En este caso queremos agregarle un evento de KeyPressed
    
    NOTA: Tener cuidado si queremos usar botones y eventos, JAVA no permite tener dos listeners dentro del frame, lo digo por si quieren usar botones
            Si agregan un boton, tomara como prioridad el click listener del boton que el key pressed, solo para que lo tengan en cuenta :3
            Pueden probar usando un Panel y agregarle al panel ese evento del key pressed, no se :3
    */
    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // EN ESTE CASO, NECESITAMOS ENCONTRAR LA TECLA QUE FUE PRESIONADA
        // usamos el metodo getKeyCode(), que nos retornara un entero y lo usaremos como un Switch case mas adelante
        int tecla = evt.getKeyCode();
        
        // Como queremos darle movimiento a nuestro objeto por medio de las teclas, utilizamos las variables posx y posy, solo para obtener su posicion en el frame
        int posx, posy;
        posx = jLabel1.getX();
        posy = jLabel1.getY();

        /* EL HACK:
            Resulta que todos los componentes en JAVA cuentan con un "Hitbox" o un recuadro donde se maneja el componente, este recuadro es un componente conocido como 
            Rectanlge, los Rectangle son ese recuadro que le vemos al componente, en este caso, creamos un area donde se puede mover la nave y usamos sus Rectangles para
            delimitar ese espacio.
        */
        Rectangle rct_inf = jLabel3.getBounds();
        Rectangle rct_sup = jLabel2.getBounds();
        Rectangle rct_izq = jLabel4.getBounds();
        Rectangle rct_der = jLabel5.getBounds();
        Rectangle rct = jLabel1.getBounds();

        // DARLE FUNCION A LAS TECLAS :)
        // Usamos el switch, cada vez que presionemos una tecla, se activa este evento y segun el codigo, nuestra variable tecla tiene el valor de la tecla que presionamos
        switch (tecla) {
            // Para saber la tecla, utilizamos el KeyEvent. y ver cuales son las teclas aceptada por el evento, por este caso solo necesitamos las flechas, es decir
            // VK_UP, VK_DOWN, VK_LEFT, VK_RIGHT, siendo para las teclas arriba, abajo, izquierda, derecha respectivamente
            
            /* EXPLICACION DEL CODIGO DENTRO DE CADA TECLA
                Como queremos hacer un movimiento del objeto, usaremos el metodo de setLocation, en este caso depende de la posicion del objeto, pero la cuestion es que
                usando su posicion X y Y vamos a darle el movimiento dentro del frame
            */
            case KeyEvent.VK_UP:
                System.out.println("TECLA ARRIBA");
                /* INTERSECCIONES
                    Utilizando nuestros rectangles, estos componentes tienen un metodo que permite verificar si un rectangle intercepto con un rectangle ajeno, entonces podemos usar este metodo
                    para delimitar el movimiento, indicando que:
                        SI EL RECTANGULO NO INTERCEPTA, NOS PODEMOS MOVER LIBREMENTE HASTA QUE INTERCEPTE
                */
                if (!rct.intersects(rct_sup)) {
                    jLabel1.setLocation(posx, posy - 10);
                    
                    /* MOVIENDO UN OBJETO CON UN HILO
                        En este caso, necesitamos crear un nuevo objeto que hereda de un hilo, por que, por que necesitamos que nuestro objeto tenga movimiento independiente
                        de todo lo demas, entonces creamos el objeto Objeto, que tiene todo lo necesario para trabajar como un JLabel, ver la clase para una mejor explicacion
                    
                        NOTA: Le mandamos como parametro el this, porque queremos mandarle la ventana actual donde fue creado el objeto
                        Objeto nuevo = new Objeto(jLabel1.getBounds(), this);
                    
                        NOTA: utilizar el metodo start() siempre, para sincronizar los hilos al hilo actual, correcto, el main trabaja con un hilo.
                        nuevo.start();                    
                    */
                } else {
                    System.out.println("Topaste por arriba");
                }
                break;
            case KeyEvent.VK_DOWN:
                System.out.println("TECLA ABAJO");
                if (!rct.intersects(rct_inf)) {
                    jLabel1.setLocation(posx, posy + 10);
                } else {
                    System.out.println("Topaste por abajo");
                }
                break;
            case KeyEvent.VK_LEFT:
                System.out.println("TECLA IZQUIERDA");
                if (!rct.intersects(rct_izq)) {
                    jLabel1.setLocation(posx - 10, posy);
                } else {
                    System.out.println("Topaste por izquierda");
                }
                break;
            case KeyEvent.VK_RIGHT:
                System.out.println("TECLA DERECHA");
                if (!rct.intersects(rct_der)) {
                    jLabel1.setLocation(posx + 10, posy);
                } else {
                    System.out.println("Topaste por derecha");
                }
                break;
        }
    }//GEN-LAST:event_formKeyPressed

    // Los frames generados por Netbeans tambien cuentan con un metodo main :) 
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    /* OBJETOS GENERADOS POR EL DRAG AND DROP
        En este caso, son las declaraciones de todos los componentes, para cambiar su accesibilidad tenemos que hacerlo desde el drag and drop cambiando las propiedades de cada objeto.
    */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
