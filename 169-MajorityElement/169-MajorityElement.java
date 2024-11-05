class Solution {
    public int majorityElement(int[] nums) {
        // Sorted map, meaning one can put elements in any format,
        // it will return elements in sorted way

        // How do I pop elements in descending order ?

        // Key - Element and Value - Occurenec of that elemenct
        TreeMap <Integer, Integer> occMap = new TreeMap<>(Collections.reverseOrder());

        for (Integer num: nums) {
            occMap.put(num, occMap.getOrDefault(num, 0) + 1);
        }

        int majorityElemBound = nums.length / 2 ;
        for(Map.Entry<Integer, Integer> mapElem: occMap.entrySet()) {
            if (mapElem.getValue() > majorityElemBound) {
                return mapElem.getKey();
            }
        }

        return 0;
    }
}