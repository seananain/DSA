

public class DSAStack
{
    private double[] stack;
    private int count;
    private int DEFAULT_CAPACITY = 5;
    private boolean empty = false, full = false;
    

    /*public DSAStack(double[] pstack, int pcount)
    {
        stack = pstack;
        count = pcount;
    }*/

    public DSAStack()
    {
        stack = new double[DEFAULT_CAPACITY];
        count = 0;
    }

    public DSAStack(int maxCapacity)
    {
        stack = new double[maxCapacity];
        count = 0;
        //for(int i=0; ) 
    }

    public DSAStack(DSAStack pDSAStack)
    {
        //stack = pDSAStack.getStack();
        count = pDSAStack.getCount();
        //empty = pDSAStack.isEmpty();
    }

    public int getCount()
    {
        return count;
    }

    public boolean isEmpty()
    {
        if(count == 0)
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
        if(count == stack.length)
        {
            full = true;
        }
        else
        {
            full = false;
        }
        return full;
    }

    public void push(double value)
    {
        if(isFull())
        {
            throw new IllegalArgumentException();
        }
        else
        {
            stack[count] = value;
            count += 1;
        }
    }

    public double pop()
    {
        double topVal = top();
        count += 1;
        return topVal;
    }

    public double top()
    {
        double topVal;
        if(isEmpty())
        {
            throw new IllegalArgumentException();
        }
        else
        {
            topVal = stack[count-1];
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
            for(int i=0; i<stack.length; i++)
            {
                System.out.print(stack[i] + " ");
            }
        }
    }
}