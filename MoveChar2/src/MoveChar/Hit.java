package MoveChar;

/**
File: Hit.java
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

public class Hit extends Event{
    private final int the_hit;
    
    @Override
    public String toString(){
        return hitTypeAsString();
    }
    //find out what kind of hit it was.
    public String hitTypeAsString(){
        if(getHit() == 10) return "Heavy";
        else if (getHit()==5) return "Medium";
        else if (getHit()==2) return "Light";
        else return "No Hit";
    }

    @Override
    //Returns hit type as string for the event.
    String execute(AbstractCharacter character) {
        return hitTypeAsString();
    }
    //70% chance of light
    private boolean isLight(){
        return (the_hit > 30 && the_hit <= 100);
    }
    //20% chance of medium
    private boolean isMedium(){
        return (the_hit > 10 && the_hit <= 30);
    }
    //10% chance of heavy
    private boolean isHeavy(){
        return (the_hit >= 1 && the_hit <= 10);
    }

    public int getHit(){
        //25% chance the hit will miss.
        if(Chance())
        {
            return 0;
        }
        else if(isHeavy()){
            return 10;
        }
        else if(isMedium()){
            return 5;
        }
        else{
            return 2;
        }
    }
    
    @Override
    public boolean lessThan(Comparable y) {
        Hit e = (Hit) y;  // Will throw an exception if y is not an Event
        return this.the_hit < e.the_hit;
    }

    public Hit(){
        Random r = new Random();
        //Hit is random 1-100.
        the_hit = Math.abs(r.nextInt()) % 100 + 1;
    } 
    public boolean Chance()
    {
        Random r = new Random();
        int some_num;
        some_num = Math.abs(r.nextInt()) % 100 + 1;
        //25% chance the hit will miss.
        return some_num >= 1 && some_num <=25;
    }
}
