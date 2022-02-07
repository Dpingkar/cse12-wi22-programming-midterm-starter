/**
 * Name:Dylan Frederick Pingkardi
 * ID:A15914005
 * Email:dpingkar@ucsd.edu
 * File description: 
 */

/**
 * TODO: Add class header
 */
public class MyArrayList<E> implements MyReverseList<E> {
    static final int DEFAULT_CAPACITY = 5;
    
    Object[] data;
    int size;

    //IMPORTANT: DO NOT MODIFY THIS CONSTRUCTOR!
    //IMPORTANT: DO NOT ADD ANY MORE CONSTRUCTORS!

    /**
     * Constructor to create an array list with the given array's elements
     * @param arr - array of elements to be used to construct the ArrayList
     */
    public MyArrayList(E[] arr) {
        if (arr == null) {
            this.data = new Object[DEFAULT_CAPACITY];
        } else {
            this.data = arr.clone();
            this.size = arr.length;
        }
    }

    /**
	 * Method that reverses the elements in the data array, from the given 
     * staring poinr(fromIndex) to the end(toIndex) including the elements
     * at the start and end. If any of the given indexes are invalid, 
     * IndexOutOfBundsException will be thrown. If fromIndex is larger than
     * toIndex, the data array will be unchanged.
	 */
    public void reverseRegion(int fromIndex, int toIndex){
        if(fromIndex < 0 || toIndex > this.data.length){
            throw new IndexOutOfBoundsException();
        }
        if(fromIndex >= toIndex){
            return;
        }
        int subtract = 0;
        Object[] newArray = new Object[data.length];
        for(int i = 0;i < this.data.length; i ++){
            if(i < fromIndex || i > toIndex){
                newArray[i] = data[i];
            }
        }
        for(int i = fromIndex;i <= toIndex;i++){
            newArray[i] = this.data[toIndex - subtract];
            subtract ++;
        }
        this.data = newArray;
    }

    @Override
    /**
     * A method that returns the number of valid elements
     * in the ArrayList 
     * @return - number of valid elements in the arraylist
     */
    public int size() {
        return this.size;
    }

    @Override
    /**
     * A method that returns an Element at the specified index
     * @param index - the index of the return Element
     * @return Element at specified index
     */
    @SuppressWarnings("unchecked")
    public E get(int index) {
        return (E) data[index];
    }
}
