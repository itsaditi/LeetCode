// Last updated: 8/4/2025, 4:50:07 PM
class Solution {
    public int minimumOperations(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        
        for (int i: nums) arr.add(i);

        int n = nums.length;
        int index = 0;
        int minOp = 0;
        while (index >= 0) {
            if (arr.size() >= 3) {
                if (isDistint(arr)) {
                    return minOp;
                } else {
                    for (int i = 2 ; i >= 0 ; i--) {
                        arr.remove(i);
                    }
                    minOp++;
                }
            } else {
                if (isDistint(arr)) {
                    return minOp;
                } else {
                    arr.clear();
                    return minOp + 1;
                }
            }

            
        }
        return minOp;
    }

    private boolean isDistint(List<Integer> arr) {
        HashSet<Integer> set = new HashSet<>();
        for (Integer num: arr) {
            if (set.contains(num)) return false;
            set.add(num);
        }
        return true;
    }
}