import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.*;


public class DSAGraphTest extends DSAGraph
{
    DSAGraph g = new DSAGraph();

    @Test
    public void testAddVertex()
    {
        g.addVertex("label", "value");

        Object label = g.getVertex("label").getLabel();

        assertEquals("label", g.getVertex("label").getLabel());
    }

    @Test 
    public void testAddEdge()
    {
        g.addVertex("label", "value");
        g.addVertex("label2", "value2");

        g.addEdge("label", "label2");
    }

    @Test
    public void testHasVertex()
    {
        assertFalse(hasVertex("label"));
    }

    @Test
    public void testGetVertexCount()
    {
        g.addVertex("label", "value");
        g.addVertex("label2", "value2");

        assertEquals(2, g.getVertexCount());
    }

    @Test
    public void testGetVertex()
    {
        g.addVertex("label", "value");
        g.addVertex("label2", "value2");

        DSAGraphVertex vert = g.getVertex("label");
        assertEquals("label", vert.getLabel());
    }

    @Test
    public void testGetAdjacent()
    {
        g.addVertex("label", "value");
        g.addVertex("label2", "value2");

        g.addEdge("label", "label2");

        DSALinkedList links = g.getAdjacent("label");
        assertEquals("label2", ((DSAGraphVertex) links.head.getValue()).getLabel()); 
    }

    @Test
    public void testIsAdjacent()
    {
        g.addVertex("label", "value");
        g.addVertex("label2", "value2");

        g.addEdge("label", "label2");

        assertTrue(g.isAdjacent("label", "label2"));
    }


}
