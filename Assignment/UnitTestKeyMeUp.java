import java.util.*;
import java.io.*;
import java.nio.*;


//import DSAGraph.DSAGraphVertex;

public class UnitTestKeyMeUp extends keyMeUp
{
    public static void main(String args[])
	{
        DSAGraph testKB = new DSAGraph();
        int numTests=0;
        int numPassed=0;

        System.out.println("Testing All Methods in keyMeUp.java");
        System.out.println("===================");
        System.out.println();

        System.out.println("Testing File I/O");
        System.out.println("===================");
        //Test 1: loadKB()
        try
        {
            System.out.print("loadKB(): ");
            numTests++;
            loadKB("TESTkb.al", testKB);
            if(testKB.getVertexCount() != 3)
            {
                throw new IllegalArgumentException("File incorrectly read.");
            }
            if(testKB.getEdgeCount() != 4)
            {
                throw new IllegalArgumentException("File incorrectly read.");
            }
            numPassed++;
            System.out.println("passed");
 
        } catch(Exception e) { System.out.println("FAILED"); }

        //Test 2: processLine()
        try
        {
            System.out.print("processLine(): ");
            numTests++;
            testKB = new DSAGraph();
            processLine("1 2 3", testKB);
            if(testKB.getVertexCount() != 3)
            {
                throw new IllegalArgumentException("String incorrectly read.");
            }
            processLine("5 6 7", testKB);
            if(testKB.getVertexCount() != 6)
            {
                throw new IllegalArgumentException("String incorrectly read.");
            }
            numPassed++;
            System.out.println("passed");
   
        } catch(Exception e) { System.out.println("FAILED"); }

        //Test3: readStringFile()
        try
        {
            System.out.print("readStringFile(): ");
            numTests++;
            
            if(!"hello marker".equals(readStringFile("TESTinputString.txt")))
            {
                throw new IllegalArgumentException("File incorrectly read.");
            }
            numPassed++;
            System.out.println("passed");
      
        } catch(Exception e) { System.out.println("FAILED"); }
        
        //Test 4: exportKB()
        try
        {
            System.out.print("exportKB(): ");
            int testNumVert, testNumEdge;
            numTests++;
            testKB = new DSAGraph();
            loadKB("TESTkb.al", testKB);
            testNumVert = testKB.getVertexCount();
            testNumEdge = testKB.getEdgeCount();
            exportKB("TESTexport.al", testKB);
            testKB = new DSAGraph();                    //Reset keyboard graph
            loadKB("TESTexport.al", testKB); //Importing previously exported keybaord
            if(testKB.getVertexCount() != 3)
            {
                throw new IllegalArgumentException("File incorrectly read.");
            }
            if(testKB.getEdgeCount() != 4)
            {
                throw new IllegalArgumentException("File incorrectly read.");
            }
            
            numPassed++;
            System.out.println("passed");
       
        } catch(Exception e) { System.out.println("FAILED"); }


        //Test 5: writeResults
        try
        {
            System.out.print("writeResults(): ");
            numTests++;
            testKB = new DSAGraph();
            loadKB("numPad.al", testKB);
            String input = "193";
            DSALinkedList breadthPath = genBreadthPath(testKB, input);
            DSALinkedList depthPath = genDepthPath(testKB, input);
            
            
            String output;
            PrintStream out = new PrintStream(new FileOutputStream("TESTresults2.txt"));
            PrintStream old = System.out;
            System.setOut(out);
            displayPaths(testKB, breadthPath, depthPath, input);
            System.out.flush();
            System.setOut(old);

            writeResults("TESTresults.txt", testKB, breadthPath, depthPath, input);
            
            String expected = readStringFile("TESTresults2.txt");
            String actual = readStringFile("TESTresults.txt");

            if(!actual.equals(expected))
            {
                throw new IllegalAccessException();
            }
            numPassed++;
            System.out.println("passed");

         
        
      
        } catch(Exception e) { System.out.println("FAILED"); }

        System.out.println();
        System.out.println("Testing String Methods");
        System.out.println("===================");

        //Test 1: inputStringValidation()
        try
        {
            System.out.print("inputStringValidation(): ");
            numTests++;
            testKB = new DSAGraph();
            loadKB("numPad.al", testKB);
            Boolean valid = false;
            if(!inputStringValidation("20324861", testKB))
            {
                throw new IllegalArgumentException();
            }
    

            PrintStream out = new PrintStream(new FileOutputStream("TESTresults1.txt"));
            PrintStream old = System.out;
            System.setOut(out);
            valid = inputStringValidation("hi I'm Sean", testKB);
            System.out.flush();
            System.setOut(old);
            if(valid)
            {
                throw new IllegalArgumentException();
            }

            numPassed++;
            System.out.println("passed");
        } catch(Exception e) { System.out.println("FAILED"); }

        //Test 2: inputStringAltering()
        try
        {
            System.out.print("inputStringAltering(): ");
            numTests++;
            
    
            String[] actual = null;

            //Test1 - basic altering
            testKB = new DSAGraph();
            loadKB("numPad.al", testKB);
            actual = inputStringAltering("19", testKB);
            String[] expected1 = {"1","9"};
            if(!Arrays.equals(actual, expected1))
            {
                throw new IllegalArgumentException();
            }

            //Test2 - altering for captital letter
            testKB = new DSAGraph();
            loadKB("iview.al", testKB);
            actual = inputStringAltering("Sean", testKB);
            String[] expected2 = {"SHIFT","s","e","a","n"};
            if(!Arrays.equals(actual, expected2))
            {
                throw new IllegalArgumentException();
            }

            //Test3 - altering for punctuation
            testKB = new DSAGraph();
            loadKB("switch.al", testKB);
            actual = inputStringAltering("{sean}", testKB);
            String[] expected3 = {"#+=","h","#+=","s","e","a","n","#+=","j","#+="};
            if(!Arrays.equals(actual, expected3))
            {
                throw new IllegalArgumentException();
            }


            //Test4 - altering for punctuation and captial letter
            testKB = new DSAGraph();
            loadKB("switch.al", testKB);
            actual = inputStringAltering("{SeAn}", testKB);
            String[] expected4 = {"#+=","h","#+=","SHIFT","s","e","SHIFT","a","n","#+=","j","#+="};
            if(!Arrays.equals(actual, expected4))
            {
                throw new IllegalArgumentException();
            }

            numPassed++;
            System.out.println("passed");
        } catch(Exception e) { System.out.println("FAILED"); }



        System.out.println();
        System.out.println("Testing Path Generation");
        System.out.println("===================");

        //Test 1: breadthFirstSearch()
        try
        {
            System.out.print("breadthFirstSearch(): ");
            testKB = new DSAGraph();
            numTests++;
            int i=0;
            DSAQueue test = new DSAQueue();
            
            
            
            testKB.addVertex(1, 1);
            testKB.addVertex(2, 2);
            testKB.addVertex(3, 3);
            testKB.addVertex(4, 4);

            DSAGraph.DSAGraphVertex[] expected = {testKB.getVertex(3), testKB.getVertex(1), testKB.getVertex(3), testKB.getVertex(2)};

            testKB.addEdge(1, 2);
            testKB.addEdge(1, 3);
            testKB.addEdge(2, 1);
            testKB.addEdge(2, 3);
            testKB.addEdge(3, 1);
            testKB.addEdge(3, 2);
            testKB.addEdge(3, 4);
            testKB.addEdge(4, 3);
            test = breadthFirstSearch(testKB, 3, 2);

            Iterator iter = test.iterator();
            do
            {
                DSAGraph.DSAGraphVertex vert = (DSAGraph.DSAGraphVertex)iter.next();
                if(!expected[i].equals(vert))
                {
                    throw new IllegalArgumentException();
                }
                i++;
            }while(iter.hasNext());
            
            numPassed++;
            System.out.println("passed");
       
        } catch(Exception e) { System.out.println("FAILED"); }


        //Test 2: depthFirstSearch()
        try
        {
            System.out.print("depthFirstSearch(): ");
            testKB = new DSAGraph();
            numTests++;
            int i=0;
            DSAQueue test = new DSAQueue();
            testKB.addVertex(1, 1);
            testKB.addVertex(2, 2);
            testKB.addVertex(3, 3);
            testKB.addVertex(4, 4);
            DSAGraph.DSAGraphVertex[] expected = {testKB.getVertex(3), testKB.getVertex(1), testKB.getVertex(1), testKB.getVertex(2)};
            testKB.addEdge(1, 2);
            testKB.addEdge(1, 3);
            testKB.addEdge(2, 1);
            testKB.addEdge(2, 3);
            testKB.addEdge(3, 1);
            testKB.addEdge(3, 2);
            testKB.addEdge(3, 4);
            testKB.addEdge(4, 3);
            test = depthFirstSearch(testKB, 3, 2);

            Iterator iter = test.iterator();
            do
            {
                DSAGraph.DSAGraphVertex vert = (DSAGraph.DSAGraphVertex)iter.next();
                if(!expected[i].equals(vert))
                {
                    throw new IllegalArgumentException();
                }
                i++;
            }while(iter.hasNext());

            
            
            numPassed++;
            System.out.println("passed");
       
        } catch(Exception e) { System.out.println("FAILED"); }


        //Test 3: breadthOptimised()
        try
        {
            System.out.print("breadthOptimised(): ");
            numTests++;
            int i =0;
            testKB = new DSAGraph();
            loadKB("numPad.al", testKB);
            DSALinkedList test = new DSALinkedList();
            test = breadthOptimised(testKB, "1", "9");
            String[] expected = {"1","2","5","6","9"};
            Iterator iter = test.iterator();
            do
            {
                DSAGraph.DSAGraphVertex vert = (DSAGraph.DSAGraphVertex)iter.next();
                if(!expected[i].equals(vert.getLabel()))
                {
                    throw new IllegalArgumentException();
                }
                i++;
            }while(iter.hasNext());
            numPassed++;
            System.out.println("passed");
        } catch(Exception e) { System.out.println("FAILED"); }

        //Test 4: depthOptimised()
        try
        {
            System.out.print("depthOptimised(): ");
            numTests++;
            int i =0;
            testKB = new DSAGraph();
            loadKB("numPad.al", testKB);
            DSALinkedList test = new DSALinkedList();
            test = depthOptimised(testKB, "1", "9");
            String[] expected = {"1","2","5","8","9"};
            Iterator iter = test.iterator();
            do
            {
                DSAGraph.DSAGraphVertex vert = (DSAGraph.DSAGraphVertex)iter.next();
                if(!expected[i].equals(vert.getLabel()))
                {
                    throw new IllegalArgumentException();
                }
                i++;
            }while(iter.hasNext());
            numPassed++;
            System.out.println("passed");
        } catch(Exception e) { System.out.println("FAILED"); }

        
        //Test 5: genBreadthPath()
        try
        {
            System.out.print("genBreadthPath(): ");
            numTests++;
            int i =0;
            testKB = new DSAGraph();
            loadKB("numPad.al", testKB);
            DSALinkedList test = new DSALinkedList();
            test = genBreadthPath(testKB, "197");
            String[] expected = {"1","2","5","6","9","9","8","7"};
            Iterator iter = test.iterator();
            do
            {
                DSAGraph.DSAGraphVertex vert = (DSAGraph.DSAGraphVertex)iter.next();
                if(!expected[i].equals(vert.getLabel()))
                {
                    throw new IllegalArgumentException();
                }
                i++;
            }while(iter.hasNext());
            numPassed++;
            System.out.println("passed");
        } catch(Exception e) { System.out.println("FAILED"); }



        //Test 6: genDepthPath()
        try
        {
            System.out.print("genDepthPath(): ");
            numTests++;
            int i =0;
            testKB = new DSAGraph();
            loadKB("numPad.al", testKB);
            DSALinkedList test = new DSALinkedList();
            test = genDepthPath(testKB, "197");
            String[] expected = {"1","2","5","8","9","9","8","7"};
            Iterator iter = test.iterator();
            do
            {
                DSAGraph.DSAGraphVertex vert = (DSAGraph.DSAGraphVertex)iter.next();
                if(!expected[i].equals(vert.getLabel()))
                {
                    throw new IllegalArgumentException();
                }
                i++;
            }while(iter.hasNext());
            numPassed++;
            System.out.println("passed");
        } catch(Exception e) { System.out.println("FAILED"); }



         // PRINT TEST SUMMARY
         System.out.print("\nNumber PASSED: " + numPassed + "/" + numTests);
         System.out.print(" -> " + (int)(double)(numPassed/numTests)*100 + "%\n");


    }
}
