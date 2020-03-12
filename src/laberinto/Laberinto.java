package laberinto;

import interfaz.Ventana;
import ficheros.Ficheros;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Laberinto{  
    public static void main(String[] args) {
      
       Ventana ventana = new Ventana();
       ventana.setSize(900,550);
       ventana.setLocationRelativeTo(null);
       ventana.setVisible(true);
       ventana.setDefaultCloseOperation(EXIT_ON_CLOSE); 
       
    }
}
