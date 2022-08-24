public class DSAShufflingQueue extends DSAQueue
{
    protected Object[] queue;
    private int count;
    protected boolean empty;
    protected boolean full;
    protected int DEFAULT_CAPACITY = 100;

    /*public DSAShufflingQueue(Object[] pqueue, int pcount)
    {
        queue = pqueue;
        count = pcount;
    }*/

    public DSAShufflingQueue()
    {
        queue = new Object[DEFAULT_CAPACITY];
        count = 0;
    }

    public DSAShufflingQueue(int maxCapacity)
    {
        queue = new Object[maxCapacity];
        count = 0;
        //for(int i=0; ) 
    }

    public int getCount()
    {
        return count;
    }

    public boolean isEmpty()
    {
        super.isEmpty();
        if(count==0)
        {
            empty = true;
        }
        else
        {
            empty = false;
        }
        return empty;
    }

    public boolean isFull()
    {
        super.isFull();
        if(count == queue.length)
        {
            full = true;
        }
        else
        {
            full = false;
        }
        return full;
    } 
    
    public void enqueue(Object value)
    {
        super.enqueue(value);
        if(isFull())
        {
            throw new IllegalArgumentException();
        }
        else
        {
            queue[count] = value;
            count += 1;
        }
    }

    public Object dequeue()
    {
        super.dequeue();
        Object topVal = peek();
        count -= 1;
        return topVal;
    }
    
    public Object peek()
    {
        super.peek();
        Object topVal;
        if(isEmpty())
        {
            throw new IllegalArgumentException();
        }
        else
        {
            topVal = queue[count-1];
        }
        return topVal;
    }

    public void status()
    {
        super.status();
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
    }

    
}
