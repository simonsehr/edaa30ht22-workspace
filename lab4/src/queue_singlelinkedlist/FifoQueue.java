package queue_singlelinkedlist;
import java.util.*;

public class FifoQueue<E> extends AbstractQueue<E> implements Queue<E> {
	private QueueNode<E> last;
	private int size;

	public FifoQueue() {
		super();
		last = null;
		size = 0;
	}

	/**	
	 * Inserts the specified element into this queue, if possible
	 * post:	The specified element is added to the rear of this queue
	 * @param	e the element to insert
	 * @return	true if it was possible to add the element 
	 * 			to this queue, else false
	 */
	public boolean offer(E e) {
		QueueNode<E> node = new QueueNode<E>(e);

		if(last == null){
			last = node;
		} else {
			if(last.next == null){
				last.next = node;
				node.next = last;
				last = node;
			} else {
				node.next = last.next;
				last.next = node;
				last = node;
			}
		}

		size++;
		return true;

	}
	
	/**	
	 * Returns the number of elements in this queue
	 * @return the number of elements in this queue
	 */
	public int size() {		
		return size;
	}
	
	/**	
	 * Retrieves, but does not remove, the head of this queue, 
	 * returning null if this queue is empty
	 * @return 	the head element of this queue, or null 
	 * 			if this queue is empty
	 */
	public E peek() {
		if(last == null){
			return null;
		}else{
			if(last.next == null){
				return last.element;
			}else{
				return last.next.element;
			}
		}
	}

	/**	
	 * Retrieves and removes the head of this queue, 
	 * or null if this queue is empty.
	 * post:	the head of the queue is removed if it was not empty
	 * @return 	the head of this queue, or null if the queue is empty 
	 */
	public E poll() {
		QueueNode<E> temp = last;
		if(size == 0){
			return null;
		}

		if(size == 1){
			last = null;
			size--;
			return temp.element;
		}else{
			temp = last.next;
			last.next = temp.next;
			size--;
			return temp.element;
		}
	}
	
	/**	
	 * Returns an iterator over the elements in this queue
	 * @return an iterator over the elements in this queue
	 */	
	public Iterator<E> iterator() {
		return new QueIterator();
	}
	
	private static class QueueNode<E> {
		E element;
		QueueNode<E> next;

		private QueueNode(E x) {
			element = x;
			next = null;
		}
	}

	private class QueIterator implements Iterator<E>{
		private QueueNode<E> pos;

		private QueIterator(){
			pos = last;

		}

		public boolean hasNext(){
			/**pos = last.next;
			if(last.next.element == pos.element){
				return false;
			}
			return true;*/

			if (pos != null) {
				if (pos.next != null) {
					return true;
				}
				else {
					return false;
				}	
				
			} 
			return false;
		}

		public E next(){
			if(pos == null || pos.next == null){
				throw new NoSuchElementException();
			}

			if(pos.next.equals(last)){ 
				E element = pos.next.element;
				pos=null;
				return element;
			}
			pos=pos.next; 
			return pos.element;	

		}
	}

	/**
	* Appends the specified queue to this queue
	* post: all elements from the specified queue are appended
	* to this queue. The specified queue (q) is empty after the call.
	* @param q the queue to append
	* @throws IllegalArgumentException if this queue and q are identical
	*/
	public void append(FifoQueue<E> q){
		if(this .equals(q)){
			throw new IllegalArgumentException();
		}else if(this.isEmpty() && q.isEmpty() || q.isEmpty() || this.isEmpty()){
			throw new IllegalArgumentException();
		}
		this.size = this.size + q.size;
		QueueNode<E> temp1 = this.last.next;
		QueueNode<E> temp2 = q.last.next;
		QueueNode<E> temp = this.last;

		this.last.next = temp2;
		q.last.next = temp1;
	

		while(temp2 != temp1){
			temp = new QueueNode<E>(temp2.element);
			temp2 = temp2.next;
		}

		this.last = temp;

		q.clear();
	}

}
