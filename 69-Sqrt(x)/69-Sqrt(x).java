class Solution {
    public int mySqrt(int x) {
        // int sqrt = (int) Math.pow(x, 0.5);
        if (x < 2) return x;

        long num;
        int left = 0, right = x / 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            num = (long) mid * mid;
            if (num < x) {
                left = mid + 1;
            } else if (num > x) {
                right = mid - 1;
            } else {
                return mid;
            }
        }

        return right;
    }
}