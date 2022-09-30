import java.util.*;

public class DSAGraph
{
    public DSALinkedList vertices;
    DSALinkedList edges;
    private int matrix[][];

    class DSAGraphVertex
    {
        private Object label, value;
        private DSALinkedList links;
        private Boolean visited;

        public DSAGraphVertex(Object inLabel, Object inValue)
        {
            links = new DSALinkedList();
            visited = false;
            label = inLabel;
            value = inLabel;

        }

        public void newLabel(Object newLabel)
        {
            label = newLabel;
        }

        public Object getLabel()
        {
            return label;
        }

        public Object getValue()
        {
            return value;
        }

        public DSALinkedList getAdjacent()
        {
            return links;
        }

        public void addEdge(DSAGraphVertex vertex)
        {
            links.insertLast(vertex);
        }

        public void setVisited()
        {
            visited = true;
        }

        public void clearVisited()
        {
            visited = false;

        }

        public Boolean getVisited()
        {
            return visited;
        }
    }

    class DSAGraphEdge
    {
        private DSAGraphVertex from, to;
        private Object label, value;

        public DSAGraphEdge(DSAGraphVertex fromVertex, DSAGraphVertex toVertex, Object inLabel, Object inValue)
        {
            from = fromVertex;
            to = toVertex;
            label = inLabel;
            value = inValue;
        }

        public Object getLabel()
        {
            return label;
        }

        public Object getValue()
        {
            return value;
        }

        public DSAGraphVertex getFrom()
        {
            return from;
        }

        public DSAGraphVertex getTo()
        {
            return to;
        }   

        public boolean isDirected()
        {
            if((getFrom() != null) || (getTo() != null))
            {
                return true;
            }
            return false;
        }

        public String toString()
        {
            String data = "";

            return data;
        }
    }

    public DSAGraph()
    {
        vertices = new DSALinkedList();
        edges = new DSALinkedList();
    }

    public void addVertex(Object label, Object value)
    {
        if(!hasVertex(label))
        {
            DSAGraphVertex vertex = new DSAGraphVertex(label, value);
        
            vertices.insertLast(vertex);
        }
    }

    public void removeVertex(Object label)
    {
        if(!hasVertex(label))
        {
            DSAGraphVertex vertex = (DSAGraphVertex)getVertex(label);
            
        
            Iterator iter = vertices.iterator();
            do
            {
                DSAGraphVertex vert = (DSAGraphVertex)iter.next();
                if(vert.equals(vertex))
                {
                    vert = null;
                }
                
            }while(iter.hasNext());
            vertex = null;
        }
    }

    public void editVertex(Object label, Object newLabel)
    {
        if(!hasVertex(label))
        {
            DSAGraphVertex vertex = (DSAGraphVertex)getVertex(label);
            
        
            Iterator iter = vertices.iterator();
            do
            {
                DSAGraphVertex vert = (DSAGraphVertex)iter.next();
                if(vert.equals(vertex))
                {
                    vert.newLabel(newLabel);
                }
                
            }while(iter.hasNext());
            vertex.newLabel(newLabel);
        }
    }

    public void addEdge(Object label1, Object label2)
    {
        DSAGraphEdge edge = new DSAGraphEdge(getVertex(label1), getVertex(label2), label1, label2);
        DSAGraphVertex vert1 = getVertex(label1);
        DSAGraphVertex vert2 = getVertex(label2);
        vert1.addEdge(vert2);
        //vert2.addEdge(vert1);
        edges.insertLast(edge);
    }

    public void removeEdge(Object label1, Object label2)
    {
        //DSAGraphEdge edge = new DSAGraphEdge(getVertex(label1), getVertex(label2), label1, label2);
        DSAGraphVertex vert1 = getVertex(label1);
        DSAGraphVertex vert2 = getVertex(label2);
    }

    public Boolean hasVertex(Object label)
    {
        DSAGraphVertex vert = getVertex(label);
        
        if(vert != null)
        {
            return true;
        }
        return false;
    }

 

    public int getVertexCount()
    {
        int count = 0;

        Iterator iter = vertices.iterator();

        while(iter.hasNext())
        {
            count++;
            iter.next();
        }

        return count;
    }

    public int getEdgeCount()
    {
        int count = 0;

        Iterator iter = edges.iterator();

        while(iter.hasNext())
        {
            count++;
            iter.next();
        }

        return count;
    }

    public DSAGraphVertex getVertex(Object label)
    {
        Iterator iter = vertices.iterator();
        DSAGraphVertex vertex = null;
        do
        {
            DSAGraphVertex vert = (DSAGraphVertex)iter.next();
            
            if(vert==null)
            {}
            else if(vert.getLabel().equals(label))
            {
                vertex = vert;
            }
        

        }while(iter.hasNext());
        return vertex;

    }

    public DSALinkedList getAdjacent(Object label)
    {
        Iterator iter = vertices.iterator();
        DSAGraphVertex vertex = getVertex(label);

        return vertex.links;
    }

