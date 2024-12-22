class Solution {
    public int lengthOfLongestSubstring(String str) {
        // TC and SC - O(N) and O(N)
        HashSet<Character> set = new HashSet<>();
        int maxLength = 0;

        int left = 0;
        for (int i = 0 ; i < str.length() ; i++) {
            Character ch = str.charAt(i);
            while (set.contains(ch)) {
                set.remove(str.charAt(left));
                left++;
            }
            set.add(ch);
            maxLength = Math.max(maxLength, set.size());
        }
        return maxLength;
    }

    public int lengthOfLongestSubstring_HashSet1(String str) {
    
        HashSet<Character> set = new HashSet<>();
        int maxLength = 0;
        int left = 0;

        // to return the unique string
        int startOfMax = 0;

        for(int right = 0; right < str.length(); right++){
            while(set.contains(str.charAt(right))){
                set.remove(str.charAt(left));
                left++;
            }
            set.add(str.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
         return maxLength;
        
    }


    public int lengthOfLongestSubstring_SlidingWindow(String str) {
        if (str.length() == 1) return 1;
        int longestSubstring = 0;

        // Sliding window
        // Time Complexity --> O(n^2)
        // Space Complexity --> O(n)
        for (int i = 0 ; i < str.length() - 1; i ++) {
            HashSet<Character> seen = new HashSet<>();
            seen.add(str.charAt(i));
            for (int j = i + 1 ; j < str.length() ; j ++) {
                Character currChar = str.charAt(j);
                if (!seen.contains(currChar)) {
                    seen.add(currChar);
                } else {
                    break;
                }
            }
            longestSubstring = Math.max(longestSubstring, seen.size());
        }

        return longestSubstring;
    }
}