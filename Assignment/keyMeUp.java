import java.util.*;



import java.io.*;

public class keyMeUp
{
    public static void main(String[] args)
    {
        if(args.length == 0 || args.length > 5)
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
                silentMode(KB, args[1], args[2], args[3]);
            break;

            default:
                System.out.println("Invalid command line argument");
                System.out.println("Enter either -i OR –s keyFile strFile pathFile ");
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

    public static void silentMode(DSAGraph KB, String keyFile, String strFile, String pathFile)
    {
        readFile(keyFile, KB);

    }

    public static void interactiveMode(DSAGraph KB)
    {
        Scanner sc = new Scanner(System.in);
        Boolean loop = true;
        String file, inputString = null, fileAlt = "basicNum.al";
        String output = "output.al", input;
        int choice;
        DSALinkedList breadthPath = new DSALinkedList();
        DSALinkedList depthPath = new DSALinkedList();
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
                    nodeOperations(KB);
                break; 

                case 3: //Edge operations (find, add, remove, update)
                    edgeOperations(KB);
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
                    sc.nextLine();
                    inputString = sc.nextLine();
                    inputString(inputString, KB);
                    do
                    {
                        inputString = sc.nextLine();
                        inputString(inputString, KB);
                    }while(inputString(inputString, KB)==false);
                break;

                case 7: //Generate paths
                    breadthPath = genBreadth(KB, inputString);
                    depthPath = genDepth(KB, inputString);
                break;

                case 8://Display path(s) (ranked, option to save)
                    displayPaths(KB, breadthPath, depthPath);
                    System.out.println("Save results? y/n");
                    input = sc.nextLine();
                    //save
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

    public static boolean inputString(String inputString, DSAGraph KB)
    {
        Boolean valid = true;
        String[] input = null;
        input = inputString.split("");
        for(int i=0; i<inputString.length();i++)
        {
            if(!KB.hasVertex(input[i]))
            {
                valid = false;
                System.out.println("Key does not exist");
            }
        }
        return valid;
    }
   
    public static void displayPaths(DSAGraph KB ,DSALinkedList breadthPath, DSALinkedList depthPath)
    {
        int bNum=0, dNum=0;
        String input;
        Iterator bIter = breadthPath.iterator();
        Iterator dIter = depthPath.iterator();

        System.out.println("Breadth First Search");
        do
        {
            DSAGraph.DSAGraphVertex vertex = (DSAGraph.DSAGraphVertex)bIter.next();
            System.out.print(vertex.getLabel() + "  ");
            bNum++;
        }while(bIter.hasNext());
        System.out.println("Total moves: " + bNum);
        System.out.println();

        System.out.println("Depth First Search");
        do
        {
            DSAGraph.DSAGraphVertex vertex = (DSAGraph.DSAGraphVertex)dIter.next();
            System.out.print(vertex.getLabel() + "  ");
            dNum++;
        }while(dIter.hasNext());
        System.out.println("Total moves: " + dNum);



    }

    public static DSALinkedList genBreadth(DSAGraph KB, String inputString)
    {
        String[] input = null;
        DSALinkedList path = new DSALinkedList();
        DSALinkedList totalPath = new DSALinkedList();
        input = inputString.split("");
        
        for(int i=0; i<input.length-1;i++)
        {
            path = breadth(KB, input[i], input[i+1]);
            Iterator iter = path.iterator();
            do
            {
                DSAGraph.DSAGraphVertex vertex = (DSAGraph.DSAGraphVertex)iter.next();
                totalPath.insertLast(vertex);
            }while(iter.hasNext());
        }
        return totalPath;
    }

    public static DSALinkedList genDepth(DSAGraph KB, String inputString)
    {
        String[] input = null;
        DSALinkedList path = new DSALinkedList();
        DSALinkedList totalPath = new DSALinkedList();
        input = inputString.split("");
        
        for(int i=0; i<input.length-1;i++)
        {
            path = depth(KB, input[i], input[i+1]);
            Iterator iter = path.iterator();
            do
            {
                DSAGraph.DSAGraphVertex vertex = (DSAGraph.DSAGraphVertex)iter.next();
                totalPath.insertLast(vertex);
            }while(iter.hasNext());
        }
        return totalPath;
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

        Iterator iter2 = KB.vertices.iterator();
        do
        {
            DSAGraph.DSAGraphVertex vert2 = (DSAGraph.DSAGraphVertex)iter2.next();
            vert2.clearVisited();

        }while(iter2.hasNext());

        if(KB.getVertex(vertex2)==null)
        {
            System.out.println("Its null bro");
            System.out.println(vertex2);
        }
        DSAGraph.DSAGraphVertex v = KB.getVertex(vertex2);

        Q.insertFirst(v);


        Iterator iter = T.iterator();
        do
        {
            DSAGraph.DSAGraphVertex w = (DSAGraph.DSAGraphVertex)iter.next();
            if(w.getVisited() == false && KB.isAdjacent(v.getLabel(), w.getLabel()))
            {
                Q.insertFirst(w);
                w.setVisited();
                if(w.getLabel().equals(vertex1))
                {
                    loop = false;
                }
                v = w;

            }
            

        }while(iter.hasNext() == true &&loop == true);

       
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

    public static void nodeOperations(DSAGraph KB)
    {
        Scanner sc = new Scanner(System.in);
        Object label, value;
        String find;
        int input;
        Boolean loop = true;
        do
        {
            nodeOpMenu();
            input = sc.nextInt();
            switch(input)
            {
                case 0:
                    loop = false;
                    
                case 1://Find
                    System.out.println("Enter a label");
                    find = sc.nextLine();
                    if(KB.getVertex(find)!=null)
                    {
                        System.out.println("Vertex found");
                    }
                    else
                    {
                        System.out.println("Vertex does not exit");
                    }
                break;

                case 2://Insert
                    System.out.println("Enter a label");
                    label = sc.nextLine();
                    System.out.println("Enter a value");
                    value = sc.nextLine();
                    System.out.println("Creating vertex...");
                    if(KB.getVertex(label)==null)
                    {
                        KB.addVertex(label, value);
                    }
                break;

                case 3://Delete

                break;

                case 4://Update

                break;

                default:

                break;
            }
        }while(loop);
        sc.close();
    }

    public static void nodeOpMenu()
    {
        System.out.println("Node Operations");
        System.out.println("================");
        System.out.println("0. Return to main menu");
        System.out.println("1. Find");
        System.out.println("2. Insert");
        System.out.println("3. Delete");
        System.out.println("4. Update");
    }

    public static void edgeOperations(DSAGraph KB)
    {
        Scanner sc = new Scanner(System.in);
        Object label, value;
        Object vert1, vert2;
        int input;
        Boolean loop = true;
        do
        {
            nodeOpMenu();
            input = sc.nextInt();
            switch(input)
            {
                case 0:
                    loop = false;
                    
                case 1://Find
                    System.out.println("Enter a label for vertex 1");
                    vert1 = sc.nextLine();
                    System.out.println("Enter a label for vertex 2");
                    vert2 = sc.nextLine();
                    if(KB.isAdjacent(vert1, vert2))
                    {
                        System.out.println("Edge from " + vert1 + " to " + vert2 + " found");
                    }
                    else
                    {
                        System.out.println("Vertex does not exit");
                    }
                break;

                case 2://Insert
                    System.out.println("Enter a label for vertex 1");
                    vert1 = sc.nextLine();
                    System.out.println("Enter a label for vertex 2");
                    vert2 = sc.nextLine();
                    if(KB.getVertex(vert1) != null && KB.getVertex(vert2) != null && KB.isAdjacent(vert1, vert2) == false)
                    {
                        System.out.println("Inserting edge from " + vert1 + " to " + vert2);
                        KB.addEdge(vert1, vert2);
                    }
                    else
                    {
                        System.out.println("Cannot insert edge there");
                    }
                    
                break;

                case 3://Delete

                break;

                case 4://Update

                break;

                default:

                break;
            }
        }while(loop);
        sc.close();
    }

    public static void edgeOpMenu()
    {
        System.out.println("Node Operations");
        System.out.println("================");
        System.out.println("0. Return to main menu");
        System.out.println("1. Find");
        System.out.println("2. Add");
        System.out.println("3. Remove");
        System.out.println("4. Update");
    }
    

}