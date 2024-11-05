// class Solution {
//     public int majorityElement(int[] nums) {
//         // Sorted map, meaning one can put elements in any format,
//         // it will return elements in sorted way

//         // How do I pop elements in descending order ?
//         //      By using Collections.reverseOrder() while initializaing TreeMap

//         // Key - Element and Value - Occurenec of that elemenct
//         TreeMap <Integer, Integer> occMap = new TreeMap<>();
//         int majorityElemBound = nums.length / 2 ;

//         for (Integer num: nums) {
//             occMap.put(num, occMap.getOrDefault(num, 0) + 1);
//             if (occMap.get(num) > majorityElemBound) return num;
//         }

//         return 0;
//     }
// }

class Solution {
    private Map<Integer, Integer> countNums(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num, 1);
            } else {
                counts.put(num, counts.get(num) + 1);
            }
        }
        return counts;
    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counts = countNums(nums);

        Map.Entry<Integer, Integer> majorityEntry = null;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (entry.getValue() > nums.length / 2) return entry.getKey();
        }

        return majorityEntry.getKey();
    }
}