import java.util.*;

public class SharedQueue {

    private final ArrayList<Customer> allCustomers = new ArrayList<>();
    private final PriorityQueue<Customer> q = new PriorityQueue<Customer>(new ComparatorQueue());
    int maxsize; //the number of tellers

    public SharedQueue(int tellers_num, ArrayList<Integer> pris_list) {
        this.maxsize = tellers_num;
        for (int i = 0; i < pris_list.size(); i++) {
            this.allCustomers.add(new Customer(i, pris_list.get(i)));
        }
    }

    public synchronized boolean continueWork(){
        return q.size() != 0 || allCustomers.size() != 0;
    }

    public synchronized boolean queueIsEmpty() {
        return q.isEmpty();
    }
    
    public synchronized void addToQueue() {
        while (continueWork()) {
            while (q.size() == maxsize) {
                try {
                    wait();
                    System.out.println("Q is full in add to Queue");
                } catch (InterruptedException e) {
                    System.err.println("Error in addToQueue");
                    throw new RuntimeException(e);
                }
            }
            if (!allCustomers.isEmpty()) {
                Customer c = allCustomers.get(0);
                allCustomers.remove(0);
                this.q.add(c);
                notify();
            } else break;

        }
        System.out.println("Finished all customers");
    }

    public synchronized Customer takeFromQueue() {
        while (q.isEmpty()) {
            try {
                System.out.println("Q is empty - No customers to take");
                wait();
            } catch (InterruptedException e) {
                System.err.println("Error in takeFromQueue");
                throw new RuntimeException(e);
            }
        }
        Customer c = q.poll();
        notify();
        return c;
    }
}
