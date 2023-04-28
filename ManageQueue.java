public class ManageQueue implements Runnable {
    //aka: Producer
    
    private SharedQueue q;
    public ManageQueue(SharedQueue q){
        this.q = q;
    }
    @Override
    public void run() {
        System.out.println("Started adding to queue");
        q.addToQueue();
    }
}