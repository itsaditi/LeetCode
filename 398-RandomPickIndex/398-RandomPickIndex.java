// Last updated: 4/21/2026, 8:52:28 PM
class Solution {
    // Elem -> indices
    HashMap<Integer, List<Integer>> indices = new HashMap<>();
    Random rand = new Random();

    public Solution(int[] nums) {
        for (int i = 0 ; i < nums.length ; i ++) {
            if (!indices.containsKey(nums[i])) {
                indices.put(nums[i], new ArrayList<>());
            }
            indices.get(nums[i]).add(i);
        }
    }
    
    public int pick(int target) {
        int l = indices.get(target).size();
        int randomIndex = indices.get(target).get(rand.nextInt(l));
        return randomIndex;
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */