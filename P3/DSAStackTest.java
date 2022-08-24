import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.*;
public class DSAStackTest extends DSAStack
{
   DSAStack stack = new DSAStack();
   

   @Test
   public void testGetCount()
   {
        assertEquals(0, stack.getCount());
   }

   @Test
   public void testIsEmpty()
   {
        assertTrue(stack.isEmpty());
   }

   @Test
   public void testIsFull()
   {
        assertFalse(stack.isFull());
   }

   @Test
   public void testPush()
   {
        stack.push(1.2);
        assertEquals(1, stack.getCount());
        assertEquals(1.2, stack.stack[1]);
   }

   @Test
   public void testPop()
   {
        stack.push(1.2);
        assertEquals(1.2, stack.pop());
        assertEquals(0, getCount());
   }

   @Test void testTop()
   {
        stack.push(1.2);
        assertEquals(1.2, stack.top());
   }

}
