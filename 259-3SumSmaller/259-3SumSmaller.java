class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        

        Arrays.sort(nums);
        int count = 0;

        for(int i = 0 ; i < nums.length - 2 ; i++){

            count+= searchPair(nums, target - nums[i], i);
        }
        return count;
    }

    private int searchPair(int[] nums, int target, int first){

        int count = 0;
        int start = first + 1;
        int end = nums.length - 1;

        while(start < end){
            if(nums[start] + nums[end] < target){
                count+= end - start;
                start++;
            } else {
                end--;
            }
        }
        return count;
    }
}