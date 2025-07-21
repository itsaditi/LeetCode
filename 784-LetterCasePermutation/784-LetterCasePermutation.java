// Last updated: 7/21/2025, 7:43:10 PM
class Solution {
    List<String> res = new ArrayList<>();
    int n = 0;

    public List<String> letterCasePermutation(String s) {
        n = s.length();
        backTracking(0, "", s);
        return res;
    }

    private void backTracking(int index, String str, String s) {
        if (str.length() == n) {
            System.out.println(str);
            res.add(str);
            return;
        }
        
        if (index > n - 1) return;

        char ch = s.charAt(index);
        index++;

        if (Character.isDigit(ch)) {
            String newString = str + String.valueOf(ch);
            backTracking(index, newString, s);
        } else {
            String lowerCase = str + String.valueOf(ch).toLowerCase();
            backTracking(index, lowerCase, s);

            String upperCase = str + String.valueOf(ch).toUpperCase();
            backTracking(index, upperCase, s);
        }
    }
}