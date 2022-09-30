public interface BagInterface<T> 
{
    public int getCurrentSize();

    public boolean isEmpty();

    public boolean add(T entry);

    public T remove();

    public boolean remove(T entry);

    public void clear();

    public int getFrequencyOf(T entry);

    public boolean contains(T entry);

    public T[] toArray();

    public BagInterface<T> union(BagInterface<T> bag);

    public BagInterface<T> intersection(BagInterface<T> bag);

    public BagInterface<T> difference(BagInterface<T> bag);


}
