import java.util.*;

public class Q5 
{
    public static void main(String args[])
	{
        Scanner sc = new Scanner(System.in);
        Boolean loop = true;
        int choice;
        String in;

        DSALinkedList list = new DSALinkedList();



        menu();

        choice = sc.nextInt();

        try
        {
            do
            {
                switch(choice)
                {
                    case 0:
                        System.out.println("Exiting...");
                        loop = false;
                    break;

                    case 1:
                        System.out.println("Insert First: Enter something...");
                        in = sc.nextLine();
                        list.insertFirst(in);
                    break;

                    case 2:
                        System.out.println("Insert Last: Enter something...");
                        in = sc.nextLine();
                        list.insertLast(in);
                    break;

                    case 3:
                        System.out.println("Removing first value: " + list.peekFirst());
                        list.removeFirst();
                    break;

                    case 4:
                        System.out.println("Removing last value: " + list.peekLast());
                        list.removeLast();
                    break;

                    case 5:
                        
                    break;

                    case 6:

                    break;

                    case 7:

                    break;


                }
            }while(loop == true);
        }catch(Error e)
        {
            throw new InputMismatchException("invalid input");
        }
    }

    public static void menu()
    {
        System.out.println("Select an option from below");
        System.out.println("==================");
        System.out.println("0. Exit");
        System.out.println("1. Insert First");
        System.out.println("2. Insert Last");
        System.out.println("3. Remove First");
        System.out.println("4. Remove Last");
        System.out.println("5. Display List");
        System.out.println("6. Read from a file");
        System.out.println("7. Write from a file");
    }


}
