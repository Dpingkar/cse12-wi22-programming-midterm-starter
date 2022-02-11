/**
 * Tests to check the implementation of reverseRegion method in MyArrayList.java
*/

//other import statements

import org.junit.*;
import static org.junit.Assert.*;

//IMPORTANT: DO NOT MODIFY THE TEST HEADERS!
/**
 * This class contains various test cases to test the reverseRegion method
 */
public class ReverseArrayListTester {
    /**
     * Run before every test
     */
    static final int FIVE = 5;
    static final int THREE = 3;
    Object[] toChange = new Object[]{1,2,3,4,5,6,7,8,9,10};
    Object[] originalTest = new Object[]{1,2,3,4,5,6,7,8,9,10};
    Object[] reversed = new Object[]{10,9,8,7,6,5,4,3,2,1};

    private MyArrayList newArray,cloneArray,changedArray;
    @Before
    public void setUp(){
        newArray = new MyArrayList<>(toChange);
        cloneArray = new MyArrayList<>(originalTest);
        changedArray = new MyArrayList<>(reversed);

    }


    /**
     * Tests reverseRegion method when either fromIndex or toIndex
     * or both are out of bounds.
     */
    @Test
    public void testReverseIndexOutOfBounds(){
        try{
            newArray.reverseRegion(-1,0);
            newArray.reverseRegion(0,-1);
            newArray.reverseRegion(-1,-1);
            newArray.reverseRegion(newArray.size() + 1,0);
            newArray.reverseRegion(0,newArray.size() + 1);
            newArray.reverseRegion(newArray.size() + 1,newArray.size() + 1);
            fail();

        }
        catch(Exception e){}
    }

    /**
     * Tests reverseRegion method when
     * fromIndex > toIndex
     */
    @Test
    public void testReverseFromIndexGreater(){
        newArray.reverseRegion(FIVE, THREE);
        for(int i = 0; i < newArray.size(); i ++){
            assertEquals(newArray.get(i), cloneArray.get(i));
        }


    }

    /**
     * Tests reverseRegion method when
     * fromIndex and toIndex are within bounds
    */
    @Test
    public void testReverseIndexWithinBounds(){
        newArray.reverseRegion(0, newArray.size() - 1);
        for(int i = 0; i < newArray.size(); i ++){
            assertEquals(newArray.get(i), changedArray.get(i));
        }
    }

    /**
     * Tests reverse region when fromIndex = toIndex, 
     * and both are within bounds
    */
    @Test
    public void testReverseCustom(){
        newArray.reverseRegion(THREE, THREE);
        for(int i = 0; i < newArray.size(); i ++){
            assertEquals(newArray.get(i), cloneArray.get(i));
        }
    }


}
