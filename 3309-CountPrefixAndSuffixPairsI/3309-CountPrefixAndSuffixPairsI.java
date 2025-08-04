// Last updated: 8/4/2025, 4:50:10 PM
class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        
        int indexPairs = 0;

        for (int i = 0 ; i < words.length - 1 ; i++) {
            for (int j = i + 1 ; j < words.length ; j++) {
                if (isPrefixAndSuffix(words[i], words[j])) {
                    indexPairs++;
                }
            } 
        }



        return indexPairs;
    }
    private boolean isPrefixAndSuffix(String str1, String str2) {
        return (str2.startsWith(str1) && str2.endsWith(str1));
    }
}