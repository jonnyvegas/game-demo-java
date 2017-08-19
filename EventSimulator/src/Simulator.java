abstract class Event extends AbstractEvent {
    double hit;

    @Override
    public boolean lessThan(Comparable y) {
        Event e = (Event) y;  // Will throw an exception if y is not an Event
        return this.hit < e.hit;
    }
}

class Simulator extends AbstractSimulator {
    double hit;
    double health = 100;
    double total_damage = 0;
    
    int heavy=0,medium=0,light=0,nohit=0;
    
     void saveHit(Hit h){
        if(h.getHit() == 10) heavy++;
        else if(h.getHit() == 5) medium++;
        else if(h.getHit() == 2) light++;
        else nohit++;
     }

    public String getStats(){
        return "Heavy:"+heavy+"\nMedium:"+medium+"\nLight:"+light+
                "\nNo Hit:"+nohit+"\nHealth:"+health+"\nTotal Damage Done:"+total_damage;
    }
 
    double getDamage() {
        System.out.println("Attacking for " + hit + " health.");
        total_damage += hit;
        return hit;
    }
    
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
    
    void be_attacked(double the_damage)
    {
        health = health - the_damage;
        System.out.println("Loss of " + the_damage + " health.");
    }
    
    double getHealth()
    {
        return health;
    }

    Event nextEvent(){
        return (Event) events.removeFirst();
    }

    String executeNext(){
        Event e  = (Event) events.removeFirst();
        return e.execute(this);
    }

    void doAllEvents() {
        Event e;
        while ( (e= (Event) events.removeFirst()) != null) {
            hit = e.hit;
            e.execute(this);
        }
    }
}
