
import java.util.*;
import java.io.*;

public class Q3A 
{
    public static void main(String[] args) throws PracExamException
    {
        Scanner sc = new Scanner(System.in);
        String inputFile = "6degrees.csv";
        String entry = "";
        Object value = "";

        int type;
        Q3HashTable table = new Q3HashTable(100);
        System.out.println(table.getArrayLength());


        System.out.println("Select an entry type:");
        System.out.println("    1. Movie Name");
        System.out.println("    2. Year");
        System.out.println("    3. Actor/Actress Name");
        System.out.println("    4. Role");
        type = sc.nextInt();
        readFile(inputFile, table, type);
        System.out.println(table.getArrayLength());
        System.out.println("Enter a string associated with chosen entry type");
        sc.nextLine();
        entry = sc.nextLine();
   
        table.get(entry);



        sc.close();
    }

    public static void readFile(String pFileName, Q3HashTable table, int type)
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
                processLine(line, table, type);
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

    private static void processLine(String csvRow, Q3HashTable table, int type)
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
        
        table.PutNew(key, value);
          
    }

    
}
