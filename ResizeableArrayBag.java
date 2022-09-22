public class ResizeableArrayBag<T> implements BagInterface<T>
{
    private final T[] bag;
    private static final int defaultCapacity = 25;
    private int numberOfEntries;
    private boolean integrityOK;

    public void ArrayBag()
    {

    }

    public void ArrayBag(int Capacity)
    {

    }

    private void checkIntegrity()
    {
        if(!integrityOK)
        {
            throw new SecurityException("ArrayBag object is corrupt");
        }
    }

    public int getCurrentSize()
    {

    }

    public boolean isEmpty()
    {

    }

    private void checkCapacity(int capacity)
    {
        if(capacity > MAX_CAPACITY)
        {
            throw new illegalStateException("Attempt to create a bag whose capacity exeeds allowed maximum of " + MAX_CAPACITY);
        }
    }

    private void doubleCapacity()
    {
        int newLength = 2*bag.length;
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
        bag[numberOfEntries] = newEntry;
        numberOfEntries++;
    }

    public T remove()
    {

    }

    public boolean remove(T entry)
    {

    }

    public void clear()
    {

    }

    public int getFrequencyOf(T entry)
    {

    }

    public boolean contains(T entry)
    {

    }

    public T[] toArray()
    {

    }

    public T union(T bag)
    {

    }

    public T intersection(T bag)
    {

    }

    public T difference(T bag)
    {

    }
}
