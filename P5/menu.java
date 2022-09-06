import java.util.*;
import java.io.*;

public class menu 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        DSABinarySearchTree bst = new DSABinarySearchTree("2", 2);
        String serfile = "file.ser";

        String key, find;
        Object value;
        int choice, choice2;
        Boolean loop = true, loop2 = true;

        try
        {
            do
            {
                menu();
                choice = sc.nextInt();
                
                switch(choice)
                {
                    case 0:
                        System.out.println("Exiting...");
                        loop = false;
                    break;

                    case 1:
                        System.out.println("Insert: Enter key...");
                        sc.nextLine();
                        key = sc.nextLine();
                        System.out.println("Enter value...");
                        value = sc.nextLine();
                        bst.insert(key, value);
                    break;

                    case 2:
                        System.out.println("Display Tree");
                        do
                        {
                            menu2();
                            choice2 = sc.nextInt();
                            switch(choice2)
                            {
                                case 0:
                                    loop2 = false;
                                break;

                                case 1:
                                    System.out.println("Pre-Order Traversal");
                                    bst.preOrder();
                                break;

                                case 2:
                                    System.out.println("In-Order Traversal");
                                    bst.inOrder();
                                break;

                                case 3:
                                    System.out.println("Post-Order Traversal");
                                    bst.postOrder();
                                break;
                            }
                        }while(loop2 == true);
                    break;

                    case 3:
                        System.out.println("Deleting value: Enter something...");
                        sc.nextLine();
                        find = sc.nextLine();
                        bst.delete(find);
                    break;

                    case 4:
                        System.out.println("Read from a CSV file");
                        
                    break;

                    case 5:
                        System.out.println("Write to a CSV file");
                        
                        
                    break;

                    case 6:
                        System.out.println("Read from a serial file");
                        bst = load(serfile);
                    break;

                    case 7:
                        System.out.println("Write to a serial file");
                        save(bst, serfile);
                    break;


                }
            }while(loop == true);
        }catch(Error e)
        {
            throw new InputMismatchException("invalid input");
        }






        sc.close();
    }

    public static void menu()
    {
        System.out.println("Select an option from below");
        System.out.println("==================");
        System.out.println("0. Exit");
        System.out.println("1. Insert");
        System.out.println("2. Display tree");
        System.out.println("3. Delete");
        System.out.println("4. Read from a CSV file");
        System.out.println("5. Write to a CSV file");
        System.out.println("6. Read from a serial file");
        System.out.println("7. Write to a serial file");
    }

    public static void menu2()
    {
        System.out.println("Choose a traversal method from below");
        System.out.println("0. Return");
        System.out.println("1. Pre-Order");
        System.out.println("2. In-Order");
        System.out.println("3. Post-Order");
    }

    public static void save(DSABinarySearchTree objToSave, String filename)
    {
        FileOutputStream fileStrm;
        ObjectOutputStream objStrm;
        try {
            fileStrm = new FileOutputStream(filename); 
            objStrm = new ObjectOutputStream(fileStrm); 
            objStrm.writeObject(objToSave); 
            
            objStrm.close(); 
        }
        catch (Exception e) { 
        throw new IllegalArgumentException("Unable to save object to file");
        }
    } 

    public static DSABinarySearchTree load(String filename) throws IllegalArgumentException
    {
        FileInputStream fileStrm;
        ObjectInputStream objStrm;
        DSABinarySearchTree inObj = new DSABinarySearchTree();
        try 
        {
            fileStrm = new FileInputStream(filename);
            objStrm = new ObjectInputStream(fileStrm); 
            inObj = (DSABinarySearchTree)objStrm.readObject(); 
            objStrm.close(); 
        }
        catch (ClassNotFoundException e) 
        {
            System.out.println("Class ContainerClass not found" + e.getMessage());
        }
        catch (Exception e) 
        {
            throw new IllegalArgumentException("Unable to load object from file");
        }
        return inObj;
    }
}
