import java.util.Scanner;

class FightSimulatorMain {

    public static void main(String[] args) {
        start();
    }

    public static void start(){
        Scanner input = new Scanner(System.in);
        int numOfEvents;
        double damage;
        System.out.print("Please enter the number of rounds you would like to simulate: ");
        numOfEvents = input.nextInt();
        HeroSimulator hs  = new HeroSimulator(numOfEvents);
        MonsterSimulator ms  = new MonsterSimulator(numOfEvents);
        int i = 0;
        while(hs.getHealth() > 0 && ms.getHealth() > 0 && i < numOfEvents)
        {
            i++;
            Event heroHit = hs.nextEvent();
            Event monsterHit = ms.nextEvent();
            hs.setDamage(heroHit.execute(hs));
            System.out.println("Health left for Hero: " + hs.getHealth());
            ms.be_attacked(hs.getDamage());
            ms.setDamage(monsterHit.execute(ms));
            System.out.println("Health left for Monster: " + ms.getHealth());
            hs.be_attacked(ms.getDamage());
        }

        if(hs.getHealth() <= 0)
        {
            System.out.println("Hero dies.");
        }
        else if (ms.getHealth() <= 0)
        {
            System.out.println("Monster dies.");
        }
        else if(ms.getHealth() < hs.getHealth())
        {
            System.out.println("Hero wins with more health.");
        }
        else if (hs.getHealth() < ms.getHealth())
        {
            System.out.println("Monster wins with more health.");
        }
        else
        {
            System.out.println("They tied?!!!?");
        }
        System.out.println("Hero Stats:\n"+hs.getStats());
        System.out.println("Monster Stats:\n"+ms.getStats());
    }
}
