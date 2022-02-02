
/**
 * TODO: Add your file header
 * Name:
 * ID:
 * Email:
 * File description: 
 */

/**
 * TODO: Add class header
 */
public class MyLinkedList<E> implements MyReverseList<E>{

	int size;
	Node head;
	Node tail;

	/**
     * A Node class that holds data and references to previous and next Nodes
	 * This class is used for both MyLinkedList and MyListIterator.
     */
	protected class Node {
		E data;
		Node next;
		Node prev;

		/** 
		 * Constructor to create singleton Node 
		 * @param element Element to add, can be null	
		 */
		public Node(E element) {
			//Initialise the elements
			this.data = element;
			this.next = null;
			this.prev = null;
		}

		/** 
		 * Set the previous node in the list
		 * @param p new previous node
		 */
		public void setPrev(Node p) {
			//Set the node p on the previous position
			prev = p;
		}

		/** 
		 * Set the next node in the list
		 * @param n new next node
		 */
		public void setNext(Node n) {
			//Set the node n on the next position
			next = n;
		}

		/** 
		 * Set the element 
		 * @param e new element 
		 */
		public void setElement(E e) {
			this.data = e;
		}

		/** 
		 * Accessor to get the next Node in the list 
		 * @return the next node
		 */
		public Node getNext() {
			return this.next;
		}
		/** 
		 * Accessor to get the prev Node in the list
		 * @return the previous node  
		 */
		public Node getPrev() {
			return this.prev;
		} 
		/** 
		 * Accessor to get the Nodes Element 
		 * @return this node's data
		 */
		public E getElement() {
			return this.data;
		} 
	}

	/**
	 * Constructor to create an empty Doubly linked list
	 */
	public MyLinkedList() {
		//Create dummy nodes
		head = new Node(null);
		tail = new Node(null);
		head.setNext(tail);
		tail.setPrev(head);
		size = 0;	
	}


	/**
	 * TODO: Method header comment here
	 */
	public void reverseRegion(int fromIndex, int toIndex){
		//TODO: Add your solution here
	}

	@Override
	/** 
	 * Returns the number of elements stored
	 * @return - number of elements in the linkedlist
	*/
	public int size() {
		//Return the number of node in the linkedlist
		return this.size;
	}


	/** A method that returns the node at a specified index,
	 *  not the content
	 *  @param index - position to return the node
	 * @return - Node at 'index'
	 */
	// Helper method to get the Node at the Nth index
	protected Node getNth(int index) {
		if (index >= this.size || index < 0)
			throw new IndexOutOfBoundsException();

		Node currNode = this.head;

		//Loop through the linked list and stop at the position
		for (int i = 0; i <= index; i++) {
			currNode = currNode.getNext();
		}

		//return the node	
		return currNode; 
	}

}