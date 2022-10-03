import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;
public class ResizeableArrayBagTest 
{
 //                ~~~UNION TEST~~~

    /*
     * Tests union() on ResizableArrayBags
     * given bag1={3,3,4,5}  bag2={3,4,6}
     * expected union() result is {3,3,4,5,3,4,6}
     * !!!order of numbers may differ depending on algorithm!!!
     */
    @Test
    public void shouldGiveUnionResizArrayBag(){
        BagInterface<Integer> unionExpect = new ResizeableArrayBag<Integer>(); //creates an expected answer key of (3,3,4,5,3,4,6)
            unionExpect.add(3);
            unionExpect.add(3);
            unionExpect.add(3);
            unionExpect.add(4);
            unionExpect.add(4);
            unionExpect.add(5);
            unionExpect.add(6);
        BagInterface<Integer> bag1 = new ResizeableArrayBag<Integer>();   //creates a resiz array bag1 of (3,3,4,5)
            bag1.add(3);
            bag1.add(3);
            bag1.add(4);
            bag1.add(5);
        BagInterface<Integer> bag2 = new ResizeableArrayBag<Integer>();  //creates a resiz array bag2 of (3,4,6)
            bag2.add(3);
            bag2.add(4);
            bag2.add(6);
        BagInterface<Integer> unionActual = bag1.union(bag2);     //calculates the actual union of bag1 and bag2
        assertArrayEquals(unionExpect.toArray(), unionActual.toArray()); 
    }


    //              ~~~INTERSECTION TESTS~~~

    /*
     * Tests intersection() on ResizeableArrayBags when both bags have a repeated entry in a row
     * given bag1={1,2,2,2,3,2}  bag2={2,2,4,3,2}
     * expected intersection() result is {2,2,2,3}
     */
    @Test
    public void shouldGiveIntersectBothResizArrayBagsHaveRow(){
        BagInterface<Integer> intersectExpect = new ResizeableArrayBag<Integer>();   //creates an expected answer key of 2,2,2,3
            intersectExpect.add(2);
            intersectExpect.add(2);
            intersectExpect.add(2);
            intersectExpect.add(3);
        BagInterface<Integer> bag1 = new ResizeableArrayBag<Integer>();     //creates a resiz array bag1 of (1,2,2,2,3,2)
            bag1.add(1);
            bag1.add(2);
            bag1.add(2);
            bag1.add(2);
            bag1.add(3);
            bag1.add(2);
        BagInterface<Integer> bag2 = new ResizeableArrayBag<Integer>();    //creates resiz array bag2 of (2,2,4,3,2)
            bag2.add(2);
            bag2.add(2);
            bag2.add(4);
            bag2.add(3);
            bag2.add(2);
            BagInterface<Integer> intersectActual = bag1.intersection(bag2); //calculates the actual intersection of bag1 and bag2
            assertArrayEquals(intersectExpect.toArray(), intersectActual.toArray());
    }

    /*
     * Tests intersection() on ResizableArrayBags when only bag1 has a repeated entry in a row
     * given bag1={1,2,2,2}  bag2={2,1,3,2}
     * expected intersection() result is {1,2,2}
     */
    public void shouldGiveIntersectResizArrayBag1HasRow(){
        BagInterface<Integer> intersectExpect = new ResizeableArrayBag<Integer>(); //creates an expected answer key of (1,2,2)
            intersectExpect.add(1);
            intersectExpect.add(2);
            intersectExpect.add(2);
        BagInterface<Integer> bag1 = new ResizeableArrayBag<Integer>();   //creates a resiz array bag1 of (1,2,2,2)
            bag1.add(1);
            bag1.add(2);
            bag1.add(2);
            bag1.add(2);
        BagInterface<Integer> bag2 = new ResizeableArrayBag<Integer>();  //creates a resiz array bag2 of (2,1,3,2)
            bag2.add(2);
            bag2.add(1);
            bag2.add(3);
            bag2.add(2);
        BagInterface<Integer> intersectActual = bag1.intersection(bag2);     //calculates the actual intersection of bag1 and bag2
        assertArrayEquals(intersectExpect.toArray(), intersectActual.toArray());
    }

