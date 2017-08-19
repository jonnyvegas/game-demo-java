/**
File: GridLinesPanel.java
Description: Develop an application that draws the gridlines.  
* In the random square draw the Monster character.  Start 
* the Hero character in the lower left hand corner.   
* Use the wsad keys to move up,down,left and right respectively. 
* When the key is pressed to move the Hero character, 
* update a position attribute (can be 2 integers) in the character, 
* and repaint the Gridpanel with the character in the new position.
* When the Hero is within 1 block of the monster, call the fight 
* method that you developed earlier.
Author: Jonathan Villegas
mail: jonathan.e.villegas@gmail.com
Date: 5/25/14
**/


package MoveChar;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Class to draw some gridlines
 * @author Jonny
 */
public class GridLinesPanel extends JPanel {    
   private char move;
   private String message;
   private int monsterx;
   private int monstery;
   private int herox;
   private int heroy;
   private final int num_of_boxes = 625;
   private int min_x = 1;
   private int max_x = 25;
   private int min_y = 1;
   private int max_y = 25;
    //Create an array for all the squares.
    boolean monster_panels[] = new boolean[num_of_boxes];
    boolean hero_panels[] = new boolean[num_of_boxes];
   int monster_box;
   int hero_box;
   
   

   public GridLinesPanel() {
       this.message = "start"; 
   }
   
