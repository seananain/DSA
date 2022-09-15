import java.lang.reflect.Array;
import java.util.InputMismatchException;
import java.util.concurrent.atomic.DoubleAdder;

public class DSAHashTable
{
    private class DSAHashEntry
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
    }
    
    private DSAHashEntry[] hashArray;
    private int count;
    
    public DSAHashTable(int tableSize)
    {
        int actualSize = NextPrime(tableSize);

        hashArray = new DSAHashEntry[actualSize];
        for(int i=0; i<actualSize; i++)
        {
            hashArray[i] = new DSAHashEntry();
        }

    }
    
    
    
    private int hash(String key)
    {
        int hashIdx = 0;

        for(int i=0; i<key.length(); i++)
        {
            hashIdx = (31* hashIdx) + key.charAt(i);
        }
        return hashIdx % hashArray.length;
    }

    private int stepHash(String key)
    {
        int hashStep = 0, keyValue = 0;
        int max_step = NextPrime(5);

        for(int i=0; i<key.length(); i++)
        {
            keyValue = (31* hashStep) + key.charAt(i);
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
        int hashIdx = hash(inKey);
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

    public void put(String inKey, Object inValue)
    {
        int hashIdx = hash(inKey);
        int origiIdx = hashIdx;

        while(hashArray[hashIdx].state == 0 || hashArray[hashIdx].state == 2)
        {
            hashIdx += stepHash(inKey);
            if(hashIdx == origiIdx)
            {
                throw new InputMismatchException("hashIdx == origiIdx");
            }
            else
            {
                
            }
        }
        hashArray[hashIdx]  = new DSAHashEntry(inKey, inValue);
    }

    public Object remove(String inKey)
    {
        int hashIdx = hash(inKey);
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
        

        return value;
    }

    public int getLoadFactor()
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
        LF = 100*Double.valueOf(numItems)/Double.valueOf(hashArray.length);
        return LF.intValue();
    }

    public void resize()
    {
        int LF = getLoadFactor();
        if(LF<40)
        {

        }
        else if (LF>60)
        {

        }
    }

    private void sizeUp()
    {

    }

    private void sizeDown()
    {

    }

}