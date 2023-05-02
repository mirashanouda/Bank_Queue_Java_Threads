import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        Integer tellers_num;

        Scanner in = new Scanner(System.in);
        System.out.println("Enter Number of Tellers:");
        tellers_num = in.nextInt();
        
        ArrayList<Integer> customer_pri = ReadFile();
        SharedQueue q = new SharedQueue(tellers_num, customer_pri);
        
        // launch the consumers
        Thread[] tellers = new Thread[tellers_num+1];
        for (int i = 1; i <= tellers_num; i++){
            tellers[i] =  new Teller(i, q);
            tellers[i].start();
        }
        // launch the producer
        Thread bankQueue = new Thread(new ManageQueue(q));
        bankQueue.start();
    }

    public static ArrayList<Integer> UserInpout(Scanner in) {
        //Console input:
        Integer customers_num; 
        System.out.println("Enter Number of Customers:");
        customers_num = in.nextInt();
        System.out.print("Enter the type of each customer\n(1) for regular and (2) for VIP\n");

        ArrayList<Integer> customer_pri = new ArrayList<>(); //a list of priorities for each customer
        
        for (int  i = 0; i < customers_num; i++){
            while (true){
                try {
                    int priority = in.nextInt();
                    if (priority != 1 && priority != 2) {
                        throw new Exception("Invalid customer type");
                    }
                    else {
                        customer_pri.add(priority);
                        break;
                    }
                } catch (Exception e) {
                    System.err.println("Invalid customer type. Please input a value of (1) or (2)");
                }
            }
        }
        return customer_pri;
    }

    public static ArrayList<Integer> ReadFile() {
        String filename = "TestFile.txt";
        System.out.printf("Priorities are read from the file %s\n(1) for regular and (2) for VIP\n", filename);
        ArrayList<Integer> customer_pri = new ArrayList<>(); //a list of priorities for each customer
        
        FileReader reader;
        try {
            reader = new FileReader(filename);
            BufferedReader buffReader = new BufferedReader(reader);
            String line;
            try {
                while ((line = buffReader.readLine()) != null){
                    try{
                        Integer priority = Integer.parseInt(line);
                        if (priority != 1 && priority != 2) {
                            throw new Exception("Invalid customer type");
                        }
                        else {
                            System.out.println(priority);
                            customer_pri.add(priority);
                        }
                    } catch (Exception e) {
                        System.err.println("Invalid customer type. Please input a value of (1) or (2)");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            System.err.print("Error! File not found");
            e.printStackTrace();
        }
        
        return customer_pri;
    }
}


