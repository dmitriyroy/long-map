package de.comparus.opensource.longmap;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class LongMapImplTest<V> {

    LongMapImpl longMap;

    @Test
    public void test(){
        LongMapImpl<String> longMap = new LongMapImpl<>();
        longMap.put(2,"Два");
        longMap.put(3,"Три");
        longMap.put(8,"Восемь");
        longMap.put(1,"Один");
        longMap.put(5,"Пять");
        longMap.put(123,"Сто двадцать три");
        longMap.put(0,"Ноль");
        longMap.put(19,"Девятнадцать");
        System.out.println("longMap = " + longMap);
    }

    @Test
    public void putOneElementTest(){
        LongMapImpl<String> longMap = new LongMapImpl<>();
        longMap.put(1,"One");
        assertEquals("[1]", Arrays.toString(longMap.keys()));
        assertEquals("[One]", Arrays.toString(longMap.values()));
        assertEquals(1,longMap.size());
    }

    @Test
    public void putManyTest(){
        LongMapImpl<String> longMap = new LongMapImpl<>();
        longMap.put(2,"Два");
        longMap.put(3,"Три");
        longMap.put(8,"Восемь");
        longMap.put(1,"Один");
        longMap.put(5,"Пять");
        longMap.put(123,"Сто двадцать три");
        longMap.put(0,"Ноль");
        longMap.put(19,"Девятнадцать");
        assertEquals("[0, 1, 2, 3, 5, 8, 19, 123]", Arrays.toString(longMap.keys()));
        assertEquals("[Ноль, Один, Два, Три, Пять, Восемь, Девятнадцать, Сто двадцать три]", Arrays.toString(longMap.values()));
        assertEquals(8,longMap.size());
    }

    @Test
    public void getTest(){
        LongMapImpl<String> longMap = new LongMapImpl<>();
        longMap.put(2,"Два");
        longMap.put(3,"Три");
        longMap.put(8,"Восемь");
        longMap.put(1,"Один");
        longMap.put(5,"Пять");
        longMap.put(123,"Сто двадцать три");
        longMap.put(0,"Ноль");
        longMap.put(19,"Девятнадцать");
        assertEquals("Ноль", longMap.get(0));
        assertEquals("Пять", longMap.get(5));
        assertEquals("Сто двадцать три", longMap.get(123));
    }

    @Test
    public void keysTest(){
        LongMapImpl<String> longMap = new LongMapImpl<>();
        longMap.put(2,"Два");
        longMap.put(3,"Три");
        longMap.put(8,"Восемь");
        longMap.put(1,"Один");
        longMap.put(5,"Пять");
        longMap.put(123,"Сто двадцать три");
        longMap.put(0,"Ноль");
        longMap.put(19,"Девятнадцать");
        assertEquals("[0, 1, 2, 3, 5, 8, 19, 123]", Arrays.toString(longMap.keys()));
    }

    @Test
    public void valuesTest(){
        LongMapImpl<String> longMap = new LongMapImpl<>();
        longMap.put(2,"Два");
        longMap.put(3,"Три");
        longMap.put(8,"Восемь");
        longMap.put(1,"Один");
        longMap.put(5,"Пять");
        longMap.put(123,"Сто двадцать три");
        longMap.put(0,"Ноль");
        longMap.put(19,"Девятнадцать");
        assertEquals("[Ноль, Один, Два, Три, Пять, Восемь, Девятнадцать, Сто двадцать три]", Arrays.toString(longMap.values()));
    }

    @Test
    public void removeOneElementTest(){
        LongMapImpl<String> longMap = new LongMapImpl<>();
        longMap.put(2,"Два");
        assertEquals("[2]", Arrays.toString(longMap.keys()));
        assertEquals("[Два]", Arrays.toString(longMap.values()));
        assertEquals(1,longMap.size());
        longMap.remove(2);
        assertEquals("[]", Arrays.toString(longMap.keys()));
        assertEquals("[]", Arrays.toString(longMap.values()));
        assertEquals(0,longMap.size());
    }

    @Test
    public void removeTwoElementTest1(){
        LongMapImpl<String> longMap = new LongMapImpl<>();
        longMap.put(2,"Два");
        longMap.put(3,"Три");
        assertEquals("[2, 3]", Arrays.toString(longMap.keys()));
        assertEquals("[Два, Три]", Arrays.toString(longMap.values()));
        assertEquals(2,longMap.size());
        longMap.remove(2);
        assertEquals("[3]", Arrays.toString(longMap.keys()));
        assertEquals("[Три]", Arrays.toString(longMap.values()));
        assertEquals(1,longMap.size());
    }

    @Test
    public void removeTwoElementTest2(){
        LongMapImpl<String> longMap = new LongMapImpl<>();
        longMap.put(2,"Два");
        longMap.put(3,"Три");
        assertEquals("[2, 3]", Arrays.toString(longMap.keys()));
        assertEquals("[Два, Три]", Arrays.toString(longMap.values()));
        assertEquals(2,longMap.size());
        longMap.remove(3);
        assertEquals("[2]", Arrays.toString(longMap.keys()));
        assertEquals("[Два]", Arrays.toString(longMap.values()));
        assertEquals(1,longMap.size());
    }

    @Test
    public void removeThreeElementTest1(){
        LongMapImpl<String> longMap = new LongMapImpl<>();
        longMap.put(2,"Два");
        longMap.put(3,"Три");
        longMap.put(8,"Восемь");
        assertEquals("[2, 3, 8]", Arrays.toString(longMap.keys()));
        assertEquals("[Два, Три, Восемь]", Arrays.toString(longMap.values()));
        assertEquals(3,longMap.size());
        longMap.remove(3);
        assertEquals("[2, 8]", Arrays.toString(longMap.keys()));
        assertEquals("[Два, Восемь]", Arrays.toString(longMap.values()));
        assertEquals(2,longMap.size());
    }

    @Test
    public void removeThreeElementTest2(){
        LongMapImpl<String> longMap = new LongMapImpl<>();
        longMap.put(2,"Два");
        longMap.put(3,"Три");
        longMap.put(8,"Восемь");
        assertEquals("[2, 3, 8]", Arrays.toString(longMap.keys()));
        assertEquals("[Два, Три, Восемь]", Arrays.toString(longMap.values()));
        assertEquals(3,longMap.size());
        longMap.remove(2);
        assertEquals("[3, 8]", Arrays.toString(longMap.keys()));
        assertEquals("[Три, Восемь]", Arrays.toString(longMap.values()));
        assertEquals(2,longMap.size());
    }

    @Test
    public void removeThreeElementTest3(){
        LongMapImpl<String> longMap = new LongMapImpl<>();
        longMap.put(2,"Два");
        longMap.put(3,"Три");
        longMap.put(8,"Восемь");
        assertEquals("[2, 3, 8]", Arrays.toString(longMap.keys()));
        assertEquals("[Два, Три, Восемь]", Arrays.toString(longMap.values()));
        assertEquals(3,longMap.size());
        longMap.remove(8);
        assertEquals("[2, 3]", Arrays.toString(longMap.keys()));
        assertEquals("[Два, Три]", Arrays.toString(longMap.values()));
        assertEquals(2,longMap.size());
    }

    @Test
    public void removeTest(){
        LongMapImpl<String> longMap = new LongMapImpl<>();
        longMap.put(2,"Два");
        longMap.put(3,"Три");
        longMap.put(8,"Восемь");
        longMap.put(1,"Один");
        longMap.put(5,"Пять");
        longMap.put(123,"Сто двадцать три");
        longMap.put(0,"Ноль");
        longMap.put(19,"Девятнадцать");
        assertEquals("[0, 1, 2, 3, 5, 8, 19, 123]", Arrays.toString(longMap.keys()));
        assertEquals("[Ноль, Один, Два, Три, Пять, Восемь, Девятнадцать, Сто двадцать три]", Arrays.toString(longMap.values()));
        assertEquals(8,longMap.size());
        longMap.remove(5);
        assertEquals("[0, 1, 2, 3, 8, 19, 123]", Arrays.toString(longMap.keys()));
        assertEquals("[Ноль, Один, Два, Три, Восемь, Девятнадцать, Сто двадцать три]", Arrays.toString(longMap.values()));
        assertEquals(7,longMap.size());
    }

    @Test
    public void getIndexOneElementTest() {
        long[] arr = new long[]{2};
        longMap = new LongMapImpl();
        assertEquals(0,longMap.getIndex(arr,2));
    }

    @Test
    public void getIndexTwoElementsTest() {
        long[] arr = new long[]{2,4};
        longMap = new LongMapImpl();
        assertEquals(0,longMap.getIndex(arr,2));
        assertEquals(1,longMap.getIndex(arr,4));
    }

    @Test
    public void getIndexTest() {
        long[] arr = new long[]{2,4,5,7,14,20};
        longMap = new LongMapImpl();
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
        longMap = new LongMapImpl();
        assertEquals(0,longMap.getIndexNew(arr,0));
        assertEquals(0,longMap.getIndexNew(arr,1));
        assertEquals(0,longMap.getIndexNew(arr,111));
    }

    @Test
    public void getIndexNewOneElementTest() {
        long[] arr = new long[]{2};
        longMap = new LongMapImpl();
        assertEquals(0,longMap.getIndexNew(arr,Long.MIN_VALUE));
        assertEquals(0,longMap.getIndexNew(arr,-1));
        assertEquals(0,longMap.getIndexNew(arr,1));
        assertEquals(1,longMap.getIndexNew(arr,3));
        assertEquals(1,longMap.getIndexNew(arr,Long.MAX_VALUE));
    }

    @Test
    public void getIndexNewTwoElementTest() {
        long[] arr = new long[]{1,5};
        longMap = new LongMapImpl();
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
        longMap = new LongMapImpl();
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
