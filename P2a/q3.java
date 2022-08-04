package P2a;
import java.util.*;
//stack overflow
public class q3 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an integer...");
        int num = sc.nextInt();

        System.out.println("Enter a base umber from 2 to 16...");
        int base = sc.nextInt();

        String output = "";
        output = Integer.toString(num, base);

        System.out.println("Result: " + output);

        sc.close();

    }



}
