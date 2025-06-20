// Last updated: 6/18/2025, 8:57:24 PM
class Solution {
    public boolean isPalindrome(String s) {
        // Time Complexity --> O(n)
        // Space Complexity --> O(n/2) ~ O(n)
        Stack<Character> stackedChar = new Stack<>();

        s = s.toLowerCase().replaceAll("[^\\sa-zA-Z0-9]", "").replace(" ", "");
        int midIndex = s.length() / 2;
        int n = s.length();


        for (int i = 0 ; i < midIndex ; i ++) {
            stackedChar.add(s.charAt(i));
        }

        int startingIndex = n % 2 == 0 ? midIndex : midIndex + 1;

        for (int i = startingIndex ; i < n ; i ++) {
            Character topElem = stackedChar.pop();
            if (topElem != s.charAt(i)) {
                return false;
            }
        }

        return stackedChar.isEmpty();
    }
}