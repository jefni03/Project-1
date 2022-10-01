import org.junit.Test;

public class LinkedBagTest {
    
    //bag scenarios
    //1. bag1 has multiple of same entry in a row
    //2. bag2 has multiple of same entry in a row
    //3. bag1 and bag2 have multiple of same entry in a row

    //1. bag1 has multiple


    @Test
    public void shouldGiveUnionWhen(){
        BagDriver<Integer> LinkedBag1 = new LinkedBag();
        LinkedBag1.add(5);
        LinkedBag1.add(4);
        LinkedBag1.add(2);
        LinkedBag1.add(5);
    }

    @Test
    public void shouldGiveIntersect(){

    }

    @Test
    public void shouldGiveDIfference(){

    }
}