    public Boolean isAdjacent(Object label1, Object label2)
    {
        DSAGraphVertex vert1 = getVertex(label1);
        DSAGraphVertex vert2 = getVertex(label2);
        
        Iterator iter = edges.iterator();
        while(iter.hasNext())
        {
            DSAGraphEdge edge = (DSAGraphEdge)iter.next();

            if((edge.getFrom()==vert1 && edge.getTo()==vert2))
            { 
                return true;
            }
        }
        return false;
    }

    public void displayAsList()
    {
        Iterator iter = vertices.iterator();
        DSAGraphVertex vertex = null;
        do
        {
            DSAGraphVertex vert = (DSAGraphVertex)iter.next();
            System.out.println("Vertex: " + vert.getLabel());
            System.out.println("Adjacent vertices:");
            DSAGraphVertex adj = null;
            Iterator iter2 = vert.links.iterator();
            do
            {
                DSAGraphVertex vert2 = (DSAGraphVertex)iter2.next();
                System.out.println(vert2.getLabel());
            }while(iter2.hasNext());
        }while(iter.hasNext());
    }

    public void displayAsMatrix()
    {
        int num = 0;
        matrix = new int[getVertexCount()][getVertexCount()];
        
        Object[] array1 = new Object[getVertexCount()];
        //Object[] array2 = new Object[getVertexCount()];

        Iterator iter = vertices.iterator();
        DSAGraphVertex vertex = null;
        System.out.println("Lookup");
        do
        {
            DSAGraphVertex vert = (DSAGraphVertex)iter.next();
            System.out.println(num+" " + vert.getLabel());
            array1[num] = vert.getLabel();
            num++;
        
        }while(iter.hasNext());
        System.out.println("\n");
        for(int i=0; i<getVertexCount(); i++)
        {
            for(int j=0; j<getVertexCount(); j++)
            {
                if(isAdjacent(array1[i], array1[j])==true)
                {
                    matrix[i][j] = 1;
                }
                else
                {
                    matrix[i][j] = 0;
                }
            }
        }

        for(int j=0;j<getVertexCount();j++)
        {
            for(int k=0;k<getVertexCount();k++)
            {
                System.out.print(matrix[j][k] + " ");
            }
            System.out.println("\n");
        }

    }

    public void depthFirstSearch(DSAGraph graph)
    {
        DSAQueue T = new DSAQueue();
        DSAStack S = new DSAStack();
       
        Iterator iter = vertices.iterator();
        do
        {
            DSAGraphVertex vert2 = (DSAGraphVertex)iter.next();
            vert2.clearVisited();
        }while(iter.hasNext());

        DSAGraphVertex v = (DSAGraphVertex)vertices.head.getValue();
       
        S.push(v);
        v.setVisited();
        

        do
        {
            Iterator iter2 = v.links.iterator();
            do
            {
                DSAGraphVertex w = (DSAGraphVertex)iter2.next();
                if(!w.getVisited())
                {
                    T.enqueue(v);
                    T.enqueue(w);
                    w.setVisited();
                    S.push(w);
                    v=w;
                }

            }while(iter2.hasNext());
            v = (DSAGraph.DSAGraphVertex) S.pop();

        }while(!S.isEmpty());

    }

    public void breadthFirstSearch()
    {
        DSAQueue T = new DSAQueue();
        DSAQueue Q = new DSAQueue();

        Iterator iter = vertices.iterator();
        do
        {
            DSAGraphVertex vert2 = (DSAGraphVertex)iter.next();
            vert2.clearVisited();

        }while(iter.hasNext());

        
        DSAGraphVertex v = (DSAGraphVertex)vertices.head.getValue();
       
        Q.enqueue(v);
        do
        {
            Iterator iter2 = v.links.iterator();
            v = (DSAGraph.DSAGraphVertex) Q.dequeue();
            do
            {
                DSAGraphVertex w = (DSAGraphVertex)iter2.next();
                if(!w.getVisited())
                {
                    T.enqueue(v);
                    T.enqueue(w);
                    w.setVisited();
                    Q.enqueue(w);
                }
            }while(iter2.hasNext());

        }while(!Q.isEmpty());

    }

    /*public DSAQueue breadthFirstSearchAlt(DSAGraph graph, Object vertex1, Object vertex2)
    {
        DSAQueue T = new DSAQueue();
        DSAQueue Q = new DSAQueue();
        Boolean loop = true;

        Iterator iter = graph.vertices.iterator();
        do
        {
            DSAGraphVertex vert2 = (DSAGraphVertex)iter.next();
            vert2.clearVisited();

        }while(iter.hasNext());

        
        DSAGraphVertex v = graph.getVertex(vertex1);
       
        Q.enqueue(v);
        do
        {
            Iterator iter2 = v.links.iterator();
            v = (DSAGraph.DSAGraphVertex) Q.dequeue();
            do
            {
                DSAGraphVertex w = (DSAGraphVertex)iter2.next();
                
                if(!w.getVisited())
                {
                    T.enqueue(v);
                    T.enqueue(w);
                    w.setVisited();
                    Q.enqueue(w);
                }
                if(w.equals(vertex2))
                {
                    loop = false;
                }
            }while(iter2.hasNext() && loop == true);

        }while(!Q.isEmpty());
        return T;
    }*/


    

}
