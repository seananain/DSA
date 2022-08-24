public class DSAQueue 
{
    protected Object[] queue;
    private int count;
    protected boolean empty;
    protected boolean full;
    protected int DEFAULT_CAPACITY = 5;

    /*public DSAQueue(double[] pqueue, int pcount)
    {
        queue = pqueue;
        count = pcount;
    }*/

    public DSAQueue()
    {
        queue = new Object[DEFAULT_CAPACITY];
        count = 0;
    }

    public DSAQueue(int maxCapacity)
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
        Object topVal = peek();
        count += 1;
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
            topVal = queue[count-1];
        }
        return topVal;
    }

    public void status()
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
    }

    
}
