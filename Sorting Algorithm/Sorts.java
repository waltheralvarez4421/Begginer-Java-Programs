/****************************************************************************
 * SortingOutSorts
 * This program will provide the methods for sorting the 
 * array created in the main method. 
 * 
 * @author Provided by instructor.
 * @revised by Walther Alvarez
 * @version 1.0
 * @date 4/18/2017
 * @course CISC 503 Data Structures and Algorithms
 * @instructor Dr. Jeremy Lanman
 *****************************************************************************/

//----------------------------------------------------------------------------
// Sorts.java               by Dale/Joyce/Weems                     Chapter 10
//
// Test harness used to run sorting algorithms.
//----------------------------------------------------------------------------
import java.text.DecimalFormat;
import java.util.*;

public class Sorts 
{
    // variable declaration
    int size;
    int[] values,originalValues;
    
    /**
     * 
     * @param s - Size of an array
     * Parameterized constructor
     */
    public Sorts(int s)
    {
        size=s;
        values=new int[size];
        originalValues=new int[size];
    }
    /**
     * To initialize the random value from 0 to n-1
     */
    public void initValues()    
    {
        Random rand = new Random();
        for (int index = 0; index < size; index++)
            values[index] = Math.abs(rand.nextInt(size));
        originalValues=values;
    }
    /**
     * Set the initial value (before sorting)
     */
    public void backupOriginal()
    {
        values=originalValues;
    }
    /**
     * 
     * @return  Returns an array which is sorted or not
     */
    public boolean isSorted()
    // Returns true if the array values are sorted and false otherwise.
    {
        boolean sorted = true;
        for (int index = 0; index < (size - 1); index++)
            if (values[index] > values[index + 1])
                sorted = false;
        return sorted;
    }
    /**
     * 
     * @param index1 - Index position 1
     * @param index2 - Index position 2
     */
    public void swap(int index1, int index2)
    // Precondition: index1 and index2 are >= 0 and < SIZE.
    //
    // Swaps the integers at locations index1 and index2 of the values array. 
    {
        int temp = values[index1];
        values[index1] = values[index2];
        values[index2] = temp;
    } 
    /**
     * Print an array values
     */
    public void printValues()
    // Prints all the values integers.
    {
        int value;
        DecimalFormat fmt = new DecimalFormat("00");
        System.out.println("The values array is:");
        for (int index = 0; index < size; index++)
        {
            value = values[index];
            if (((index + 1) % 10) == 0)
                System.out.println(fmt.format(value));
            else
                System.out.print(fmt.format(value) + " ");
        }
        System.out.println();
    }


  /////////////////////////////////////////////////////////////////
  //
  //  Selection Sort

    int minIndex(int startIndex, int endIndex)
    // Returns the index of the smallest value in
    // values[startIndex]..values[endIndex].
    {
        int indexOfMin = startIndex;
        for (int index = startIndex + 1; index <= endIndex; index++)
            if (values[index] < values[indexOfMin])
                indexOfMin = index;
        return indexOfMin;
    }

    void selectionSort()
    // Sorts the values array using the selection sort algorithm.
    {
        int endIndex = size - 1;
        for (int current = 0; current < endIndex; current++)
            swap(current, minIndex(current, endIndex));
    }


    /////////////////////////////////////////////////////////////////
    //
    //  Bubble Sort

    void bubbleUp(int startIndex, int endIndex)
    // Switches adjacent pairs that are out of order 
    // between values[startIndex]..values[endIndex] 
    // beginning at values[endIndex].
    {
        for (int index = endIndex; index > startIndex; index--)
            if (values[index] < values[index - 1])
                swap(index, index - 1);
    }
 
    void bubbleSort()
    // Sorts the values array using the bubble sort algorithm.
    {
        int current = 0;
 
        while (current < (size - 1))
        {
            bubbleUp(current, size - 1);
            current++;
        }
    }


  /////////////////////////////////////////////////////////////////
  //
  //  Short Bubble Sort

    boolean bubbleUp2(int startIndex, int endIndex)
    // Switches adjacent pairs that are out of order 
    // between values[startIndex]..values[endIndex] 
    // beginning at values[endIndex].
    //
    // Returns false if a swap was made; otherwise, returns true.
    {
        boolean sorted = true;
        for (int index = endIndex; index > startIndex; index--)
            if (values[index] < values[index - 1])
            {
                swap(index, index - 1);
                sorted = false;
            }
        return sorted;
    } 
 
