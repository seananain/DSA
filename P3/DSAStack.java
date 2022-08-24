

public class DSAStack
{
    private Object[] stack;
    private int count;
    private int DEFAULT_CAPACITY = 100;
    private boolean empty = false, full = false;
    

    /*public DSAStack(double[] pstack, int pcount)
    {
        stack = pstack;
        count = pcount;
    }*/

    public DSAStack()
    {
        stack = new Object[DEFAULT_CAPACITY];
        count = 0;
    }

    public DSAStack(int maxCapacity)
    {
        stack = new Object[maxCapacity];
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
            return true;
        }
        else
        {
            return false;
        }

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

    public void push(Object value)
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

    public Object pop()
    {
        Object topVal = top();
        count -= 1;
        return topVal;
    }

    public Object top()
    {
        Object topVal;
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

    public void display()
    {
        if(isEmpty())
        {
            System.out.println("empty queue");
        }
        else
        {
            //System.out.println(getCount());
            System.out.println();
            for(int i=count; i>=0; i--)
            {
                if(stack[i]==null)
                {
                    System.out.print("");
                }
                else
                {
                    System.out.println(stack[i] + " ");
                }
            }
        }
    }
}