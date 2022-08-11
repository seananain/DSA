

public class DSAStack
{
    private double[] stack;
    private int count;
    private int DEFAULT_CAPACITY = 100;
    private boolean empty = false, full = false;
    

    public DSAStack(double[] pstack, int pcount)
    {
        stack = pstack;
        count = pcount;
    }

    public DSAStack(int max)
    {
        stack = new double[max];
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
}