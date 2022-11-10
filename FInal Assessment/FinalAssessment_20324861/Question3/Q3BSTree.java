/**
 * DSA Final Assessment Question 3 - Q3BSTree.java
 *
 * Name : Sean Anain
 * ID   : 20324861
 *
 **/

public class Q3BSTree {   
	// Inner class TreeNode
	private class TreeNode {
		private String m_key;
        private Object m_value;
        private TreeNode m_leftChild;
        private TreeNode m_rightChild;

        public TreeNode(String inKey, Object inVal)
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

        public TreeNode getLeft()
        {
            return m_leftChild;
        }

        public void setLeft(TreeNode newLeft)
        {
            m_leftChild = newLeft;
        }

        public TreeNode getRight()
        {
            return m_rightChild;
        }

        public void setRight(TreeNode newRight)
        {
            m_rightChild = newRight;
        }
	}
	// End Inner class
	// Class Q3BSTree
	private TreeNode root;
	
	public Q3BSTree()
	{
		root = null;
	}
	
	public Q3BSTree(String key, Object data)
    {
        root = new TreeNode(key, data);
    }


	public Boolean isEmpty()
	{
		return root == null;
	}

	public void insert(String key, Object value)
    {
        insertRec(key, value, root);
    }

    public TreeNode insertRec(String key, Object data, TreeNode currNode)
    {
        TreeNode updateNode = currNode;
        if(currNode == null)
        {
            TreeNode newNode = new TreeNode(key, data);
            updateNode = newNode;
            
        }
        else if (key.equals(currNode.getKey()))
        {
            currNode.setRight(insertRec(key, data, currNode.getRight()));
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
	
	public int height()
    {
        return heightRec(root);
    }

    public int heightAlt(TreeNode node)
    {
        return heightRec(node);
    }

    public int heightRec(TreeNode currNode)
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
        return minRec(root);
    }

    public int minRec(TreeNode currNode)
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
        return maxRec(root);
    }

    public int maxRec(TreeNode currNode)
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
        TreeNode currNode = root;
        int Ltotal, Rtotal;
        Double balance;
        TreeNode left = currNode.getLeft();
        TreeNode right = currNode.getRight();


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

    public void inOrderFind(String key)
    {
        inOrderRec(root, key);
    }

    public void inOrderRec(TreeNode currNode, String key)
    {
        if(currNode == null)
        {
            return;
        }
        else
        {
            inOrderRec(currNode.getLeft(), key);
			if(currNode.getKey().equals(key))
			{
				System.out.println(currNode.getValue());
			}
            inOrderRec(currNode.getRight(), key);
        }
    }
    
    public void preOrder()
    {
        preOrderRec(root);
    }

    public void preOrderRec(TreeNode currNode)
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
        postOrderRec(root);
    }

    public void postOrderRec(TreeNode currNode)
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
