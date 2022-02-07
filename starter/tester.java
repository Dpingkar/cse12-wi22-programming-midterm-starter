public class tester {
    public static void main(String[] args){
        Object[] test = new Object[10];
        test[0] = 1;
        test[1] = 2;
        test[2] = 3;
        test[3] = 4;
        test[4] = 5;
        test[5] = 6;
        test[6] = 7;
        test[7] = 8;
        test[8] = 9;
        test[9] = 10;
        MyLinkedList newArray = new MyLinkedList<>(test);
        for(int i = 0; i < test.length;i++){
            System.out.println("Index " + i + ": " + newArray.get(i));
        }
        newArray.reverseRegion(0, 9);
        System.out.println("Reverse Array");
        for(int i = 0; i < test.length;i++){
            System.out.println("Index " + i + ": " + newArray.get(i));
        }
        System.out.println("Check .prev");
        newArray.reversePrint();

    }
    
}
