package design;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 146. LRU Cache
 */
public class LRUCache {
    private Cache cache;

    public LRUCache(int capacity) {
        cache = new Cache(capacity);
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }

    private static class Cache extends LinkedHashMap<Integer, Integer> {
        private int capacity;

        public Cache(int capacity) {
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > capacity;
        }
    }
}
