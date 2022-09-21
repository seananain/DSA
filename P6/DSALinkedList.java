import java.util.Iterator;
import java.io.*;

public class DSALinkedList implements Iterable, Serializable
{
    public class DSAListNode implements Serializable
    {
        private Object value;
        private DSAListNode next;
        private DSAListNode prev;

        public DSAListNode(Object inValue)
        {
            value = inValue;
            next = null;
            //prev = null;
        }

        public Object getValue()
        {
            return value;
        }

        public void setValue(Object inValue)
        {
            value = inValue;
        }

        public DSAListNode getNext()
        {
            return next;
        }

        public DSAListNode getPrev()
        {
            return prev;
        }

        public void setNext(DSAListNode newNext)
        {
            next = newNext;
        }

        public void setPrev(DSAListNode newPrev)
        {
            prev = newPrev;
        }
    }
    
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
    
    
    public DSAListNode head;
    DSAListNode tail;

    public DSALinkedList()
    {
        head = null;
        tail = null;
    }

    public Object getHead()
    {
        return head;
    }

    public void insertFirst(Object newValue)
    {
        DSAListNode newNd = new DSAListNode(newValue);
        //newNd.setValue(newValue);
        if(isEmpty())
        {
            head = newNd;
            tail = newNd;
            //tail.setValue(newValue);
        }
        else
        {
            //newNd.setValue(newValue);
            newNd.setNext(head);
            head.setPrev(newNd);
            head = newNd;
        }
    }

    /*public void insertBefore(Object valueToFind)
    {
        DSAListNode newNd = new DSAListNode(valueToFind);
        if(isEmpty())
        {
            throw new IllegalArgumentException("empty");
        }
        else
        {

        }
    }*/

    public void insertLast(Object newValue)
    {
        DSAListNode newNd = new DSAListNode(newValue);
        //newNd.setValue(newValue);
        if(isEmpty())
        {
            head = newNd;
            tail = newNd;
        }
        else
        {
            tail.setNext(newNd);
            newNd.setPrev(tail);
            tail = newNd;
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
            throw new IllegalArgumentException("empty");
        }
        else
        {
            //Object nodeValue = head.getValue();
            return head.getValue();
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
            //Object nodeValue = tail.getValue();
            return tail.getValue();
        }
    }

    public Object removeFirst()
    {
        if(isEmpty())
        {
            throw new IllegalArgumentException("empty");
        }
        else if(head.getNext() == null)
        {
            Object nodeValue = head.getValue();
            head = null;
            tail = null;
            return nodeValue;
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
        else if(head.getNext()==null)
        {
            Object nodeValue = head.getValue();
            head = null;
            tail = null;
            return nodeValue;
        }
        else
        {
            Object nodeValue = tail.getValue();
            tail = tail.getPrev();
            return nodeValue;
        } 
    }

    public void Display(DSALinkedList list)
    {

        Iterator iter =  list.iterator();
        do
        {
            System.out.println(iter.next());
        }while(iter.hasNext());
    }

    

}
