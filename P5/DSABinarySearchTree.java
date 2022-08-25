import java.util.NoSuchElementException;

public class DSABinarySearchTree
{
    private class DSATreeNode
    {
        private String m_key;
        private Object m_value;
        private DSATreeNode m_leftChild;
        private DSATreeNode m_rightChild;

        public DSATreeNode(String inKey, Object inVal)
        {
            if(inKey==null)
            {
                throw new IllegalArgumentException("Key cannot be null");
            }
            m_key = inKey;
            m_value = inVal;
            m_rightChild = null;
            m_leftChild = null;
        }

        public String getKey()
        {
            return m_key;
        }

        public Object getValue()
        {
            return m_value;
        }

        public DSATreeNode getLeft()
        {
            return m_leftChild;
        }

        public void setLeft(DSATreeNode newLeft)
        {
            m_leftChild = newLeft;
        }

        public DSATreeNode getRight()
        {
            return m_rightChild;
        }

        public void setRight(DSATreeNode newRight)
        {
            m_rightChild = newRight;
        }
    }

    private DSATreeNode m_root;

    public DSABinarySearchTree()
    {
        m_root = null;
    }

    public Object find(String key)
    {
        return findRec(key, m_root);
    }

    public Object findRec(String key, DSATreeNode currNode)
    {
        Object value = null;

        if(currNode == null)
        {
            throw new NoSuchElementException("Key " + key + " not found");
        }

        else if(key.equals(currNode.getKey()))
        {
            value = currNode.getValue();
        }
        else if(key.compareTo(currNode.getKey()) < 0)
        {
            value = findRec(key, currNode.getLeft());
        }
        else
        {
            value = findRec(key, currNode.getRight());
        }
        return value;
    }

    public void insert(String key, Object value)
    {
        insertRec(key, value, m_root);
    }

    public DSATreeNode insertRec(String key, Object data, DSATreeNode currNode)
    {
        DSATreeNode updateNode = currNode;
        if(currNode == null)
        {
            DSATreeNode newNode = new DSATreeNode(key, data);
            updateNode = newNode;
        }
        else if (key.equals(currNode.getKey()))
        {
            throw new IllegalArgumentException();
        }
        else if (key.compareTo(currNode.getKey()) < 0)
        {
            currNode.setLeft(insertRec(key, data, currNode.getLeft()));
        }
        else
        {
            currNode.setRight(insertRec(key, data, currNode.getRight()));
        }
        return updateNode;
    }

    public void delete(String key)
    {

    }

    public DSATreeNode promoteSuccessor(DSATreeNode currNode)
    {
        DSATreeNode successor = new DSATreeNode(inKey, inVal);
        //currNode = 
    }

    public void display()
    {

    }

    public int height()
    {
        return heightRec(m_root);
    }

    public int heightRec(DSATreeNode currNode)
    {
        int htSoFar, iLeftHt, iRightHt;

        if(currNode == null)
        {
            htSoFar = -1;
        }
        else
        {
            iLeftHt = heightRec(currNode.getLeft());
            iRightHt = heightRec(currNode.getRight());

            if(iLeftHt > iRightHt)
            {
                htSoFar = iLeftHt + 1;
            }
            else 
            {
                htSoFar = iRightHt + 1;
            }
        }
        return htSoFar;
    }

    public int min(DSATreeNode currNode)
    {
        return minRec(currNode);
    }

    public int minRec(DSATreeNode currNode)
    {
        int minKey;
        if(currNode.getLeft() != null)
        {
            minKey = minRec(currNode.getLeft());
        }
        else
        {
            minKey = Integer.parseInt(currNode.getKey());
        }
        return minKey;
    }

    public int max(DSATreeNode currNode)
    {
        return maxRec(currNode);
    }

    public int maxRec(DSATreeNode currNode)
    {
        int maxKey;
        if(currNode.getRight() != null)
        {
            maxKey = maxRec(currNode.getRight());
        }
        else
        {
            maxKey = Integer.parseInt(currNode.getKey());
        }
        return maxKey;
    }

    public Double balance()
    {

    }

    public void inOrderRec(DSATreeNode currNode)
    {
        if(currNode == null)
        {
            throw new IllegalArgumentException();
        }
        else
        {
            
        }
    }
}