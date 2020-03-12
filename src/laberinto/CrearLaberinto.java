/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laberinto;


import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author ceque
 */
public class CrearLaberinto {

   
    private int[][] taboa = new int[15][15];
    

    
    public  int[][]  crearLaberinto() {
        for (int f = 0; f < taboa.length; f++) {
            for (int d = 0; d < taboa[f].length; d++) {
                taboa[f][d] = 1;
            }
        }

        taboa[1][1] = 0;
        int[][] laberinto = recursion(1, 1);
        laberinto=elegirFinal(laberinto);
        laberinto[1][1]=2;        
        return laberinto;

    }
    
        
        

    public int[][] recursion(int r, int c) {

        Integer[] randDirs = generateRandomDirections();

        for (int i = 0; i < randDirs.length; i++) {

            switch (randDirs[i]) {
                case 1: // Arriba
                    if (r - 2 <= 0) {
                        continue;
                    }
                    if (taboa[r - 2][c] != 0) {
                        taboa[r - 2][c] = 0;
                        taboa[r - 1][c] = 0;
                        recursion(r - 2, c);
                    }
                    break;
                case 2: // Derecha
                    if (c + 2 >= taboa.length - 1) {
                        continue;
                    }
                    if (taboa[r][c + 2] != 0) {
                        taboa[r][c + 2] = 0;
                        taboa[r][c + 1] = 0;
                        recursion(r, c + 2);
                    }
                    break;
                case 3: // Abajo
                    if (r + 2 >= taboa.length - 1) {
                        continue;
                    }
                    if (taboa[r + 2][c] != 0) {
                        taboa[r + 2][c] = 0;
                        taboa[r + 1][c] = 0;
                        recursion(r + 2, c);
                    }
                    break;
                case 4: // Izquierda
                    if (c - 2 <= 0) {
                        continue;
                    }
                    if (taboa[r][c - 2] != 0) {
                        taboa[r][c - 2] = 0;
                        taboa[r][c - 1] = 0;
                        recursion(r, c - 2);
                    }
                    break;
            }
        }
        return taboa;

    }

    public Integer[] generateRandomDirections() {
        ArrayList<Integer> direccion = new ArrayList<Integer>();
        for (int i = 0; i < 4; i++) {
            direccion.add(i + 1);
        }
        Collections.shuffle(direccion);

        return direccion.toArray(new Integer[4]);
    }

   
    public int [][] elegirFinal(int [][] taboa){
        int fila=0;
        int columna=0;
        for (int f = 0; f < taboa.length; f++) {
                for (int c = 0; c < taboa[f].length; c++) {
                if(taboa[f][c]==0 && f+c>fila+columna && (taboa[f+1][c]+taboa[f-1][c]+taboa[f][c+1]+taboa[f][c-1])==3){
                    fila=f;
                    columna=c;
                }
            }
        }
        taboa[fila][columna]=3;
        return taboa;
        }
    public int [][] generarEnemigos(int [][] taboa){
        int fila;
        int columna;
        int enemigos=0;
        
        
        do{     
        fila=0;
        columna=0;
        for (int f = 0; f < taboa.length; f++) {            
                for (int c = 0; c < taboa[f].length; c++) {
                    int i=(int) (Math.random()*(10));
                    if(taboa[f][c]==0&&i==7&&enemigos<=4){
                    fila=f;
                    columna=c;
                    enemigos++;
                    taboa[fila][columna]=4;
                }
            }
        }
        
        }while(enemigos==4);
        return taboa;
    }
}