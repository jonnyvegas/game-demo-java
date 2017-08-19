
//import gameengine.ListQueue;

class HeroSimulator extends Simulator{

     public HeroSimulator(int num) {
        events = new ListQueue();
        for(int i=0;i<num;i++){
           Hit h = new Hit();
           saveHit(h);
           events.insert( h );
        }
    }
}

