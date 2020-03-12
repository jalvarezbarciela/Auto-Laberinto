package interfaz;

import ficheros.Ficheros;
import laberinto.CrearLaberinto;

import personaje.Protagonista;


public class Ventana extends javax.swing.JFrame implements Runnable{
        int salir=0;
        CrearLaberinto obx= new CrearLaberinto();
        Protagonista pelota=new Protagonista(); 
        Amosar a=new Amosar();
        int [][]laberinto;
       
        private int seg = 0;
        private boolean continuar = true;
        private Incrementar i;
        
        
    public Ventana() {
        initComponents();        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Ventana = new javax.swing.JPanel();
        CrearLaberinto = new javax.swing.JButton();
        Derecha = new javax.swing.JButton();
        Arriba = new javax.swing.JButton();
        Arriba.setVisible(false);
        Abajo = new javax.swing.JButton();
        Izquierda = new javax.swing.JButton();
        Cronometro = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        CrearLaberinto.setText("Crear Laberinto");
        CrearLaberinto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CrearLaberintoMouseClicked(evt);
            }
        });
        CrearLaberinto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearLaberintoActionPerformed(evt);
            }
        });

        Derecha.setVisible(false);
        Derecha.setText("Derecha");
        Derecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DerechaPresinada(evt);
            }
        });

        Arriba.setText("Arriba");
        Arriba.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ArribaPresionada(evt);
            }
        });

        Abajo.setVisible(false);
        Abajo.setText("Abajo");
        Abajo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AbajoPresioando(evt);
            }
        });

        Izquierda.setVisible(false);
        Izquierda.setText("Izquierda");
        Izquierda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                IzquierdaPresionada(evt);
            }
        });

        setVisible(false);
        Cronometro.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        Cronometro.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout VentanaLayout = new javax.swing.GroupLayout(Ventana);
        Ventana.setLayout(VentanaLayout);
        VentanaLayout.setHorizontalGroup(
            VentanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VentanaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Cronometro, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 173, Short.MAX_VALUE)
                .addComponent(CrearLaberinto, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(Izquierda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(VentanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Arriba, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                    .addComponent(Abajo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Derecha)
                .addGap(39, 39, 39))
        );
        VentanaLayout.setVerticalGroup(
            VentanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VentanaLayout.createSequentialGroup()
                .addContainerGap(358, Short.MAX_VALUE)
                .addComponent(Arriba)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(VentanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Abajo)
                    .addComponent(Izquierda)
                    .addComponent(Derecha))
                .addGap(29, 29, 29))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VentanaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(VentanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CrearLaberinto, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cronometro, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(Ventana, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Ventana, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IzquierdaPresionada(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IzquierdaPresionada
        laberinto=pelota.moverseIzquierda(laberinto);
        salir=pelota.getSalir();
        a.amosar(Ventana.getGraphics(),laberinto);
        if(salir==1){
            dispose();
            parar();
            Ficheros records=new Ficheros();
            records.escribirObxetos();
            records.visualizar();
       
            
        }
    }//GEN-LAST:event_IzquierdaPresionada

    private void AbajoPresioando(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AbajoPresioando
        laberinto=pelota.moverseAbajo(laberinto);
        salir=pelota.getSalir();
        a.amosar(Ventana.getGraphics(),laberinto);
        if(salir==1){
            dispose();
            parar();
            Ficheros records=new Ficheros();
       records.escribirObxetos();
       records.visualizar();
        }
    }//GEN-LAST:event_AbajoPresioando

    private void ArribaPresionada(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ArribaPresionada
        laberinto=pelota.moverseArriba(laberinto);  
        salir=pelota.getSalir();
        a.amosar(Ventana.getGraphics(),laberinto);
        if(salir==1){
            dispose();
            parar();
            Ficheros records=new Ficheros();
        records.escribirObxetos();
        records.visualizar();
        }
        
    }//GEN-LAST:event_ArribaPresionada

    private void DerechaPresinada(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DerechaPresinada
         laberinto=pelota.moverseDerecha(laberinto);
        salir=pelota.getSalir();
        a.amosar(Ventana.getGraphics(),laberinto);
        if(salir==1){
            dispose();
            parar();
            Ficheros records=new Ficheros();
       records.escribirObxetos();
        }
    }//GEN-LAST:event_DerechaPresinada

    private void CrearLaberintoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearLaberintoActionPerformed
        resetSeg();
        seguir();
        i=null;
        i = new Incrementar(this);
        i.start();
        Cronometro.setVisible(true);
    }//GEN-LAST:event_CrearLaberintoActionPerformed

    private void CrearLaberintoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CrearLaberintoMouseClicked
        laberinto=obx.crearLaberinto();
        a.amosar(Ventana.getGraphics(),laberinto);
        CrearLaberinto.setVisible(false);
        Izquierda.setVisible(true);
        Derecha.setVisible(true);
        Arriba.setVisible(true);
        Abajo.setVisible(true);
    }//GEN-LAST:event_CrearLaberintoMouseClicked

    /**
     * @param args the command line arguments
     */
    
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
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new Ventana().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Abajo;
    private javax.swing.JButton Arriba;
    private javax.swing.JButton CrearLaberinto;
    private javax.swing.JTextField Cronometro;
    private javax.swing.JButton Derecha;
    private javax.swing.JButton Izquierda;
    private javax.swing.JPanel Ventana;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        
    }
    public synchronized int aumentSeg(){
    seg++;
    Cronometro.setText(String.valueOf(seg));
    return seg;
    }    
    public void resetSeg(){
        Cronometro.setText(String.valueOf("0"));
        seg=0;
    }
    public synchronized int getSeg(){
        return seg;
    }    
    public synchronized void seguir(){
        continuar =true;
    }
    public synchronized void parar(){
        continuar =false;
    }
    public synchronized boolean isContinuar() {
        return continuar;
    }       
}
