/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personaje;

/**
 *
 * @author ceque
 */
public interface Personaje {  
   public abstract int[][] moverseArriba(int [][] taboa);       
   public abstract int[][] moverseAbajo(int [][] taboa);
   public abstract int[][] moverseDerecha(int [][] taboa);
   public abstract int[][] moverseIzquierda(int [][] taboa);
}
