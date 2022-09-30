import java.util.*;

import javax.print.event.PrintEvent;

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
                if(args.length==4)
                {
                    silentMode(KB, args[1], args[2], args[3]);
                }
                else
                {
                    System.out.println("Invalid number of command line arguments");
                }
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
        DSALinkedList breadthPath = new DSALinkedList();
        DSALinkedList depthPath = new DSALinkedList();        
        readFile(keyFile, KB);
        String inputString = readFile2(strFile);
        breadthPath = genBreadth(KB, inputString);
        depthPath = genDepth(KB, inputString);
        writeResults(pathFile, KB, breadthPath, depthPath, inputString);
    }

    public static void interactiveMode(DSAGraph KB)
    {
        Scanner sc = new Scanner(System.in);
        Boolean loop = true, valid = false;
        String file, inputString = null, fileAlt = "numPad.al", resultsFile = "results.txt";
        String output = "output.al", input;
        char save;
        int choice;
        DSALinkedList breadthPath = new DSALinkedList();
        DSALinkedList depthPath = new DSALinkedList();
        do
        {
            menu();
            choice = sc.nextInt();
            
            switch(choice)
            {
                case 0://Exit
                    System.out.println("Exiting");
                    loop = false;
                break;
                
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
                    System.out.println("Number of edges: " + KB.getEdgeCount());
                break;

                case 6: //Enter string for finding path
                    sc.nextLine();
                    do
                    {
                        System.out.println("Enter a string");
                        
                        inputString = sc.nextLine();
                        valid = inputStringValidation(inputString, KB);
                    }while(!valid);
                    //inputString = inputStringAltering(inputString, KB);
                break;

                case 7: //Generate paths
                    if(inputString == null)
                    {
                        System.out.println("No input string provided.");
                    }
                    else
                    {
                        breadthPath = genBreadth(KB, inputString);
                        depthPath = genDepth(KB, inputString);
                    }
                    
                break;

                case 8://Display path(s) (ranked, option to save)
                    if(breadthPath.isEmpty() || depthPath.isEmpty())
                    {
                        System.out.println("Paths have not been generated");
                    }
                    else
                    {
                        displayPaths(KB, breadthPath, depthPath, inputString);
                        System.out.println("Save results? y/n");
                        save = sc.next().charAt(0);
                        if(save=='y')
                        {
                            writeResults(resultsFile, KB, breadthPath, depthPath, inputString);
                        }
                    }
                    //save
                break;

                case 9: //Save keyboard
                    System.out.println("Saving keyboard...");
                    writeFile(output, KB);
                break;

                default:
                    System.out.println("Invalid input");
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

    public static void processLine(String csvRow, DSAGraph graph)
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
        for(int i=1; i<lineLength;i++)
        {
            if(!graph.hasVertex(splitLine[i]))
            {
                graph.addVertex(splitLine[i], splitLine[i]);
            }
            if(!graph.isAdjacent(vertex1, splitLine[i]))
            {
                graph.addEdge(vertex1, splitLine[i]);
            }
        }
        
         
        
        
        
    }

    public static String readFile2(String pFileName)
    {
        
        
        FileInputStream fileStream = null;
        InputStreamReader isr;
        BufferedReader bufRdr;
        int lineNum;
        String line;
        String finalString = "";
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
                finalString += line;
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
        return finalString;

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
                
                pw.print(vertex.getLabel());
                Iterator iter2 = vertex.getAdjacent().iterator();
                do
                {
                    DSAGraph.DSAGraphVertex adj = (DSAGraph.DSAGraphVertex)iter2.next();
                    pw.print(" "+adj.getLabel());
                    
                }while(iter2.hasNext());
                pw.println();
            }while(iter.hasNext());
            pw.close();
        } catch (IOException e) 
        {
            System.out.println("Error in writing to file" + e.getMessage());
        }
    }

    public static void writeResults(String pFileName, DSAGraph KB, DSALinkedList breadthPath, DSALinkedList depthPath, String inputString)
    {
        FileOutputStream fileStrm = null;
        PrintWriter pw;
        try
        {
            fileStrm = new FileOutputStream(pFileName);
            pw = new PrintWriter(fileStrm);
            

            int bNum=0, dNum=0, stringNum2 =-1, stringNum = -1;
            //String input;
            Iterator bIter = breadthPath.iterator();
            Iterator dIter = depthPath.iterator();
            DSAGraph.DSAGraphVertex Bprev = (DSAGraph.DSAGraphVertex)breadthPath.peekFirst();
            DSAGraph.DSAGraphVertex Dprev = (DSAGraph.DSAGraphVertex)depthPath.peekFirst();
            String[] input = inputStringAltering(inputString, KB);
            pw.println("Breadth First Search");
            do
            {
                DSAGraph.DSAGraphVertex vertex = (DSAGraph.DSAGraphVertex)bIter.next();
                if(vertex.equals(Bprev))
                {
                    pw.println();
                    stringNum++;
                }
                if(input[stringNum].equals("SHIFT"))
                {
                    pw.print(vertex.getLabel().toString().toUpperCase() + "  ");
                    
                }
                else
                {
                    pw.print(vertex.getLabel() + "  ");
                }
                
                Bprev = vertex;
                
                bNum++;
            }while(bIter.hasNext());
            pw.println();
            pw.println("Total moves: " + (bNum-input.length+1));
            pw.println();

            pw.println("Depth First Search");
            do
            {
                DSAGraph.DSAGraphVertex vertex = (DSAGraph.DSAGraphVertex)dIter.next();
                if(vertex.equals(Dprev))
                {
                    pw.println();
                    stringNum2++;
                }
                if(input[stringNum2].equals("SHIFT"))
                {
                    pw.print(vertex.getLabel().toString().toUpperCase() + "  ");
                    
                }
                else
                {
                    pw.print(vertex.getLabel() + "  ");
                }
                Dprev = vertex;
                dNum++;
            }while(dIter.hasNext());
            pw.println();
            pw.println("Total moves: " + (dNum-input.length+1));










            pw.close();
        } catch (IOException e) 
        {
            System.out.println("Error in writing to file" + e.getMessage());
        }
    }

    public static boolean inputStringValidation(String inputString, DSAGraph KB)
    {
        Boolean valid = true;
        char[] temp = inputString.toCharArray();
        String[] input = new String[temp.length];
        for(int i=0; i<temp.length;i++)
        {
            input[i] = Character.toString(temp[i]);
        }

        //input = inputString.split("");
        for(int i=0; i<input.length;i++)
        {
            if(!(input[i].equals(" ")))
            {
                if(KB.hasVertex(input[i].toLowerCase())==false)
                {
                    valid = false;
                    System.out.println("Key does not exist: " + input[i]);
                    
                }
            }
            
            
        }
        return valid;
    }

    public static String[] inputStringAltering(String inputString, DSAGraph KB)
    {
        int num = 0;
        String[] input = null;
        input = inputString.split("");

        DSALinkedList newString = new DSALinkedList();

        if(KB.getVertex("SHIFT") != null && KB.getVertex("SPACE") !=null)
        {
            for(int i=0; i<input.length; i++)
            {
                
                System.out.println(input[i]);
                if(input[i].equals(" "))
                {
                    newString.insertLast("SPACE");
                }
                else
                {
                    
                    if(Character.isUpperCase(input[i].charAt(0)))
                    {
                        newString.insertLast("SHIFT");
                        newString.insertLast(input[i].toLowerCase());
                    }
                    else
                    {
                        newString.insertLast(input[i]);
                    }
                }
                //newString.insertLast(" ");
                
            }
        }
        else if(KB.getVertex("SHIFT") == null && KB.getVertex("SPACE") !=null)
        {
            for(int i=0; i<input.length; i++)
            {
                
                System.out.println(input[i]);
                if(input[i].equals(" "))
                {
                    newString.insertLast("SPACE");
                }
                else
                {
                    newString.insertLast(input[i]);
                }
            }
        }
        else
        {
            for(int i=0; i<input.length; i++)
            {
                newString.insertLast(input[i]);
            }
        }
        Iterator iter = newString.iterator();
        do
        {
            String s = (String)iter.next();
          

            num++;
        }while(iter.hasNext());
        String[] finalString = new String[num];
        num =0;
        Iterator iter2 = newString.iterator();
        do
        {
            String s = (String)iter2.next();
            finalString[num] = s;

            num++;
        }while(iter2.hasNext());

        return finalString;
        
        
    }
   
    public static void displayPaths(DSAGraph KB ,DSALinkedList breadthPath, DSALinkedList depthPath, String inputString)
    {
        int bNum=0, dNum=0, stringNum2 =-1, stringNum = -1;
        //String input;
        Iterator bIter = breadthPath.iterator();
        Iterator dIter = depthPath.iterator();
        DSAGraph.DSAGraphVertex Bprev = (DSAGraph.DSAGraphVertex)breadthPath.peekFirst();
        DSAGraph.DSAGraphVertex Dprev = (DSAGraph.DSAGraphVertex)depthPath.peekFirst();
        String[] input = inputStringAltering(inputString, KB);
        System.out.println("Breadth First Search");
        do
        {
            DSAGraph.DSAGraphVertex vertex = (DSAGraph.DSAGraphVertex)bIter.next();
            if(vertex.equals(Bprev))
            {
                System.out.println();
                stringNum++;
            }
            if(input[stringNum].equals("SHIFT"))
            {
                System.out.print(vertex.getLabel().toString().toUpperCase() + "  ");
                
            }
            else
            {
                System.out.print(vertex.getLabel() + "  ");
            }
            
            
            Bprev = vertex;
            
            bNum++;
        }while(bIter.hasNext());
        System.out.println();
        System.out.println("Total moves: " + (bNum-input.length+1));
        System.out.println();

        System.out.println("Depth First Search");
        do
        {
            DSAGraph.DSAGraphVertex vertex = (DSAGraph.DSAGraphVertex)dIter.next();
            if(vertex.equals(Dprev))
            {
                System.out.println();
                stringNum2++;
            }
            if(input[stringNum2].equals("SHIFT"))
            {
                System.out.print(vertex.getLabel().toString().toUpperCase() + "  ");
                
            }
            else
            {
                System.out.print(vertex.getLabel() + "  ");
            }
            Dprev = vertex;
            dNum++;
        }while(dIter.hasNext());
        System.out.println();
        System.out.println("Total moves: " + (dNum-input.length+1));



    }

    public static DSALinkedList genBreadth(DSAGraph KB, String inputString)
    {
        String[] input = inputStringAltering(inputString, KB);
        //System.out.println(input[0] );
        DSALinkedList path = new DSALinkedList();
        DSALinkedList totalPath = new DSALinkedList();
        //input = inputString.split(" ");
        
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
        String[] input = inputStringAltering(inputString, KB);
        DSALinkedList path = new DSALinkedList();
        DSALinkedList totalPath = new DSALinkedList();
        //input = inputString.split(" ");
        
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
            
            v = (DSAGraph.DSAGraphVertex) Q.dequeue();
            Iterator iter2 = v.getAdjacent().iterator();

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
        Boolean loop = true, loop2 = true;

  

        
        DSAGraph.DSAGraphVertex v = KB.getVertex(vertex2);

        Q.insertFirst(v);


        do
        {
            //System.out.println("Looping");
            loop = true;
            Iterator iter = T.iterator();
            do
            {
                //System.out.println("Looping again");
                DSAGraph.DSAGraphVertex w = (DSAGraph.DSAGraphVertex)iter.next();
                if(KB.isAdjacent(w.getLabel(), v.getLabel()))
                {
                    Q.insertFirst(w);
                    if(w.getLabel().equals(vertex1))
                    {
                        loop2 = false;
                    }
                    v = w;
                    loop = false;
                }
            }while(iter.hasNext() && loop == true);
        }while(loop2 == true);
       

        

       
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
        Boolean loop = true, loop2 = true;
        DSAGraph.DSAGraphVertex v = KB.getVertex(vertex2);
        Q.insertFirst(v);
      
    
        

        do
        {
            loop = true;
            Iterator iter = T.iterator();
            do
            {
                DSAGraph.DSAGraphVertex w = (DSAGraph.DSAGraphVertex)iter.next();
                if(KB.isAdjacent(w.getLabel(), v.getLabel()))
                {
                    Q.insertFirst(w);
                    if(w.getLabel().equals(vertex1))
                    {
                        loop2 = false;
                    }
                    v = w;
                    loop = false;
                }
            }while(iter.hasNext() && loop == true);
        }while(loop2 == true);
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