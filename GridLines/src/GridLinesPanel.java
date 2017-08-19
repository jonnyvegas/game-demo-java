import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class GridLinesPanel extends JPanel {

   public GridLinesPanel() {
   
   }
   
   public void paintComponent(Graphics g) {
   
      try{
	      super.paintComponent(g);  // Call the paintComponent method from the 
					// superclass, JPanel.  This simply fills the 
					// entire panel with the background color, black.
	      
	      int width = getWidth();
	      int height = getHeight();
	      Image img;
	      img = ImageIO.read(new File("images.jpg"));
	      g.drawImage(img,0,0,width,height,null);     
	      g.drawLine(0,0,100,100);     
      }
      catch(IOException ioexcpt){

      }
   } // end paintComponent()
   

}  // end class GridLinesPanel
