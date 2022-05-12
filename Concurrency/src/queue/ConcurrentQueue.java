package queue;
import java.util.LinkedList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * A Linked-List based Queue
 * Is concurrent (i.e., can modify front and back in parallel)
 *
 * @param <T>
 */
public class ConcurrentQueue<T> implements IQueue<T>{
	private LinkedList<T> list;
	private Lock queueLock;
	/**
	 * Constructor: Initialize the inner list
	 */
	public ConcurrentQueue(){
		//TODO: Write this method
		list = new LinkedList<T>();
		queueLock = new ReentrantLock();
	}
	

	/**
	 * Return the size by invoking the size of the list
	 */
	public int size() { 
		return list.size();
	}
	

	/**
	 * Simply add the data to the tail of the linked list
	 */
	public void enqueue(T data) {
		queueLock.lock();
		list.add(data);
		queueLock.unlock();
	}
	
	/**
	 * Simply remove data from the head of the list
	 */
	public T dequeue(){
		T temp;
		queueLock.lock();
		temp = list.pollFirst();
		queueLock.unlock();
		
		return temp;
	}
	
	
}
