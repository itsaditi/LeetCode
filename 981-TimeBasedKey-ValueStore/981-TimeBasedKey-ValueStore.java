class TimeMap {

    HashMap<String, TreeMap<Integer, String>> map = new HashMap<>();

    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new TreeMap<>(Collections.reverseOrder()));
        }

        map.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (map.containsKey(key)) {
            if (map.get(key).containsKey(timestamp)) {
                return map.get(key).get(timestamp);
            } else {
                for (Map.Entry<Integer, String> mapElem: map.get(key).entrySet()) {
                    if (mapElem.getKey() <= timestamp)
                        return map.get(key).get(mapElem.getKey());
                }
            }
        }
        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */