import java.util.InputMismatchException;

/**
 * DSA Final Assessment Question 3 - Q3HashTable.java
 *
 * Name : Sean Anain
 * ID   : 20324861
 *
 **/

public class Q3HashTable {
    
    protected class HashEntry
    {
        //class fields
        private String key;
        private Object value; 
        private int state; //0 = never used/free,  1 = used / not free

        //default constructor
        public HashEntry() {

            key = "";
            value = null;
            state = 0;
        }

        //alternate constructor
        public HashEntry(String inKey, Object inValue) 
        {

            key = inKey;
            value = inValue;
            state = 1;
        }

        public String getKey() 
        {
            return this.key;
        }


        public Object getValue() 
        {
            return this.value;
        }


        public int getState() 
        {
            return this.state;
        }

        public void setKey(String inKey) {
            this.key = inKey;
        }

        public void setValue(Object inValue) {
            this.value = inValue;
        }

        public void setState() {
            this.state = -1;
        }
    }

    private HashEntry[] hashArray; 
    private int hashCount; 

    public Q3HashTable(int tableSize) {

        int actualSize = nextPrime(tableSize - 1); 
        hashArray = new HashEntry[actualSize];

        for (int i = 0; i < (actualSize); i++) {
            hashArray[i] = new HashEntry(); 
        }
    } 
    
    private void put(String inKey, Object inValue)
    {
        
        int hashIdx = (int)hash(inKey);
        int origiIdx = hashIdx;

        while(hashArray[hashIdx].state == 1)
        {
            hashIdx += stepHash(inKey);
            if(hashIdx == origiIdx)
            {
                throw new InputMismatchException("hashIdx == origiIdx");
            }
            else if(hashIdx >= hashArray.length)
            {
                hashIdx -= hashArray.length;
            }   
        }
        hashArray[hashIdx]  = new HashEntry(inKey, inValue);
        //resize();
    }

    private int stepHash(String key)
    {
        int hashStep = 0, keyValue = 0;
        int max_step = 7;

        for(int i=0; i<key.length(); i++)
        {
            keyValue = (33* hashStep) + key.charAt(i);
        }
        return max_step - (keyValue % max_step);
    }

    public void PutNew(String inKey, Object inValue)
    {
        
        put(inKey, inValue);
        resize();
        
    }

    public Object[] get(String inKey)
    {
        int hashIdx = (int)hash(inKey);
        int origiIdx = hashIdx, i=0;
        Object[] arr = new Object[hashArray.length];
        Object retValue;
        Boolean found = false;
        Boolean giveUp = false;

        while(!giveUp)
        {
            if(hashIdx >= hashArray.length)
            {
                hashIdx -= hashArray.length;
            }
            else if(hashArray[hashIdx].state == 0)
            {
                //System.out.println("giving up 1");
                giveUp = true;
                //hashIdx = (hashIdx + 1) % hashArray.length;
                //hashIdx += stepHash(inKey);
            }
            else if(hashArray[hashIdx].key.equals(inKey))
            {
                arr[i] = hashArray[hashIdx].value;
                //System.out.println(hashArray[hashIdx].value);
                //hashIdx = (hashIdx + 1) % hashArray.length;
                i++;
                hashIdx += stepHash(inKey);
            }
            else
            {
                //hashIdx = (hashIdx + 1) % hashArray.length;
                hashIdx += stepHash(inKey);
                if(hashIdx == origiIdx)
                {
                    giveUp = true;
                }
            }
        }
        if(!found)
        {
            retValue = null;
        }
        return arr;
    }


    public Double getLoadFactor()
    {
        int numItems = 0;
        Double LF = 0.0;
        for(int i=0; i<hashArray.length;i++)
        {
            if(hashArray[i].state == 1)
            {
                numItems++;
            }

        }
        LF = Double.valueOf(numItems)/Double.valueOf(hashArray.length);
        return LF;
    }

    public void resize()
    {
        Double LF = getLoadFactor();
        //System.out.println(LF);
        int numItems = 0;
        for(int i=0; i<hashArray.length;i++)
        {
            if(hashArray[i].state == 1)
            {
                numItems++;
            }
        }
        if(numItems>0)
        {
            if(LF<0.3)
            {
                //sizeUp();
                sizeDown();

            }
            else if (LF>0.7)
            {
                //sizeDown();
                sizeUp();
            }
        }
    
    }

    private void sizeUp()
    {
        int tempSize = hashArray.length * 2;
        int size = nextPrime(tempSize);
        HashEntry[] tempArray = hashArray;

        hashArray = new HashEntry[size];
        for(int i=0; i<size; i++)
        {
            hashArray[i] = new HashEntry();
        }
        //hashArray = new HashEntry[size];

        for(int i=0; i<tempArray.length; i++)
        {
            if(tempArray[i].state==1)
            {
                put((String)tempArray[i].getKey(), (Object)tempArray[i].getValue());
            }
            
        }

    }

    private void sizeDown()
    {
        int tempSize = hashArray.length / 2;
        int size = nextPrime(tempSize);
        HashEntry[] tempArray = hashArray;
        hashArray = new HashEntry[size];
        for(int i=0; i<size; i++)
        {
            hashArray[i] = new HashEntry();
        }
        for(int i=0; i<tempArray.length; i++)
        {
            if(tempArray[i].getState()==1)
            {
                put(tempArray[i].getKey(), tempArray[i].getValue());
            }
        }
    }

    public void display() 
    {    
        for (int i = 0; i < hashArray.length; i++) {   
            try 
            {
                if (hashArray[i].getValue() != null)
                {
                    System.out.println("\t\t" + i + "\t" + hashArray[i].getKey());
                }

            } 
            catch (NullPointerException e) 
            {
                System.out.println("Null pointer at element: " + i);
            } 
        }
    }

    private int hash(String inKey) 
	{
        int hashIdx = 0;

        for(int i=0; i<inKey.length(); i++)
        {
            hashIdx = (31* hashIdx) + inKey.charAt(i);
        }

        //finalIdx = (int)(hashIdx % hashArray.length);
        //return Double.valueOf(Math.sqrt((hashIdx % hashArray.length)^2)).intValue();
        if(hashIdx<0)
        {
            hashIdx = hashIdx * -1;
        }
        return hashIdx % hashArray.length;
    }

   private int nextPrime(int inNum) 
   {
        int prime;
        boolean isPrime = false;

        if (inNum % 2 == 0) {
            prime = inNum - 1; 
        } else {
            prime = inNum;
        }

        do { 
            prime = prime + 2; 
            int i = 3;
            isPrime = true;
            double rootVal = Math.sqrt(prime); 
            
            do{
                if ((prime % i) == 0) { 
                    isPrime = false;
                } else {
                    i = i + 2; 
                }
            } while ((i <= rootVal) && (isPrime));
        } while (!isPrime);

        return prime;
    }

    public int getArrayLength() 
	{
        return hashArray.length;
    }



} 
