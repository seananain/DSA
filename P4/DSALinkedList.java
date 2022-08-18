import java.util.Iterator;

public class DSALinkedList implements Iterable
{
    public Iterator iterator()
    {
        return new DSALinkedListIterator(this);
    }
    
    private class DSALinkedListIterator implements Iterator
    {
        private DSAListNode iterNext;
        public DSALinkedListIterator(DSALinkedList theList)
        {
            iterNext = theList.head;
        }

        public boolean hasNext()
        {
            return (iterNext != null);
        }

        public Object next()
        {
            Object value;
            if(iterNext == null)
            {
                value = null;
            }
            else
            {
                value = iterNext.getValue();
                iterNext = iterNext.getNext();
            }
            return value;
        }
        public void remove()
        {
            throw new UnsupportedOperationException("Not supported");
        }


    }
    
    
    DSAListNode head;

    public DSALinkedList()
    {
        head = null;
    }

    public void insertFirst(Object newValue)
    {
        DSAListNode newNd = new DSAListNode(newValue);
        if(isEmpty())
        {
            head = newNd;
        }
        else
        {
            newNd.setNext(head);
            head = newNd;
        }
    }

    public void insertLast(Object newValue)
    {
        DSAListNode newNd = new DSAListNode(newValue);
        if(isEmpty())
        {
            head = newNd;
        }
        else
        {
            DSAListNode currNd = head;
            while(currNd.getNext()!=null)
            {
                currNd = currNd.getNext();
            }
            currNd.setNext(newNd);
        }
    }

    public boolean isEmpty()
    {
        //boolean empty = 
        if(head==null)
        {
            return true;
        }
        else
        {
            return false;
        }
        
    }

    public Object peekFirst()
    {
        if(isEmpty())
        {
            return null;
        }
        else
        {
            Object nodeValue = head.getValue();
            return nodeValue;
        }
    }

    public Object peekLast()
    {
        if(isEmpty())
        {
            throw new IllegalArgumentException("empty");
        }
        else
        {
            DSAListNode currNd = head;
            while(currNd.getNext()!=null)
            {
                currNd = currNd.getNext();
            }
            Object nodeValue = currNd.getValue();
            return nodeValue;
        }
    }

    public Object removeFirst()
    {
        if(isEmpty())
        {
            throw new IllegalArgumentException("empty");
        }
        else
        {
            Object nodeValue = head.getValue();
            head = head.getNext();
            return nodeValue;
        }
    }

    public Object removeLast()
    {
        if(isEmpty())
        {
            throw new IllegalArgumentException("empty");
        }
        else
        {
            DSAListNode prevNd = new DSAListNode(null);;
            DSAListNode currNd = new DSAListNode(head);
            while(currNd != null)
            {
                prevNd = currNd;
                currNd = currNd.getNext();
            }
            prevNd.setNext(null);
            Object nodeValue = currNd.getValue();
            return nodeValue;
        } 
    }

}
