import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class GridLinesPanel extends JPanel {

   private char move;
   private String message;

   public GridLinesPanel() {
       this.message = "start"; 
   }
   
   public void paintComponent(Graphics g) {
   
      super.paintComponent(g);  // Call the paintComponent method from the 
                // superclass, JPanel.  This simply fills the 
                // entire panel with the background color, black.
     // g.drawString(this.message ,10,10);
      int width = getWidth();
      int height = getHeight();
      if(move == 'w'){
         g.drawString("Up",10,10);
      }
      else if(move == 's'){
         g.drawString("Down",10,10);
      }
      else if(move == 'a'){
         g.drawString("Left",10,10);
      }
      else if(move == 'd'){
         g.drawString("Right",10,10);
      }
      //g.drawLine(0,0,100,100);     
   } // end paintComponent()

   public void setMove(char move){
       this.move = move;
   }

   public void setMessage(String message){
       this.message = message;
   }
   

}  // end class GridLinesPanel
