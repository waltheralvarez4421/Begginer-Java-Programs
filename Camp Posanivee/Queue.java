 

/****************************************************************************
 * Queue Interface
 * 
 * @author Provided by Instructor
 * @version 1.0
 * @date Date
 * @course MCIS-0503 Fall 2012 Data Structures and Algorithms
 * @instructor Dr. Jeremy Lanman
 *****************************************************************************/
public interface Queue {
	// Transformers/Mutators
	public void enqueue(Object x);

	public Object dequeue();

	public void makeEmpty();

	// Observers/Accessors
	public Object getFront();

	public int size();

	public boolean isEmpty();

	public boolean isFull();
}

