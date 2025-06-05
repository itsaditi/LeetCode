// Last updated: 6/4/2025, 9:22:15 PM
class Solution {
    public int[] resultArray(int[] nums) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        arr1.add(nums[0]);
        arr2.add(nums[1]);

        for (int i = 2; i < nums.length ; i++) {
            if (arr1.getLast() > arr2.getLast()) {
                arr1.add(nums[i]);
            } else {
                arr2.add(nums[i]);
            }
        }

        // int[] resultArr = new int[arr1.size() + arr2.size()];
        // int index = 0;

        // for (int num: arr1) {
        //     resultArr[index] = num;
        //     index++;
        // }
        
        // for (int num: arr2) {
        //     resultArr[index] = num;
        //     index++;
        // }

        arr1.addAll(arr2);
        


        return arr1.stream().mapToInt(Integer::intValue).toArray();

    }
}