// Last updated: 6/18/2025, 9:09:10 PM
class Solution {
    public boolean isAnagram2(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (Character elem: s.toCharArray()) {
            if (!map.containsKey(elem)) {
                map.put(elem, 1);
            } else {
                int occurence = map.get(elem);
                occurence++;
                map.put(elem, occurence);
            }
        }

        for (Character elem: t.toCharArray()) {
            if (map.containsKey(elem)) {
                int occurence = map.get(elem);
                occurence--;
                map.put(elem, occurence);
                if (map.get(elem) == 0) map.remove(elem);
            } else {
                return false;
            }
        }

        if (!map.isEmpty()) return false;
        return true;
        
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        return Arrays.toString(sArr).equals(Arrays.toString(tArr));
        // return true;
        
    }
}