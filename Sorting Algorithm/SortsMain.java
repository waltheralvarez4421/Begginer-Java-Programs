/*************************************************************************
* main The main method is the controlling method for Sorts.
* Preconditions: n must be a nonnegative integer.
* Postconditions: be able to create an array of data and sort it appropriately. 
* @param scanner size; integer n; sortObj;
* @throws Exception Message
************************************************************************/

import java.util.Scanner;
public class SortsMain 
{
    /**
     * Main Program
     */
    public static void main(String[] args)
    {
        Scanner size = new Scanner(System.in);        // it is used to read the values from keyboard
        Integer n;      //variable declaration
        long start,end;
        Sorts sortObj;      //sorts object declaration
        try
        {
            System.out.print("Enter the size of an array : ");
            n=Integer.parseInt(size.nextLine());        //read the array size 
            sortObj = new Sorts(n);                       //intialize the sorts object
            sortObj.initValues();               //set random values to specfied array
            
            System.out.println("Before Sorting ....\n");
            if (n <= 100)
            sortObj.printValues(); 
            else//Print all the random values (before sorting)
            
            System.out.println("\nn=" + n + "\n");              //print the headers
            
            System.out.println("Bubble Sorting...");
            start=System.currentTimeMillis();               //find start time in ms
            sortObj.bubbleSort();                           //bubble sorting
            end=System.currentTimeMillis();                 //find end time in ms
            if(sortObj.isSorted())          //check whether array is sorted or not
                System.out.println("\tBubble Sorting completed Successfully");  //if sorted, it displays successfully message
                if (n <= 100)
                sortObj.printValues(); 
                else
            System.out.println("\tElapsed Time (Bubble) in milliseconds : " + (end-start));       //print the elapsed time for bubble sorting
            
            sortObj.backupOriginal();           //back up the original values (before sorting values)   
            System.out.println("Selection Sorting...");     //similarly, we did the remaining algorithms
            start=System.currentTimeMillis();
            sortObj.selectionSort();
            end=System.currentTimeMillis();            
            if(sortObj.isSorted())
                System.out.println("\tSelection Sorting completed Successfully");
                if (n <= 100)
                sortObj.printValues(); 
                else
            System.out.println("\tElapsed Time (Selection) in milliseconds : " + (end-start));
            
            sortObj.backupOriginal();
            System.out.println("Insertion Sorting...");
            start=System.currentTimeMillis();
            sortObj.insertionSort();
            end=System.currentTimeMillis();            
            if(sortObj.isSorted())
                System.out.println("\tInsertion Sorting completed Successfully");
                if (n <= 100)
                sortObj.printValues(); 
                else
            System.out.println("\tElapsed Time (Insertion) in milliseconds : " + (end-start));
            
            sortObj.backupOriginal();
            System.out.println("Merge Sorting...");
            start=System.currentTimeMillis();
            sortObj.mergeSort(0, n - 1);
            end=System.currentTimeMillis();            
            if(sortObj.isSorted())
                System.out.println("\tMerge Sorting completed Successfully");
                if (n <= 100)
                sortObj.printValues(); 
                else
            System.out.println("\tElapsed Time (Merge) in milliseconds : " + (end-start));
            
            sortObj.backupOriginal();
            System.out.println("Heap Sorting...");
            start=System.currentTimeMillis();
            sortObj.heapSort(); 
            end=System.currentTimeMillis();            
            if(sortObj.isSorted())
                System.out.println("\tHeap Sorting completed Successfully");
                if (n <= 100)
                sortObj.printValues(); 
                else
            System.out.println("\tElapsed Time (Heap) in milliseconds : " + (end-start));
        }
        catch(Exception ex)
        {
            System.out.println("Error : " + ex.getMessage());
        }
    }
}