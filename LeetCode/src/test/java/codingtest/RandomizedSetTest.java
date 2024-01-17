package codingtest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomizedSetTest {
    @Test
    void test1() {
        RandomizedSet randomizedSet = new RandomizedSet();
        assertEquals(true,randomizedSet.insert(1));
        assertEquals(false,randomizedSet.remove(2));
        assertEquals(true,randomizedSet.insert(2));
//        assertEquals(2,randomizedSet.getRandom());
        assertEquals(true,randomizedSet.remove(1));
        assertEquals(false,randomizedSet.insert(2));
        assertEquals(2,randomizedSet.getRandom());
    }
}