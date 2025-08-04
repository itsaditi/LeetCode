// Last updated: 8/4/2025, 4:50:38 PM
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        // Time complexity - O(n log n)
        // TC of BS is O(log n)
        
        // Using Binary Search
        int totalCapacity = 0;
        int maxCapacity = 0;

        for (int weight: weights) {
            totalCapacity += weight;
            maxCapacity = Math.max(maxCapacity, weight);
        }

        // BS from maxCapacity to totalCapacity
        int left = maxCapacity;
        int right = totalCapacity;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canBeShipped(mid, weights, days)) {
                // If we are able to ship the packages with mid capacity 
                // within the required days, we know the answer is at most mid, 
                // so we can look for a better answer by moving to the lower half 
                // - change r = mid.
                right = mid;
            } else {
                // if we are not able to ship the packages with mid capacity, 
                // we cannot ship the packages with any capacity less than or 
                //equal to mid. So, we move to the upper half of the range by 
                // moving l = mid + 1.
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canBeShipped(int cap, int[] weights, int days) {
        int sum = 0;
        int reset = 1;
        for (int i = 0; i < weights.length ; i++) {
            if (sum + weights[i] > cap) {
                sum = 0;
                reset++;
            }
            sum += weights[i];
        }

        return reset <= days;
    }
}