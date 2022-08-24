public class DSACircularQueue extends DSAQueue
{
    //private double[] queue;
    //private int count;
    //private boolean empty, full;
    //private int DEFAULT_CAPACITY = 100;
    private int front, rear;

    public DSACircularQueue()
    {
        queue = new Object[DEFAULT_CAPACITY];
        front = -1;
        rear = -1;
    }

    public DSACircularQueue(int maxCapacity)
    {
        queue = new Object[maxCapacity];
        
        front = -1;
        rear = -1;
    }

    public int getFront()
    {
        return front;
    }

    public int getRear()
    {
        return rear;
    }

    @Override
    public boolean isEmpty()
    {
        if(front == 0 && rear == DEFAULT_CAPACITY - 1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public boolean isFull()
    {
        if(front == -1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public void enqueue(Object value)
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
                rear = (rear + 1) % queue.length;
                queue[rear] = value;
     
            }
        }
    }

    @Override
    public Object dequeue()
    {
        Object topVal = peek();
        return topVal;
    }

    @Override
    public Object peek()
    {
        Object topVal;
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
                front = (front + 1) % queue.length;
            }
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
