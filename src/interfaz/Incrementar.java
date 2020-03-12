package interfaz;

public class Incrementar extends Thread{
    private Ventana v;
    public static int seg;
  
    public Incrementar(Ventana v){
        this.v=v;
        seg = v.getSeg(); 
    }
    @Override
    public void run() {
        for (; ;){
            
                seg=v.aumentSeg();
                
            
             try {
                sleep(999);
            } catch (InterruptedException ex) {
                System.err.println(ex.getMessage());
            }
            if(!v.isContinuar()){
                try {
                    synchronized(this){
                       this.wait(); 
                    } 
                } catch (InterruptedException ex) {
                    System.err.println(ex.getMessage());
                }
            }    
        }       
    }    
    public void seguir(){
        synchronized(this){
            notifyAll();
        }
    }   

}
