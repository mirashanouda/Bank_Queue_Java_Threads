import java.util.*;

public class SharedQueue {

    private final ArrayList<Customer> allCustomers = new ArrayList<>();
    int maxsize; //the number of tellers

    public SharedQueue(int tellers_num, ArrayList<Integer> pris_list) {
        this.maxsize = tellers_num;
        for (int i = 0; i < pris_list.size(); i++) {
            this.allCustomers.add(new Customer(i, pris_list.get(i)));
        }
    }
    
}
