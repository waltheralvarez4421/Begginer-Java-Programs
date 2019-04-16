import java.util.Scanner;
import java.io.IOException;
import java.io.FileReader;

public class LaFood
{

public static void main (String [] args) throws IOException, QueueOverflowException, QueueUnderflowException
{
    //get name of simulation file from user and "open" that file
    Scanner start= new Scanner (System.in);

    System.out.println("--- Welcome to the La Food Restaurant Simulator! ---");
    System.out.println("Enter a data file name:");
    String filename = start.next();

    Scanner fileread = new Scanner(new FileReader (filename));

    Queue Q = new QueueArray(99);

    boolean test=true;
    double totmins = 0; // initial total mins waiting
    int peopleseated = 0; //initial people seated per party
    int totalPeople = 0; //initial total people seated
    double avgTime; // avg wait time

    while (test==true)
    {
        char action = (fileread.next().charAt(0));//read first character per line
        int time = 0;// time = seating time
        int tos = 0;// tos = time of seating
        //System.out.println(action); //TESTING PURPOSES ONLY

        //if A, read in party class and put them in at the back of the queue (enqueue).
        if(action == 'A' || action == 'a')
        {
            Party p = new Party(fileread);
            Q.enqueue(p);
                            
            //System.out.println(p.name); //TESTING PURPOSES ONLY
            //System.out.println(p.size); // TESTING PURPOSES ONLY

            System.out.println("Please wait at the bar, party " + p.name + "of " + p.size + " people.  (time = " + p.arrival + ")");
            
        }

        //if T, put the party at the front of the queue and remove them (dequeue).
        if(action == 'T' || action == 't')
        {
            time = fileread.nextInt();
            //System.out.println(time); //TESTING PURPOSES ONLY

            Party p2 =(Party) Q.dequeue();
            //System.out.println(p2.name);
            peopleseated = p2.size;
            tos = p2.arrival;
            
            
            //TESTING System.out.println(time);
            //TESTING System.out.println(tos);
            //TESTING System.out.println(peopleseated);

            //Returns the front object's (the one that was dequeued) info (size,name,arrival)
            System.out.println("Table for " + p2.name + "!  (time=" + time + ")");
            //Keeps count of the total amount of people seated
            totalPeople = (totalPeople + peopleseated);
        }
        
        totmins = totmins + (peopleseated*(time - tos));//total time spent waiting
        
        // if Q stop the simulation
        if(action == 'Q' || action == 'q')
        {
            test=false;
        }
        
    }
    
    avgTime = totmins/totalPeople;//average time for getting a table
    
    System.out.println("---Simulation Terminated---");
    System.out.println("Total number of people seated:" + totalPeople);
    System.out.format("The average waiting time was %.3f", avgTime);
    System.out.println();
    
    //if parties have not been seated before termination of the program this dequeues each and returns them
    String partyNotSeated = null;//initialize name of party not seated
    int partySizeNot = 0;//initialize size of party not seated
    System.out.println("The following parties were never seated:");
    
    while (!Q.isEmpty()){
        Party p3 = (Party) Q.dequeue();
        //System.out.println(p3.name);
        partyNotSeated = p3.name;
        partySizeNot = p3.size;
        System.out.println("Party " + partyNotSeated + "of " + partySizeNot + " people");
        } 
    
    System.out.println("Have a nice meal!" );
    
}
}	
