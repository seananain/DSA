/**
 * DSA Final Assessment Question 5 - GraphTest.java
 *
 * Name : Sean Anain
 * ID   : 20324861
 *
 **/
public class GraphTest
{
	public static void main(String args[])
	{
			System.out.println("\n##### Question 5: Testing Graphs #####\n");
			int numTests=0;
        	int numPassed=0;

			// put your code here
			Q5Graph g = new Q5Graph();

			System.out.println("Testing Graph");
			System.out.println("===================");
			System.out.println();

			//Test 1: addVertex()
			try
			{
				System.out.print("addVertex(): ");
				numTests++;
				g.addVertex("one", 0);
				g.addVertex("two", 0);
				g.addVertex("three", 0);
				g.addVertex("four", 0);
				numPassed++;
				System.out.println("passed");
			} catch(Exception e) { System.out.println("FAILED"); }

			//Test 2: hasVertex()
			try
			{
				System.out.print("hasVertex(): ");
				numTests++;
				if(!g.hasVertex("one"))
				{
					throw new PracExamException("Graph does have that vertex");
				}
				numPassed++;
				System.out.println("passed");
			} catch(Exception e) { System.out.println("FAILED"); }

			//Test 3: addEdge()
			try
			{
				System.out.print("addEdge(): ");
				numTests++;
				g.addEdge("one", "two", 3);
				g.addEdge("one", "three", 4);
				g.addEdge("one", "four", 5);
				g.addEdge("four", "two", 6);
				g.addEdge("four", "three", 7);
				numPassed++;
				System.out.println("passed");
			} catch(Exception e) { System.out.println("FAILED"); }

			//Test 4: hasEdge()
			try
			{
				System.out.print("hasEdge(): ");
				numTests++;
				if(!g.hasEdge("one", "two"))
				{
					throw new PracExamException("Graph does have that edge");
				}
				numPassed++;
				System.out.println("passed");
			} catch(Exception e) { System.out.println("FAILED"); }

        // PRINT TEST SUMMARY
        System.out.print("\nNumber PASSED: " + numPassed + "/" + numTests);
        System.out.print(" -> " + (int)(double)(numPassed/numTests)*100 + "%\n");
			
			
			
			
			
			g.displayAsList();
			
			System.out.println("\n##### Tests Complete #####\n");

	}
	
}
