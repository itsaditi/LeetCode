// Last updated: 6/15/2025, 11:05:17 PM
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String res = "";

        int smallestString = Integer.MAX_VALUE;

        for (String str: strs) {
            smallestString = Math.min(smallestString, str.length());
        }
        
        // Time Complexity - O(N L) where N is the length of the array and
        // L is the length of the longest common prefix
        for (int counter = 0; counter < smallestString ; counter++) {
            char charAtIndex = strs[0].charAt(counter);
            int commonFound = 1;
            int unCommonFound = 1;

            for (int i = 1 ; i < strs.length ; i ++) {

                if (charAtIndex == strs[i].charAt(counter)) {
                    commonFound++;
                } else {
                    unCommonFound++;
                    break;
                }
            }
            if (commonFound == strs.length) {
                res += charAtIndex;
            }
            if (unCommonFound > 1) {
                break;
            }
        }
        
        return res;       

    }
}