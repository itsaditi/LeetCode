// Last updated: 4/21/2026, 8:51:22 PM
class Solution {
    public int maxRepeating(String sequence, String word) {
        int repeatingSubString = 0;
        String repeatedWord = word;

        while (sequence.contains(repeatedWord)) {
            repeatingSubString ++;
            repeatedWord = word + repeatedWord;
        }

        return repeatingSubString;
    }
}