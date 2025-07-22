// Last updated: 7/21/2025, 8:10:49 PM
class Solution {
    public int minLength(String s) {
        String str = minString(s);;
        
        return str.length();
        
    }

    private String minString(String str) {
        // Base case
        if (str.length() == 0) return "";

        int abIndex = str.indexOf("AB");
        int cdIndex = str.indexOf("CD");

        if (abIndex == -1 && cdIndex == -1) return str;

        if (abIndex > -1) {
            str = str.replaceFirst(str.substring(abIndex, abIndex + 2), "");
        } else if (cdIndex > -1) {
            str = str.replaceFirst(str.substring(cdIndex, cdIndex + 2), "");
        }

        return minString(str);
    }
}