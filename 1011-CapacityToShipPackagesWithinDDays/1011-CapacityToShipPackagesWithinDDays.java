class Solution {
    public int shipWithinDays(int[] weights, int days) {
        // Binary Search
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
                right = mid;
            } else {
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