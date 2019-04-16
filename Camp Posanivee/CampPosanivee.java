 
 
     import java.util.Scanner;
     import java.io.*;
 
     /****************************************************************************
     * CampPosanivee
     * The program will keep track of who is enrolled for the two-week summer
     * camp. The program uses a binary search tree to maintain the set of campers
     * enrolled in Camp Posanivee. The program is not case sensitive and reads a
     * text file to process commands.  The commands include: H (help), E (enroll
     * new camper), W (withdraw a camper), D (display the age and gender of a
     * camper), A (display avg age of campers), L (list all campers), S (print the
     * number of boy and girl campers), P (display all campers names in preorder),
     * Q (quit).
     *
     * @author Walther Alvarez
     * @version 2.3
     * @date 04/03/17
     * @course CISC-0503 Summer 2016 Data Structures and Algorithms
     * @instructor Dr. Jeremy Lanman
     *****************************************************************************/
     public class CampPosanivee {

     static BST Tree = new BST();
 
    /*************************************************************************
    * main The main method is the controlling method for Camp Posanivee.
    * Preconditions: must have properly formatted data file.
    * Postconditions: be able to create a Queue and BST for data.
    *
    * @param args
    * @throws IOException
    ************************************************************************/
    public static void main(String[] args) throws IOException {
 
      System.out.println("Welcome to Camp Posanivee! ");
 
      //Get the name of the file from the user
      System.out.println("Please, enter the name of the data file: ");
 
 
     // Creates new Scanner object to read user input
      Scanner scan = new Scanner(System.in);
      String fileName = scan.nextLine();
      System.out.println(fileName);
      Scanner fileToRead = new Scanner(new FileReader(fileName));
        
      //Sets the condition for reading the first character of each line in file.
      boolean flag = true;
      
      while (fileToRead.hasNext()) {
          String[] line = fileToRead.nextLine().split(" ");
          System.out.println("\nCommand: " + line[0]);
 
          char action = line[0].charAt(0);
                   
          //if line starts with 'H', print a list of commands
          if (action == 'H' || action == 'h') {
              HelpMenu();     //calls function displayHelp
              }
 
          //if line starts with 'E', enqueue/insert camper
          if (action == 'E' || action == 'e') {
              String NameOfCamper = line[1];
              int AgeOfCamper = Integer.parseInt(line[2]);      //convert string into integer
              char GenderOfCamper = line[3].charAt(0);      //convert string into character
              System.out.println("New camper " + NameOfCamper + " " + "of age " + AgeOfCamper + " and gender " + GenderOfCamper);
              CamperInsert(NameOfCamper, AgeOfCamper, GenderOfCamper);     //calls function insertnewCamper
             
          }
          
          //if line starts with 'W', dequeue/delete camper
          if (action == 'W' || action == 'w') {
              String NameOfCamper = line[1];
              if(Tree.count == 0)
                    System.out.println("There are no campers.");
              else
                    System.out.println(NameOfCamper);
                    DeleteCamper(line[1]);      //calls function deleteCamper
          }
 
          //if line starts with 'A', print the average age of the campers
          if (action == 'A' || action == 'a') {
              System.out.println("The average age of the campers is: ");
              if(Tree.count == 0)      //checks if tree is empty
                    System.out.println("There are no campers.");
              else
                    System.out.println("Average age = " + AgeAverageCal());     //calls function avgAge() and prints result
          }
          
           //if line starts with 'D', display age and gender of the camper
           if (action == 'D' || action == 'd') {
               if(Tree.count == 0)
                    System.out.println("There are no campers.");
               else
                    DisplayEntireData(line[1]);     //calls function dispData
           }
 
           //if line starts with 'L', list campers' names in alphabetical order
            if (action == 'L' || action == 'l') {
                System.out.println("The campers' names are: ");
                if(Tree.count == 0)
                    System.out.println("There are no campers.");
                else
                    ListCampers();     //calls function listNames

            }
 
            //if line starts with 'S', print the number of boy and girl campers
            if (action == 'S' || action == 's') {
                if(Tree.count == 0)
                    System.out.println("There are no campers.");
                else
                   CamperNum();     //calls function numCampers
            }
 
            //if line starts with 'P', print all campers' names in preorder
            if (action == 'P' || action == 'p') {
                if(Tree.count == 0)
                    System.out.println("There are no campers.");
                else
                    PreOrderList();     //calls function listNamesPre
                
            }
 
            //if line starts with 'Q', quit
            else if (action == 'Q' || action == 'q') {
                System.out.println("End of program.");
                System.out.println("Bring plenty of calomine lotion!");
            }
        }
 
            System.out.println("***Camp Posanivee Terminated***");
            System.out.println("Good bye! ");
        }
    
    //displayHelp function displays the help
    private static void HelpMenu() 
    {
        System.out.println("List of commands:");
        System.out.println("H\t\t\tHelp:print a list of commands");
        System.out.println("E name age gender\tEnroll a new camper");
        System.out.println("W name\t\t\tWithdraw a camper");
        System.out.println("D name\t\t\tDisplay the age and gender of a camper");
        System.out.println("A\t\t\tPrint the average age of campers");
        System.out.println("L\t\t\tList all campers names in alphabetical order");
        System.out.println("S\t\t\tPrint the number of�boy�and�girl�campers");
        System.out.println("P\t\t\tList all campers names in preorder");
        System.out.println("Q\t\t\tQuit");
    }

    //insertnewCamper function inserts new camper in the tree
    private static void CamperInsert(String name, int age, char gender) 
    {
        Camper newCamper = new Camper(name, age, gender);
        Tree.insert(newCamper);
        System.out.println("Added.");
    }



    // deleteCamper function deletes the camper from the tree
    private static void DeleteCamper(String name) 
    {
        Camper toRemove = new Camper(name);
        Tree.delete(toRemove);
        System.out.println("Camper withdrawn.");
    }

    //dispData function displays the data of the camper
    private static void DisplayEntireData(String name) 
    {
        Camper displayCamp = new Camper(name);
        displayCamp = (Camper)Tree.lookup(displayCamp);
        System.out.println("Name: " + name);
        System.out.println("Age: " + displayCamp.getAge());
        System.out.println("Gender: " + displayCamp.getGender());   
    }
    
    //avgAge function calculate and display the average age of all the campers in the tree
    private static float AgeAverageCal()
    {
        int sum = 0;
        float avg = 0;
        Tree.reset();
        while(Tree.hasNext())
        {
            sum += (((Camper)Tree.getNext()).getAge());
        }
        avg = (float)sum/(Tree.count);
        return avg;
    }

    //listNames function lists names of all the campers in alphabetical order
    private static void ListCampers() 
    {
        System.out.println("Alphabetical List of Campers: ");
        Tree.reset();
        while(Tree.hasNext())
        {
            System.out.println(((Camper)Tree.getNext()));
        }   
    }

    //listNamesPre function lists names of all the campers in preorder
    private static void PreOrderList() 
    {
        System.out.println("Preorder Traversal:"); 
        Tree.reset(BST.PREORDER);
        while(Tree.hasNext())
        {
            System.out.println(((Camper)Tree.getNext()));
        }
    }

    //numCampers function counts the number of boys and girls
    private static void CamperNum() 
    {
        System.out.println("Camper count by gender:"); 
        int male = 0, female = 0;
        Tree.reset();
        while(Tree.hasNext())
        {
           if((((Camper)Tree.getNext()).getGender()) == 'M')
               male++;
           else
               female++;
        }
        System.out.println("Boys: " + male); 
        System.out.println("Girls: " + female); 
    }
    }
