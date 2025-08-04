// Last updated: 8/4/2025, 4:50:48 PM
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // Using Binary Search
        int minAmt = Integer.MAX_VALUE;
        int maxAmt = 0;
        int totalAmt = 0;
        for (int amt : piles) {
            minAmt = Math.min(minAmt, amt);
            maxAmt = Math.max(maxAmt, amt);
            totalAmt += amt;
        }

        // BS between minAmt to maxAmt
        
        // Minimum possible eating speed will be 1 since
        // there is not speed slower than 1
        int left = 1;
        int right = maxAmt;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canEat(mid, piles, h, totalAmt)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canEat(int amt, int[] piles, int hr, int totalAmt) {
        int hrNeeded = 0;
        int carryOver = 0;
        for (int i = 0; i < piles.length ; i++) {
            // Remember this step
            hrNeeded += Math.ceil((double) piles[i] / amt);
        }

        return hrNeeded <= hr;
    }
}