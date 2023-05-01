import java.security.SecureRandom;

public class Teller extends Thread {
    //aka: consumer

    SecureRandom rand = new SecureRandom();
    private SharedQueue qu;
    public int tellerNum;
    public Teller(int i, SharedQueue q){
        this.qu = q;
        this.tellerNum = i;
    }

    @Override
    public void run() {
        Customer c;
        while (qu.continueWork()) {
            if (!qu.queueIsEmpty()) {
                c = qu.takeFromQueue();
                System.out.printf("[Start] customer %d with priority %d -- by Teller %d\n", c.getTurn(), c.getPriority(), tellerNum);
                try {
                    int t = rand.nextInt(5) + 2; //random time from 2 to 7 seconds
                    Thread.sleep(t + 1000);
                    System.out.printf("[Finished] customer %d with priority %d\n", c.getTurn(), c.getPriority(), tellerNum);
                } catch (InterruptedException e) {
                    System.err.println("Error in Sleep");
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
