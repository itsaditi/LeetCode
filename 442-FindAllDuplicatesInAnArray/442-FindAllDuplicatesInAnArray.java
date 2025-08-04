// Last updated: 8/4/2025, 4:51:11 PM
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int i = 0;
        int n = nums.length;
        List<Integer> duplicates = new ArrayList<>();

        while(i < n){
            int j = nums[i] - 1;
            if(nums[i] != nums[j]){

                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            } else {
                i++;
            }
        }

        for(int j = 0 ; j < n ; j++){
            if(nums[j] != j+1){
                duplicates.add(nums[j]);
            }
        }
        return duplicates;
    }
}