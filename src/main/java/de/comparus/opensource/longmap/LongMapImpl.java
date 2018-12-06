package de.comparus.opensource.longmap;

import sun.invoke.empty.Empty;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class LongMapImpl<V> implements LongMap<V> {

    private Set<Long> keySet = new HashSet<>();
    private Set<V> valueSet = new HashSet<>();

    private long[] keys;
    private Object[] values;
    private int mapSize;

    public LongMapImpl() {
        mapSize = 0;
        keys = new long[mapSize];
        values = new Object[mapSize];
    }

    public LongMapImpl(int initialSize) {
        if(initialSize > 0){
            keys = new long[initialSize];
            values = new Object[initialSize];
            mapSize = initialSize;
        }else{
            keys = new long[0];
            values = new Object[0];
            mapSize = 0;
        }
    }

    @Override
    public V put(long key, V value) {
        if(keySet.contains(key)){
            values[getIndex(keys,key)] = value;
            return (V) values[getIndex(keys,key)];
        }
        keySet.add(key);
        int newIndex = getIndexNew(keys,key);
        long[] keysNew = new long[mapSize+1];
        Object[] valuesNew = new Object[mapSize+1];
        System.arraycopy(keys,0,keysNew,0,newIndex);
        System.arraycopy(keys,newIndex+1,keysNew,newIndex+1,mapSize-newIndex);
        System.arraycopy(values,0,valuesNew,0,newIndex);
        System.arraycopy(values,newIndex+1,values,newIndex+1,mapSize-newIndex);
        keysNew[newIndex] = key;
        valuesNew[newIndex] = value;
        keys = keysNew;
        values = valuesNew;
        mapSize++;
        return (V)values[newIndex];
    }

    @Override
    public V get(long key) {
        if(!keySet.contains(key)) return null;
        return (V) values[getIndex(keys, key)];
    }

    public int getIndexNew(long[] arr, long value){
        if(mapSize == 0) return 0;
        int index = 0;
        int i = 0;
        int from = 0;
        int to = mapSize - 1;
        if(mapSize == 1){
            if(arr[0] < value ){
                index = 1;
            }
            return index;
        }

        i = (to - from)/2;
        while(true){
            if(arr[i] < value){
                if(i >= mapSize - 1){
                    index = mapSize;
                    break;
                }
                if(arr[i+1] > value){
                    index = i+1;
                    break;
                }
                from = i+1;
            }else{
                if(i <= 0){
                    index = 0;
                    break;
                }
                if(arr[i-1] < value){
                    index = i-1;
                    break;
                }
                to = i-1;
            }

            i = (from + to) / 2;
        }
        return index;
    }

    public int getIndex(long[] arr, long value){
        int index = 0;
        int i = 0;
        int from = 0;
        int to = mapSize - 1;
        i = (to - from)/2;
        while(true){
            if(arr[i] == value){
                index = i;
                break;
            }
            if(arr[i] < value){
                from = i+1;
            }else {
                to = i-1;
            }
            i = (from + to) / 2;
        }
        return index;
    }

    @Override
    public V remove(long key) {
        if(!keySet.contains(key)) return null;
//        keySet.

        return null;
    }

    @Override
    public boolean isEmpty() {
        return mapSize == 0 ? true : false;
    }

    @Override
    public boolean containsKey(long key) {
        return keySet.contains(key) ? true : false;
    }

    @Override
    public boolean containsValue(V value) {
        return valueSet.contains(value) ? true : false;
    }

    @Override
    public long[] keys() {
        return keys;
    }

    @Override
    public V[] values() {
        return (V[]) values;
    }

    @Override
    public long size() {
        return mapSize;
    }

    @Override
    public void clear() {
        mapSize = 0;
        keys = new long[0];
        values = new Object[0];
        keySet = new HashSet<>();
        valueSet = new HashSet<>();
    }


}
