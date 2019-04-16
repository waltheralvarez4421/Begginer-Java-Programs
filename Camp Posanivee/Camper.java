 
 
      /****************************************************************************
     * Camper class The camper class is intended to create a comparable class of
     * campers. The data structure includes name, age, and gender and the
     * information is stored in a binary search tree using a queue.
     *
     * @author Walther Alvarez
     * @version 1.0
     * @date Date
     * @course CISC 503 - Data Structures and Algorithms
     * @instructor Dr. Jeremy Lanman
     *****************************************************************************/
      /*

This class include the constructors of the camper, 
that creates the camper object. Camper class implements Comparable.
It returns the camper data. These functions are used in CampPosanivee.java
*/
public class Camper implements Comparable<Camper>
{
    //declare the variables
    private String name;
    private int age;
    private char gender;
    
    //constructor initializes the variables with parameters
    public Camper(String name, int age, char gender)
    {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    
    //constructor initializes the variables with parameters
    public Camper(String name)
    {
        this.name = name;
        this.age = 50;
        this.gender = 'M';
    }
    
    //returns the name of the camper
    public String getName()
    {
        return name;
    }
    
    //returns the age of the camper
    public int getAge()
    {
        return age;
    }
    
    //returns the gender of the camper
    public char getGender()
    {
        return gender;
    }
    
    //this function overrides the compareTo function of Comparable. It sets the criteria for comaprison of Camper
    @Override
    public int compareTo(Camper e)
    {
        return name.compareTo(e.name);
    }
    
    //This function overrides the toString function. It prints the name of the Camper
    @Override
    public String toString()
    {
        return String.format(name);
    }

}