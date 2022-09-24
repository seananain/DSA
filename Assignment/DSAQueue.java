import java.util.*;

public class DSAQueue implements Iterable
{
    //protected Object[] queue;
    //private int count;
    protected boolean empty;
    protected boolean full;
    protected int DEFAULT_CAPACITY = 100;

    DSALinkedList list = new DSALinkedList();

    /*public DSAQueue(double[] pqueue, int pcount)
    {
        queue = pqueue;
        count = pcount;
    }*/

    public Iterator iterator()
    {
        return list.iterator(); // Expose list's iterator
    }


  

    public boolean isEmpty()
    {
        return list.isEmpty();
    }

  

    public void enqueue(Object value)
    {
        
        
        list.insertLast(value);
        
    }

    public Object dequeue()
    {
        Object topVal = peek();
        list.removeFirst();
        return topVal;
    }

    public Object peek()
    {
        Object topVal;
        if(isEmpty())
        {
            throw new IllegalArgumentException();
        }
        else
        {
            topVal = list.peekFirst();
        }
        return topVal;
    }

    /*public void status()
    {
        if(isEmpty())
        {
            System.out.println("empty queue");
        }
        else
        {
            System.out.println(getCount());
            for(int i=0; i<DEFAULT_CAPACITY; i++)
            {
                System.out.print(queue[i] + " ");
            }
        }
    }*/

    
}
