import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.*;

public class DSAQueueTest extends DSAQueue
{
   DSAQueue q = new DSAQueue();
   
    @Test
   public void testGetCount()
   {
        assertEquals(0, q.getCount());
   }

   @Test
   public void testIsFull()
   {
        assertFalse(q.isFull());
   }

   @Test
   public void testIsEmpty()
   {
        assertTrue(q.isEmpty());
   }

   @Test
   public void testEnqueue()
   {
        q.enqueue(5.1);
        assertEquals(5.1, q.queue[0]);
        assertEquals(1, q.getCount());
   }

   @Test
   public void testDequeue()
   {
        q.enqueue(5.1);
        assertEquals(5.1, q.dequeue());
        assertEquals(0, q.getCount());
   }

   @Test
   public void testPeek()
   {
        q.enqueue(5.1);
        assertEquals(5.1, q.peek());
   }


}

