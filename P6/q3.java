import java.util.*;
import java.io.*;


public class q3 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        String file1 = "prac6_1.al", file2 = "prac6_2.al";

        DSAGraph graph = new DSAGraph();


        int choice;
        System.out.println("Choose which file to read into graph...");
        System.out.println("1. prac6_1.al");
        System.out.println("2, prac6_2.al");
        choice = sc.nextInt();


        try
        {
            switch(choice)
            {
                case 1:
                    graph = readFile(file1);
                break;

                case 2:
                    graph = readFile(file1);
                break;


            }
        }catch(Error e)
        {
            throw new InputMismatchException();
        }











        sc.close();
    }

    public static DSAGraph readFile(String pFileName)
    {
        DSAGraph graph = new DSAGraph();
        
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
                lineNum++;
                System.out.println(line);
                processLine(line, bst);
                
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
        return bst;
    }

    private static void processLine(String csvRow, DSAGraph graph)
    {
        String[] splitLine;
        splitLine = csvRow.split(",");
        int lineLength = splitLine.length;
        String temp1 = splitLine[1];
        Object o = temp1;
        /*for(int i = 0; i < lineLength; i++)
        {
            System.out.print(splitLine[i] + " ");
            String temp = splitLine[1];
            String temp1 = splitLine[0];
            Object o = temp;
            bst.insert(splitLine[0], temp);
            
        }*/
        bst.insert(splitLine[0], temp1);
        System.out.println("");
    }
}
