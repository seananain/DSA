import java.io.Serializable;
import java.util.NoSuchElementException;

public class DSABinarySearchTree implements Serializable
{
    private class DSATreeNode implements Serializable
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

    public DSABinarySearchTree(String key, Object data)
    {
        m_root = new DSATreeNode(key, data);
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

    public DSATreeNode delete(String key)
    {
        return deleteRec(key, m_root);
    }

    public DSATreeNode deleteRec(String key, DSATreeNode currNode)
    {
        DSATreeNode updateNode = currNode;
        if(currNode == null)
        {
            throw new IllegalArgumentException();
        }
        else if (key.equals(currNode.getKey()))
        {
            updateNode = deleteNode(key, currNode);
        }
        else if (key.compareTo(currNode.getKey()) < 0)
        {
            currNode.setLeft(deleteRec(key, currNode.getLeft()));
        }
        else
        {
            currNode.setRight(deleteRec(key, currNode.getRight()));
        }
        return updateNode;

    }

    public DSATreeNode deleteNode(String key, DSATreeNode delNode)
    {
        DSATreeNode updateNode = null;

        if((delNode.getLeft() == null)&&(delNode.getRight()==null))
        {
            updateNode = null;
        }
        else if((delNode.getLeft() != null)&&(delNode.getRight()==null))
        {
            updateNode = delNode.getLeft();
        }
        else if((delNode.getLeft() == null)&&(delNode.getRight()!=null))
        {
            updateNode = delNode.getRight();
        }
        else
        {
            updateNode = promoteSuccessor(delNode.getRight());
            if(updateNode!=delNode.getRight())
            {
                updateNode.setRight(delNode.getRight());
            }
            updateNode.setLeft(delNode.getLeft());
        }
        return updateNode;
    }

    public DSATreeNode promoteSuccessor(DSATreeNode currNode)
    {
        DSATreeNode successor = currNode;

        if(currNode.getLeft() == null)
        {
            successor = currNode;
        }
        else if(currNode.getLeft() != null)
        {
            successor = promoteSuccessor(currNode.getLeft());
            if(successor == currNode.getLeft())
            {
                currNode.setLeft(successor.getRight());
            }
        }
        return successor;
        //currNode = 
    }

    public void display()
    {

    }

    public int height()
    {
        return heightRec(m_root);
    }

    public int heightAlt(DSATreeNode node)
    {
        return heightRec(node);
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

    public int min()
    {
        return minRec(m_root);
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

    public int max()
    {
        return maxRec(m_root);
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
        DSATreeNode currNode = m_root;
        int Ltotal, Rtotal;
        Double balance;
        DSATreeNode left = currNode.getLeft();
        DSATreeNode right = currNode.getRight();


        Ltotal = heightAlt(left);
        Rtotal = heightAlt(right);

        if(Ltotal > Rtotal)
        {
            balance = 100*(Double.valueOf(Rtotal)/Double.valueOf(Ltotal));
        }
        else
        {
            balance = 100*(Double.valueOf(Ltotal)/Double.valueOf(Rtotal));
        }
        return balance;
    }

    public void inOrder()
    {
        inOrderRec(m_root);
    }

    public void inOrderRec(DSATreeNode currNode)
    {
        if(currNode == null)
        {
            return;
        }
        else
        {
            inOrderRec(currNode.getLeft());
            System.out.println(currNode.getKey());
            inOrderRec(currNode.getRight());
        }
    }
    
    public void preOrder()
    {
        preOrderRec(m_root);
    }

    public void preOrderRec(DSATreeNode currNode)
    {
        if(currNode == null)
        {
            return;
        }
        else
        {
            System.out.println(currNode.getKey());
            preOrderRec(currNode.getLeft());
            preOrderRec(currNode.getRight());
        }
    }

    public void postOrder()
    {
        postOrderRec(m_root);
    }

    public void postOrderRec(DSATreeNode currNode)
    {
        if(currNode == null)
        {
            return;
        }
        else
        {
            postOrderRec(currNode.getLeft());
            postOrderRec(currNode.getRight());
            System.out.println(currNode.getKey());
        }
    }
}