import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayDictionaryTest {
    @Test
    public void demo() {
        int testSize = 5;
        ArrayDictionary dict = new ArrayDictionary(testSize);
        assertTrue(dict.add(2, 82));
        assertTrue(dict.add(4, 84));
        assertTrue(dict.add(7, 87));
        System.out.println(dict);
    }

    @Test
    public void remove() {
        // homework
        ArrayDictionary empty = new ArrayDictionary(0);
        ArrayDictionary t = new ArrayDictionary(5);
        ArrayDictionary t2 = new ArrayDictionary(4);

        assertFalse(empty.remove(3)); //empty dictionary

        t.add(0,10);
        t.add(1,30);
        t.add(2,40);
        assertTrue(t.remove(1));
        assertFalse(t.remove(1));
        assertTrue(t.remove(0));
        assertFalse(t.remove(5));

        t2.add(0,12);
        t2.add(1,15);
        t2.add(3,37);
        t2.add(9,20);
        assertTrue(t2.remove(1));
        assertTrue(t2.remove(0));
        assertFalse(t2.remove(5));
        assertFalse(t2.remove(11));
    }

    @Test
    public void contains() {
        // homework
        assertTrue(false);  // place holder
    }
}