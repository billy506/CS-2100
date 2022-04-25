package list;

/** A custom built linked list **/
/** T here is the type the list stores **/

public class LinkedList<T> implements List<T>{

	/* Dummy head & tail */
	private ListNode<T> head, tail;
	private int size;
	
	public LinkedList() {
		this.size = 0;
		head = new ListNode<T>(null);
		tail = new ListNode<T>(null);
		
		head.next = tail;
		head.prev = null;
		
		tail.prev = head;
		tail.next = null;
	}
	
	public int size() {
		return this.size;
	}
	
	/*** Clears out the entire list ***/
	public void clear() {
		head.next = tail;
		tail.prev = head;
		this.size = 0; 
	}
	
	/** Inserts new data at the end of the list (i.e., just before the dummy tail node) **/
	public void insertAtTail(T data) {
		ListNode<T> newNode = new ListNode<T>(data);
		newNode.next = tail;
		newNode.prev = tail.prev;
		newNode.prev.next = newNode;
		tail.prev = newNode;
		this.size++;
	}
	
	/** Inserts data at the front of the list (i.e., just after the dummy head node **/
	public void insertAtHead(T data) {
		ListNode<T> newNode = new ListNode<T>(data);
		newNode.prev = this.head;
		newNode.next = this.head.next;
		this.head.next = newNode;
		this.size++;
	}
	
	/*** Inserts node such that index becomes the position of the newly inserted data ***/
	public void insertAt(int index, T data) {
		if(index<=this.size) {
			ListNode<T> newNode = new ListNode<T>(data);
			ListNode<T> temp = head;
			for(int i=0;i<index;i++)
			{
				if(temp.next!=null)
				{
					temp = temp.next;
				}
			}
			newNode.prev = temp;
			newNode.next = temp.next;
			temp.next.prev = newNode;
			temp.next = newNode;
			this.size++;
		}
	}
	
	/**Inserts data after the node pointed to by iterator**/
	public void insert(ListIterator<T> it, T data) {
		/* TODO: Implement this method */ 
		ListNode<T> newNode = new ListNode<T>(data);
		ListNode<T>	nextNode = it.curNode.next;
		newNode.next = nextNode;
		nextNode.prev = newNode;
		newNode.prev = it.curNode;
		it.curNode.next = newNode;
		this.size++;
	}
	
	
	
	public T removeAtTail(){
		ListNode<T> oldNode = back().curNode;
		ListNode<T> prevNode = oldNode.prev;
		prevNode.next = tail;
		this.tail.prev = prevNode;
		this.size--;
		return oldNode.getData();
	}
	
	public T removeAtHead(){
		ListNode<T> oldNode = front().curNode;
		if(head.next.next!=null){
			ListNode<T> nextNode = head.next.next;
			this.head.next = nextNode;
			nextNode.prev = head;
		}
		this.size--;
		return oldNode.getData();
	}
	
	/*** Remove based on Iterator position. Sets the iterator to the node AFTER the one removed. ***/
	public T remove(ListIterator<T> it) {
		ListNode<T> oldNode = it.curNode;
		it.moveForward();
		oldNode.prev.next = oldNode.next;
		oldNode.next.prev = oldNode.prev;
		this.size--;
		return oldNode.getData();
	}
	
	/*** Returns index of first occurrence of the data in the list, or -1 if not present ***/
	public int find(T data) {
		ListNode<T> temp = head;
		int count = 0;
			while(temp.next!=null) {
				if(data.equals(temp.getData()))
				{
					return count-1;
				}
				temp = temp.next;
				count++;
			}
			return -1;
	}
	
	/**Returns the data at the given index, null if anything goes wrong (index out of bounds, empty list, etc.)**/
	public T get(int index) {
		if(index>this.size){
			return null;
			}
			ListNode<T> temp = head;
			for(int i=0;i<=index;i++) {
			if(temp.next!=null) {
				temp = temp.next;
			}
		}	
		return(temp.getData());
	}
	
	/*** Returns the list as space separated values ***/
	public String toString() {
		String toRet = "[";
		
		ListNode<T> curNode = head.next;
		while(curNode != tail) {
			toRet += curNode.getData() + ", ";
			curNode = curNode.next;
		}
		
		return toRet + "]";
	}
	
	/* Return iterators at front and end of list */
	public ListIterator<T> front(){ 
		ListIterator<T> temp = new ListIterator<T>(head);
		temp.moveForward();
		return temp;
	}

	public ListIterator<T> back(){
		ListIterator<T> temp = new ListIterator<T>(tail);
		temp.moveBackward();
		return temp;
	}
	
	
}
