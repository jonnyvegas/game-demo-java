public class Direction
{
   //public enum d  {up,down,left,right};

   private int dir;

   public Direction(int d){
      dir = d;
   }

   public void setDirection(int d){
       dir = d;
   }

   public int getDirection(){
       return dir;
   }
}
