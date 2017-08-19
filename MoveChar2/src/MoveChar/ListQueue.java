package MoveChar;

/**
File: ListQueue.java
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



import java.util.Vector;
class ListQueue extends OrderedSet {

    private Vector<Comparable> elements = new Vector<>();

    @Override
    //Insert an event into the vector of comparables, which are events.
    void insert(Comparable x) {
        int i = 0;
        while (i < elements.size() && ((Comparable) elements.elementAt(i)).lessThan(x)) {
            i++;
        }
        elements.insertElementAt(x,i);
     }

    @Override
    //Returns the first event in the vector.
     Comparable removeFirst() {
        if (elements.isEmpty()) return null;
        
        Comparable x = (Comparable) elements.firstElement();
        elements.removeElementAt(0);
        return x;
     }

    @Override
    //Removes the element in the array.
    Comparable remove(Comparable x) {
            for (int i = 0; i < elements.size(); i++) {
                if (elements.elementAt(i).equals(x)) {
                   Object y = elements.elementAt(i);
                   elements.removeElementAt(i);
                    return (Comparable) y;
                }
            }
        return null;
    }

    @Override
    //Return the size of the array.
    public int size() {
        return elements.size();
    }
}
