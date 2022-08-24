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

        switch(choice)
        {
            case 1:
                Recursive.calcNFactorialRecursive(n, stack);
                //stack.push("calcNFactorialRecursive");
                popper(n, stack);
            break;

            
        }
        sc.close();
    }

    public static void popper(int n, DSAStack stack)
    {
        
        
        final int count = stack.getCount();
        for(int i=0; i<count; i++)
        {
            System.out.println(stack.getCount());
            System.out.print("popping");
            stack.pop();
            stack.display();
        }
    }
}
