/**
* Import arrays framework 
*/
import java.util.Arrays;
public class BagDriver 
{
    public static void main(String args[])
    {
    /**
     * Creates two bags of LinkedBag Type that takes String values
     */
    BagInterface <String> bag1 = new LinkedBag <String>();
    BagInterface <String> bag2 = new LinkedBag <String>();

    /**
     * Bags are filled with letters to test the methods 
     */
    bag1.add("a");
    bag1.add("b");
    bag1.add("c");
    bag2.add("b");
    bag2.add("b");
    bag2.add("d");
    bag2.add("e");


    /**
     * Methods are called with the results printed out 
     */
    System.out.println(Arrays.toString(bag1.union(bag2).toArray()));
    System.out.println(Arrays.toString(bag1.intersection(bag2).toArray()));
    System.out.println(Arrays.toString(bag1.difference(bag2).toArray()));
    System.out.println(Arrays.toString(bag2.difference(bag1).toArray()));

    /**
     * Creaates two bags of ResizeableArrayBag Type that takes String values
     */
    BagInterface <String> bag3 = new ResizeableArrayBag <String>();
    BagInterface <String> bag4 = new ResizeableArrayBag <String>();

    /**
     * Bags are filled with letters to test the methods 
     */
    bag3.add("a");
    bag3.add("b");
    bag3.add("c");
    bag4.add("b");
    bag4.add("b");
    bag4.add("d");
    bag4.add("e");

    /**
     * Methods are called with the results printed out 
     */
    System.out.println(Arrays.toString(bag3.union(bag4).toArray()));
    System.out.println(Arrays.toString(bag3.intersection(bag4).toArray()));
    System.out.println(Arrays.toString(bag3.difference(bag4).toArray()));
    System.out.println(Arrays.toString(bag4.difference(bag3).toArray()));
    }
}

