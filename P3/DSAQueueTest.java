public class DSAQueueTest extends DSAQueue
{
    public static void main(String[] args) 
    {
        DSAQueue q = new DSAQueue();
        q.enqueue(1.2);
        q.enqueue(5.1);
        q.enqueue(8.2);
        q.enqueue(5.9);
        q.enqueue(11.2);
        //q.enqueue(5.4);
        q.dequeue();
        q.status();

        



    }
}
