// Last updated: 8/4/2025, 4:51:03 PM
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        s1 = sortString(s1);

        for (int i = 0; i <= (s2.length() - s1.length()) ; i++) {
            if (s1.equals(sortString(s2.substring(i, i + s1.length())))) {
                return true;
            }
        }

        return false;
    }

    private String sortString(String str) {
        char[] tempArray = str.toCharArray();
        Arrays.sort(tempArray);

        return new String(tempArray);
    }
}
