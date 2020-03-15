package src;

public class MaxHeap implements Heap {
    int size;

    Integer[] data;

    public MaxHeap(int capacity) {
        data = new Integer[capacity];
        size = 0;
    }

    // build a heap based on data
    // to be implemented in O(nlogn)
    public void MaxHeapLogN(Integer[] data) {
        for(int i = 0; i < data.length; i++)
        {
            if(data[i] == null)
            {
                break;
            }
            this.add(data[i]);
            
        }
    }
    /*makes sure node at this index is keeping up with the rules of the max heap.
     */
    public void heapify(int i)
    {
        int leftI = 2*i + 1;
        int rightI = 2*i + 2;
        int maxI = i;
        if(leftI < size && this.data[leftI] > this.data[maxI])
        {
            maxI = leftI;
        }
        //System.out.println(rightI < this.size);
        //System.out.println(this.data[rightI] > this.data[maxI]);
        if(rightI < size && this.data[rightI] > this.data[maxI])
        {
            maxI = rightI;
            System.out.println("we Swapped");
        }
        if(maxI != i)
        {
            swap(i, maxI);
            heapify(maxI);
        }
    }
    /*build a heap based on data
    to be implemented in O(n)
    */
    public void MaxHeapN(Integer[] data) {
        int count = 0;
        for(int i = 0; i < data.length; i++)
        {
            if(data[i] == null)
            {
                count = i;
                break;
            }
            this.data[i] = data[i];
        }
        
        int lastNonLeaf = (count/2) -1;
        this.size = count;
        System.out.println(this.toString());
        for(int i = lastNonLeaf; i >= 0; i--)
        {
            heapify(i);
        }
    }

    /*add an item to the heap
     * only returns false if the array is full, otherwise we run a while loop while the item is greater than its parent to swap
     * spots with its parent. If false is not returned, size increments and true is returned as well. The parents indice will
     * always be the childs indice minus one divided by two (due to integer division). 
     */
    public boolean add(Integer item) {
        if(size >= data.length)
        {
            return false;
        }
        this.data[size] = item; 
        size++;
        int curr = size-1;
        while(data[curr] > data[(curr-1)/2])//while current is bigger than its parent
        {
            swap(curr, (curr-1)/2);
            curr = (curr-1)/2;
        }
        return true;
    }
    
    /*Helper function swapping two indices of an array. Created because for the implementation of the max heap, every time a
     * node is in the incorrect spot, a swap will need to happen with its parent and it would be redunant to keep writing the
     * same piece of code.
     */
    public void swap(int i1, int i2)
    {
        int temp = data[i1];
        data[i1] = data[i2];
        data[i2] = temp;
    }

    /* return the max item in the heap
     * The Integer at index 0 will be the largest by definition in a max heap so i just return that
     */
    public Integer get() {
        return this.data[0];
    }

    /* remove the root item
     *stores the first indice of the array (as that will be the largest number) then calls the heapify function to sort out the
     *rest of the array before we can return the result we just stored.
     */
    public Integer pop() {
        Integer result = this.data[0];
        this.data[0] = this.data[this.size-1];
        this.data[size-1] = null;
        this.size--;
        heapify(0);
        return result;
    }
    
    public String toString()
    {
        String s = "";
        for(int i = 0; i < size; i++)
        {
            s += (data[i] + ", ");
        }
        return s;
    }
}
