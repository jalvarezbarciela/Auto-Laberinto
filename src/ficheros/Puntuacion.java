/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficheros;

/**
 *
 * @author ceque
 */
public class Puntuacion implements Comparable{
    private String nombre;
    int segundos;

    public Puntuacion() {
    }

    public Puntuacion(String nombre, int segundos) {
        this.nombre = nombre;
        this.segundos = segundos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    @Override
    public String toString() {
        return  nombre+","+segundos;
    }

    @Override
    public int compareTo(Object o) {
        Puntuacion record=(Puntuacion)o;
        if(this.segundos>record.segundos){
            return 1;
        }else if(this.segundos==record.segundos){   
            return 0;
        }else{
            return -1;
        }       
        
    }
    
    
}
