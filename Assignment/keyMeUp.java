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
        String file, inputString, fileAlt = "basicNum.al";
        String output = "output.al";
        int choice;
        do
        {
            menu();
            choice = sc.nextInt();
            
            switch(choice)
            {
                case 1: //Load keyboard file
                    /*System.out.println("Enter file name");
                    sc.nextLine();
                    file = sc.nextLine();*/
                    readFile(fileAlt, KB);
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
                    genPaths(KB, "inputString");
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
        DSALinkedList path1 = new DSALinkedList();
        DSALinkedList path2 = new DSALinkedList();
        DSAQueue path12 = new DSAQueue();
      

        path1 = breadth(KB, "1", "9");
        path12 = breadthFirstSearchAlt(KB, "1", "9");

        Iterator iter = path1.iterator();
        System.out.println("Breadth first");
        do
        {
            DSAGraph.DSAGraphVertex vertex = (DSAGraph.DSAGraphVertex)iter.next();
            System.out.print(vertex.getLabel() + " -> ");
        }while(iter.hasNext());
        System.out.println();
        System.out.println();
        


        path2 = depth(KB, "1", "9");
        Iterator iter2 = path2.iterator();
        System.out.println("Depth first");
        
        do
        {
            DSAGraph.DSAGraphVertex vertex1 = (DSAGraph.DSAGraphVertex)iter2.next();
            System.out.print(vertex1.getLabel() + " -> ");
        }while(iter2.hasNext());
        System.out.println();



    }

    public static DSAQueue breadthFirstSearchAlt(DSAGraph graph, Object vertex1, Object vertex2)
    {
        DSAQueue T = new DSAQueue();
        DSAQueue Q = new DSAQueue();
        Boolean loop = true;

        Iterator iter = graph.vertices.iterator();
        do
        {
            DSAGraph.DSAGraphVertex vert2 = (DSAGraph.DSAGraphVertex)iter.next();
            vert2.clearVisited();

        }while(iter.hasNext());

        DSAGraph.DSAGraphVertex v = graph.getVertex(vertex1);
    
        Q.enqueue(v);
        v.setVisited();
        do
        {
            Iterator iter2 = v.getAdjacent().iterator();
            v = (DSAGraph.DSAGraphVertex) Q.dequeue();
            do
            {
                DSAGraph.DSAGraphVertex w = (DSAGraph.DSAGraphVertex)iter2.next();
                
                if(w.getVisited()==false)
                {
                    T.enqueue(v);
                    T.enqueue(w);
                    w.setVisited();
                    Q.enqueue(w);
                    if(w.getLabel().equals(vertex2))
                    {
                        loop = false;
                    }
                }
                
            }while(iter2.hasNext() && loop == true);

        }while(!Q.isEmpty() &&loop == true );
        return T;
    }

    public static DSALinkedList breadth(DSAGraph KB, Object vertex1, Object vertex2)
    {
        DSAQueue T = breadthFirstSearchAlt(KB, vertex1, vertex2);
        
        DSALinkedList Q = new DSALinkedList();
        Boolean loop = true;

        DSAGraph.DSAGraphVertex v = KB.getVertex(vertex2);

        Q.insertFirst(v);


        Iterator iter = T.iterator();
        do
        {
            DSAGraph.DSAGraphVertex w = (DSAGraph.DSAGraphVertex)iter.next();
            if(KB.isAdjacent(w.getLabel(), v.getLabel()))
            {
                Q.insertFirst(w);
                if(w.getLabel().equals(vertex1))
                {
                    loop = false;
                }
                v = w;

            }
            

        }while(iter.hasNext()&&loop == true);

       
        return Q;
    }

    public static DSAQueue depthFirstSearchAlt(DSAGraph graph, Object vertex1, Object vertex2)
    {
        DSAQueue T = new DSAQueue();
        DSAStack S = new DSAStack();
        Boolean loop = true;
        Iterator iter = graph.vertices.iterator();
        do
        {
            DSAGraph.DSAGraphVertex vert2 = (DSAGraph.DSAGraphVertex)iter.next();
            vert2.clearVisited();
        }while(iter.hasNext());

        DSAGraph.DSAGraphVertex v = (DSAGraph.DSAGraphVertex)graph.getVertex(vertex1);
       
        S.push(v);
        v.setVisited();
        

        do
        {
            Iterator iter2 = v.getAdjacent().iterator();
            do
            {
                DSAGraph.DSAGraphVertex w = (DSAGraph.DSAGraphVertex)iter2.next();
                if(!w.getVisited())
                {
                    T.enqueue(v);
                    T.enqueue(w);
                    w.setVisited();
                    S.push(w);
                    if(w.getLabel().equals(vertex2))
                    {
                        loop = false;
                    }
                    v=w;
                }

            }while(iter2.hasNext() && loop == true);
            v = (DSAGraph.DSAGraphVertex) S.pop();

        }while(!S.isEmpty()&&loop == true);
        return T;

    }

    public static DSALinkedList depth(DSAGraph KB, Object vertex1, Object vertex2)
    {
        DSAQueue T = depthFirstSearchAlt(KB, vertex1, vertex2);
        DSALinkedList Q = new DSALinkedList();
        Boolean loop = true;
        DSAGraph.DSAGraphVertex v = KB.getVertex(vertex2);
        Q.insertFirst(v);
        Iterator iter = T.iterator();
        do
        {
            DSAGraph.DSAGraphVertex w = (DSAGraph.DSAGraphVertex)iter.next();
            if(KB.isAdjacent(w.getLabel(), v.getLabel()))
            {
                Q.insertFirst(w);
                if(w.getLabel().equals(vertex1))
                {
                    loop = false;
                }
                v = w;
            }
        }while(iter.hasNext()&&loop == true);
        return Q;
    }

    public static DSALinkedList dfsRecWrapper(DSAGraph KB, Object vertex1, Object vertex2)
    {
        DSALinkedList L = new DSALinkedList();
    }
    
    public static void dfsRec(DSAGraph KB, Object starting, Object vertex2, DSALinkedList L)
    {

    }

}