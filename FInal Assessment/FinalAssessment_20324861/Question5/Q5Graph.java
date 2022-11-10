/**
 * DSA Final Assessment Question 5 - Q5Graph.java                             4
 *
 * Name : Sean Anain
 * ID   : 20324861
 *
 **/
import java.util.*;
import java.io.*;

public class Q5Graph 
{
    private int maxsize;
    private int wmatrix[][];
    private String labels[];
    private int values[];
    private int vertexCount;

    public Q5Graph() 
    {
        maxsize = 20;
        wmatrix = new int[maxsize][maxsize];
        labels = new String[maxsize];
        values = new int[maxsize];
        for(int i=0; i < maxsize; i++)
            for (int j=0; j< maxsize; j++)
            { 
                wmatrix[i][j] = 0;
            }
        vertexCount = 0;
    }

    public void addVertex(String label, int value)
    {
        if (vertexCount == maxsize)
        {
            // do nothing, but should throw exception
        }
        else if (!(hasVertex(label))) 
        {
            labels[vertexCount] = label;
            values[vertexCount] = value;
            vertexCount++;
        }
    }

    public void addEdge(String label1, String label2, int weight)
    {
        int v1, v2;

        v1 = getIndex(label1); 
        v2 = getIndex(label2);   

        
        if(v1 >= 0 && v2>= 0)
        {
            wmatrix[v1][v2] = weight;
        }   
    }

    public boolean hasEdge(String label1, String label2)
    {
        int v1, v2;
        boolean hasEdge = false;
        v1 = getIndex(label1); 
        v2 = getIndex(label2);
        if(v1 >= 0 && v2>= 0)
        {
            if(wmatrix[v1][v2]!=0)
            {
                hasEdge = true;
            }
        }   
        
        return hasEdge;
    }

    public boolean hasVertex(String label) 
    {
        boolean has = false;
        for (int i=0; i < vertexCount; i++) 
        {
           if (labels[i].equals(label))
                has = true;
        }
        return has;
    }

    public int getIndex(String label) 
    {
        int theVertex = -1;
        for (int i=0; i < vertexCount; i++) 
            {
            if (labels[i].equals(label))
                theVertex = i;
            }
	return theVertex;    
	}

    public void displayAsList() 
    {
		System.out.println("Adjacency List display (stub)");
    }

	// put your methods here

    public static void loadGraph(String pFileName, Q5Graph graph) 
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
                processLine(line, graph);
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

    public static void processLine(String csvRow, Q5Graph graph)
    {
        String movie, actor, role;
        String[] splitLine;
        splitLine = csvRow.split(",");
        int lineLength = splitLine.length;
        movie = splitLine[0];
        actor = splitLine[3];
        role = splitLine[5];

        if(!graph.hasVertex(movie))
        {
            graph.addVertex(movie, 1);
        }

        if(!graph.hasVertex(actor))
        {
            graph.addVertex(actor, 2);
        }

        if(!graph.hasVertex(role))
        {
            graph.addVertex(role, 3);
        }

        if(!graph.hasEdge(movie, actor) && !graph.hasEdge(actor, movie))
        {
            graph.addEdge(actor, movie, 1);
            graph.addEdge(movie, actor, 1);
        }

        if(!graph.hasEdge(movie, role) && !graph.hasEdge(role, movie))
        {
            graph.addEdge(movie, role, 1);
            graph.addEdge(role, movie, 1);
        }

        if(!graph.hasEdge(actor, role) && !graph.hasEdge(role, actor))
        {
            graph.addEdge(actor, role, 1);
            graph.addEdge(role, actor, 1);
        }
        
    }


    public void displayMovies()
    {
        for(int i=0; i<vertexCount; i++)
        {
            if(values[i] == 1)
            {
                System.out.println(labels[i]);
            }
        }
    }

    public void displayActors()
    {
        for(int i=0; i<vertexCount; i++)
        {
            if(values[i] == 2)
            {
                System.out.println(labels[i]);
            }
        }
    }

    public void displayRoles()
    {
        for(int i=0; i<vertexCount; i++)
        {
            if(values[i] == 3)
            {
                System.out.println(labels[i]);
            }
        }
    }

    public void displayActorsMovies()
    {
        for(int i=0; i<vertexCount; i++)
        {
            if(values[i] == 2)
            {
                System.out.println();
                System.out.println("Actor: " + labels[i]);
                System.out.println("Movies:");
            }
            for(int j=0; j<vertexCount; j++)
            {
                if(wmatrix[i][j]==1 && values[j] == 1)
                {
                    System.out.println(labels[j]);
                }
            }
        }
    }

    public void displayMovieActors()
    {
        for(int i=0; i<vertexCount; i++)
        {
            if(values[i] == 1)
            {
                System.out.println();
                System.out.println("Movie: " + labels[i]);
                System.out.println("Actors:");
            }
            for(int j=0; j<vertexCount; j++)
            {
                if(wmatrix[i][j]==1 && values[j] == 2)
                {
                    System.out.println(labels[j]);
                }
            }
        }
    }

    public void displayCostars()
    {
        for(int i=0; i<vertexCount; i++)
        {
            if(values[i] == 2)
            {
                System.out.println();
                System.out.println("Costars for " + labels[i]);
            }
            for(int j=0; j<vertexCount; j++)
            {
                if(wmatrix[i][j]==1 && values[j] == 1)
                {
                    System.out.println(labels[j]);
                    for(int k=0; k<vertexCount; k++)
                    {
                        if(wmatrix[j][k]==1 && values[k] == 2 && labels[k]!=labels[i])
                        {
                            System.out.println("    "+labels[k]);
                        }
                    }
                }
            }
        }
    }


    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Q5Graph graph = new Q5Graph();
        String fileName = "sampleData.csv";
        loadGraph(fileName, graph);
        System.out.println("Movies:");
        graph.displayMovies();
        System.out.println();

        System.out.println("Actors:");
        graph.displayActors();
        System.out.println();


        System.out.println("Roles:");
        graph.displayRoles();
        System.out.println();

        graph.displayActorsMovies();

        graph.displayMovieActors();

        graph.displayCostars();
        
        sc.close();
    }


}  
