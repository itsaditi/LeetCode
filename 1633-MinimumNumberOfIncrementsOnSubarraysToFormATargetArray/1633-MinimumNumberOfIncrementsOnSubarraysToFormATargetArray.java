// Last updated: 8/4/2025, 4:50:25 PM
class Solution {
    public int minNumberOperations(int[] target) {

        int n = target.length;
        int prev = 0, res = 0;
        for(int i = 0 ; i < n ; i++){
            if(target[i] > prev)
                res += (target[i] - prev);
            prev = target[i];
        }
        return res;
        
        /*Time Limit Exceeded - Using Sliding Window*/
        // int[] arr = new int[target.length];

        // int start = 0;
        // int numOfOp = 0;
        // while (start < target.length) {
        //     int end = 0;
        //     while (start < target.length) {
        //         if (target[start] == arr[start]) {
        //             start++;
        //         } else {
        //             break;
        //         }
        //     }
        //     if (start == target.length) break;
        //     end = start + 1;
        //     while (end < target.length) {
                
        //         if (target[end] != arr[end]) {
        //             end++;
        //         } else {
        //             break;
        //         }
        //     }
        //     incrementSubArray(arr, start, end - 1);
        //     end = 0;
        //     start = 0;
        //     numOfOp++;
        // }
        // return numOfOp;
    }

    private void incrementSubArray(int[] arr, int start, int end) {
        while (start <= end && start < arr.length) {
            arr[start]++;
            start++;
        }
    }
}