public class Customer {
    private int turn;
    private int priority;


    public Customer(int turn, int priority){
        this.turn = turn;
        this.priority = priority;
    }

    public int getTurn(){
        return turn;
    }
    public int getPriority() {
        return priority;
    }
}
