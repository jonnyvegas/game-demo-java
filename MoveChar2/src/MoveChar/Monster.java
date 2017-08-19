package MoveChar;

/**
File: Monster.java
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



public class Monster extends CharacterClass
{
    public Monster(int num)
    {
        //Creates a list queue from the ordered events from interfaces.
        events = new ListQueue();
        //Insert the correct numbrer of events into the queue.
        for(int i=0;i<num;i++){
           Hit h = new Hit();
           saveHit(h);
           events.insert( h );
        }
    }
    
    @Override
    public String toString(){
       return "Monster";
    }
}
