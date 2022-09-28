import java.lang.reflect.Array;
import java.util.InputMismatchException;
import java.util.concurrent.atomic.DoubleAdder;

public class DSAHashTable
{
    public class DSAHashEntry
    {
        String key;
        Object value;
        public int state;

        public DSAHashEntry()
        {
            key = "";
            value = null;
            state = 0;
        }

        public DSAHashEntry(String inKey, Object inValue)
        {
            key = inKey;
            value = inValue;
            state = 1;
        }

        public String getKey()
        {
            return key;
        }

        public Object getValue()
        {
            return value;
        }

        public int getState()
        {
            return state;
        }
    }
    
    public DSAHashEntry[] hashArray;
    private int count;
    
    public DSAHashTable()
    {
        
        int actualSize = NextPrime(10);

        hashArray = new DSAHashEntry[actualSize];
        for(int i=0; i<actualSize; i++)
        {
            hashArray[i] = new DSAHashEntry();
        }

    }
    
    
    
    private long hash(String key)
    {
        //int hashIdx = 0;
        long hashIdx = 0;
        int finalIdx;

        for(int i=0; i<key.length(); i++)
        {
            hashIdx = (31* hashIdx) + key.charAt(i);
        }

        //finalIdx = (int)(hashIdx % hashArray.length);
        //return Double.valueOf(Math.sqrt((hashIdx % hashArray.length)^2)).intValue();
        if(hashIdx<0)
        {
            hashIdx = hashIdx * -1;
        }
        return hashIdx % hashArray.length;
        //return finalIdx;
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

    public int NextPrime(int startVal)
    {
        int prime;
        Boolean isPrime;
        if(startVal % 2 == 0)
        {
            prime = startVal + 1;
        }
        else
        {
            prime = startVal;
        }
        prime = prime -2;

        isPrime = false;
        while(!isPrime)
        {
            prime += 2;
            int i = 3;
            isPrime = true;
            while(i*i <= prime && isPrime)
            {
                if(prime % i == 0)
                {
                    isPrime = false;
                }
                else
                {
                    i += 2;
                }
                
            }
        }
        return prime;
    }

    public Object get(String inKey)
    {
        int hashIdx = (int)hash(inKey);
        int origiIdx = hashIdx;
        Object retValue;
        Boolean found = false;
        Boolean giveUp = false;

        while(!found && !giveUp)
        {
            if(hashArray[hashIdx].state == 0)
            {
                giveUp = true;
            }
            else if(hashArray[hashIdx].key == inKey)
            {
                found = true;
            }
            else
            {
                hashIdx += stepHash(inKey);
                if(hashIdx == origiIdx)
                {
                    throw new InputMismatchException("hashIdx == origiIdx");
                }
            }
        }
        if(!found)
        {
            throw new InputMismatchException();
        }
        return retValue = hashArray[hashIdx].value;
    }

    private void put(String inKey, Object inValue)
    {
        
        int hashIdx = (int)hash(inKey);
        int origiIdx = hashIdx;

        while(hashArray[hashIdx].state == 1)
        {
            System.out.println("Before:" + hashIdx);
            hashIdx += stepHash(inKey);
            System.out.println("After:" + hashIdx);
            if(hashIdx == origiIdx)
            {
                throw new InputMismatchException("hashIdx == origiIdx");
            }
            else if(hashIdx >= hashArray.length)
            {
                hashIdx = 0;
            }   
        }
        hashArray[hashIdx]  = new DSAHashEntry(inKey, inValue);
        //resize();
    }

    public void PutNew(String inKey, Object inValue)
    {
        
        put(inKey, inValue);
        resize();
        
    }

    private Object remove(String inKey)
    {
        int hashIdx = (int)hash(inKey);
        int origiIdx = hashIdx;
        Object value;
        Boolean found = false;
        Boolean giveUp = false;

        while(!found && !giveUp)
        {
            if(hashArray[hashIdx].state == 0)
            {
                giveUp = true;
            }
            else if(hashArray[hashIdx].key == inKey)
            {
                found = true;
            }
            else
            {
                hashIdx += stepHash(inKey);
                if(hashIdx == origiIdx)
                {
                    throw new InputMismatchException("hashIdx == origiIdx");
                }
            }
        }

        value = hashArray[hashIdx].value;
        hashArray[hashIdx] = new DSAHashEntry();
        hashArray[hashIdx].state = 2;
        //resize();

        return value;
    }

    public Object removeNew(String inKey)
    {
        Object toRemove = remove(inKey);
        resize();
        return toRemove;
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
                System.out.println("Sizing down");
                //sizeUp();
                sizeDown();
                System.out.println("New len: " + hashArray.length );

            }
            else if (LF>0.7)
            {
                System.out.println("Sizing up");
                //sizeDown();
                sizeUp();
                System.out.println("New len: " + hashArray.length );
            }
        }
    
    }

    private void sizeUp()
    {
        int tempSize = hashArray.length * 2;
        int size = NextPrime(tempSize);
        DSAHashEntry[] tempArray = hashArray;

        hashArray = new DSAHashEntry[size];
        for(int i=0; i<size; i++)
        {
            hashArray[i] = new DSAHashEntry();
        }
        //hashArray = new DSAHashEntry[size];

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
        int size = NextPrime(tempSize);
        DSAHashEntry[] tempArray = hashArray;
        hashArray = new DSAHashEntry[size];
        for(int i=0; i<size; i++)
        {
            hashArray[i] = new DSAHashEntry();
        }
        for(int i=0; i<tempArray.length; i++)
        {
            if(tempArray[i].getState()==1)
            {
                put(tempArray[i].getKey(), tempArray[i].getValue());
            }
        }
    }

}