import java.util.Arrays;

public class ResizeableArrayBag<T> implements BagInterface<T>
{
    private T[] bag;
    private static final int DEFAULT_CAPACITY = 25;
    private int numberOfEntries;
    private boolean integrityOK = false;
    private static final int MAX_CAPACITY = 10000;

    /**
     * Constructs an empty ResizeableArrayBag
     */
    public ResizeableArrayBag()
    {
        this(DEFAULT_CAPACITY);
    }



    /**
     * Constructs an empty ResizeableArrayBag
     */
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



    // Throws an exception if this object is not initialized.
    private void checkIntegrity()
    {
      if(!integrityOK)
      {
        throw new SecurityException("ArrayBag object is corrupt.");
      }
    }



    /** Gets the current number of entries in this bag.
    @return  The integer number of entries currently in this bag. 
    */
    public int getCurrentSize()
    {
        return numberOfEntries;
    }


    // Throws an exception if the client requests a capacity that is too large.
    private void checkCapacity(int capacity)
    {
        if(capacity > MAX_CAPACITY)
        {
            throw new IllegalStateException("Attempt to create a bag whose capacity exeeds allowed maximum of " + MAX_CAPACITY);
        }
    }



    /**Doubles the size of the array bag.
    Precondition: checkIntegrity has been called.*/
    private void doubleCapacity()
    {
        int newLength = 2 * bag.length;
        checkCapacity(newLength);
        bag = Arrays.copyOf(bag, newLength);
    }



    /** Adds a new entry to this bag.
    @param newEntry  The object to be added as a new entry.
    @return  True if the addition is successful, or false if not. 
    */
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



    /** Removes one unspecified entry from this bag, if possible.
    @return  Either the removed entry, if the removal was successful, or null. */
    public T remove()
    {
        checkIntegrity();
        T result = removeEntry(numberOfEntries - 1);
        return result;
    }



    /** Removes one occurrence of a given entry from this bag.
    @param anEntry  The entry to be removed.
    @return  True if the removal was successful, or false if not. 
    */
    public boolean remove(T anEntry)
    {
        checkIntegrity();
        int index = getIndexOf(anEntry);
        T result = removeEntry(index);
        return anEntry.equals(result);
    }



    /** Sees whether this bag is empty.
    @return  True if this bag is empty, or false if not. 
    */
    public boolean isEmpty()
    {
        return numberOfEntries == 0;
    }



    /** Removes all entries from this bag. */
    public void clear()
    {
        while(!isEmpty())
            remove();
    }



    /** Counts the number of times a given entry appears in this bag.
    @param anEntry  The entry to be counted.
    @return  The number of times anEntry appears in this bag. 
    */
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



    // Locates a given entry within the array bag.
    // Returns the index of the entry, if located, or -1 otherwise.
    // Precondition: checkIntegrity has been called.
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



    /** Tests whether this bag contains a given entry.
     @param anEntry  The entry to find.
     @return  True if the bag contains anEntry, or false if not. */
    public boolean contains(T anEntry)
    {
        checkIntegrity();
        return getIndexOf(anEntry)>-1;
    }



    /** Retrieves all entries that are in this bag.
    @return  A newly allocated array of all the entries in the bag. 
    Note: If the bag is empty, the returned array is empty. */
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



    //returns a boolean to tell whether it is full or not
    private boolean isArrayFull()
    {
        return numberOfEntries == bag.length;
    }



    // Removes and returns the entry at a given index within the array bag.
    // If no such entry exists, returns null.
    // Preconditions: 0 <= givenIndex < numberOfEntries;
    //                checkIntegrity has been called.
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
        BagInterface<T> result = new ResizeableArrayBag<>();
        @SuppressWarnings("unchecked")
        T[] bagTwoArrayCopy = (T[]) new Object[bag.getCurrentSize()];
        T[] bagOneArray = this.toArray();
        T[] bagTwoArray = bag.toArray();
        for(int i=0; i<bag.getCurrentSize(); i++){
            bagTwoArrayCopy[i]=bagTwoArray[i];
        }

        for(int i=0; i<this.getCurrentSize(); i++){
            for(int j=0; j<bag.getCurrentSize(); j++){
                if(bagOneArray[i]==bagTwoArrayCopy[j]){
                    result.add(bagOneArray[i]);
                    bagTwoArrayCopy[j]=null;
                    break;
                }
            }
        }
        return result;
    }


    
    public BagInterface<T> difference(BagInterface<T> bag) 
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
            if(result.contains(index))
            {
                result.remove(index);
            }
        }
        return result;
    }
}
