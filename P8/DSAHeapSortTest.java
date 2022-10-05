public class DSAHeapSortTest 
{
    public static void main(String[] args)
    {
        DSAHeap heap = new DSAHeap();
        int[] array = {5, 3, 8, 9, 2, 6};
        int numItems = 6;
        System.out.println("Before");
        for(int i=0; i<numItems; i++)
        {
            System.out.println(array[i]);
        }
        array = heap.heapSort(array, numItems);
        System.out.println("After");
        for(int i=0; i<numItems; i++)
        {
            System.out.println(array[i]);
        }
        

    }
}
