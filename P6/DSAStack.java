import java.util.*;

public class DSAStack implements Iterable
{
    //protected Object[] stack;
    private int count;
    private int DEFAULT_CAPACITY = 100;
    private boolean empty = false, full = false;

    DSALinkedList stack = new DSALinkedList();
    

    /*public DSAStack(double[] pstack, int pcount)
    {
        stack = pstack;
        count = pcount;
    }*/

    /*public DSAStack()
    {
        stack = new DSALinkedList();
        count = 0;
    }*/
    public Iterator iterator()
    {
        return stack.iterator(); // Expose list's iterator
    }

    public boolean isEmpty()
    {
        return stack.isEmpty();
    }

    public boolean isFull()
    {
        return !stack.isEmpty();
    }

    public void push(Object value)
    {
        stack.insertFirst(value);
    }

    public Object pop()
    {
        Object topVal = top();
        stack.removeFirst();
        return topVal;
    }

    public Object top()
    {
        Object topVal;
        topVal = stack.peekFirst();
        return topVal;
    }

    /*public void display()
    {
        if(isEmpty())
        {
            System.out.println();
            System.out.println("empty stack");
        }
        else
        {
            System.out.println();
            for(int i=count-1; i>=0; i--)
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
    }*/
}