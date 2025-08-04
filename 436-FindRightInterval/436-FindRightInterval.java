// Last updated: 8/4/2025, 4:51:13 PM
class Solution {
    // O(n logn) and o(n)
    public int[] findRightInterval(int[][] intervals) {
        
       int size = intervals.length;
       int[] arr = new int[size];
       int[] ans = new int[size];

       for(int i = 0 ; i < size ; i++){
            arr[i] = intervals[i][0];
       }

       HashMap<Integer, Integer> map = new HashMap<>();
       for(int i = 0 ; i < size ; i++){
            map.put(arr[i], i);
       }

       Arrays.sort(arr);
       for(int i = 0; i < size ; i++){
            int value = BS(arr, intervals[i][1]);
            if(value == -1){
                ans[i] = -1;
            } else {
                ans[i] = map.get(arr[value]);
            }
       }
        return ans;

    }
    private int BS(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;
        int ans = -1;

        while(left <= right){
            int mid = (left +right) /2;
            if(arr[mid] == target)
                return mid;
            else if(arr[mid] > target){
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}