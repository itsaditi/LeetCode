class LRUCache {

    HashMap<Integer, Integer> cache;
    Queue<Integer> list;
    int cacheCapacity = 0;
    public LRUCache(int capacity) {
        cache = new HashMap<>();
        list = new LinkedList<>();
        cacheCapacity = capacity;
    }
    
    // Time Complexity - O(N)
    public int get(int key) {
        if (cache.containsKey(key)) {
            list.remove(Integer.valueOf(key)); // O(N)
            list.add(key); // O(1)
            return cache.get(key);
        }
        return -1;
    }
    
    // Time Complexity - O(N)
    public void put(int key, int value) {


        if (cache.size() == cacheCapacity && !cache.containsKey(key)) {
            cache.remove(list.poll());
            
        }

        if (cache.containsKey(key)) {
            list.remove(Integer.valueOf(key));
        }
        cache.put(key, value);
        list.add(key);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */