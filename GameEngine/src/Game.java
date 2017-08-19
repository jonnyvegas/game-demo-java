import java.util.ArrayList;

public class Game{
   
   public static void main(String [] args){
      ArrayList<Character> playerList = new ArrayList<Character>();
      playerList.add(new Monster());
      playerList.add(new Hero());
      playerList.add(new Hero());

      for(Character p: playerList){
	System.out.println(p);
	Event e = new Event();
	int the_move;
	System.out.println(e.generateRandom(1,4));
	the_move = e.generateRandom(1,4);
	p.move(new Direction(the_move));
	p.move(new Direction(the_move));
      }
   }
}
