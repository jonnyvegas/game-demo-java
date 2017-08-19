import java.util.Random;
public class Hit extends Event{
   
    private int hit;
    
    public String toString(){
        return hitTypeAsString();
    }

    public String hitTypeAsString(){
        if(getHit() == 3) return "Heavy";
        else if (getHit()==2) return "Medium";
        else if (getHit()==1) return "Light";
        else return "No Hit";
    }

    String execute(AbstractSimulator simulator) {
        return hitTypeAsString();
    }

    private boolean isLight(){
        return hit <= 70;
    }

    private boolean isMedium(){
        return hit <= 20;
    }

    private boolean isHeavy(){
        return hit <= 10;
    }

    public int getHit(){
        if(isHeavy()){
            return 3;
        }
        else if(isMedium()){
            return 2;
        }
        else if(isLight()){
            return 1;
        }
        else {
            return 0;
        }
    }

    public Hit(){
        Random r = new Random();
        hit = Math.abs(r.nextInt()) % 100 + 1;
    } 
}
