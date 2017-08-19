/**
File: GameDemo.java
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

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
 /**
  * GameDemo Demonstrates the game using a gridpanel, monster, hero, and
  * methods that let a hero move around and fight a monster.
  * @author Jonny
  */
public class GameDemo extends JFrame
        implements KeyListener,
        ActionListener
{
    static int num_of_events = 100;
    static Monster monster = new Monster(num_of_events);
    static Hero hero = new Hero(num_of_events);
    static GridLinesPanel gridpanel = new GridLinesPanel();
    JTextField typingArea;
    static final String newline = System.getProperty("line.separator");
    static boolean next_to = false;
     
    public static void main(String[] args) {
        //Schedule a job for event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
        //Put the monster in a random square.
         Random r = new Random();
        Random r2 = new Random();
          int num1 = Math.abs(r.nextInt()) % 25 + 1;
          //System.out.println("First number " + num1);
          int num2 = Math.abs(r2.nextInt()) % 25 + 1;
          //System.out.println("Second number " + num2);
          gridpanel.setMonsterX(num1);
          gridpanel.setMonsterY(num2);
          monster.setCoordinates(num1, num2);
          //gridpanel.setMonsterCoordinates(num1,num2);
          int the_x = gridpanel.getMonsterX();
          int the_y = gridpanel.getMonsterY();
            //System.out.println(the_x);
            //System.out.println(the_y);
            monster.setX(the_x);
            monster.setY(the_y);
            gridpanel.setHeroX(1);
            gridpanel.setHeroY(25);
            hero.setCoordinates(1, 25);
        //While they are not next to each other, test to see if they are.
        while(!next_to)
        {
            if((gridpanel.getHeroX() == gridpanel.getMonsterX() + 1) || (gridpanel.getHeroX() == gridpanel.getMonsterX() - 1) || gridpanel.getHeroX() == gridpanel.getMonsterX())
            {
                if((gridpanel.getHeroY() == gridpanel.getMonsterY() + 1) || (gridpanel.getHeroY() == gridpanel.getMonsterY() - 1) || gridpanel.getHeroY() == gridpanel.getMonsterY())
                {
                    next_to = true;
                }
            }
        }
        if(next_to)//If they are standing next to each other, they will fight.
        {
            System.out.println("They are next to each other!!! A battle ensues!!!");
            fight(hero, monster, num_of_events);
        }
        System.out.println("Hero Stats:\n"+hero.getStats());
        System.out.println("Monster Stats:\n"+monster.getStats());
    }
     
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        GameDemo frame = new GameDemo("Game Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        //Set up the content pane.
        frame.addComponentsToPane();
         
         
        //Display the window.
        frame.pack();
        frame.setVisible(true);
        /*
         GridLinesPanel gridpanel = new GridLinesPanel();
          int theX = 500, theY = 500;
	  gridpanel.setPreferredSize(new Dimension(theX,theY));
	  frame.getContentPane().add(gridpanel,BorderLayout.CENTER);
	  gridpanel.setPreferredSize(new Dimension(theX,theY));
	  frame.getContentPane().add(gridpanel,BorderLayout.CENTER);

	  frame.pack();
	  frame.setVisible(true);
          */
    }
     /**
      * Adds components to the pane in the window.
      */
    private void addComponentsToPane() {
         
        JButton button = new JButton("Clear");
        button.addActionListener(this);
         
        typingArea = new JTextField(20);
        typingArea.addKeyListener(this);
         
        //Uncomment this if you wish to turn off focus
        //traversal.  The focus subsystem consumes
        //focus traversal keys, such as Tab and Shift Tab.
        //If you uncomment the following line of code, this
        //disables focus traversal and the Tab events will
        //become available to the key event listener.
        //typingArea.setFocusTraversalKeysEnabled(false);
        
        
        JScrollPane scrollPane = new JScrollPane(gridpanel);
        scrollPane.setPreferredSize(new Dimension(525, 525));
         
        getContentPane().add(typingArea, BorderLayout.PAGE_START);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(button, BorderLayout.PAGE_END);
       
         
    }
     
    public GameDemo(String name) {
        super(name);
    }
     
     
    /** Handle the key typed event from the text field. */
    public void keyTyped(KeyEvent e) {
        processKey(e, "KEY TYPED: ");
    }
     
    /** Handle the key pressed event from the text field. */
    public void keyPressed(KeyEvent e) {
        //processKey(e, "KEY PRESSED: ");
    }
     
    /** Handle the key released event from the text field. */
    public void keyReleased(KeyEvent e) {
        //processKey(e, "KEY RELEASED: ");
    }
     
    /** Handle the button click. */
    public void actionPerformed(ActionEvent e) {
        //Clear the text components.
        typingArea.setText("");
         
        //Return the focus to the typing area.
        typingArea.requestFocusInWindow();
    }
     
    /*
     * We have to jump through some hoops to avoid
     * trying to print non-printing characters
     * such as Shift.  (Not only do they not print,
     * but if you put them in a String, the characters
     * afterward won't show up in the text area.)
     */
    private void processKey(KeyEvent e, String keyStatus){
         
        //You should only rely on the key char if the event
        //is a key typed event.
        int id = e.getID();
        String keyString;
        if (id == KeyEvent.KEY_TYPED) {
            char c = e.getKeyChar();
            keyString = "id = "+id + " - key character = '" + c + "'";
            gridpanel.setMove(c);
            gridpanel.setMessage(keyString);
            //System.out.println(keyString);
        }
        gridpanel.repaint();
        //gridpanel.update();
    }
    /**
     * Method to make the two fight
     * @param the_hero CharacterClass hero to fight
     * @param the_monster CharacterClass monster to fight
     * @param numOfEvents The number of rounds the hero and monster will fight
     */
    public static void fight(CharacterClass the_hero, CharacterClass the_monster, int numOfEvents)
   {
       int i = 0;
       //While neither one is dead and the number of events hasn't gone past
       while(the_hero.getHealth() > 0 && the_monster.getHealth() > 0 && i < numOfEvents)
        {
            i++;
            Event heroHit = the_hero.nextEvent();
            Event monsterHit = the_monster.nextEvent();
            the_hero.setDamage(heroHit.execute(the_hero));
            System.out.println("Health left for Hero: " + the_hero.getHealth());
            the_monster.beAttacked(the_hero.getDamage());
            the_monster.setDamage(monsterHit.execute(the_monster));
            System.out.println("Health left for Monster: " + the_monster.getHealth());
            the_hero.beAttacked(the_monster.getDamage());
        }

      if(the_hero.getHealth() <= 0)
      {
          System.out.println("Hero dies.");
      }
      else if (the_monster.getHealth() <= 0)
      {
          System.out.println("Monster dies.");
      }
      else if(the_monster.getHealth() < the_hero.getHealth())
      {
          System.out.println("Hero wins with more health.");
      }
      else if (the_hero.getHealth() < the_monster.getHealth())
      {
          System.out.println("Monster wins with more health.");
      }
      else
      {
          System.out.println("They tied?!!!?");
      }
   }

}
