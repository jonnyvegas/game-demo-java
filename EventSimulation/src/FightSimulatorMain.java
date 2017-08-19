class FightSimulatorMain {

    public static void main(String[] args) {
        start();
    }

    public static void start(){
        HeroSimulator hs  = new HeroSimulator(10);
        MonsterSimulator ms  = new MonsterSimulator(10);
        for(int i=0;i<10;i++){
            Event heroHit = hs.nextEvent();
            Event monsterHit = ms.nextEvent();
            //System.out.println("Hero:"+heroHit.execute(hs));
            System.out.println("Damage done by hero: " + hs.getDamage(heroHit.execute(hs)));
            //System.out.println("Monster:"+monsterHit.execute(ms));
            System.out.println("Damage done by monster: " + ms.getDamage(monsterHit.execute(ms)));
        }
        System.out.println("Hero Stats:\n"+hs.getStats());
        System.out.println("Monster Stats:\n"+ms.getStats());
    }
}
