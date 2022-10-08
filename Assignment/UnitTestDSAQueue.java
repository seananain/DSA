import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.*;

public class UnitTestDSAQueue extends DSAQueue
{
    DSAQueue q = new DSAQueue();



    @Test
    public void testIsEmpty()
    {
        assertTrue(q.isEmpty());
        q.enqueue("a");
        assertFalse(q.isEmpty());
    }

    @Test
    public void testEnqueue()
    {
        q.enqueue(5.1);
        assertEquals(5.1, q.peek());
    }

    @Test
    public void testDequeue()
    {
        q.enqueue(5.1);
        assertFalse(q.isEmpty());
        assertEquals(5.1, q.dequeue());
        assertTrue(q.isEmpty());
    }

    @Test
    public void testPeek()
    {
        q.enqueue(5.1);
        assertEquals(5.1, q.peek());
    }
}

