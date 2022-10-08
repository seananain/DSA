import java.util.*;



//import DSAGraph.DSAGraphVertex;

public class UnitTestKeyMeUp extends keyMeUp
{
    public static void main(String args[])
	{
        DSAGraph testKB = new DSAGraph();
        int numTests=0;
        int numPassed=0;


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








         // PRINT TEST SUMMARY
         System.out.print("\nNumber PASSED: " + numPassed + "/" + numTests);
         System.out.print(" -> " + (int)(double)(numPassed/numTests)*100 + "%\n");


    }
}
