abstract class Event extends AbstractEvent {
    double time;

    public boolean lessThan(Comparable y) {
        Event e = (Event) y;  // Will throw an exception if y is not an Event
        return this.time < e.time;
    }
}

class Simulator extends AbstractSimulator {
    double time;
    int no_hit = 0;
    int light_hit = 1;
    int medium_hit = 2;
    int heavy_hit = 3;
    
    int getDamage(String type)
    {
    	if(type.equals("Heavy"))
    	{
    		return heavy_hit;
    	}
    	else if(type.equals("Medium"))
    	{
    		return medium_hit;
    	}
    	else if(type.equals("Light"))
    	{
    		return light_hit;
    	}
    	else
    	{
    		return no_hit;
    	}
    }
    double now() {
        return time;
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
            time = e.time;
            e.execute(this);
        }
    }
}
