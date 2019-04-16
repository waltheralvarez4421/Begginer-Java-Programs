import java.util.Scanner;
import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;
import java.util.Arrays;
import java.io.FileNotFoundException;

public class ExamStatisticsProgram{
   public static void main(String[] args) throws IOException {

   System.out.println("Welcome to the Exam Statistics Program!!");
   
   //Prompts for the location file of the data to be used
   int i = 0;
   Scanner keyboard = new Scanner(System.in);
   
   System.out.println("Enter the name of the file");
   String fileName = keyboard.nextLine();
  
   int scores[] = readScoresFromFile(fileName);

   //Finds the Highest and Lowest score
   System.out.println("Lowest score: " + scores[0]);
   System.out.println("Highest score: " + scores[(scores.length - 1)]);
   
   
   //Calculates the Mean
   double gradesTotal = 0;
   for (i=0; i<scores.length; i++){
     gradesTotal = gradesTotal + scores[i];
   }
   double mean = gradesTotal/scores.length;
   System.out.println("Mean score: " + mean);
  

   //Finds the Median score
   double median;
   if (scores.length % 2 == 0)
     median = ((scores[(scores.length/2) - 1]) + scores[(scores.length/2)]) / 2;
   else
     median = scores[(scores.length/2)];
   System.out.println("Median score: " + median);
   
   
   //Finds out how many number of A's, B's, etc
   int gradeA = 0;
   int gradeB = 0;
   int gradeC = 0;
   int gradeD = 0;
   int gradeF = 0;
   
   
   for (i=0; i<scores.length; i++)
   {
     if (scores[i] >= 90){
       gradeA++; 
     }
     else if (scores[i] <= 89 && scores[i] >=80){
       gradeB++; 
     }
     else if (scores[i] <= 79 && scores[i] >=70){
       gradeC++; 
     }
     else if (scores[i] <= 69 && scores[i] >=60){
       gradeD++; 
     }
     else{
     
       gradeF++; 
     } 
   }
   
   System.out.println("You have recieved " + gradeA + " A's, " + gradeB + " B's, " + gradeC + " C's, " + gradeD +
                      " D's, and " + gradeF + " F's");
   
   
   }// End Main
   
   //Reads the data from the file submitted
   private static int[] readScoresFromFile(String fileName) throws FileNotFoundException 
   {
    File inputFile = new File(fileName);
    Scanner statList = new Scanner(inputFile);
    try {
        //Declares that whatever the first number in the document is is how many indices the document has
        int scores[] = new int[statList.nextInt()];

        int i = 0;
        while (statList.hasNext()){
            scores[i] = statList.nextInt();
            i++;
        }
        System.out.println("There are " + (i) + " scores");        
        Arrays.sort(scores);
        return scores;
    }
    finally {
        statList.close();
    }
   }
}  