# Bank Queue Simulator using Multithreading in Java (Producer-Consumer Problem)


It is a program that simulates a real banking queue system in the form of a single producer (Queue Manager) and multiple consumers (bank tellers) that interact using a shared buffer (Priority Queue). The user inputs the number of tellers (threads) and the customers based on their type (priority): PIV (higher priority) and regular (lower priority).
The program is built based on multithreading where each teller is a separate thread that handles the incoming customers' requests at a certain time period. The shared resources in the code (the shared buffer) are synchronized when multiple threads are accessing it.


## **Program Design:**
- **Main**: Handles User input for the number of tellers and customers along with the type of each one (VIP: priority 1 and Regular: priority 2). It also includes how the customer types are entered: either from a TestFile or manually by the user.
- **Customer**: class to store the customer turn (its index in the array list) and priority (the value of the index).
- **SharedQueue**: Acts like a shared buffer between the producer and consumer(s). It is a priority queue that arranges customers in the line (queue) based on their priorities.  Each object in this queue is of type customer.
- **ComparatorQueue**: A class that implements the Comparator interface. It returns the customer with a higher priority. If priorities equate, the customer who came first is returned (lower turn).
- **ManageQuery**: It acts as the producer that puts the customers in the queue.
- **Teller**: It acts as the consumer that takes the customers from the queue. It sleeps for a random number of seconds between 2-7 seconds to simulate the processing time of the customer on the bank window.


## Input:
1. **Number of tellers** [Integer]: The number of tellers (threads) that will be created.
2. **Input method** [Integer]: The user should choose the method to enter the type of each customer arriving. It should be either a user input from the console (1) or a file input with all priorities (2).
3. The types of each customer will be its priority. The 1 represents a regular customer (low priority) and the 2 represents a VIP customer (higher priority).
4. **TestFile.txt**: It is a test file to include the customers priorities seperated by a new line.  


## Output
The output of the program is the order of processed customers indicated by their number and priority. The VIP customers are processed first even if they arrived later.