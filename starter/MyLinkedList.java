/**
 * Name:Dylan Frederick Pingkardi
 * ID: A15914005
 * Email:dpingkar@ucsd.edu
 * File description: 
 * File created to be submitted for midterm of CSE 12. Contains class for
 * a LinkedList , and a class for Nodes, simplified for the purpose of 
 * the midterm. Contains only a few methods to be used to help complete
 * the reverseRegion method. 
 */

/**
 * A simplified MyLinkedList class, with 3 instance variables.
 * An int for amount of elements,size, a Node to be placed at the start,head,
 * and a Node to signify the end,tail. Contains a node class inside to be
 * used to hold elements.
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

    //IMPORTANT: DO NOT MODIFY THIS CONSTRUCTOR!
    //IMPORTANT: DO NOT ADD ANY MORE CONSTRUCTORS!
    /**
     * Constructor to create a doubly linked list 
     * with the argument array's elements
     * @param arr - array of elements to be used to construct the LinkedList
     */
    public MyLinkedList(E[] arr) {

        //Create dummy nodes
        head = new Node(null);
        tail = new Node(null);
        head.setNext(tail);
        tail.setPrev(head);
        size = 0;	

        if(arr != null){
            //create list by inserting each element
            Node currNode = head;
            for(int i=0; i<arr.length; i++){
                Node newNode = new Node(arr[i]);
                currNode.next.prev = newNode;
                newNode.next = currNode.next;
                newNode.prev = currNode;
                currNode.next = newNode;

                //move pointer to the next node
                currNode = currNode.next;
                //increase size of list
                this.size++;
            }
        }
    }


    /**
     * Method which reverses the order of nodes within a specified range,
     * as indicated by fromIndex being the start and toIndex being the end.
     * If any of the given indexes are invalid, IndexOutOfBundsException 
     * will be thrown. If fromIndex is larger than toIndex, 
     * the data array will be unchanged.
     * @param fromIndex Int to specify starting index 
     * @param toIndex Int to specify ending index
     */
    public void reverseRegion(int fromIndex, int toIndex){
        if(fromIndex < 0 || toIndex < 0 || fromIndex >= this.size()
                || toIndex >= this.size()){
            throw new IndexOutOfBoundsException();
        }
        if(fromIndex >= toIndex){
            return;
        }
        Node start = this.getNth(fromIndex);
        Node end = this.getNth(toIndex);
        Node curr;
        Node before;
        // Switches around the nodes in between start and end
        for(int i = 1;i < toIndex - fromIndex ; i ++){
            curr = this.getNth(toIndex - i);
            before = curr.getPrev();
            curr.setPrev(curr.getNext());
            curr.setNext(before);
        }
        //Changes to the next and prev of nodes before the start and after end
        start.getPrev().setNext(end);
        end.getNext().setPrev(start);

         //Changes the next and prev of start and end nodes
        before = start.getPrev();
        start.setPrev(start.getNext());
        start.setNext(end.getNext());
        end.setNext(end.getPrev());
        end.setPrev(before);


    }

    @Override
    /** 
     * Returns the number of elements stored
     * @return - number of elements in the linkedlist
    */
    public int size() {
        //Return the number of nodes in the linkedlist
        return this.size;
    }

    @Override
    /** 
     * Get contents at position i
     * @param index - The index position to obtain the data
     * @return the Element at the specified index
     */
    public E get(int index)	{

        Node currNode = this.getNth(index);

        //Get the value of data at the position
        E element = currNode.getElement();

        return element;	
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

    public void reversePrint(){
        Node curr = this.getNth(size - 1);
        for(int i = size - 1; i >= 0; i --){
            System.out.println("Index " + i + ": " + curr.getElement());
            curr = curr.getPrev();
        }
    }
}
