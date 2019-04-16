public interface Queue<T>
{
  // Transformers/Mutators
  public void enqueue(T element) throws QueueOverflowException;;
  public T dequeue() throws QueueUnderflowException;
  public void makeEmpty();
  
  // Observers/Accessors
  public T getFront();
  public int size();
  public boolean isEmpty();
  public boolean isFull();
}
