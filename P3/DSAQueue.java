public class DSAQueue 
{
    private double[] queue;
    private int count;
    private boolean empty, full;

    public DSAQueue(double[] pqueue, int pcount)
    {
        queue = pqueue;
        count = pcount;
    }

    public DSAQueue(DSAQueue pDSAQueue)
    {

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

    public void enqueue(double value)
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

    public double dequeue()
    {
        double topVal = peek();
        count += 1;
        return topVal;
    }

    public double peek()
    {
        double topVal;
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
}
