public class Hero implements Character
{
	public void move(Direction d){
	    System.out.println("Hero move code");
	    System.out.println(d.getDirection());
	}

	public String toString(){
	   return "Hero";
	}
}
