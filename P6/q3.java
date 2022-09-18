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
        System.out.println("2. prac6_2.al");
        choice = sc.nextInt();


        try
        {
            switch(choice)
            {
                case 1:
                    graph = readFile(file1);
                    graph.displayAsList();
                break;

                case 2:
                    graph = readFile(file2);
                    graph.displayAsMatrix();
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
                //System.out.println(line);
                processLine(line, graph);
                
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
        return graph;
    }

    private static void processLine(String csvRow, DSAGraph graph)
    {
        Object vertex1, vertex2;
        String v1, v2;
        String[] splitLine;
        splitLine = csvRow.split(" ");
        int lineLength = splitLine.length;
        v1 = splitLine[0];
        v2 = splitLine[1];
        //System.out.println(splitLine[0] + splitLine[1]);

        vertex1 = v1;
        vertex2 = v2;
        graph.addVertex(vertex1, vertex1);
        graph.addVertex(vertex2, vertex2);
        graph.addEdge(vertex1, vertex2);
       
        
    }
}
