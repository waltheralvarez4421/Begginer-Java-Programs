 

/****************************************************************************
 * Queue Implementation
 * 
 * @author Provided by Instructor
 * @version 1.0
 * @date Date
 * @course MCIS-0503 Fall 2012 Data Structures and Algorithms
 * @instructor Dr. Jeremy Lanman
 *****************************************************************************/
public final class QueueLL implements Queue {
	private class node {
		public Object data;
		public node next;
	}

	node front, back;
	int count;

	public QueueLL() {
		makeEmpty();
	}

	// Transformers/Mutators
        @Override
	public void enqueue(Object x) {
		node nn = new node();
		nn.data = x;
		nn.next = null;
		if (isEmpty())
			front = nn;
		else
			back.next = nn;
		back = nn;
		count++;
	}

        @Override
	public Object dequeue() {
		if (isEmpty())
			return null;
		Object frontitem = getFront();
		front = front.next;
		count--;
		if (count == 0)
			back = null;
		return frontitem;
	}

        @Override
	public void makeEmpty() {
		front = back = null;
		count = 0;
	}

	// Observers/Accessors
        @Override
	public Object getFront() {
		if (isEmpty())
			return null;
		return front.data;
	}

        @Override
	public int size() {
		return count;
	}

        @Override
	public boolean isEmpty() {
		return count == 0;
	}

        @Override
	public boolean isFull() {
		return false;
	}
}
 
