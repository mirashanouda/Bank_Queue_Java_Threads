import java.security.SecureRandom;

public class Teller extends Thread {
    //aka: consumer

    private SharedQueue qu;
    public int teller_Num;
    public Teller(int i, SharedQueue q){
        this.qu = q;
        this.teller_Num = i;
    }

    @Override
    public void run() {
    }
}
