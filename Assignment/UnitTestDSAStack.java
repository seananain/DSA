import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class UnitTestDSAStack extends DSAStack
{
    DSAStack stack = new DSAStack();
   


   @Test
   public void testIsEmpty()
   {
        assertTrue(stack.isEmpty());
        stack.push("a");
        assertFalse(stack.isEmpty());
   }

   @Test
   public void testPush()
   {
        stack.push(1.2);
        assertEquals(1.2, stack.top());
   }

   @Test
   public void testPop()
   {
        stack.push(1.2);
        assertFalse(stack.isEmpty());
        assertEquals(1.2, stack.pop());
        assertTrue(stack.isEmpty());
   }

   @Test 
   public void testTop()
   {
        stack.push(1.2);
        assertEquals(1.2, stack.top());
   }

}
