
import java.util.stream.Collector.Characteristics;class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        /** PLAN - 
         * Brute Force : 
         * Create a map using magazine with letter with its occurrence (key - letter/char and value - occurrence)
         * Iterate over ransomNote - 
         *      If letter is found in the map, decrement its occurrence by 1, this a way of visiting the letter.
         *      If letter does not exist in the map OR occurrence of that letter in the map has reached 0, then return false        
         */

        HashMap<Character, Integer> map = new HashMap<>();
        for (Character letter: magazine.toCharArray()) {
            if (!map.containsKey(letter)) {
                map.put(letter, 1);
            } else {
                int occ = map.get(letter);
                occ++;
                map.put(letter, occ);
            }
        }

        for (Character letter: ransomNote.toCharArray()) {
            if (!map.containsKey(letter) || map.get(letter) == 0) {
                 return false;
            } else {
                int occ = map.get(letter);
                occ--;
                map.put(letter, occ);
            }
        }
        return true;
    }
}