class HeroSimulator extends Simulator{

     int heavy=0,medium=0,light=0,nohit=0;
    
     private void saveHit(Hit h){
        if(h.getHit() == 3) heavy++;
        else if(h.getHit() == 2) medium++;
        else if(h.getHit() == 1) light++;
        else nohit++;
     }

    public String getStats(){
        return "Heavy:"+heavy+"\nMedium:"+medium+"\nLight:"+light+"\nNo Hit:"+nohit;
    }

     public HeroSimulator(int num) {
        events = new ListQueue();
        for(int i=0;i<num;i++){
           Hit h = new Hit();
           saveHit(h);
           insert( h );
        }
    }
}

