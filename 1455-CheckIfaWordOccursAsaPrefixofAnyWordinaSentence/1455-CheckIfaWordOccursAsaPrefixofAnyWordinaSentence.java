// Last updated: 7/21/2025, 7:45:41 PM
class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] str = sentence.split(" ");

        for (int i = 0 ; i < str.length ; i++) {
            if (str[i].startsWith(searchWord)) {
                return i + 1;
            }
        }

        return -1;
    }
}