import static org.junit.Assert.assertEquals;

import java.io.*;

import org.junit.*;


public class BSTtest extends DSABinarySearchTree
{
    public DSABinarySearchTree bst = new DSABinarySearchTree("4", 4);
    
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void testInsert()
    {
        try
        {
            //bst.insert("4", 4);
            bst.insert("2", 2);
            bst.insert("1", 1);
            bst.insert("3", 3);
            bst.insert("5", 5);
            bst.insert("6", 6);
        }catch(Error e)
        {
            throw new IllegalArgumentException(e);
        }
    }

    @Test
    public void testFind()
    {
        bst.insert("2", 2);
        bst.insert("1", 1);
        bst.insert("3", 3);
        bst.insert("5", 5);
        bst.insert("6", 6);

        assertEquals(3, bst.find("3"));
    }

    @Test
    public void testDelete()
    {
        bst.insert("2", 2);
        bst.insert("1", 1);
        bst.insert("3", 3);
        bst.insert("5", 5);
        bst.insert("6", 6);

        bst.delete("2");
        bst.inOrder();

        assertEquals("1\r\n3\r\n4\r\n5\r\n6", outContent.toString().trim());
        
    }

    @Test
    public void testHeight()
    {
        bst.insert("2", 2);
        bst.insert("1", 1);
        bst.insert("3", 3);
        bst.insert("5", 5);
        bst.insert("6", 6);

        assertEquals(2, bst.height());
    }

    @Test
    public void testMin()
    {
        bst.insert("2", 2);
        bst.insert("1", 1);
        bst.insert("3", 3);
        bst.insert("5", 5);
        bst.insert("6", 6);

        assertEquals(1, bst.min());
    }

    @Test
    public void testMax()
    {
        bst.insert("2", 2);
        bst.insert("1", 1);
        bst.insert("3", 3);
        bst.insert("5", 5);
        bst.insert("6", 6);

        assertEquals(6, bst.max());
    }

    @Test
    public void testBalance()
    {
        bst.insert("2", 2);
        bst.insert("1", 1);
        bst.insert("3", 3);
        bst.insert("5", 5);
        bst.insert("6", 6);

        assertEquals(Double.valueOf(100), bst.balance());
    }

    @Test
    public void testInOrder()
    {
        bst.insert("2", 2);
        bst.insert("1", 1);
        bst.insert("3", 3);
        bst.insert("5", 5);
        bst.insert("6", 6);

        bst.inOrder();

        assertEquals("1\r\n2\r\n3\r\n4\r\n5\r\n6", outContent.toString().trim());
    }

    @Test
    public void testPreOrder()
    {
        bst.insert("2", 2);
        bst.insert("1", 1);
        bst.insert("3", 3);
        bst.insert("5", 5);
        bst.insert("6", 6);

        bst.preOrder();

        assertEquals("4\r\n2\r\n1\r\n3\r\n5\r\n6", outContent.toString().trim());
    }

    @Test
    public void testpostOrder()
    {
        bst.insert("2", 2);
        bst.insert("1", 1);
        bst.insert("3", 3);
        bst.insert("5", 5);
        bst.insert("6", 6);

        bst.postOrder();

        assertEquals("1\r\n3\r\n2\r\n6\r\n5\r\n4", outContent.toString().trim());
    }





}
