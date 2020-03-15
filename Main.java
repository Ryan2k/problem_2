package src;
import java.util.Arrays;
public class Main {

    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(8);
        heap.add(new Integer(5));
        heap.add(new Integer(12));
        heap.add(new Integer(16));
        heap.add(new Integer(2));
        heap.add(new Integer(10));
        heap.add(new Integer(16));
        System.out.println(heap.add(new Integer(1)));
        //heap.add(new Integer(1));
        MaxHeap newHeap = new MaxHeap(8);
        Integer[] data = new Integer[8];
        data[0] = (new Integer(5));
        data[1] = (new Integer(12));
        data[2] = (new Integer(16));
        data[3] = (new Integer(2));
        data[4] = (new Integer(10));
        data[5] = (new Integer(16));
        data[6] = (new Integer(50));
        System.out.println(Arrays.toString(data));
        newHeap.MaxHeapN(data);
        //System.out.println(heap.toString());
        System.out.println(newHeap.toString());
        System.out.println("EOF");
        MaxHeapTest.testNLogN();
        MaxHeapTest.testN();
    }
}
