// Last updated: 8/4/2025, 4:51:12 PM
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        char[] pArray = p.toCharArray();
        Arrays.sort(pArray);
        int windowLength = p.length();

        for (int i = 0 ; i < s.length() - windowLength + 1 ; i ++) {
            String str = s.substring(i, i + windowLength);
            char[] sArray = str.toCharArray();
            Arrays.sort(sArray);
            if (Arrays.equals(pArray, sArray)) res.add(i);
        }

        return res;
    }
}