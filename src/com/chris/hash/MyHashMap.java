package com.chris.hash;

import java.util.Objects;

/**
 * Created by wuxing on 2016/8/26.
 */
public class MyHashMap<K,V> {
    private MyEntry[] table;
    static  final  int DEFAULT_INITIAL_CAPACITY = 16;
    private int size;

    public MyHashMap(){
        table = new MyEntry[DEFAULT_INITIAL_CAPACITY];
        size = DEFAULT_INITIAL_CAPACITY;
    }

    public int getSize(){
        return size;
    }

    static int indexFor(int h, int length){
        return h & (length -1);
    }

    public V get(Object key){
        if (key == null){
            return null;
        }
        int hash = key.hashCode();
        int index = indexFor(hash, table.length);
        for (MyEntry<K,V> e = table[index];
                e != null;
                e = e.next){
            Object k = e.getKey();
            if(e.key.hashCode() == hash && (k == key || k.equals(key))){
                return e.value;
            }
        }
        return null;
    }

    public V put(K key, V value){
        if(key == null){
            return null;
        }
        int hash = key.hashCode();
        int index = indexFor(hash, table.length);

        for(MyEntry<K, V> e = table[index];
                e != null;
                e = e.next){
            Object k = e.value;
            if(e.key.hashCode() == hash && (k == key || k.equals(k))){
                V oldValue = e.value;
                e.value = value;
                return oldValue;
            }
        }
        MyEntry<K, V> e = table[index];
        table[index]= new MyEntry<K, V>(key, value, e);
        return null;
    }

    public static void main(String[] args) {
        System.out.println(8 & 15);
    }
}
