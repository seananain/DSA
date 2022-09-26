import org.junit.*;

import static org.junit.Assert.assertEquals;

import java.io.*;

public class keyMeUpTEST extends keyMeUp
{
    public DSAGraph KB = new DSAGraph();
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
    public void testMenu()
    {
        menu();
        assertEquals("Main Menu\r\n==============\r\n1. Load keyboard file\r\n2. Node operations (find, insert, delete, update)\r\n3. Edge operations (find, add, remove, update)\r\n4. Display graph\r\n5. Display graph information\r\n6. Enter string for finding path\r\n7. Generate paths\r\n8. Display path(s) (ranked, option to save)\r\n9. Save keyboard\r\n",outContent.toString());
    }

    @Test
    public void testSilentMode()
    {

    }

    @Test
    public void testInteractiveMode()
    {

    }

    @Test
    public void testReadFile()
    {

    }

    @Test
    public void testProcessLine()
    {

    }

    @Test
    public void testReadFile2()
    {

    }

    @Test
    public void testWriteFile()
    {

    }

    @Test
    public void testWriteResults()
    {

    }

    @Test
    public void testInputStringValidation()
    {

    }

    @Test
    public void testInputStringAltering()
    {

    }

    @Test
    public void testDisplayPaths()
    {

    }

    @Test
    public void testGenBreadth()
    {

    }

    @Test
    public void testGenDepth()
    {

    }

    @Test
    public void testBreadthFirstSearchAlt()
    {

    }

    @Test
    public void testDepthFirstSearchAlt()
    {

    }


    @Test
    public void testBreadth()
    {

    }

    @Test
    public void testDepth()
    {

    }

    @Test
    public void testNodeOperations()
    {

    }

    @Test
    public void testNodeOpMenu()
    {

    }

    @Test
    public void testEdgeOperations()
    {

    }

    @Test
    public void testEdgeOpMenu()
    {

    }
}
