import java.util.Arrays;

public class ResizeableArrayBag<T> implements BagInterface<T>
{
    private T[] bag;
    private static final int DEFAULT_CAPACITY = 25;
    private int numberOfEntries;
    private boolean integrityOK = false;
    private static final int MAX_CAPACITY = 10000;

    public ResizeableArrayBag()
    {
        this(DEFAULT_CAPACITY);
    }

    public ResizeableArrayBag(int capacity)
    {
        if(capacity<=MAX_CAPACITY){
            numberOfEntries=0;
            @SuppressWarnings("unchecked")
            T[] tempBag = (T[]) new Object[capacity];
            bag=tempBag;
            integrityOK = true;
        }
        else{
            throw new IllegalStateException("Trying to make a bag with a capacity above the maximum.");
        }
    }

    private void checkIntegrity()
    {
      if(!integrityOK)
      {
        throw new SecurityException("ArrayBag object is corrupt.");
      }
    }

    public int getCurrentSize()
    {
        return numberOfEntries;
    }

    private void checkCapacity(int capacity)
    {
        if(capacity > MAX_CAPACITY)
        {
            throw new IllegalStateException("Attempt to create a bag whose capacity exeeds allowed maximum of " + MAX_CAPACITY);
        }
    }

    private void doubleCapacity(T[] bag)
    {
        int newLength = 2 * bag.length;
        checkCapacity(newLength);
        bag = Arrays.copyOf(bag, newLength);
    }

    public boolean add(T newEntry)
    {
        checkIntegrity();
        boolean result = true;
        if(isArrayFull())
        {
            doubleCapacity();
        }
        else
        {
            bag[numberOfEntries] = newEntry;
            numberOfEntries++;
        }
        return result;
    }

    public T remove()
    {
        checkIntegrity();
        T result = removeEntry(numberOfEntries - 1);
        return result;
    }

    public boolean remove(T anEntry)
    {
        checkIntegrity();
        int index = getIndexOf(anEntry);
        T result = removeEntry(index);
        return anEntry.equals(result);
    }

    public boolean isEmpty()
    {
        return numberOfEntries == 0;
    }

    public void clear()
    {
        while(!isEmpty())
            remove();
    }

    public int getFrequencyOf(T anEntry)
    {
        checkIntegrity();
        int counter = 0;

        for(int index = 0; index < numberOfEntries; index++)
        {
            if(anEntry.equals(bag[index]))
            {
                counter++;
            }
        }
        return counter;
    }

    private int getIndexOf(T anEntry)
    {
        int where = -1;
        boolean found = false;
        int index = 0;

        while(!found && (index<numberOfEntries))
        {
            if(anEntry.equals(bag[index]))
            {
                found = true;
                where = index;
            }
            index++;
        }
        return where;
    }

    public boolean contains(T anEntry)
    {
        checkIntegrity();
        return getIndexOf(anEntry)>-1;
    }

    public T[] toArray()
    {
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[numberOfEntries];
        for(int index = 0; index < numberOfEntries; index++)
        {
            result[index] = bag[index];
        }
        return result;
    }

    private boolean isArrayFull()
    {
        return numberOfEntries == bag.length;
    }

    private T removeEntry(int givenIndex)
    {
        T result = null;
        if(!isEmpty() && (givenIndex >= 0))
        {
            result = bag[givenIndex];
            bag[givenIndex] = bag[numberOfEntries - 1];
            bag[numberOfEntries - 1] = null;
            numberOfEntries--;
        }
        return result;
    }

    public BagInterface<T> union(BagInterface<T> bag) 
    {
        BagInterface <T> result = new ResizeableArrayBag < >();
        T[] array = this.toArray();
        for (T index : array) 
        {
            result.add(index);
        }
        T[] secondBag = bag.toArray();
        for (T index : secondBag) 
        {
            result.add(index);
        }
        return result;
    }

    public BagInterface<T> intersection(BagInterface<T> bag) 
    {
        BagInterface <T> result = new ResizeableArrayBag < >();
        BagInterface <T> finalResult = new ResizeableArrayBag < >();
        T[] array = this.toArray();
        for (T index : array) 
        {
            result.add(index);
        }
        T[] secondBag = bag.toArray();
        for (T index : secondBag) 
        {
            if(result.contains(index))
            {
                finalResult.add(index);
            }
        }
        return finalResult;
    }

    public BagInterface<T> difference(BagInterface<T> bag) 
    {
        BagInterface <T> result = new ResizeableArrayBag < >();
        T[] mine = this.toArray();
        for (T index : mine) 
        {
            result.add(index);
        }
        T[] secondBag = bag.toArray();
        for (T elem : secondBag)
        {
            if(result.contains(elem))
            {
                result.remove(elem);
            }
        }
        return result;
    }
}
