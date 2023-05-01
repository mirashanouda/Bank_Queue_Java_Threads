import java.util.Comparator;

public class ComparatorQueue implements Comparator<Customer> {
    @Override
    public int compare(Customer c1, Customer c2) {
        //return the higher priority
        if (c1.getPriority() > c2.getPriority()) return -1;
        if (c1.getPriority() < c2.getPriority()) return 1;
        
        //if priorities are equal:

        if (c1.getTurn() > c2.getTurn()) return 1; //return who came first
        else return -1;   
    }
}