class Solution {
    public String longestCommonPrefix(String[] strs) {
        String res = "";

        int smallestString = Integer.MAX_VALUE;

        for (String str: strs) {
            smallestString = Math.min(smallestString, str.length());
        }
        
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
            if (unCommonFound == strs.length || unCommonFound > 1) {
                break;
            }
        }
        
        return res;       

    }
}