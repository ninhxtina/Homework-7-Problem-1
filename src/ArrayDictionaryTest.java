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
        ArrayDictionary empty = new ArrayDictionary(0);
        ArrayDictionary t = new ArrayDictionary(1);
        ArrayDictionary t2 = new ArrayDictionary(2);
        ArrayDictionary t3 = new ArrayDictionary(3);
        ArrayDictionary t4 = new ArrayDictionary(4);

        //empty dictionary
        assertFalse(empty.contains(-1));
        assertFalse(empty.contains(0));
        assertFalse(empty.contains(1));

        //test 1
        t.add(0,103);
        assertFalse(t.contains(2));
        assertTrue(t.contains(0));

        //test 2
        t2.add(0,103);
        t2.add(1,105);
        assertTrue(t2.contains(0));
        assertTrue(t2.contains(1));
        assertFalse(t2.contains(2));

        //test 3
        t3.add(0,103);
        t3.add(1,105);
        assertFalse(t3.contains(3));
        t3.add(2,206);
        assertTrue(t3.contains(1));

        //test 4
        t4.add(0,103);
        t4.add(1,105);
        t4.add(2,206);
        t4.add(4,407);
        assertTrue(t4.contains(1));
        assertTrue(t4.contains(4));
        assertFalse(t4.contains(7));
        assertFalse(t4.contains(8));
    }
}