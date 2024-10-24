class Solution {
    public int longestPalindrome(String s) {
        
        /* PLAN :-
         * * Keep a map of characters and their occurences.
         * * To compute the plaindrome length - 
         *  * Compute sum of all letters with even number of occurences
         *  * Check if any letter exists with 1 occurence, add that to the computed sum. 
         */

        HashMap<Character, Integer> map = new HashMap<>();
        int longestPalindromeLen = 0;
        boolean foundElementWithOneOccurence = false;

        // Create map with letters as key and occurence as value
        for (Character letter: s.toCharArray()) {
            if (!map.containsKey(letter)) {
                map.put(letter, 1);
            } else {
                int occOfLetter = map.get(letter);
                occOfLetter ++;
                map.put(letter, occOfLetter);
            }
        }

        

        for (Map.Entry<Character, Integer> mapElement: map.entrySet()) {
            
            Integer elementValue = mapElement.getValue();
            if (map.size() == 1) {
                return elementValue;
            }
            if (elementValue % 2 == 0) {
                longestPalindromeLen += elementValue;
            } else {
                longestPalindromeLen += elementValue - 1;
                foundElementWithOneOccurence = true;
            }
        }
        
        longestPalindromeLen += foundElementWithOneOccurence ? 1 : 0;

        return longestPalindromeLen;

    }
}