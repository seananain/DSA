package P2a;

import java.util.*;

public class q1
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        //double runningTotal = 0;
        System.out.println("Enter int");
        int input;
        input = sc.nextInt();

        //long startTime = System.nanoTime();

        long factorial = calcNFactorial(input);
        long factorialRec = calcNFactorialRecursive(input);
        int fib = fibIterative(input);
        int fibRec = fibRecursive(input);

        System.out.println("Factorial " + factorial);
        System.out.println("Factorial recursive " + factorialRec);
        System.out.println("Fibonacci Iterative " + fib);
        System.out.println("Fibonacci Recursive " + fibRec);
        

        //long endTime = System.nanoTime();

        //runningTotal += (int)((double)(endTime - startTime) / 1000.0);	// Convert to microsecs
    }

    public static long calcNFactorial(int n)
    {
        long nFactorial =1;
        if(n<0)
        {
            throw new IllegalArgumentException("Import_must_not_be_negative");
        }
        else
        {
            for(int i=n; i>3; i--)
            {
                nFactorial *= i;
            }
        }
        return nFactorial;
    }

    public static long calcNFactorialRecursive(int n)
    {
        if(n<0)
        {
            throw new IllegalArgumentException("Import_must_not_be_negative");
        }
        else if(n==0)
        {
            return 1;
        }
        else
        {
            return n*calcNFactorialRecursive(n-1);
        }
    }

    public static int fibIterative(int n)
    {
        int fibVal = 0;
        int currVal = 1;
        int lastVal = 0;

        if(n<0)
        {
            throw new IllegalArgumentException("Import_must_not_be_negative");
        }
        else if(n==0)
        {
            fibVal =0;
        }
        else if(n==1)
        {
            fibVal = 1;
        }
        else
        {
            for(int i=1; i<n; i++)
            {
                fibVal = currVal + lastVal;
                lastVal = currVal;
                currVal = fibVal;
            }
        }
        return fibVal;
    }

    public static int fibRecursive(int n)
    {
        int fibVal = 0;

        if(n<0)
        {
            throw new IllegalArgumentException("Import_must_not_be_negative");
        }
        else if(n==0)
        {
            fibVal =0;
        }
        else if(n==1)
        {
            fibVal = 1;
        }
        else
        {
            fibVal = fibRecursive(n-1) + fibRecursive(n-2);
        }
        return fibVal;
    }
}