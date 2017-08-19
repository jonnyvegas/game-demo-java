import java.util.Random;
public class Hit extends Event{
   
    private final int the_hit;
    
    @Override
    public String toString(){
        return hitTypeAsString();
    }

    public String hitTypeAsString(){
        if(getHit() == 10) return "Heavy";
        else if (getHit()==5) return "Medium";
        else if (getHit()==2) return "Light";
        else return "No Hit";
    }

    @Override
    String execute(AbstractSimulator simulator) {
        return hitTypeAsString();
    }

    private boolean isLight(){
        return (the_hit > 30 && the_hit <= 100);
    }

    private boolean isMedium(){
        return (the_hit > 10 && the_hit <= 30);
    }

    private boolean isHeavy(){
        return (the_hit >= 1 && the_hit <= 10);
    }

    public int getHit(){
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
        the_hit = Math.abs(r.nextInt()) % 100 + 1;
    } 
    public boolean Chance()
    {
        Random r = new Random();
        int some_num;
        some_num = Math.abs(r.nextInt()) % 100 + 1;
        return some_num >= 1 && some_num <=25;
    }
}
