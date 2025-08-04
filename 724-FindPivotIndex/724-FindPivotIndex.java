// Last updated: 8/4/2025, 4:50:59 PM
import java.io.*;
import java.util.*; 

class Solution {
    public int pivotIndex(int[] nums) {
        
        if(nums.length == 0) return -1;
        
        for (int i = 0 ; i < nums.length ; i++) {
            int possiblePivotIndex = i;

            int sumLeft = 0;
            int sumRight = 0;
            
            for (int j = 0 ; j < possiblePivotIndex ; j ++) {
                sumLeft += nums[j];
            }
            
            for (int k = i+1; k < nums.length; k++) {
                // rightArray.add(nums[k]);
                sumRight += nums[k];
            }

            if (sumRight == sumLeft) {
                return possiblePivotIndex;
            }
            
        }
        
        return -1;
    }
}