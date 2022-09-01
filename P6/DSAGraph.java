import java.util.*;

public class DSAGraph
{
    DSALinkedList vertices;
    DSALinkedList edges;

    private class DSAGraphVertex
    {
        private Object label, value;
        private DSALinkedList links;
        private DSALinkedList visited;

        public DSAGraphVertex(Object inLabel, Object inValue)
        {

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

        }

        public void setVisited()
        {

        }

        public void clearVisited()
        {

        }

        public Boolean getVisited()
        {
            return true;
        }
    }

    private class DSAGraphEdge
    {
        private DSAGraphVertex from, to;
        private Object label, value;

        public DSAGraphEdge(DSAGraphVertex fromVertex, DSAGraphVertex toVertex, Object inLabel, Object inValue)
        {

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

    }

    public void addVertex(Object label, Object value)
    {
        DSAGraphVertex vertex = new DSAGraphVertex(label, value);
        vertices.insertLast(vertex);
    }

    public void addEdge(Object label1, Object label2)
    {
        DSAGraphEdge edge = new DSAGraphEdge(getVertex(label1), getVertex(label2), label1, label2);
        DSAGraphVertex vert1 = getVertex(label1);
        DSAGraphVertex vert2 = getVertex(label2);
        vert1.addEdge(vert2);
        vert2.addEdge(vert1);
        edges.insertLast(edge);
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

    public DSAGraphVertex getVertex(Object label)
    {
        Iterator iter = vertices.iterator();
        DSAGraphVertex vertex = null;
        while(iter.hasNext())
        {
            DSAGraphVertex vert = (DSAGraphVertex)iter.next();
            
            if(vert.getLabel().equals(label))
            {
                return vert;
            }
        

        }
        return vertex;

    }

    public DSALinkedList getAdjacent(Object label)
    {
        Iterator iter = vertices.iterator();
        DSAGraphVertex vertex = getVertex(label);
        return vertex.getAdjacent();

    }

    public Boolean isAdjacent(Object label1, Object label2)
    {
        DSAGraphVertex vert1 = getVertex(label1);
        DSAGraphVertex vert2 = getVertex(label2);
        
        Iterator iter = edges.iterator();
        while(iter.hasNext())
        {
            DSAGraphEdge edge = (DSAGraphEdge)iter.next();

            if((edge.getFrom()==vert1 && edge.getTo()==vert2) || (edge.getTo()==vert1 && edge.getFrom()==vert2))
            {
                return true;
            }
        }
        return false;
    }

    public void displayAsList()
    {

    }

    public void displayAsMatrix()
    {

    }

    

}