    /*
     * Tests intersection() on ResizableArrayBags when only bag2 has a repeated entry in a row
     * given bag1={1,2,3,4}  bag2={1,2,2,1,1}
     * expected intersection() result is {1,2}
     */
    @Test
    public void shouldGiveIntersectResizArrayBag2HasRow(){
        BagInterface<Integer> intersectExpect = new ResizeableArrayBag<Integer>(); //creates an expected answer key of (1,2)
            intersectExpect.add(1);
            intersectExpect.add(2);
        BagInterface<Integer> bag1 = new ResizeableArrayBag<Integer>();   //creates a resiz array bag1 of (1,2,3,4)
            bag1.add(1);
            bag1.add(2);
            bag1.add(3);
            bag1.add(4);
        BagInterface<Integer> bag2 = new ResizeableArrayBag<Integer>();  //creates a resiz array bag2 of (1,2,2,1,1)
            bag2.add(1);
            bag2.add(2);
            bag2.add(2);
            bag2.add(1);
            bag2.add(1);
        BagInterface<Integer> intersectActual = bag1.intersection(bag2);     //calculates the actual intersection of bag1 and bag2
        assertArrayEquals(intersectExpect.toArray(), intersectActual.toArray());
    }

    /*
     * Tests intersection() on ResizeableArrayBags when both bags don't have a repeated entry in a row
     * given bag1={1,2,3,4}  bag2={3,4,5,4}
     * expected intersection() result is {3,4}
     */
    @Test
    public void shouldGiveIntersectBothResizArrayBagsNoRow(){
        BagInterface<Integer> intersectExpect = new ResizeableArrayBag<Integer>(); //creates an expected answer key of (3,4)
            intersectExpect.add(3);
            intersectExpect.add(4);
        BagInterface<Integer> bag1 = new ResizeableArrayBag<Integer>();   //creates a resiz array bag1 of  (1,2,3,4)
            bag1.add(1);
            bag1.add(2);
            bag1.add(3);
            bag1.add(4);
        BagInterface<Integer> bag2 = new ResizeableArrayBag<Integer>();  //creates a resiz array bag2 of (3,4,5,4)
            bag2.add(3);
            bag2.add(4);
            bag2.add(5);
            bag2.add(4);
        BagInterface<Integer> intersectActual = bag1.intersection(bag2);     //calculates the actual intersection of bag1 and bag2
        assertArrayEquals(intersectExpect.toArray(), intersectActual.toArray());
    }


    //                ~~~DIFFERENCE TESTS~~~

    /*
     * Tests difference() on ResizeableArrayBags when both bags have repeated entry in a row
     * given bag1={1,2,2,3,4}  bag2={2,2,3,3,4}
     * expected difference() result is {1,4}     
    */
    @Test
    public void shouldGiveDifferenceBothResizArrayBagsHaveRow(){
        BagInterface<Integer> differenceExpect = new ResizeableArrayBag<Integer>();      //creates an expected answer key of (1,4)
            differenceExpect.add(1);
            differenceExpect.add(4);
        BagInterface<Integer> bag1 = new ResizeableArrayBag<Integer>();      //creates a resiz array bag1 of (1,2,2,3,4)
            bag1.add(1);
            bag1.add(2);
            bag1.add(2);
            bag1.add(3);
            bag1.add(4);
        BagInterface<Integer> bag2 = new ResizeableArrayBag<Integer>();      //creates a resiz array bag2 of (2,2,3,3,4)
            bag2.add(2);
            bag2.add(2);
            bag2.add(3);
            bag2.add(3);
            bag2.add(4);
        BagInterface<Integer> differenceActual = bag1.difference(bag2);     //calculates the actual difference of bag1 and bag2
        assertArrayEquals(differenceExpect.toArray(), differenceActual.toArray());
    }
    
