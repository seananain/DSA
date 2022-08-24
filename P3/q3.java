
import java.util.*;
//stack overflow
public class q3 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an integer...");
        int num = sc.nextInt();


        int answer = toBinary(num);

        System.out.println("Result: " + answer);

        sc.close();

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
