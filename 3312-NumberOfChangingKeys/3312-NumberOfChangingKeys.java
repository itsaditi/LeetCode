// Last updated: 8/4/2025, 4:50:10 PM
class Solution {
    public int countKeyChanges(String s) {
        s = s.toLowerCase();
        char ch = s.charAt(0);

        int keyChange = 0;

        for (int i = 1; i < s.length() ; i++) {
            if (ch != s.charAt(i)) {
                keyChange++;
                ch = s.charAt(i);
            }
        }

        return keyChange;
    }
}