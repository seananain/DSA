import java.util.*;

public class Q4PriorityTest 
{
    public static void main(String args[])
	{
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        int numTests=0;
        int numPassed=0;

        System.out.println("Testing Priority Queue");
        System.out.println("===================");
        System.out.println();

        //Test 1: add()
        try
        {
            System.out.print("add(): ");
            numTests++;
            q.add(5);
            q.add(1);
            q.add(3);
            q.add(8);
            numPassed++;
            System.out.println("passed");
        } catch(Exception e) { System.out.println("FAILED"); }

        //Test 2: size()
        try
        {
            System.out.print("size(): ");
            numTests++;
            if(q.size() != 4)
            {
                throw new PracExamException("Size is not 4");
            }
            numPassed++;
            System.out.println("passed");
        } catch(Exception e) { System.out.println("FAILED"); }

        //Test 3: remove()
        try
        {
            System.out.print("remove(): ");
            numTests++;
            q.remove(3);
            if(q.size() != 3)
            {
                throw new PracExamException("Size is not 3");
            }
            numPassed++;
            System.out.println("passed");
        } catch(Exception e) { System.out.println("FAILED"); }

        //Test 4: peek()
        try
        {
            System.out.print("peek(): ");
            numTests++;
            if(!q.peek().equals(1))
            {
                throw new PracExamException("Front is not 1");
            }
            numPassed++;
            System.out.println("passed");
        } catch(Exception e) { System.out.println("FAILED"); }

        //Test 5: poll()
        try
        {
            System.out.print("poll(): ");
            numTests++;

            if(!q.poll().equals(1))
            {
                throw new PracExamException("Front is not 1");
            }
            if(q.size() != 2)
            {
                throw new PracExamException("Size is not 2");
            }
            numPassed++;
            System.out.println("passed");
        } catch(Exception e) { System.out.println("FAILED"); }

        //Test 6: isEmpty()
        try
        {
            System.out.print("isEmpty(): ");
            numTests++;

            if(q.isEmpty()==true)
            {
                throw new PracExamException("Queue is not empty");
            }
            q.poll();
            q.poll();
            if(q.isEmpty()==false)
            {
                throw new PracExamException("Queue is empty");
            }
            numPassed++;
            System.out.println("passed");
        } catch(Exception e) { System.out.println("FAILED"); }
        
       

         // PRINT TEST SUMMARY
         System.out.print("\nNumber PASSED: " + numPassed + "/" + numTests);
         System.out.print(" -> " + (int)(double)(numPassed/numTests)*100 + "%\n");


    }
}
