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


    private class Node{
        private T data;
        private Node nextNode;

        private Node(T data, Node nextNode){
            this.data=data;
            this.nextNode=nextNode;    
        }

        private T getData(){
            return data;
        }

        private void setData(T data){
            this.data=data;
        }
        
        private Node getNextNode(){
            return nextNode;
        }

        private void setNextNode(Node nextNode){
            this.nextNode=nextNode;
        }
        
    }
}
