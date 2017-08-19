package MoveChar;

/**
File: Game.java
Description:Download the event simulator for the game engine discussed in class.  
* Generalize the MonsterSimulator and HeroSimulator classes so that the hit 
* types are in a base class.  Combine the code from the event simulator with the 
* game engine so that a fight can be simulated between the monster and the hero. 
* Add effects to the monster and the hero so that when there is a hit, damage is 
* done to either character.   Add a member to the Character class which 
* represents the life of the character so at the end of the fight, it is known 
* which character has more life (or wins).
Author: Jonathan Villegas
mail: jonathan.e.villegas@gmail.com
Date: 5/18/14
**/



import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Game extends JFrame
        implements KeyListener,
        ActionListener{
    JTextField typingArea;
    GridLinesPanel gridpanel;
   
   public static void main(String [] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    Scanner input = new Scanner(System.in);
    int numOfEvents;
    boolean next_to = false;
    System.out.print("Please enter the number of rounds you would like to simulate: ");
    numOfEvents = input.nextInt();
    Hero the_hero = new Hero(numOfEvents);
    Monster the_monster = new Monster(numOfEvents);
    //Start the hero at the bottom and the monster on the opposite side.
    the_hero.setCoordinates(25, 1);
    the_monster.setCoordinates(5, 5);
    //Move the characters until they meet up.
    /*
    while(!next_to)
    {
        move(the_hero, the_monster);
        if(the_hero.standingNextTo(the_monster))
        {
            next_to = true;
        }
    }
    if(next_to)//If they are standing next to each other, they will fight.
    {
        System.out.println("They are next to each other!!! A battle ensues!!!");
        fight(the_hero, the_monster, numOfEvents);
    }
    */
    int monster_box = (((the_monster.getX() - 1) * 25) + the_monster.getY());
    

    
    System.out.println("Hero Stats:\n"+the_hero.getStats());
    System.out.println("Monster Stats:\n"+the_monster.getStats());
    }
   
   private static void createAndShowGUI() {
        //Create and set up the window.
        Game frame = new Game();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        //Set up the content pane.
        frame.addComponentsToPane();
         
         
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
     
    public void addComponentsToPane() {
         
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
        
        gridpanel = new GridLinesPanel();
        JScrollPane scrollPane = new JScrollPane(gridpanel);
        scrollPane.setPreferredSize(new Dimension(500, 500));
         
        getContentPane().add(typingArea, BorderLayout.PAGE_START);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(button, BorderLayout.PAGE_END);
    }
   //Moves the characters.
   public static void move(CharacterClass char1, CharacterClass char2)
   {
       /*
       Random r;
       Random r2;
       r = new Random();
       r2 = new Random();
       int num1 = Math.abs(r.nextInt()) % 4 + 0;
       int num2 = Math.abs(r2.nextInt()) % 4 + 0;
       //Move the characters between 0-4 spaces.
       System.out.println("Moving the hero...");
       char1.move(num1);
       System.out.println("Moving the monster...");
       char2.move(num2);
       if(char1.standingNextTo(char2))
       {
           System.out.println("Standing next to each other.");
       }
       else
       {
           System.out.println("Not standing next to each other.");
       }
       */
   }

    /**
     *Function to have the two types fight based on the number of events.
     * @param the_hero the character class for the hero
     * @param the_monster the character class for the montser
     * @param numOfEvents the number of events to simulate
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

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
