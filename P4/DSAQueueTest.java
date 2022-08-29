import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.*;

public class DSAQueueTest extends DSAQueue
{
   DSAQueue q = new DSAQueue();
   //DSACircularQueue cQ = new DSACircularQueue();
   
   

   @Test
   public void testIsFull()
   {
     assertFalse(q.isFull());
     //assertFalse(((DSACircularQueue)cQ).isFull());
   }

   @Test
   public void testIsEmpty()
   {
     assertTrue(q.isEmpty());
     //assertTrue(((DSACircularQueue)cQ).isEmpty());
   }

   @Test
   public void testEnqueue()
   {
     q.enqueue(5.1);
     assertEquals(5.1, q.peek());
     //assertEquals(1, q.getCount());

     /*cQ.enqueue(6.3);
     assertEquals(6.3, cQ.queue[0]);
     assertEquals(0, cQ.getFront());
     assertEquals(0, cQ.getRear());*/
   }

   @Test
   public void testDequeue()
   {
     q.enqueue(5.1);
     assertEquals(5.1, q.dequeue());
     //assertEquals(0, q.getCount());

     /*cQ.enqueue(6.3);
     assertEquals(6.3, cQ.dequeue());
     assertEquals(-1, cQ.getFront());*/
   }

   @Test
   public void testPeek()
   {
     q.enqueue(5.1);
     assertEquals(5.1, q.peek());

     /*cQ.enqueue(5.1);
     assertEquals(5.1, cQ.peek());*/
   }

 

}

