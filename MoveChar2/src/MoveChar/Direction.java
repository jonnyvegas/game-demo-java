package MoveChar;

/**
File: Direction.java
Description: Download the event simulator for the game engine discussed in class.  
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



public class Direction
{
   //public enum d  {up,down,left,right};

   private int dir;
   //Constructor.
   public Direction(int d){
      dir = d;
   }
   //Sets the direction with an int.
   public void setDirection(int d){
       dir = d;
   }
   //Returns an int representing the direction.
   public int getDirection(){
       return dir;
   }
}
