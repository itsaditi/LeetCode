// Last updated: 8/4/2025, 4:50:24 PM
class Solution {
    public int findKthPositive(int[] arr, int k) {
        
        for(int i = 0; i < arr.length ; i++){
            if(arr[i] <= k){
                k++;
            }
        }
        return k;
    }
}