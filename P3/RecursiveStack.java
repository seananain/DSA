import java.util.*;

public class RecursiveStack 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        int choice, n;
        DSAStack stack = new DSAStack();

        System.out.println("Choose method");
        System.out.println("1. calcNFactorialRecursive");
        System.out.println("2. fibRecursive");
        System.out.println("3. GCD");
        System.out.println("4. toBinary");
        choice = sc.nextInt();

        System.out.println("Enter integer");
        n = sc.nextInt();
        try
        {
            switch(choice)
            {
                case 1:
                    Recursive.calcNFactorialRecursive(n, stack);
                    
                    popper(n, stack);
                break;

                case 2:
                    Recursive.fibRecursive(n, stack);
                    popper(n,stack);
                break;

                case 3:
                    //Recursive.GCD(x, y, stack)(n, stack);
                    popper(n,stack);
                break;

                case 4:
                    Recursive.toBinary(n, stack);
                    popper(n,stack);
                break;

                
            }
        }catch (Exception e)
        {
            System.out.println("Invalid input");
        }
        sc.close();
    }

    public static void popper(int n, DSAStack stack)
    {
        for(int i=0; i<n+1; i++)
        {
            System.out.println();
            System.out.print("popping");
            stack.pop();
            stack.display();
        }
    }
}
