public class DSAHeap
{
    private class DSAHeapEntry
    {
        private int priority;
        private Object value;

        public DSAHeapEntry(int pPriority, Object pValue)
        {
            priority = pPriority;
            value = pValue;
        }

        public int getPriority()
        {
            return priority;
        }

        public void setPriority(int pPriority)
        {
            priority = pPriority;
        }

        public Object getValue()
        {
            return value;
        }

        public void setValue(Object pValue)
        {
            value = pValue;
        }
    }

    public DSAHeapEntry[] heapArr;
    public int count;

    

    public DSAHeap()
    {
        heapArr = new DSAHeapEntry[1];
        count = 0;
    }

    public void add(int priority, Object value)
    {
        DSAHeapEntry entry = new DSAHeapEntry(priority, value);
        
        heapArr[count] = entry;
        trickleUp();

        DSAHeapEntry[] temp = new DSAHeapEntry[heapArr.length+1];
        for(int i=0; i<heapArr.length;i++)
        {
            temp[i] = heapArr[i];
        }
        heapArr = temp;
        count++;
    }


    public DSAHeapEntry remove()
    {
        DSAHeapEntry temp = heapArr[0];
        heapArr[0] = heapArr[count-1];
        trickleDown();
        

        DSAHeapEntry[] tempArr = new DSAHeapEntry[heapArr.length-1];
        for(int i=0; i<heapArr.length-1;i++)
        {
            tempArr[i] = heapArr[i];
        }
        heapArr = tempArr;
        count--;

        return temp;
    }

    public DSAHeapEntry trickleDown()
    {
        return trickleDownRec(0);
    }

    public DSAHeapEntry trickleDownRec(int curIdx)
    {
        int leftChild = curIdx * 2 + 1;
        int rightChild = leftChild + 1;
        int largeIdx=0;

        if(leftChild < count)
        {
            largeIdx = leftChild;
            if(rightChild < count)
            {
                
                if(heapArr[leftChild].getPriority() < heapArr[rightChild].getPriority())
                {
                    largeIdx = rightChild;
                }
            }
            if(heapArr[largeIdx].getPriority() > heapArr[curIdx].getPriority())
            {
                DSAHeapEntry temp = heapArr[largeIdx];
                heapArr[largeIdx] = heapArr[curIdx];
                heapArr[curIdx] = temp;
            }
            return trickleDownRec(largeIdx);
        }
        return heapArr[largeIdx];
    }



    private void trickleUp()
    {
        trickleUpRec(count);
    }

    private DSAHeapEntry trickleUpRec(int curIdx)
    {
        int parentIdx = (curIdx-1)/2;
        if(curIdx>0)
        {
            if(heapArr[curIdx].getPriority() > heapArr[parentIdx].getPriority())
            {
                DSAHeapEntry temp = heapArr[parentIdx];
                heapArr[parentIdx] = heapArr[curIdx];
                heapArr[curIdx] = temp;
                return trickleUpRec(parentIdx);
            }
        }
        
        return heapArr[curIdx];
        
    }

    public void display()
    {
        for(int i=0; i<count; i++)
        {
            System.out.println("Index: " + i + " Priority: " +heapArr[i].priority + " Value: " + heapArr[i].getValue());
        }
    }

    public int[] heapSort(int[] array, int numItems)
    {
        for(int i=0; i<numItems; i++)
        {
            add(array[i], array[i]);
        }

        for(int j=numItems-1; j>=0; j--)
        {
            array[j] = (int)remove().getValue();
        }
        return array;
    }


}