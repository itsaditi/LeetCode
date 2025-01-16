class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> occMap = new HashMap<>();
        PriorityQueue<String> minHeap = new PriorityQueue<>(
            (w1,w2) -> occMap.get(w1).equals(occMap.get(w2)) ? w2.compareTo(w1) : occMap.get(w1) -  occMap.get(w2)
        );

        for (String word: words) {
            if (!occMap.containsKey(word)) {
                occMap.put(word, 0);
            }

            occMap.put(word, occMap.get(word) + 1);
        }

        for (String key: occMap.keySet()) {
            
            minHeap.offer(key);
            if (minHeap.size() > k) {
                minHeap.poll();
            }            
        }

        List<String> kFreq = new ArrayList<>();

        while (!minHeap.isEmpty()) {
            String poppedElem = minHeap.poll();
            kFreq.add(poppedElem);
        }
        Collections.reverse(kFreq);

        return kFreq;

    }
}