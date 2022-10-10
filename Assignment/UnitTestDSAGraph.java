import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.*;


public class UnitTestDSAGraph extends DSAGraph
{
    DSAGraph g = new DSAGraph();

    @Test
    public void testAddVertex()
    {
        g.addVertex("label", "value");

        Object label = g.getVertex("label").getLabel();
        assertTrue("Vertex exists", g.hasVertex("label"));
        assertEquals("label", g.getVertex("label").getLabel());
    }

    @Test
    public void testRemoveVertex()
    {
        g.addVertex("label", "value");
        g.addVertex("label2", "value2");
        g.addEdge("label", "label2");
        assertTrue("Vertex exists", g.hasVertex("label"));
        g.removeVertex("label");
        assertFalse("Vertex deleted", g.hasVertex("label"));
    }

    @Test 
    public void testAddEdge()
    {
        g.addVertex("label", "value");
        g.addVertex("label2", "value2");

        g.addEdge("label", "label2");
        assertTrue(g.isAdjacent("label", "label2")); 
    }

    @Test
    public void testRemoveEdge()
    {
        g.addVertex("label", "value");
        g.addVertex("label2", "value2");
        g.addEdge("label", "label2");
        assertTrue(g.isAdjacent("label", "label2")); 
        g.removeEdge("label", "label2");
        assertFalse(g.isAdjacent("label", "label2")); 
    }

    @Test
    public void testEditEdge()
    {
        g.addVertex("a", "a");
        g.addVertex("b", "b");
        g.addEdge("a", "b"); 
        g.addVertex("c", "c");
        assertTrue(g.isAdjacent("a", "b"));
        assertFalse(g.isAdjacent("a", "c"));
        g.editEdge("a", "b", "c");
        assertTrue(g.isAdjacent("a", "c"));
        assertFalse(g.isAdjacent("a", "b"));
    }

    @Test
    public void testHasVertex()
    {
        assertFalse(hasVertex("label"));
        g.addVertex("a", "a");
        assertTrue(g.hasVertex("a"));
    }

    @Test
    public void testEditVertex()
    {
        g.addVertex("a", "a");
        g.addVertex("b", "b");
        g.addEdge("a", "b");
        g.editVertex("a", "d");

        assertTrue("Check if d is now adjacent to b", g.isAdjacent("d", "b"));
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
