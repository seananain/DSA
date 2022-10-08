import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.*;

public class UnitTestDSALinkedList 
{
    DSALinkedList ll = new DSALinkedList();


    @Test
    public void testInsertFirst()
    {
        ll.insertFirst("a");
        ll.insertFirst("b");
        assertEquals("b", ll.peekFirst());
    }

    @Test
    public void testInsertLast()
    {
        ll.insertLast("a");
        ll.insertLast("b");
        assertEquals("b", ll.peekLast());
    }

    @Test
    public void testIsEmpty()
    {
        assertTrue(ll.isEmpty());
        ll.insertFirst("a");
        assertFalse(ll.isEmpty());
    }

    @Test
    public void testPeekFirst()
    {
        ll.insertFirst("a");
        ll.insertFirst("b");
        assertEquals("b", ll.peekFirst());
    }

    @Test
    public void testPeekLast()
    {
        ll.insertLast("a");
        ll.insertLast("b");
        assertEquals("b", ll.peekLast());
    }

    @Test
    public void testRemoveFirst()
    {
        ll.insertFirst("a");
        ll.insertFirst("b");
        assertEquals("b", ll.peekFirst());
        ll.removeFirst();
        assertEquals("a", ll.peekFirst());
    }

    @Test
    public void testRemoveLast()
    {
        ll.insertFirst("a");
        ll.insertFirst("b");
        assertEquals("b", ll.peekFirst());
        ll.removeLast();
        assertEquals("b", ll.peekFirst());
    }

}
