public class LinkedBag<T> implements BagInterface<T>
{
    private Node firstNode;
    private int numberOfEntries;

    public LinkedBag()
    {
        firstNode = null;
        numberOfEntries = 0;
    }
    public int getCurrentSize()
    {
        return numberOfEntries;
    }
    public boolean isEmpty()
    {
        return numberOfEntries == 0;
    }
    public boolean add(T entry)
    {
        Node newNode = new Node(entry);
        newNode.next = firstNode;
        firstNode = newNode;
        numberOfEntries++;
        return true;
    }

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

    public void clear()
    {
        while(!isEmpty())
        {
            remove();
        }
    }

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

    public T union(T bag)
    {
        //clone bags before looking through them so it isn't possible to change data inside of original
        //

    }

    public T intersection(T bag)
    {

    }

    public T difference(T bag)
    {

    }


    private class Node{
        private T data;
        private Node nextNode;

        //Node constructor, which has data and connection to next node
        private Node(T data, Node nextNode){
            this.data=data;
            this.nextNode=nextNode;    
        }
        
        //Node constructor, which makes node without a connection to another node
        private Node(T data){
            this.data=data;
            nextNode=null;
        }

        //returns the data of current node
        private T getData(){
            return data;
        }

        //sets data of current node
        private void setData(T data){
            this.data=data;
        }
        
        //returns the node after current node
        private Node getNextNode(){
            return nextNode;
        }

        //sets the next node after the current node to something else
        private void setNextNode(Node nextNode){
            this.nextNode=nextNode;
        }
        
    }
}
