import org.junit.*;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.*;
import java.util.*;

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
        readFile("numPad.al", KB);
    }

    @Test
    public void testProcessLine()
    {
        processLine("1, 2, 3", KB);
    }

    @Test
    public void testReadFile2()
    {
        assertEquals("hi sean", readFile2("inputString.txt"));
    }

    @Test
    public void testWriteFile()
    {
        readFile("numPad.al", KB);
        writeFile("output.al", KB);
    }

    @Test
    public void testWriteResults()
    {
        DSALinkedList breadthPath = new DSALinkedList();
        DSALinkedList depthPath = new DSALinkedList();
        String inputString = "sean";
        readFile("iview", KB);
        breadthPath = genBreadth(KB, inputString);
        depthPath = genDepth(KB, inputString);
        writeResults("results.txt", KB, breadthPath, depthPath, inputString);
    }

    @Test
    public void testInputStringValidation()
    {
        readFile("numPad.al", KB);
        assertFalse(inputStringValidation("sean", KB));
        assertTrue(inputStringValidation("1", KB));
    }

    @Test
    public void testInputStringAltering()
    {
        readFile("iview.al", KB);
        String[] test = {"","s", "e", "a", "n"};
        assertEquals(test, inputStringAltering("sean", KB));
    }

    @Test
    public void testDisplayPaths()
    {
        DSAGraph KB = new DSAGraph();
        DSALinkedList breadthPath = new DSALinkedList();
        DSALinkedList depthPath = new DSALinkedList();
        String inputString = "sean";
        readFile("iview", KB);
        breadthPath = genBreadth(KB, inputString);
        depthPath = genDepth(KB, inputString);
        displayPaths(KB, breadthPath, depthPath, inputString);
        
    }

    @Test
    public void testGenBreadth()
    {
        DSALinkedList test = new DSALinkedList();
        test.insertLast("1");
        test.insertLast("2");
        test.insertLast("3");

        readFile("numPad.al", KB);
        
        assertEquals(test, genBreadth(KB, "123"));
    }

    @Test
    public void testGenDepth()
    {
        DSALinkedList test = new DSALinkedList();
        test.insertLast("1");
        test.insertLast("2");
        test.insertLast("3");

        readFile("numPad.al", KB);
        
        assertEquals(test, genDepth(KB, "123"));
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
