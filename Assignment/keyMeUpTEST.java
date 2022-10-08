import org.junit.*;

import static org.junit.Assert.*;
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;

import java.io.*;
import java.util.*;


public class keyMeUpTEST extends keyMeUp
{
    public DSAGraph testKB = new DSAGraph();
    /*private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
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
    }*/
     


    @Test
    public void testLoadKB()
    {
        //testKB = new DSAGraph();
        loadKB("TESTkb.al", testKB);
        int test = testKB.getVertexCount();
        assertEquals(3, test);
    }

    @Test
    public void testProcessLine()
    {
        processLine("1 2 3", testKB);
        assertEquals(3, testKB.getVertexCount());
    }

    @Test
    public void testReadStringFile()
    {
        assertEquals("hi valerie", readStringFile("inputStringTEST.txt"));
    }

    @Test
    public void testExportKB()
    {
        loadKB("TESTkb.al", testKB);
        exportKB("TESTexport.al", testKB);
        //assertTrue(FileUtils);
    }

    @Test
    public void testWriteResults()
    {
        loadKB("switch.al", testKB);
        DSALinkedList breadthPath = new DSALinkedList();
        DSALinkedList depthPath = new DSALinkedList();
        String inputString = "sean";
        //readFile("iview", testKB);
        breadthPath = genBreadthPath(testKB, inputString);
        depthPath = genDepthPath(testKB, inputString);
        writeResults("results.txt", testKB, breadthPath, depthPath, inputString);
    }

    @Test
    public void testInputStringValidation()
    {
        //readFile("numPad.al", testKB);
        processLine("1 2 3", testKB);
        assertFalse(inputStringValidation("sean", testKB));
        assertTrue(inputStringValidation("1", testKB));
    }

    @Test
    public void testInputStringAltering()
    {
        //readFile("iview.al", testKB);
        String[] expected = {"s", "e", "a", "n"};
        String[] test = inputStringAltering("sean", testKB);
        //assertEquals(expected, test);
        assertArrayEquals(expected, test);
    }

    //@Test
    public void testDisplayPaths()
    {
        DSAGraph testKB = new DSAGraph();
        DSALinkedList breadthPath = new DSALinkedList();
        DSALinkedList depthPath = new DSALinkedList();
        String inputString = "sean";
        //readFile("iview", testKB);
        //breadthPath = genBreadth(testKB, inputString);
        //depthPath = genDepth(testKB, inputString);
        //displayPaths(testKB, breadthPath, depthPath, inputString);
        
    }

    @Test
    public void testGenBreadth()
    {
        DSALinkedList test = new DSALinkedList();
        test.insertLast("1");
        test.insertLast("2");
        test.insertLast("3");

        //readFile("numPad.al", testKB);
        
        //assertEquals(test, genBreadth(testKB, "123"));
    }

    @Test
    public void testGenDepth()
    {
        DSALinkedList test = new DSALinkedList();
        test.insertLast("1");
        test.insertLast("2");
        test.insertLast("3");

        //readFile("numPad.al", testKB);
        
        //assertEquals(test, genDepth(testKB, "123"));
    }

    @Test
    public void testBreadthFirstSearch()
    {
        


    }

    @Test
    public void testDepthFirstSearch()
    {

    }


    @Test
    public void testBreadthOptimised()
    {

    }

    @Test
    public void testDepthOptimised()
    {

    }



  
}
