package MoveChar;

/**
File: CharacterClass.java
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



import java.util.Random;

abstract class Event extends AbstractEvent {
    double hit;

    @Override
    public boolean lessThan(Comparable y) {
        Event e = (Event) y;  // Will throw an exception if y is not an Event
        return this.hit < e.hit;
    }
}
/**
 * Base class for all monsters and heroes.
 * @author Jonny
 */
public class CharacterClass extends AbstractCharacter {
    double hit;
    double health;
    double total_damage;
    int x;
    int y;
    int x_bound = 25;
    int y_bound = 25;
    Direction up, down, left, right;
    
    int heavy=0,medium=0,light=0,nohit=0;
    //Constructor.
    public CharacterClass() {
        up = new Direction(1);
        down = new Direction(2);
        left = new Direction(3);
        right = new Direction(4);
        health = 100;
        total_damage = 0;
    }
    //Saves a hit in the counter.
     void saveHit(Hit h){
        if(h.getHit() == 10) heavy++;
        else if(h.getHit() == 5) medium++;
        else if(h.getHit() == 2) light++;
        else nohit++;
     }
     //Prints out the stats for the character.
    public String getStats(){
        return "Heavy:"+heavy+"\nMedium:"+medium+"\nLight:"+light+
                "\nNo Hit:"+nohit+"\nHealth:"+health+"\nTotal Damage Done:"+total_damage;
    }
    //Gets the amount of damage and also adds it to the total.
    double getDamage() {
        System.out.println("Attacking for " + hit + " health.");
        total_damage += hit;
        return hit;
    }
    //Sets the hit based on the text for the hit.
    void setDamage(String the_damage)
    {
        if(the_damage.equals("Heavy"))
            hit = 10;
        else if(the_damage.equals("Medium"))
            hit = 5;
        else if(the_damage.equals("Light"))
            hit = 2;
        else
            hit = 0;
    }
    //Character will be attacked with a certain amount of damage.
    void beAttacked(double the_damage)
    {
        health = health - the_damage;
        System.out.println("Loss of " + the_damage + " health.");
    }
    //Returns the amount of health.
    double getHealth()
    {
        return health;
    }
    //Sets where the character is standing.
    void setCoordinates(int the_x, int the_y)
    {
        x = the_x;
        y = the_y;
    }
    //Sets the x.
    void setX(int the_x)
    {
        x = the_x;
    }
    //Sets the Y.
    void setY(int the_y)
    {
        y = the_y;
    }
    //Returns the x coordinate.
    int getX()
    {
        return x;
    }
    //Returns the y coordinate.
    int getY()
    {
        return y;
    }
    //Get the direction in the form of an integer.
    int getDirection(String the_direction)
    {
        if(the_direction.equals("up"))
            return 1;
        else if (the_direction.equals("down"))
            return 2;
        else if (the_direction.equals("left"))
            return 3;
        else //direction is right
            return 4;
    }
    
    /**
     *Moves the character anywhere from 0 - 3 spaces randomly to simulate moving.
     * @param the_direction tells which direction the character should move.
     */
    public void move(int the_direction){
        Random r = new Random();
        int num = Math.abs(r.nextInt()) % 3 + 0;
        if(the_direction == 1)
        {
            System.out.println("Moving up " + num + " spaces.");
            y = y + num;
            checkCoordinates();
            System.out.println("New x coordinate: " + x + " y coordinate: " + y);
        }
        else if(the_direction == 2)
        {
            System.out.println("Moving down " + num + " spaces.");
            y = y - num;
            checkCoordinates();
            System.out.println("New x coordinate: " + x + " y coordinate: " + y);
        }
        if(the_direction == 3)
        {
            System.out.println("Moving left " + num + " spaces.");
            x = x - num;
            checkCoordinates();
            System.out.println("New x coordinate: " + x + " y coordinate: " + y);
        }
        if(the_direction == 4)
        {
            System.out.println("Moving right " + num + " spaces.");
            x = x + num;
            checkCoordinates();
            System.out.println("New x coordinate: " + x + " y coordinate: " + y);
        }
    }
    //Makes sure that the characters do not go outside of the bounds of the grid.
    public void checkCoordinates()
    {
        //If they try to move past 0 on the coordinates, it will leave the
        //character at 0.
        if(getX() < 0)
        {
            setX(0);
        }
        //If they try to move past the bound on the coordinates, it will leave the
        //character at the max bound.
        else if (getX() > x_bound)
        {
            setX(x_bound);
        }
        else if (getY() < 0)
        {
            setY(0);
        }
        else if (getY() > y_bound)
        {
            setY(y_bound);
        }
    }
    //Returns true if the characters are standing next to each other.
    public boolean standingNextTo(CharacterClass a_char)
    {
        //If the characters are within 1 space in any direction, this returns true.
        if((this.getX() == a_char.getX() + 1) || (this.getX() == a_char.getX() - 1) || this.getX() == a_char.getX())
        {
            if((this.getY() == a_char.getY() + 1) || (this.getY() == a_char.getY() - 1) || this.getY() == a_char.getY())
            {
                return true;
            }
        }
        
        return false;
    }
    //Returns the next event in the event array, which stores hits, a type of event.
    Event nextEvent(){
        return (Event) events.removeFirst();
    }
    //Executes the next event in the array after removing it.
    String executeNext(){
        Event e  = (Event) events.removeFirst();
        return e.execute(this);
    }
    //Execute all events.
    void doAllEvents() {
        Event e;
        while ( (e= (Event) events.removeFirst()) != null) {
            hit = e.hit;
            e.execute(this);
        }
    }
}
