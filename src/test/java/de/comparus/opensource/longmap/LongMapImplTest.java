package de.comparus.opensource.longmap;

import org.junit.Test;
import sun.invoke.empty.Empty;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LongMapImplTest<V> {

    LongMapImpl longMap;

    @Test
    public void getIndexOneElementTest() {
        long[] arr = new long[]{2};
        longMap = new LongMapImpl(arr.length);
        assertEquals(0,longMap.getIndex(arr,2));
    }

    @Test
    public void getIndexTwoElementsTest() {
        long[] arr = new long[]{2,4};
        longMap = new LongMapImpl(arr.length);
        assertEquals(0,longMap.getIndex(arr,2));
        assertEquals(1,longMap.getIndex(arr,4));
    }

    @Test
    public void getIndexTest() {
        long[] arr = new long[]{2,4,5,7,14,20};
        longMap = new LongMapImpl(arr.length);
        assertEquals(0,longMap.getIndex(arr,2));
        assertEquals(1,longMap.getIndex(arr,4));
        assertEquals(2,longMap.getIndex(arr,5));
        assertEquals(3,longMap.getIndex(arr,7));
        assertEquals(4,longMap.getIndex(arr,14));
        assertEquals(5,longMap.getIndex(arr,20));
    }

    @Test
    public void getIndexNewZeroElementTest() {
        long[] arr = new long[0];
        longMap = new LongMapImpl(arr.length);
        assertEquals(0,longMap.getIndexNew(arr,0));
        assertEquals(0,longMap.getIndexNew(arr,1));
        assertEquals(0,longMap.getIndexNew(arr,111));
    }

    @Test
    public void getIndexNewOneElementTest() {
        long[] arr = new long[]{2};
        longMap = new LongMapImpl(arr.length);
        assertEquals(0,longMap.getIndexNew(arr,Long.MIN_VALUE));
        assertEquals(0,longMap.getIndexNew(arr,-1));
        assertEquals(0,longMap.getIndexNew(arr,1));
        assertEquals(1,longMap.getIndexNew(arr,3));
        assertEquals(1,longMap.getIndexNew(arr,Long.MAX_VALUE));
    }

    @Test
    public void getIndexNewTwoElementTest() {
        long[] arr = new long[]{1,5};
        longMap = new LongMapImpl(arr.length);
        assertEquals(0,longMap.getIndexNew(arr,Long.MIN_VALUE));
        assertEquals(0,longMap.getIndexNew(arr,-1));
        assertEquals(0,longMap.getIndexNew(arr,0));
        assertEquals(1,longMap.getIndexNew(arr,2));
        assertEquals(1,longMap.getIndexNew(arr,4));
        assertEquals(2,longMap.getIndexNew(arr,7));
        assertEquals(2,longMap.getIndexNew(arr,Long.MAX_VALUE));
    }

    @Test
    public void getIndexNewTest() {
        long[] arr = new long[]{2,4,5,7,14,20};
        longMap = new LongMapImpl(arr.length);
        assertEquals(0,longMap.getIndexNew(arr,Long.MIN_VALUE));
        assertEquals(0,longMap.getIndexNew(arr,-121));
        assertEquals(0,longMap.getIndexNew(arr,-1));
        assertEquals(0,longMap.getIndexNew(arr,0));
        assertEquals(0,longMap.getIndexNew(arr,1));
        assertEquals(1,longMap.getIndexNew(arr,3));
        assertEquals(3,longMap.getIndexNew(arr,6));
        assertEquals(5,longMap.getIndexNew(arr,15));
        assertEquals(6,longMap.getIndexNew(arr,21));
        assertEquals(6,longMap.getIndexNew(arr,Long.MAX_VALUE));
    }
}
