package list;

public class ListIterator<T> {
	
	protected ListNode<T> curNode;
	
	public ListIterator(ListNode<T> curNode) {
		this.curNode = curNode;
	}
	
	/**
	 * These two methods tell us if the iterator has run off
	 * the list on either side
	 */
	public boolean isPastEnd() {
		if(curNode.next==null)
		{
			return true;
		}
			return false;
	}
	
	public boolean isPastBeginning() {
		if(curNode.prev==null)
		{
			return true;
		}
		return false;
	}
	
	// Get the data at the current iterator position
	public T value() {
		/* TODO: Implement this method */
		return curNode.getData();
	}
	
	//These two methods move the cursor of the iterator forward / backward one position
	
	public void moveForward() {
		curNode = curNode.next;
	}
	
	public void moveBackward() {
		curNode = curNode.prev;
	}
}
