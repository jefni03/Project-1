public interface BagInterface<T> 
{
    /**
     * @return the size of the bag
     */
    public int getCurrentSize();

    /**
     * @return if the bag is empty (doesn't have entries) 
     */
    public boolean isEmpty();

    /**
     * adds an entry to the bag
     * @param entry entry to be added
     * @return if the add was successful
     */
    public boolean add(T entry);

    /**
     * removes one unspecified entry from the bag
     * @return the entry that was removed
     */
    public T remove();

    /**
     * removes a specified entry from the bag
     * @param entry a specified entry to remove
     * @return if the removal was successful
     */
    public boolean remove(T entry);

    /**
     * removes all entries from the bag
     */
    public void clear();

    /**
     * finds the frequency of a specified entry in a bag
     * @param entry the entry that you want to find frequency of
     * @return the frequency
     */
    public int getFrequencyOf(T entry);

    /**
     * finds if the bag contains a specified entry or not
     * @param entry entry you want to see if bag contains
     * @return if bag has that entry
     */
    public boolean contains(T entry);

    /**
     * converts the bag to an array
     * @return the bag as an array
     */
    public T[] toArray();

    public BagInterface<T> union(BagInterface<T> bag);

    public BagInterface<T> intersection(BagInterface<T> bag);

    public BagInterface<T> difference(BagInterface<T> bag);


}
