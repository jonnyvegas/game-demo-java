package MoveChar;

/**
File: Interfaces.java
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



interface Comparable {
    boolean lessThan(Comparable y);
}

//executes the event which returns a string.
abstract class  AbstractEvent implements Comparable {
    abstract String execute(AbstractCharacter character);
}
//Ordered set of events.
abstract class OrderedSet {
    abstract void insert(Comparable x);
    abstract Comparable  removeFirst();
    abstract int size();
    abstract Comparable remove(Comparable x);
}
//Character with an ordered set of events to be implemented later.
class AbstractCharacter {

    OrderedSet events;
    //insert the event into the ordered set or the list after it is created.
    void insert(AbstractEvent e) {
        events.insert(e);
    }
    AbstractEvent cancel(AbstractEvent e)  {
        throw new java.lang.RuntimeException("Method not implemented");
    }
}
