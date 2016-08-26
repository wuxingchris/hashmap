package com.chris.hash;

/**
 * Created by wuxing on 2016/8/26.
 */
public class MyEntry<K, V> {
    final K key;
    V value;
    MyEntry<K, V> next;

    public MyEntry(K key,  V value ,MyEntry<K, V> next) {
        this.key = key;
        this.next = next;
        this.value = value;
    }

    public final K getKey() {
        return key;
    }

    public final V getValue() {
        return value;
    }

    public final V setValue(V newValue) {
        V oldValue = value;
        value = newValue;
        return oldValue;
    }

    public final boolean equals(Object o){
        if(!(o instanceof MyEntry)){
            return false;
        }
        MyEntry e = (MyEntry)o;
        Object k1 = getKey();
        Object k2 = e.getKey();
        if(k1 == k2 || (k1 != null && k1.equals(k2))){
            Object v1 = getValue();
            Object v2 = e.getValue();
            if(v1 == v2 || (v1 != null && v1.equals(v2))){
                return true;
            }
        }
        return false;
    }

    public final int hasCode(){
        return (key == null ? 0: key.hashCode()) ^ (value == null ? 0 : value.hashCode());
    }

    public final String toString(){
        return getKey() + "=" + getValue();
    }
}
