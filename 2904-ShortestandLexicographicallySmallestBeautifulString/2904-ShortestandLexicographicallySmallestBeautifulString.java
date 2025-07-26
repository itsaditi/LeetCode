// Last updated: 7/26/2025, 1:21:39 PM
class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        
        int[] prefixSum = new int[s.length()];

        // Compute prefix sum 
        int numOfOnes = 0;
        for (int i = 0 ; i < s.length() ; i++) {
            if (s.charAt(i) == '1') {
                numOfOnes ++;
            };
            prefixSum[i] = numOfOnes;
        }

        if (numOfOnes < k) return "";

        if (k == 1 && numOfOnes >= k) return "1";

        String beautString = null;

        for (int l = 0 ; l < s.length(); l++) {
            for (int r = l + 1; r < s.length() ; r++) {
                int countOnes = (l == 0) ? prefixSum[r] : (prefixSum[r] - prefixSum[l - 1]); 
                if (countOnes == k) {
                    String candidate = s.substring(l, r + 1);
                    if (
                        beautString == null ||
                        candidate.length() < beautString.length() || 
                        (candidate.length() == beautString.length() && candidate.compareTo(beautString) < 0)
                    ) {
                            beautString = candidate;
                    }
                } 
                
            }
        }
        return beautString;
    }
}