package algorithm;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Cache<K, V> {
    private Map<K, V> map = null;
    //private Lock lock=new ReentrantLock();

    private int segemantSize = 16;

    private ReentrantReadWriteLock[] readWriteLocks = null;

    public Cache() {
        map = new ConcurrentHashMap<K, V>(16);
    }

    public Cache(int capacity) {
        map = new ConcurrentHashMap<K, V>(capacity);
    }

    public Cache(Map<K, V> map) {
        this.map = map;
        for (int i = 0; i < segemantSize; i++) {
            readWriteLocks[i] = new ReentrantReadWriteLock();
        }
    }


    public V getCache(K key) {
        if (map instanceof ConcurrentHashMap) {
            return map.get(key);
        } else {
            return getCacheMap(key);
        }
    }

    private int hash(K key) {
        return key.hashCode() % segemantSize;
    }

    private V getCacheMap(K key) {
        int hash = hash(key);
        readWriteLocks[hash].readLock().tryLock();
        try {
            return map.get(key);
        } finally {
            readWriteLocks[hash].readLock().unlock();
        }
    }

    public void setCache(K key, V value) {
        if (map instanceof ConcurrentHashMap) {
            map.put(key, value);
        } else {
            setCacheMap(key, value);
        }
    }

    private void setCacheMap(K key, V value) {
        int hash = hash(key);
        readWriteLocks[hash].writeLock().tryLock();
        try {
            map.put(key, value);
        } finally {
            readWriteLocks[hash].writeLock().unlock();
        }
    }


}
