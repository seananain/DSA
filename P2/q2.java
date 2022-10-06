package P2a;
import java.util.*;

public class q2 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first integer...");
        int num1 = sc.nextInt();

        System.out.println("Enter second integer...");
        int num2 = sc.nextInt();


        System.out.println("The GCD is: " + GCD(num1, num2));
        sc.close();


    }



public static int GCD(int x, int y) //geeksforgeeks.org/java-program-to-compute-gcd/
{
    if(y==0)
    {
        return x;
    }
    return GCD(y, x % y);
}

}
