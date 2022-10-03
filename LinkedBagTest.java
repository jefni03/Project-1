import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;
public class LinkedBagTest
{
    @Test
    public void shouldGiveLinkedBagUnion(){
        BagInterface<Integer> bag1 = new LinkedBag<>(); //creates linked bag1 with (4,3,2,1)
        bag1.add(1);
        bag1.add(2);
        bag1.add(3);
        bag1.add(4);
        BagInterface<Integer> bag2 = new LinkedBag<>(); //creates linked bag2 with (5,4,3)
        bag2.add(3);
        bag2.add(4);
        bag2.add(5);
        BagInterface<Integer> expectUnion = new LinkedBag<>(); //creates expected answer key of (5,4,3,4,3,2,1)
        expectUnion.add(5);
        expectUnion.add(4);
        expectUnion.add(3);
        expectUnion.add(4);
        expectUnion.add(3);
        expectUnion.add(2);
        expectUnion.add(1);
        BagInterface<Integer> actualUnion = bag1.union(bag2);
        assertArrayEquals(expectUnion.toArray(), actualUnion.toArray());
    
    }

    @Test
    public void shouldGiveIntersectBothLinkedBagsHaveRow(){
        BagInterface<Integer> intersectExpect = new LinkedBag<Integer>();   //creates an expected answer key of (3,2,2,2)
            intersectExpect.add(2);
            intersectExpect.add(2);
            intersectExpect.add(2);
            intersectExpect.add(3);
        BagInterface<Integer> bag1 = new LinkedBag<Integer>();     //creates a linked bag1 of (1,2,2,2,3,2)
            bag1.add(2);
            bag1.add(3);
            bag1.add(2);
            bag1.add(2);
            bag1.add(2);
            bag1.add(1);
        BagInterface<Integer> bag2 = new LinkedBag<Integer>();    //creates linked bag2 of (2,2,4,3,2)
            bag2.add(2);
            bag2.add(3);
            bag2.add(4);
            bag2.add(2);
            bag2.add(2);
            BagInterface<Integer> intersectActual = bag1.intersection(bag2); //calculates the actual intersection of bag1 and bag2
            assertArrayEquals(intersectExpect.toArray(), intersectActual.toArray());
    }

    @Test
    public void shouldGiveIntersectLinkedBag1HasRow(){
        BagInterface<Integer> intersectExpect = new LinkedBag<Integer>(); //creates an expected answer key of (1,2,2)
            intersectExpect.add(2);
            intersectExpect.add(2);
            intersectExpect.add(1);
        BagInterface<Integer> bag1 = new LinkedBag<Integer>();   //creates a linked bag1 of (2,2,2,1)
            bag1.add(1);
            bag1.add(2);
            bag1.add(2);
            bag1.add(2);
        BagInterface<Integer> bag2 = new LinkedBag<Integer>();  //creates a linked bag2 of (2,3,1,2)
            bag2.add(2);
            bag2.add(1);
            bag2.add(3);
            bag2.add(2);
        BagInterface<Integer> intersectActual = bag1.intersection(bag2);     //calculates the actual intersection of bag1 and bag2
        assertArrayEquals(intersectExpect.toArray(), intersectActual.toArray());
    }

    @Test
    public void shouldGiveIntersectLinkedBag2HasRow(){
        BagInterface<Integer> intersectExpect = new LinkedBag<Integer>(); //creates an expected answer key of (1,2)
            intersectExpect.add(2);
            intersectExpect.add(1);
        BagInterface<Integer> bag1 = new LinkedBag<Integer>();   //creates a linked bag1 of (4,3,2,1)
            bag1.add(1);
            bag1.add(2);
            bag1.add(3);
            bag1.add(4);
        BagInterface<Integer> bag2 = new LinkedBag<Integer>();  //creates a linked bag2 of (1,1,2,2,1)
            bag2.add(1);
            bag2.add(2);
            bag2.add(2);
            bag2.add(1);
            bag2.add(1);
        BagInterface<Integer> intersectActual = bag1.intersection(bag2);     //calculates the actual intersection of bag1 and bag2
        assertArrayEquals(intersectExpect.toArray(), intersectActual.toArray());
    }

