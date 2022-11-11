import java.util.*;
import java.io.*;

public class Q3B 
{
    public static void main(String[] args) throws PracExamException
    {
        Scanner sc = new Scanner(System.in);
        String inputFile = "6degrees.csv";
        String entry = "";
        Object value = "";
        Object[] arr = new Object[1000];
        int type;
        Q3BSTree tree = new Q3BSTree("1", 1);


        System.out.println("Select an entry type:");
        System.out.println("    1. Movie Name");
        System.out.println("    2. Year");
        System.out.println("    3. Actor/Actress Name");
        System.out.println("    4. Role");
        type = sc.nextInt();
        readFile(inputFile, tree, type);
        System.out.println("Enter a string associated with chosen entry type");
        sc.nextLine();
        entry = sc.nextLine();
        long startTime = System.nanoTime();
        arr = tree.inOrderFind(entry);
        long endTime = System.nanoTime();
        int runningTotal = (int)((double)(endTime - startTime) / 1000.0);
        for(int i=0; i<1000; i++)
        {
            if(arr[i]!=null)
            {
                System.out.println(arr[i]);
            }
        }
        System.out.println("Time taken (ms): " + runningTotal);
        //tree.postOrder();



        sc.close();
    }

    public static void readFile(String pFileName, Q3BSTree tree, int type)
    {
        
        FileInputStream fileStream = null;
        InputStreamReader isr;
        BufferedReader bufRdr;
        int lineNum;
        String line;
        try
        {
            fileStream = new FileInputStream(pFileName);
            isr = new InputStreamReader(fileStream);
            bufRdr = new BufferedReader(isr);
            lineNum = 0;
            line = bufRdr.readLine();
            while(line != null)
            {
                
                //System.out.println(line);
                processLine(line, tree, type);
                lineNum++;
                line = bufRdr.readLine();
            }
            fileStream.close();
        }
        catch(IOException errorDetails)
        {
        if(fileStream != null)
        {
            try
            {
                fileStream.close();
            }
            catch(IOException ex2)
            { }
        }
        System.out.println("Error in fileProcessing: " + errorDetails.getMessage());
        }
    
    }

    private static void processLine(String csvRow, Q3BSTree tree, int type)
    {
        Object value = null;
        String key = "";
        String[] splitLine;
        splitLine = csvRow.split(",");
        int lineLength = splitLine.length;

        switch(type)
        {
            case 1:
                key = splitLine[0];
                value = csvRow;
            break;
                
            case 2:
                key = splitLine[1];
                value = csvRow;
            break;

            case 3:
                key = splitLine[3];
                value = csvRow;
            break;
                
            case 4:
                key = splitLine[5];
                value = csvRow;
            break;
        }
        
        tree.insert(key, value);
    }
}
