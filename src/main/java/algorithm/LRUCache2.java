package algorithm;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * LinkedHashMap 实现
 * put /get 操作 O(1)
 * 特殊情况：缓存已满，需要删除链表头
 * created by Ethan-Walker on 2019/2/16
 */
public class LRUCache2 {
    LinkedHashMap<Integer, Integer> cache;
    int capacity;

    public LRUCache2(int capacity) {
        cache = new LinkedHashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;

        int val = cache.get(key);
        cache.remove(key); // 从链表中删除
        cache.put(key, val); // 添加到链尾

        return val;

    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.remove(key); // 已经存在，链表中删除
        }

        if (capacity == cache.size()) {
            // cache 已满,删除链表头
            Set<Integer> keySet = cache.keySet();
            Iterator<Integer> iterator = keySet.iterator();
            cache.remove(iterator.next());
        }
        cache.put(key, value);// 添加到链尾
    }
}