/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficheros;

import interfaz.Incrementar;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import javax.swing.JOptionPane;


/**
 *
 * @author ceque
 */
public class Ficheros{
    PrintWriter esc=null;
    FileWriter fich;
    Scanner sc;
    Puntuacion record;
 public  void escribirObxetos(){
          
        try{
         Puntuacion x=new Puntuacion(JOptionPane.showInputDialog("Nombre records"),Incrementar.seg);         
         fich=new FileWriter("Records.txt",true);
         esc =new PrintWriter(fich);
         esc.println(x.getNombre()+","+x.getSegundos());   
         ordenar();
     }catch(IOException ex){
         System.out.println("erro escribirNumeros"+ex.toString()); 
     }finally{
         esc.close();
     }
 }
    
    public void visualizar(){
      try {
        File fichero=new File("Records.txt");
        sc = new Scanner(fichero);
        while(sc.hasNext()){
        System.out.println(sc.nextLine());    
      }
      }catch (IOException ex) {
        System.out.println("Erro ler liñas "+ex.toString());    
    }
    finally{
    sc.close();
 }
    }
    public void ordenar() throws FileNotFoundException{
        ArrayList <Puntuacion> lista= new ArrayList();
        try{
        File fichero=new File("Records.txt");
        sc=new Scanner(fichero).useDelimiter(",");
        while(sc.hasNextLine()){
        String b=sc.nextLine();
        String[]datos=b.split(",");
        String nombre=datos[0];
        int tiempo=Integer.parseInt(datos[1]);
        Puntuacion record=new Puntuacion(nombre,tiempo);
        lista.add(record);               
       
        }
        Collections.sort(lista);                 
         fich=new FileWriter("Records.txt");
         esc =new PrintWriter(fich);
         for(int i=0;i<lista.size();i++){
         esc.println(lista.get(i));
         }
        }catch (IOException ex) {
        System.out.println("Erro ler liñas "+ex.toString());   
        
        }finally{
        sc.close();
        esc.close();
        }
    }
}

 
