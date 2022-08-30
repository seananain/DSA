import java.io.*;
import java.util.*;

public class Q5 //implements Serializable
{
    public static void main(String args[])
	{
        Scanner sc = new Scanner(System.in);
        Boolean loop = true;
        int choice;
        String in;
        String output = "out.txt";

        DSALinkedList list = new DSALinkedList();


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
                        System.out.println("Insert First: Enter something...");
                        sc.nextLine();
                        in = sc.nextLine();
                        list.insertFirst(in);
                    break;

                    case 2:
                        System.out.println("Insert Last: Enter something...");
                        sc.nextLine();
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
                        System.out.println("Displaying List");
                        list.Display(list);
                        
                    break;

                    case 6:
                        System.out.println("Reading file...");
                    break;

                    case 7:
                        System.out.println("Saving to file...");
                        save(list, output);
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
        System.out.println("1. Insert First");
        System.out.println("2. Insert Last");
        System.out.println("3. Remove First");
        System.out.println("4. Remove Last");
        System.out.println("5. Display List");
        System.out.println("6. Read from a file");
        System.out.println("7. Write to a file");
    }


    public static void save(DSALinkedList objToSave, String filename)
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

    

    /*public static void save(String filename, DSALinkedList list)
    {
        FileOutputStream fileStrm;
        ObjectOutputStream objStrm;
        Iterator iter =  list.iterator();
        try 
        {
            fileStrm = new FileOutputStream(filename);
            objStrm = new ObjectOutputStream(fileStrm); 
            do
            {
                objStrm.writeObject(iter.next());
            }while(iter.hasNext());

            //objStrm.writeObject(list.peekFirst());
            
            
            objStrm.close(); 
            //fileStrm.close();
        }
        catch (Exception e) 
        { 
            throw new IllegalArgumentException("Unable to save object to file");
        }
    }*/

    /*private DSALinkedList load(String filename) throws IllegalArgumentException
    {
        FileInputStream fileStrm;
        ObjectInputStream objStrm;
        DSALinkedList inObj;
        try 
        {
            fileStrm = new FileInputStream(filename);
            objStrm = new ObjectInputStream(fileStrm); 
            inObj = (DSALinkedList)objStrm.readObject(); 
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
    }*/

}
