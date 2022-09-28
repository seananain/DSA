import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import java.util.*;

import java.util.InputMismatchException;

import org.junit.*;

public class DSAHashTableTEST 
{
    public DSAHashTable T = new DSAHashTable();

    @Test
    public void testPut()
    {
        T.PutNew("10", (Object)10);

        
    }

    @Test
    public void testGet()
    {
        T.PutNew("10", (Object)10);
        assertEquals(10, T.get("10"));
    }

    @Test
    public void testRemove()
    {
        T.PutNew("10", (Object)10);
        T.removeNew("10");
        //assertThrows(InputMismatchException(), T.get("10");
        
    }

    @Test
    public void testGetLoadFactor()
    {
        T.PutNew("10", (Object)10);
        //assertEquals(0.1, T.getLoadFactor());
    }


}