    void shortBubble()
    // Sorts the values array using the bubble sort algorithm.
    // The process stops as soon as values is sorted.
    {
        int current = 0;
        boolean sorted = false;
        while ((current < (size - 1)) && !sorted)
        {
            sorted = bubbleUp2(current, size - 1);
            current++;
        }
    }


    /////////////////////////////////////////////////////////////////
    //
    //  Insertion Sort

    void insertItem(int startIndex, int endIndex)
    // Upon completion, values[0]..values[endIndex] are sorted.
    {
        boolean finished = false;
        int current = endIndex;
        boolean moreToSearch = true;
        while (moreToSearch && !finished)
        {
            if (values[current] < values[current - 1])
            {
                swap(current, current - 1);
                current--;
                moreToSearch = (current != startIndex);
            }
            else
                finished = true;
        }
    }
 
    void insertionSort()
    // Sorts the values array using the insertion sort algorithm.
    {
        for (int count = 1; count < size; count++)
             insertItem(0, count);
    }


  /////////////////////////////////////////////////////////////////
  //
  //  Merge Sort

    void merge (int leftFirst, int leftLast, int rightFirst, int rightLast)
    // Preconditions: values[leftFirst]..values[leftLast] are sorted.
    //                values[rightFirst]..values[rightLast] are sorted.
    // 
    // Sorts values[leftFirst]..values[rightLast] by merging the two subarrays.
    {
        int[] tempArray = new int [size];
        int index = leftFirst;
        int saveFirst = leftFirst;  // to remember where to copy back
 
        while ((leftFirst <= leftLast) && (rightFirst <= rightLast))
        {
            if (values[leftFirst] < values[rightFirst])
            {
                tempArray[index] = values[leftFirst];
                leftFirst++;
            }
            else
            {
                tempArray[index] = values[rightFirst];
                rightFirst++;
            }
            index++;
        }
 
        while (leftFirst <= leftLast)
        // Copy remaining items from left half. 
        {
            tempArray[index] = values[leftFirst];
            leftFirst++;
            index++;
        }
 
        while (rightFirst <= rightLast)
        // Copy remaining items from right half.
        {
            tempArray[index] = values[rightFirst];
            rightFirst++;
            index++;
        } 
        for (index = saveFirst; index <= rightLast; index++)
            values[index] = tempArray[index];
    }

    void mergeSort(int first, int last)
    // Sorts the values array using the merge sort algorithm.
    {
        if (first < last)
        {
            int middle = (first + last) / 2;
            mergeSort(first, middle);
            mergeSort(middle + 1, last);
            merge(first, middle, middle + 1, last);
        }
    }

  /////////////////////////////////////////////////////////////////
  //
  //  Heap Sort

    int newHole(int hole, int lastIndex, int item)
  // If either child of hole is larger than item this returns the index
  // of the larger child; otherwise it returns the index of hole.
    {
        int left = (hole * 2) + 1;
        int right = (hole * 2) + 2;
        if (left > lastIndex)
        // hole has no children
            return hole;         
        else
            if (left == lastIndex)
            // hole has left child only
                if (item < values[left])             
                    // item < left child
                    return left;
                else
                    // item >= left child
                    return hole;
            else
                // hole has two children 
                if (values[left] < values[right])
                    // left child < right child
                    if (values[right] <= item)
                        // right child <= item
                        return hole;
                    else
                        // item < right child
                        return right;
                else
                    // left child >= right child
                    if (values[left] <= item)
                        // left child <= item
                        return hole;
                    else
                        // item < left child
                        return left;
    }

    void reheapDown(int item, int root, int lastIndex)
    // Precondition: Current root position is "empty".
    //
    // Inserts item into the tree and ensures shape and order properties.
    {
        int hole = root;   // current index of hole
        int newhole;       // index where hole should move to

        newhole = newHole(hole, lastIndex, item);   // find next hole
        while (newhole != hole)
        {
            values[hole] = values[newhole];      // move value up
            hole = newhole;                      // move hole down
            newhole = newHole(hole, lastIndex, item);     // find next hole
        }
        values[hole] = item;           // fill in the final hole
    }

    void heapSort()
    // Sorts the values array using the heap sort algorithm.
    {
        int index;
        // Convert the array of values into a heap.
        for (index = size/2 - 1; index >= 0; index--)
            reheapDown(values[index], index, size - 1);
 
        // Sort the array.
        for (index = size - 1; index >=1; index--)
        {
            swap(0, index);
            reheapDown(values[0], 0, index - 1);
        }
    } 
}
