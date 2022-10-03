/**
 * LinkedBag links objects together using nodes which contain the object and its data
 * and the reference to the next linked object.
 * Implements BagInterface using generic type T
 */

public class LinkedBag<T> implements BagInterface<T>
{
    private Node firstNode;
    private int numberOfEntries;

    /**
     * Constructs an empty LinkedBag
     */
    public LinkedBag()
    {
        firstNode = null;
        numberOfEntries = 0;
    }
    
    /**
     * @return the number of entries/objects inside the LinkedBag 
     */
    public int getCurrentSize()
    {
        return numberOfEntries;
    }

    /**
     * @return true if the LinkedBag has no entries/objects inside of it, false if it does
     */
    public boolean isEmpty()
    {
        return numberOfEntries == 0;
    }

    /**
     * Adds a object to the start of the linked objects by constructing an newNode
     * that contains the object to be added and a reference to the firstNode.
     * The newNode then becomes the firstNode.
     * @param entry the data to be added
     * @return true if the add was successful
     */
    public boolean add(T entry)
    {
        Node newNode = new Node(entry);
        newNode.next = firstNode;
        firstNode = newNode;
        numberOfEntries++;
        return true;
    }

    /**
     * Removes the first object of the LinkedBag by
     * removing the firstNode (contains the object)
     * by setting the firstNode to now be the second node.
     * The previously firstNode is now not referenced by anything and
     * is now up for garbage collection.
     * @return the bag/node that was removed
     */
    public T remove()
    {
        T result = null;
        if(firstNode != null)
        {
            result = firstNode.getData();
            firstNode = firstNode.getNextNode();
            numberOfEntries--;
        }
        return result;
    }

    /**
     * Removes a specified object of the LinkedBag.
     * First finds the reference to the specified node containing the object.
     * Then, sets that node to contain the object of firstNode instead of the specified object.
     * There are now two Nodes with the same object as their data, so now remove the firstNode
     * by setting the firstNode to be the second node. 
     * The original first node not referenced by anything and up for garbage collection.
     * @param entry object to be removed from the LinkedBag
     * @return true if the removal was successful
     */
    public boolean remove(T entry)
    {
         boolean result = false;
         Node nodeN = getReferenceTo(entry);
         if (nodeN != null)
        {
            nodeN.setData(firstNode.getData()); 
            firstNode = firstNode.getNextNode(); 
            numberOfEntries--;
         
         result = true;
        } 
    
      return result;
    }

    /**
     * Finds the reference to the node containing a specified object. Used in remove(T entry).
     * Goes through nodes until the data of the node contains the specified object 
     * or until it reaches the end of the linked nodes. 
     * @param entry object/data of node to find the reference to
     * @return the reference to the node that the object/data is located in
     */
    private Node getReferenceTo(T entry){
        boolean found = false;
        Node currentNode = firstNode;
        while(!found && (currentNode!=null)){
            if(entry.equals(currentNode.getData())){
                found = true;
            }
            else{
                currentNode = currentNode.getNextNode();
            }
        }
        return currentNode;
    }

    /**
     * Completely empties out the LinkedBag by removing all the nodes
     * until there are none left
     */
    public void clear()
    {
        while(!isEmpty())
        {
            remove();
        }
    }

    /**
     * Find the frequency of a certain data/object by going through the nodes of the LinkedBag and counting
     * @param entry the data/object you want to find the frequency of
     * @return the number of times the data/object is in the LinkedBag
     */
    public int getFrequencyOf(T entry)
    {
        int frequency = 0;
        int count = 0;
        Node currentNode = firstNode;
        while((count < numberOfEntries) && (currentNode != null))
        {
            if(entry.equals(currentNode.getData()))
            {
                frequency++;
            }
            count++;
            currentNode = currentNode.getNextNode();
        }
        return frequency;
    }

    /**
     * Finds out if a certain data/object is in the LinkedBag by going through the nodes 
     * and looking at the data of the nodes.
     * @param entry the data/object you want to look for
     * @return true if the entry is in the LinkedBag, false otherwise
     */
    public boolean contains(T entry)
    {
        boolean found = false;
        Node currentNode = firstNode;
        while(!found && (currentNode != null))
        {
            if(entry.equals(currentNode.getData()))
            {
                found = true;
            }
            else
            {
                currentNode = currentNode.getNextNode();
            }
        }
        return found;
    }

    /**
     * Converts the LinkedBag into an Array.
     * Each node of the LinkedBag corresponds to an index in the array.
     * The data of each node is inputted in the corresponding index.
     * @return the LinkedBag as an array
     */
    public T[] toArray()
    {
        @SuppressWarnings("unchecked") //need or else java compiler will spit out warning
        T[] array = (T[]) new Object[numberOfEntries]; //makes an array of objects but cast it to be generic array 

        int i=0;
        Node currentNode=firstNode;
        while((i<numberOfEntries)&&(currentNode!=null)){ 
            array[i]=currentNode.getData();
            i++;
            currentNode=currentNode.getNextNode();
        }
        return array;
    }

    public BagInterface<T> union(BagInterface<T> bag)
    {
        BagInterface<T> result = new LinkedBag<T>();
        for(Node n = firstNode; n != null; n = n.next)
        {
            result.add(n.data);
        }
        for(T object : bag.toArray())
        {
            result.add(object);
        }
        return result; 
    }

    public BagInterface<T> intersection(BagInterface<T> bag)
    {
        BagInterface < T > result = new LinkedBag < >();
        BagInterface < T > endResult = new LinkedBag < >();
        T[] array = this.toArray();
        for (T object : array) 
        {
            result.add(object);
        }
        T[] array2 = bag.toArray();
        for (T object : array2) 
        {
            if(result.contains(object))
            {
            endResult.add(object);
            }
        }
        return endResult;
        }
    

    public BagInterface<T> difference(BagInterface<T> bag)
    {
        BagInterface < T > result = new LinkedBag < >();
        T[] array = this.toArray();
        for (T object : array) 
        {
        result.add(object);
        }
        T[] array2 = bag.toArray();
        for (T object : array2) 
        {
            if(result.contains(object))
            {
            result.remove(object);
            }
        }
        return result;
    }

    /**
     * Node is used in the LinkedBag.
     * Node holds the data/object of a LinkedBag and the reference to the next Node
     * which contains another data/object.
     */
    private class Node{
        private T data;
        private Node next;

        /**
         * Constructs a node that contains a reference to the next node
         * and some data/object.
         * @param data the data/object node will contain
         * @param next the reference to the node after the newly constructed node
         */
        private Node(T data, Node next){
            this.data=data;
            this.next=next;    
        }
        
        /**
         * Constructs a node with some data/object but without a reference to the next node.
         * @param data data/object node will contain
         */
        private Node(T data){
            this.data=data;
            next=null;
        }

        /**
         * @return the data/object that the node contains
         */
        private T getData(){
            return data;
        }

        /**
         * Changes the data of a node 
         * @param data the data/object that you want the node to have instead
         */
        private void setData(T data){
            this.data=data;
        }
        
        /**
         * @return reference to the node after the current node
         */
        private Node getNextNode(){
            return next;
        }

        /**
         * @param next Node that you want the current node to reference
         */
        private void setNextNode(Node next){
            this.next=next;
        }
        
    }
}
