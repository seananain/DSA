import java.util.*;
import java.io.*;

public class Q4 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String inputFile = "RandomNames7000 copy.csv";
        String outputFile = "output.csv";
        char choice1, choice2;
        DSAHashTable table = new DSAHashTable();

        System.out.println("Read file? y/n");
        choice1 = sc.next().charAt(0);
        if(choice1 == 'y')
        {
            readFile(inputFile, table);
        }
        System.out.println("Save table? y/n");
        choice2 = sc.next().charAt(0);
        if(choice2 == 'y')
        {
            writeFile(outputFile, table);
        }



        sc.close();
    }

    public static void readFile(String pFileName, DSAHashTable table)
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
                processLine(line, table);
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

    private static void processLine(String csvRow, DSAHashTable table)
    {
        Object value;
        String key;
        String[] splitLine;
        splitLine = csvRow.split(",");
        int lineLength = splitLine.length;
        key = splitLine[0];
        value = splitLine[1];
      
        table.put(key, value);
         
        
        
        
    }

    public static void writeFile(String pFileName, DSAHashTable table)
    {
        String output;
        FileOutputStream fileStrm = null;
        PrintWriter pw;
        try
        {
            fileStrm = new FileOutputStream(pFileName);
            pw = new PrintWriter(fileStrm);
            for(int i=0; i<table.hashArray.length;i++)
            {
                pw.println(table.hashArray[i].getKey() + "," + table.hashArray[i].getValue());
            }
            pw.close();
        } catch (IOException e) 
        {
            System.out.println("Error in writing to file" + e.getMessage());
        }
    }

}
