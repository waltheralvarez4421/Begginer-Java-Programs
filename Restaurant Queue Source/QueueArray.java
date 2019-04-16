/*******************************************************************************
 * QueueArray Class
 * 
 * Description here….
 * 
 * Preconditions: 
 * Postconditions: 
 * 
 * @author Student Name
 * @date Date
 * @version 1.0
 * 
 ******************************************************************************/

public class QueueArray<T> implements Queue<T>
{
  protected final int DEFCAP = 100; // default capacity
  protected T[] elements;           // array that holds queue elements
  protected int numElements = 0;    // number of elements in the queue
  protected int front = 0;          // index of front of queue
  protected int rear;               // index of rear of queue  

  public QueueArray() 
  {
    elements = (T[]) new Object[DEFCAP];
    rear = DEFCAP - 1;
  }

 
 public QueueArray(int maxSize)
 {
    elements = (T[]) new Object[maxSize];
    rear = maxSize - 1;
 }


  // Transformers/Mutators
  public void enqueue(T element)
  // Throws QueueOverflowException if this queue is full;
  // otherwise, adds element to the rear of this queue.
  {  
    if (isFull())
      throw new QueueOverflowException("Enqueue attempted on a full queue.");
    else
    {
      rear = (rear + 1) % elements.length;
      elements[rear] = element;
      numElements = numElements + 1;
    }
  }
  
  public T dequeue()
  // Throws QueueUnderflowException if this queue is empty;
  // otherwise, removes front element from this queue and returns it.
  {       
    if (isEmpty())
      throw new QueueUnderflowException("Dequeue attempted on empty queue.");
    else
    {
      T toReturn = elements[front];
      elements[front] = null;
      front = (front + 1) % elements.length;
      numElements = numElements - 1;
      return toReturn;
    }
  }
 
  public void makeEmpty()
  {    
     while (isFull())
     {
        
     }  
  }

  // Observers/Accessors
 
  public T getFront()
  // If the queue is empty, returns null.
  // Otherwise returns the element at the front of this queue.
  {
    if (isEmpty())
       return null;
    else
      return elements[front];
  }
  
  public int size() 
  // Returns the number of elements in this queue.
  {
    return numElements;
  }
  
  public boolean isEmpty() 
  // Returns true if this queue is empty; otherwise, returns false
  {              
    return (numElements == 0);
  }
  
  public boolean isFull() 
  // Returns true if this queue is full; otherwise, returns false.
  {              
    return (numElements == elements.length);
  }
}
