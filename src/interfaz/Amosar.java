package interfaz;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Amosar extends JPanel{
        public int[][] taboa;

    public Amosar() {
        
    }

        public void amosar(Graphics grafico,int[][] taboa) {
            this.taboa=taboa;
            int x=0;
            int y=0;
        for (int f = 0; f < taboa.length; f++) {
            y=y+25;
            x=230;
            for (int c = 0; c < taboa[f].length; c++) {
                x=x+25;
                if (taboa[f][c] == 1) {                    
                    grafico.setColor(Color.black);
                    grafico.fillRect(x, y, 25, 25);
                    grafico.setColor(Color.gray);
                    grafico.drawRect(x, y, 25, 25);
                } else if (taboa[f][c] == 0) {
                    grafico.setColor(Color.white);
                    grafico.fillRect(x, y, 25, 25);
                    grafico.setColor(Color.gray);
                    grafico.drawRect(x, y, 25, 25);
                } else if (taboa[f][c] == 2) {
                    grafico.setColor(Color.yellow);
                    grafico.fillOval(x, y, 25, 25);
                    grafico.setColor(Color.black);
                    grafico.drawOval(x, y, 25, 25);
                } else if (taboa[f][c] == 3) {
                    grafico.setColor(Color.blue);
                    grafico.fillRect(x, y, 25, 25);
                    grafico.setColor(Color.gray);
                    grafico.drawRect(x, y, 25, 25);                
                }
            }
        }        
    }
}
