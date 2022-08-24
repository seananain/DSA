import java.util.*;

public class Recursive 
{
    public static long calcNFactorialRecursive(int n, DSAStack stack)
    {
        System.out.println();
        System.out.print("pushing");
        if(n<0)
        {
            throw new IllegalArgumentException("Import_must_not_be_negative");
        }
        else if(n==0)
        {
            stack.push("Argument: " + n);
            
            //stack.pop();
            stack.display();
            return 1;
        }
        else
        {
            stack.push("Argument: " + n);
            stack.display();
            //stack.pop();
            System.out.println(stack.getCount());
            return n*calcNFactorialRecursive(n-1, stack);
        }
    }  
    
    public static int fibRecursive(int n, DSAStack stack)
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
            fibVal = fibRecursive(n-1, stack) + fibRecursive(n-2, stack);
        }
        return fibVal;
    }

    public static int GCD(int x, int y, DSAStack stack) //geeksforgeeks.org/java-program-to-compute-gcd/
    {
        if(y==0)
        {
            return x;
        }
        return GCD(y, x % y, stack);
    }

    public static int toBinary(int dec, DSAStack stack)
    {
        if(dec==0)
        {
            return 0;
        }
        else
        {
            return(dec % 2 + 10*toBinary(dec/2, stack));
        }
    }
}