    /*
     * Tests difference() on ResizeableArrayBags when only bag1 has repeated entry in a row
     * given bag1={1,2,2,3,3}  bag2={1,2,3,4,2}
     * expected difference() result is {3}
     */
    @Test
    public void shouldGiveDifferenceLinkedBag1HasRow(){
        BagInterface<Integer> differenceExpect = new ResizeableArrayBag<Integer>();      //creates an expected answer key of (3)
            differenceExpect.add(3);
        BagInterface<Integer> bag1 = new ResizeableArrayBag<Integer>();      //creates a resiz array bag1 of (1,2,2,3,3)
            bag1.add(1);
            bag1.add(2);
            bag1.add(2);
            bag1.add(3);
            bag1.add(3);
        BagInterface<Integer> bag2 = new ResizeableArrayBag<Integer>();      //creates a resiz array bag2 of (1,2,3,4,2)
            bag2.add(1);
            bag2.add(2);
            bag2.add(3);
            bag2.add(4);
            bag2.add(2);
        BagInterface<Integer> differenceActual = bag1.difference(bag2);     //calculates the actual difference of bag1 and bag2
        assertArrayEquals(differenceExpect.toArray(), differenceActual.toArray());
    }

    /*
     * Tests difference() on ResizeableArrayBags when only bag2 has repeated entry in a row
     * given bag1={1,2,1,3,1}  bag2={1,2,2,1,3,3}
     * expected difference() result is {1}
     */
    @Test
    public void shouldGiveDifferenceLinkedBag2HasRow(){
        BagInterface<Integer> differenceExpect = new ResizeableArrayBag<Integer>();      //creates an expected answer key of (1)
            differenceExpect.add(1);
        BagInterface<Integer> bag1 = new ResizeableArrayBag<Integer>();      //creates a resiz array bag1 of (1,2,1,3,1)
            bag1.add(1);
            bag1.add(2);
            bag1.add(1);
            bag1.add(3);
            bag1.add(1);
        BagInterface<Integer> bag2 = new ResizeableArrayBag<Integer>();      //creates a resiz array bag2 of (1,2,2,1,3,3) 
            bag2.add(1);
            bag2.add(2);
            bag2.add(2);
            bag2.add(1);
            bag2.add(3);
            bag2.add(3);
        BagInterface<Integer> differenceActual = bag1.difference(bag2);     //calculates the actual difference of bag1 and bag2
        assertArrayEquals(differenceExpect.toArray(), differenceActual.toArray());
    }

    /*
     * Tests difference() on ResizableArrayBags when both bags don't have repeated entry in a row
     * given bag1={1,2,3,4,2}  bag2={2,3,4,2,3}
     * expected difference() result is {1}
     */
    @Test
    public void shouldGiveDifferenceLinkedBagBothNoRow(){
        BagInterface<Integer> differenceExpect = new ResizeableArrayBag<Integer>();      //creates an expected answer key of (1)
            differenceExpect.add(1);
        BagInterface<Integer> bag1 = new ResizeableArrayBag<Integer>();      //creates a resiz array bag1 of (1,2,3,4,2)
            bag1.add(1);
            bag1.add(2);
            bag1.add(3);
            bag1.add(4);
            bag1.add(2);
        BagInterface<Integer> bag2 = new ResizeableArrayBag<Integer>();      //creates a resiz array bag2 of (2,3,4,2,3)
            bag2.add(2);
            bag2.add(3);
            bag2.add(4);
            bag2.add(2);
            bag2.add(3);
        BagInterface<Integer> differenceActual = bag1.difference(bag2);     //calculates the actual difference of bag1 and bag2
        assertArrayEquals(differenceExpect.toArray(), differenceActual.toArray());
    }
}