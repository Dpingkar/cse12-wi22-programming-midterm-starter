public class tester {
    public static void main(String[] args){
        Object[] test = new Object[]{1,2,3,4,5,6,7,8};
        MyLinkedList newArray = new MyLinkedList<>(test);
        System.out.println("Size : " + newArray.size());
        for(int i = 0; i < test.length;i++){
            System.out.println("Index " + i + ": " + newArray.get(i));
        }
        newArray.reverseRegion(0, 7);
        System.out.println("Reverse Array");
        System.out.println("Size : " + newArray.size());
        for(int i = 0; i < test.length;i++){
            System.out.println("Index " + i + ": " + newArray.get(i));
        }
        System.out.println("Check .prev");
        newArray.reversePrint();

    }
    
}
