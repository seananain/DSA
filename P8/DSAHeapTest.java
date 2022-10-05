public class DSAHeapTest 
{
    public static void main(String[] args)
    {
        DSAHeap heap = new DSAHeap();

        System.out.println("Adding");
        heap.add(10, "fish");
        heap.add(5, "dog");
        heap.add(3, "Andrew");
        heap.add(6, "Michael");
        heap.add(9, "Top G");

        heap.display();

        System.out.println("Removing");

        heap.remove();

        heap.display();

        System.out.println("Removing");

        heap.remove();

        heap.display();

        System.out.println("Adding");
        heap.add(10, "fish");

        heap.display();
    }
}
