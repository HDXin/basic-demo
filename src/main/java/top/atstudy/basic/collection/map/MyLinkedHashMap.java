package top.atstudy.basic.collection.map;

import java.util.Set;
public class MyLinkedHashMap<K,V> extends MyAbstractMap<K,V> implements MyMap<K,V> {

    static class Entry<K,V> extends MyHashMap.Node<K,V> {
        MyLinkedHashMap.Entry<K,V> before, after;
        Entry(int hash, K key, V value, MyHashMap.Node<K,V> next) {
            super(hash, key, value, next);
        }
    }


    @Override
    public Set<MyMap.Entry<K, V>> entrySet() {
        return null;
    }
}