    @Test
    public void shouldGiveIntersectBothLinkedBagsNoRow(){
        BagInterface<Integer> intersectExpect = new LinkedBag<Integer>(); //creates an expected answer key of (3,4)
            intersectExpect.add(4);
            intersectExpect.add(3);
        BagInterface<Integer> bag1 = new LinkedBag<Integer>();   //creates a linked bag1 of  (4,3,2,1)
            bag1.add(1);
            bag1.add(2);
            bag1.add(3);
            bag1.add(4);
        BagInterface<Integer> bag2 = new LinkedBag<Integer>();  //creates a linked bag2 of (4,5,4,3)
            bag2.add(3);
            bag2.add(4);
            bag2.add(5);
            bag2.add(4);
        BagInterface<Integer> intersectActual = bag1.intersection(bag2);     //calculates the actual intersection of bag1 and bag2
        assertArrayEquals(intersectExpect.toArray(), intersectActual.toArray());
    }

    @Test
    public void shouldGiveDifferenceBothLinkedBagsHaveRow(){
        BagInterface<Integer> differenceExpect = new LinkedBag<Integer>();      //creates an expected answer key of (1)
            differenceExpect.add(1);
        BagInterface<Integer> bag1 = new LinkedBag<Integer>();      //creates a linked bag1 of (4,3,2,2,1)
            bag1.add(1);
            bag1.add(2);
            bag1.add(2);
            bag1.add(3);
            bag1.add(4);
        BagInterface<Integer> bag2 = new LinkedBag<Integer>();      //creates a linked bag2 of (4,3,3,2,2)
            bag2.add(2);
            bag2.add(2);
            bag2.add(3);
            bag2.add(3);
            bag2.add(4);
        BagInterface<Integer> differenceActual = bag1.difference(bag2);     //calculates the actual difference of bag1 and bag2
        assertArrayEquals(differenceExpect.toArray(), differenceActual.toArray());
    }

    @Test
    public void shouldGiveDifferenceLinkedBag1HasRow(){
        BagInterface<Integer> differenceExpect = new LinkedBag<Integer>();      //creates an expected answer key of (3)
            differenceExpect.add(3);
        BagInterface<Integer> bag1 = new LinkedBag<Integer>();      //creates a linked bag1 of (1,2,2,3,3)
            bag1.add(1);
            bag1.add(2);
            bag1.add(2);
            bag1.add(3);
            bag1.add(3);
        BagInterface<Integer> bag2 = new LinkedBag<Integer>();      //creates a linked bag2 of (1,2,3,4,2)
            bag2.add(1);
            bag2.add(2);
            bag2.add(3);
            bag2.add(4);
            bag2.add(2);
        BagInterface<Integer> differenceActual = bag1.difference(bag2);     //calculates the actual difference of bag1 and bag2
        assertArrayEquals(differenceExpect.toArray(), differenceActual.toArray());
    }

    @Test
    public void shouldGiveDifferenceLinkedBag2HasRow(){
        BagInterface<Integer> differenceExpect = new LinkedBag<Integer>();      //creates an expected answer key of (1)
            differenceExpect.add(1);
        BagInterface<Integer> bag1 = new LinkedBag<Integer>();      //creates a linked bag1 of (1,2,1,3,1)
            bag1.add(1);
            bag1.add(2);
            bag1.add(1);
            bag1.add(3);
            bag1.add(1);
        BagInterface<Integer> bag2 = new LinkedBag<Integer>();      //creates a linked bag2 of (1,2,2,1,3,3) 
            bag2.add(1);
            bag2.add(2);
            bag2.add(2);
            bag2.add(1);
            bag2.add(3);
            bag2.add(3);
        BagInterface<Integer> differenceActual = bag1.difference(bag2);     //calculates the actual difference of bag1 and bag2
        assertArrayEquals(differenceExpect.toArray(), differenceActual.toArray());
    }

    @Test
    public void shouldGiveDifferenceResizBagBothNoRow(){
        BagInterface<Integer> differenceExpect = new LinkedBag<Integer>();      //creates an expected answer key of (1)
            differenceExpect.add(1);
        BagInterface<Integer> bag1 = new LinkedBag<Integer>();      //creates a linked bag1 of (1,2,3,4,2)
            bag1.add(1);
            bag1.add(2);
            bag1.add(3);
            bag1.add(4);
            bag1.add(2);
        BagInterface<Integer> bag2 = new LinkedBag<Integer>();      //creates a linked bag2 of (2,3,4,2,3)
            bag2.add(2);
            bag2.add(3);
            bag2.add(4);
            bag2.add(2);
            bag2.add(3);
        BagInterface<Integer> differenceActual = bag1.difference(bag2);     //calculates the actual difference of bag1 and bag2
        assertArrayEquals(differenceExpect.toArray(), differenceActual.toArray());
    }
}