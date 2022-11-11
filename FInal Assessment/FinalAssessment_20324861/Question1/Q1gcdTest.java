public class Q1gcdTest 
{
    public static int GCD(int x, int y) //Altered version of practical code (own code)
    {
        if(y==0)
        {
            return x;
        }
        //System.out.println(x + " "+  y);
        return GCD(y, x % y);
    }

    public static void main(String[] args)
    {
        int num1=2032, num2=4861;
        System.out.println("Num 1: " + num1 + " Num 2: "+ num2);
        System.out.println("GCD(num1, num2) = "+GCD(num1, num2));
        System.out.println("GCD(num2, num1) = "+GCD(num2, num1));
    }
}
