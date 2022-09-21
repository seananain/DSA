import java.util.*;



import java.io.*;

public class keyMeUp
{
    public static void main(String[] args)
    {
        if(args.length == 0 || args.length > 1)
        {
            throw new Error("invalid number of command line arguments");
        }
        Scanner sc = new Scanner(System.in);
        String mode = args[0];
        

        DSAGraph KB = new DSAGraph();

        switch(mode)
        {
            case "-i":
                
              
                interactiveMode(KB);
            break;

            case "-s":

            break;

            default:
                System.out.println("Invalid command line argument");
            break;
        }

        sc.close();
    }



    public static void menu()
    {
        System.out.println("Main Menu");
        System.out.println("==============");
        System.out.println("1. Load keyboard file");
        System.out.println("2. Node operations (find, insert, delete, update)");
        System.out.println("3. Edge operations (find, add, remove, update)");
        System.out.println("4. Display graph");
        System.out.println("5. Display graph information");
        System.out.println("6. Enter string for finding path");
        System.out.println("7. Generate paths");
        System.out.println("8. Display path(s) (ranked, option to save)");
        System.out.println("9. Save keyboard");
    }

    public static void interactiveMode(DSAGraph KB)
    {
        Scanner sc = new Scanner(System.in);
        Boolean loop = true;
        String file, inputString;
        String output = "output.al";
        int choice;
        do
        {
            menu();
            choice = sc.nextInt();
            
            switch(choice)
            {
                case 1: //Load keyboard file
                    System.out.println("Enter file name");
                    sc.nextLine();
                    file = sc.nextLine();
                    readFile(file, KB);
                break;

                case 2: //Node operations (find, insert, delete, update)

                break; 

                case 3: //Edge operations (find, add, remove, update)

                break;

                case 4: // Display graph
                    System.out.println("List:");
                    KB.displayAsList();
                    System.out.println();
                    System.out.println("As matrix");
                    KB.displayAsMatrix();
                    
                break;

                case 5: //Display graph information
                    System.out.println("Graph Information");
                    System.out.println("Number of vertices: " + KB.getVertexCount());
                break;

                case 6: //Enter string for finding path
                    inputString = sc.nextLine();
                break;

                case 7: //Generate paths

                break;

                case 8://Display path(s) (ranked, option to save)

                break;

                case 9: //Save keyboard
                    System.out.println("Saving keyboard...");
                    writeFile(output, KB);
                break;

                default:

                break;
            }
        }while(loop);
        sc.close();
    }

    public static void readFile(String pFileName, DSAGraph KB)
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
                processLine(line, KB);
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
        if(!graph.hasVertex(vertex1))
        {
            graph.addVertex(vertex1, vertex1);
        }
         
        if(!graph.hasVertex(vertex2))
        {
            graph.addVertex(vertex2, vertex2);
        }
        
        if(!graph.isAdjacent(vertex1, vertex2))
        {
            graph.addEdge(vertex1, vertex2);
        }
    }

    public static void writeFile(String pFileName, DSAGraph KB)
    {
        String output;
        FileOutputStream fileStrm = null;
        PrintWriter pw;
        try
        {
            fileStrm = new FileOutputStream(pFileName);
            pw = new PrintWriter(fileStrm);
            Iterator iter = KB.vertices.iterator();
            do
            {
                DSAGraph.DSAGraphVertex vertex = (DSAGraph.DSAGraphVertex)iter.next();
                Iterator iter2 = vertex.getAdjacent().iterator();
                do
                {
                    DSAGraph.DSAGraphVertex adj = (DSAGraph.DSAGraphVertex)iter2.next();
                    pw.println(vertex.getLabel()+" "+adj.getLabel());
                }while(iter2.hasNext());
            }while(iter.hasNext());
            pw.close();
        } catch (IOException e) 
        {
            System.out.println("Error in writing to file" + e.getMessage());
        }
    }

    public static void genPaths(DSAGraph KB, String inputString)
    {
        char[] input = inputString.toCharArray();

        for(int i=0; i<input.length; i++)
        {
            //input[i];
        }

    }

    
}