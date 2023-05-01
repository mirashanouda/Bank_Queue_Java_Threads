# Bank Queue Simulator using Multithreading in Java (Producer Consumer Problem)

It is a program that simulates a real banking queue system in the form of a single producer (Queue Manager) and multiple consumers (bank tellers) that interact using a shared buffer (Priority Queue). The user inputs the number of tellers (threads) and the customers based on their type (priority): PIV (higher priority) and regular (lower priority). 
The program is built based on multithreading where each teller is a separate thread that handles the incoming customers' requests at a certain time period. The shared recourses in the code (the shared buffer) are synchronized when multiple threads are accessing it. 

## **Program Design:**
- **Main**: Handles User input for the number of tellers and cunstmers along with the type of each one (VIP: priority 1 and Regular: priority 2)
- **Customer**: class to store the customer number (turn) and priority.
- **SharedQueue**: Acts like a shared buffer between the producer and consumer(s). It is a prioirty queue that arrange customers in the line (queue) based on their prioirtiy.  Each object in this queue is of type costumer. 
- **ComparatorQueue**: A class that implements the Comparator interface. It return the customer with the higher priority. If prioirites equates, the customer who came first is returned (lower turn). 
- **ManageQuery**: It acts as the producer that puts the customers in the queue. 
- **Teller**: It acts as the consumer that takes the custmers from the queue. It sleeps for a random number of seconds bestween 2-7 seconds to simulates a processing time of the customer on the bank window.