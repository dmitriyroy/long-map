package de.comparus.opensource.longmap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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

//    public LongMapImpl(int initialSize) {
//        if(initialSize > 0){
//            keys = new long[initialSize];
//            values = new Object[initialSize];
//            mapSize = initialSize;
//        }else{
//            keys = new long[0];
//            values = new Object[0];
//            mapSize = 0;
//        }
//    }

    @Override
    public V put(long key, V value) {
        if(keySet.contains(key)){
            values[getIndex(keys,key)] = value;
            return (V) values[getIndex(keys,key)];
        }
        keySet.add(key);
        valueSet.add(value);
        int i = getIndexNew(keys,key);
        long[] keysNew = new long[mapSize+1];
        Object[] valuesNew = new Object[mapSize+1];
        System.arraycopy(keys,0,keysNew,0, i);
        System.arraycopy(values,0,valuesNew,0,i);
        if((i) < mapSize) {
            System.arraycopy(keys, i, keysNew, i+1, mapSize - i);
            System.arraycopy(values, i, valuesNew, i+1, mapSize - i);
        }
        keysNew[i] = key;
        valuesNew[i] = value;
        keys = keysNew;
        values = valuesNew;
        mapSize++;

        return (V)values[i];
    }

    @Override
    public V get(long key) {
        if(!keySet.contains(key)) return null;
        return (V) values[getIndex(keys, key)];
    }

    @Override
    public V remove(long key) {
        if(!keySet.contains(key)) return null;
        int i = getIndex(keys, key);
        V v = (V) values[i];

        long[] keysNew = new long[mapSize-1];
        Object[] valuesNew = new Object[mapSize-1];
        System.arraycopy(keys,0,keysNew,0,i);
        System.arraycopy(keys,i+1,keysNew,i,mapSize-i-1);
        System.arraycopy(values,0,valuesNew,0,i);
        System.arraycopy(values,i+1,valuesNew,i,mapSize-i-1);
        keys = keysNew;
        values = valuesNew;
        mapSize--;

        return v;
    }

    public int getIndexNew(long[] arr, long value){
        if(arr.length == 0) return 0;
        int index = 0;
        int i = 0;
        int from = 0;
        int to = arr.length - 1;
        if(arr.length == 1){
            if(arr[0] < value ){
                index = 1;
            }
            return index;
        }

        i = (to - from)/2;
        while(true){
            if(arr[i] < value){
                if(i >= arr.length - 1){
                    index = arr.length;
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
        int to = arr.length - 1;
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

    @Override
    public String toString() {
        return "LongMapImpl{" +
                "keySet=" + keySet +
                ", valueSet=" + valueSet +
                ", keys=" + Arrays.toString(keys) +
                ", values=" + Arrays.toString(values) +
                ", mapSize=" + mapSize +
                '}';
    }
}
