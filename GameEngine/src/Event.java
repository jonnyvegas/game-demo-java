import java.util.Random;
public class Event
{
    private final int upperLimit = 64000;

    public int generateRandom(int shift,int scale){
	Random r = new Random();
	return r.nextInt(upperLimit) % scale + shift;
    }


}
