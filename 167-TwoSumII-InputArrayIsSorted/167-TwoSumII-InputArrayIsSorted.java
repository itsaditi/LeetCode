class Solution {

    public int[] twoSum_HashMap(int[] numbers, int target) {
        // Works only if array will not contain duplicates
        int n = numbers.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0 ; i < n ; i++) {
            map.put(numbers[i], i);
        }

        for (int i = 0 ; i < n ; i++) {
            int diff = target - numbers[i];

            if (map.containsKey(diff)) {
                if (map.get(diff) != i) {
                    return new int[]{i + 1, map.get(diff) + 1};
                }
            }
        }

        return new int[]{-1, -1};
    }

    public int[] twoSum(int[] numbers, int target) {
        // Binary search - O(log n)

        int start = 0, end = numbers.length - 1;

        while (start < end) {
            int sum = numbers[start] + numbers[end];

            if (sum == target) {
                return new int[]{start + 1, end + 1};
            } else {
                if (sum > target) {
                    end--;
                } else {
                    start++;
                }
            }
        }

        return new int[]{-1, -1};
    }
}