class Solution {
    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);

        int left = 0;
        int right = str.length() - 1;

        while (left <= right) {
            if (str.charAt(left) == str.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }


        return true;
    }
}