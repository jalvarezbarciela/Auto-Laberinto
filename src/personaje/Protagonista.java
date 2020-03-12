/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personaje;

import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;


/**
 *
 * @author ceque
 */
public class Protagonista implements Personaje {
    private int salir=0;
    
    @Override
    public int[][] moverseArriba(int[][] taboa) {
        
        int opcion=0;
        for (int f = 0; f < taboa.length; f++) {
            if (opcion==0){
                for (int c = 0; c < taboa[f].length; c++) {
                if(taboa[f][c]==2&&taboa[f-1][c]==0){
                    taboa[f-1][c]=2;
                    taboa[f][c]=0;
                    opcion=1;
                    salir=0;
                }
                else if(taboa[f][c]==2&&taboa[f-1][c]==3){
                    JOptionPane.showMessageDialog(null,"GANASTE");
                    salir=1;
                }
                }
            }
        }
        
        
        return taboa;
    }
    

    @Override
    public int[][] moverseAbajo(int[][] taboa) {
      
        int opcion=0;
        for (int f = 0; f < taboa.length; f++) {
            if(opcion==0){
                for (int c = 0; c < taboa[f].length; c++) {
                if(taboa[f][c]==2&&taboa[f+1][c]==0){
                    taboa[f+1][c]=2;
                    taboa[f][c]=0;
                    opcion=1;
                    salir=0;
                }
                else if(taboa[f][c]==2&&taboa[f+1][c]==3){
                    JOptionPane.showMessageDialog(null,"GANASTE");
                    salir=1;
                }
                }
            }
        }
               
        return taboa;
    }
    

    @Override
    public int[][] moverseDerecha(int[][] taboa) {
        
        final int rows = taboa.length;
        final int cols = taboa[0].length;

        final int[][] taboas = new int[cols][rows];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                taboas[c][rows - 1 - r] = taboa[r][c];
            }
        }
        
        
        return taboas;
       
    }

    @Override
    public int[][] moverseIzquierda(int[][] taboa) {
         final int rows = taboa.length;
        final int cols = taboa[0].length;

        final int[][] taboas = new int[cols][rows];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                taboas[rows - 1 - r][c] = taboa[c][r];
            }
        }
        
        return taboas;
       
    }

    public int getSalir() {
        return salir;
    }

   
    
    
}
