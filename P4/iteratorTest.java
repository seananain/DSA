import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.*;

public class iteratorTest extends DSALinkedList
{
    DSALinkedList ll = new DSALinkedList();
    Iterator it;
    
    @Test
    public void testHasNext()
    {
        ll.insertFirst(1.1);
        ll.insertFirst(5.2);

        it = ll.iterator();
        assertTrue(it.hasNext());
    }

    @Test
    public void testNext()
    {
        ll.insertFirst(1.1);
        ll.insertFirst(5.2);

        it = ll.iterator();
        assertEquals(5.2, it.next());
    }

    @Test
    public void testRemove()
    {
        ll.insertFirst(1.1);
        ll.insertFirst(5.2);

        it = ll.iterator();
        UnsupportedOperationException thrown =  assertThrows(UnsupportedOperationException.class,()->it.remove());
        
    }
}
