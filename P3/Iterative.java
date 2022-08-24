public class Iterative 
{
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

    public static long calcNFactorial(int n, DSAStack stack)
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
                stack.push(nFactorial);
            }
            
        }
        //stack.push(nFactorial);
        return nFactorial;
    }


}
