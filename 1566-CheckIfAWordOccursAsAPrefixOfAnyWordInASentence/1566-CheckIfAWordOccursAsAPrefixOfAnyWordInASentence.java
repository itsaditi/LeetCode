// Last updated: 8/4/2025, 4:50:27 PM
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