   @Override
   public void paintComponent(Graphics g) {
       if(move == 'w'){
               if((getHeroY() - 1) < min_y)//Number is too low for y
               {
                   setHeroY(min_y);
               }
               else
               {
                   setHeroY((getHeroY() - 1));
               }
               //setHeroY((getHeroY() - 1));
           }
           else if(move == 's'){
               if((getHeroY() + 1) > max_y)//Number is too high for y
               {
                   setHeroY(max_y);
               }
               else
               {
                   setHeroY((getHeroY() + 1));
               }
           }
           else if(move == 'a'){
               if((getHeroX() - 1) < min_x)//Number is too low for x
               {
                   setHeroX(min_x);
               }
               else
               {
                   setHeroX((getHeroX() - 1));
               }
               //setHeroX((getHeroX() - 1));
           }
           else if(move == 'd'){
               if((getHeroX() + 1) > max_x)//Number is too high for x
               {
                   setHeroX(max_x);
               }
               else
               {
                   setHeroX((getHeroX() + 1));
               }
            }
       try {
           super.paintComponent(g);  // Call the paintComponent method from the 
           // superclass, JPanel.  This simply fills the
           // entire panel with the background color, black.
           // g.drawString(this.message ,10,10);
           int width = getWidth();
           int height = getHeight();
           //monster.setX(10);
           //monster.setY(10);
               super.paintComponent(g); 
           //monster_panels[(((getMonsterY() - 1) * 25) + getMonsterX())] = true;
           //Set the monster panel to true to paint the monster in the grid
           monster_panels[(((getMonsterY() - 1) * 25) + getMonsterX() - 1)] = true;
           //System.out.println("The Y: " + getMonsterY() + " The X: " + getMonsterX());
           //System.out.println((((getMonsterY() - 1) * 25) + getMonsterX()) + " set to true");
           //Update hero panel to true to know where to paint.
            hero_panels[(((getHeroY() - 1) * 25) + getHeroX() - 1)] = true;
            if((((getHeroY() - 1) * 25) + getHeroX()) > 625)//If higher than the max, make lower by 24.
            {
                updatePanel(601, num_of_boxes);
            }
            else
            {
                updatePanel((((getHeroY() - 1) * 25) + getHeroX()), num_of_boxes);
            }

            //monster.setX(((monster_box / 25) - 1));
           //System.out.println("Box number is: " + (((getMonsterY() - 1) * 25) + getMonsterX() + 1));
           //monster.setY(monster_box % 25);
        // Call the paintComponent method from the 
      // superclass, JPanel.  This simply fills the
      // entire panel with the background color, black.
      int size = 500, gap = 20;
           //Draws a grid based on the size of the pixels and the gap between each square.
           //This will output a blue 25x25 grid.
           for(int i = 0; i < size; i += gap)
           {
               for(int j = 0; j < size; j += gap)
               {
                   g.setColor(Color.blue);
                   g.fillRect(i, j, gap, gap);
                   g.setColor(Color.black);
                   g.drawRect(i, j, gap, gap);
                   
               }
           }  File the_file = new File("monster.jpg");
            BufferedImage img;
           img = ImageIO.read(the_file);
           File the_file2 = new File("hero.jpg");
           BufferedImage img2;
           img2 = ImageIO.read(the_file2);
           int w = img.getWidth(null);
           int h = img.getHeight(null);
           //BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
           //g = bi.getGraphics();
           //g.drawImage(img, 0, 0, null);
           int index1 = 1;
           int index2 = 0;
           int num_per_row = 25;
           int num_boxes = 625;
           int the_gap = 20;
           //Check every square in the array.
           for(int k = 1; k <= num_boxes; k++)
           {
               if(monster_panels[k - 1] == true)//The panel in the array has been clicked
               {
                   //Paint a yellow square.
                   //g.setColor(Color.yellow);
                   g.drawImage(img, ((k - index1) * the_gap), index2, the_gap, the_gap, null);
                   //g.fillRect(((k - index1) * the_gap), index2, the_gap, the_gap);
                   g.setColor(Color.black);
                   g.drawRect(((k - index1) * the_gap), index2, the_gap, the_gap);
               }
               else if(hero_panels[k - 1] == true)
               {
                   g.drawImage(img2, ((k - index1) * the_gap), index2, the_gap, the_gap, null);
                   //g.fillRect(((k - index1) * the_gap), index2, the_gap, the_gap);
                   g.setColor(Color.black);
                   g.drawRect(((k - index1) * the_gap), index2, the_gap, the_gap);
               }
               if(k % num_per_row == 0)//If we are on a multiple of 25
               {
                   //Increase the index so the x painted will be on the next row.
                   index1 += num_per_row;
                   //Increase the second index so that the correct y will be painted.
                   index2 += the_gap;
               }
           }
           //g.drawLine(0,0,100,100);     
       } // end paintComponent()
       catch (IOException ex) {
           Logger.getLogger(GridLinesPanel.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
   /**
    * Sets the move
    * @param move character to see where to move 
    */
   public void setMove(char move){
       this.move = move;
   }

   /**
    * Set a message
    * @param message The message to be set
    */
   public void setMessage(String message){
       this.message = message;
   }
   /**
    * Set box for the monster
    * @param the_box the box in the array to set to true
    */
   public void setMonsterBox(int the_box)
   {
       monster_panels[the_box - 1] = true;
       monster_box = the_box;
   }
   /**
    * get the monsters box
    * @return the monster box number
    */
   public int getMonsterBox()
   {
       return monster_box;
   }
   /**
    * sets the monster coordinates
    * @param the_x the monster x
    * @param the_y the monster y
    */
   public void setMonsterCoordinates(int the_x, int the_y)
   {
       monsterx = the_x;
       monstery = the_y;
   }
   /**
    * sets the x
    * @param the_x the monster's x
    */
   public void setMonsterX(int the_x)
   {
       monsterx = the_x;
   }
   /**
    * sets the y
    * @param the_y the monster's y
    */
   public void setMonsterY(int the_y)
   {
       monstery = the_y;
   }
   /**
    * get the monster x
    * @return the monster's x
    */
   public int getMonsterX()
   {
       return monsterx;
   }
   /**
    * get the monster's y
    * @return the monster's y
    */
   public int getMonsterY()
   {
       return monstery;
   }
   /**
    * set the hero's box
    * @param the_box the box to set to true in the array
    */
   public void setHeroBox(int the_box)
   {
       hero_panels[the_box - 1] = true;
       hero_box = the_box;
   }
   /**
    * get the hero's box
    * @return the hero's box
    */
   public int getHeroBox()
   {
       return hero_box;
   }
   /**
    * set the coordinates for the hero
    * @param the_x the hero x
    * @param the_y the hero y
    */
   public void setHeroCoordinates(int the_x, int the_y)
   {
       herox = the_x;
       heroy = the_y;
   }
   /**
    * set the hero's x
    * @param the_x the x for the hero
    */
   public void setHeroX(int the_x)
   {
       herox = the_x;
   }
   /**
    * set the hero's y
    * @param the_y the hero's y
    */
   public void setHeroY(int the_y)
   {
       heroy = the_y;
   }
   /**
    * get the hero's x
    * @return the hero's x
    */
   public int getHeroX()
   {
       return herox;
   }
   /**
    * get the hero's y
    * @return the hero's y
    */
   public int getHeroY()
   {
       return heroy;
   }
   /**
    * updates the panel for the grid
    * @param theBox the box to set to true
    * @param boxes the number of boxes in the grid.
    */
   public void updatePanel(int theBox, int boxes)
    {
        //Check every box in the array.
        for(int i = 1; i <= boxes; i++)
        {
            hero_panels[i - 1] = false;
            if(theBox == i)//The box passed is the one we are currently at.
            {                
                //Change to true so we know it is painted.
                hero_panels[i - 1] = true;         
                //System.out.println("Updated for box " + i);
            }
        }
    }
}  // end class GridLinesPanel
