public class Recursive 
{
    public static long calcNFactorialRecursive(int n, DSAStack stack)
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
            
            return n*calcNFactorialRecursive(n-1, stack);
        }
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

    public static int GCD(int x, int y) //geeksforgeeks.org/java-program-to-compute-gcd/
    {
        if(y==0)
        {
            return x;
        }
        return GCD(y, x % y);
    }

    public static int toBinary(int dec)
    {
        if(dec==0)
        {
            return 0;
        }
        else
        {
            return(dec % 2 + 10*toBinary(dec/2));
        }
    }
}
