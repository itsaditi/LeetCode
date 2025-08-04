// Last updated: 8/4/2025, 4:50:22 PM
class Solution {
    public String mergeAlternately(String word1, String word2) {
        String res = "";
        int i = 0, j = 0;
        char[] word1Arr = word1.toCharArray();
        char[] word2Arr = word2.toCharArray();

        while (i + j <= word1.length() + word2.length()) {
            
            if (i == word1.length()) {
                res += word2.substring(j);
                break;
            }

            if (j == word2.length()) {
                res += word1.substring(i);
                break;
            }
            res += String.valueOf(word1Arr[i]) + String.valueOf(word2Arr[j]);

            i++;
            j++;

        }
        return res;
    }
}