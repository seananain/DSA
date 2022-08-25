import static org.junit.Assert.assertEquals;

import org.junit.*;

public class CallStackTest extends Recursive
{
    DSAStack stack = new DSAStack();

    @Test
    public void testFactorial()
    {
        assertEquals(6, calcNFactorialRecursive(3, stack));
    }

    @Test
    public void testFib()
    {
        assertEquals(2, fibRecursive(3, stack));
    }

    @Test
    public void testGCD()
    {
        assertEquals(10, GCD(20, 30, stack));
    }

    @Test
    public void testToBinary()
    {
        assertEquals(101, toBinary(5, stack));
    }
}
