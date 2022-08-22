public class DSACircularQueue extends DSAQueue
{
    //private double[] queue;
    //private int count;
    //private boolean empty, full;
    //private int DEFAULT_CAPACITY = 100;
    private int front, rear;

    public DSACircularQueue()
    {
        queue = new double[DEFAULT_CAPACITY];
        //count = 0;
        front = -1;
        rear = -1;
    }

    public DSACircularQueue(int maxCapacity)
    {
        queue = new double[maxCapacity];
        //count = 0;
        front = -1;
        rear = -1;
        //for(int i=0; ) 
    }

    /*public int getCount()
    {
        return count;
    }*/

    public boolean isEmpty()
    {
        if(front == 0 && rear == DEFAULT_CAPACITY - 1)
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
        if(front == -1)
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
            if(front == -1)
            {
                front = 0;
                rear = (rear + 1) % DEFAULT_CAPACITY;
                queue[rear] = value;
                //count += 1;
            }
        }
    }

    public double dequeue()
    {
        double topVal = peek();
        //count += 1;
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
            topVal = queue[front];
            if(front == rear)
            {
                front = -1;
                rear = -1;
            }
            else
            {
                front = (front + 1) % DEFAULT_CAPACITY;
            }
        }
        return topVal;
    }


}
