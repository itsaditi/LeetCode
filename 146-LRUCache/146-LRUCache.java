class LRUCache {

    HashMap<Integer, Integer> cache;
    List<Integer> list;
    int cacheCapacity = 0;
    public LRUCache(int capacity) {
        cache = new HashMap<>();
        list = new ArrayList<>();
        cacheCapacity = capacity;
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            list.remove(Integer.valueOf(key));
            list.add(key);
            return cache.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {


        if (cache.size() == cacheCapacity && !cache.containsKey(key)) {
            cache.remove(list.get(0));
            list.remove(Integer.valueOf(list.get(0)));
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