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

    public T union(T bag);

    public T intersection(T bag);

    public T difference(T bag);


}
