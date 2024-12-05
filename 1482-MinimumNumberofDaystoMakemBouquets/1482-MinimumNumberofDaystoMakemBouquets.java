class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        // Edge case
        if (bloomDay.length < m * k) return -1;

        int left = 0;
        int right = 0;

        for (int day: bloomDay) {
            right = Math.max(right, day);
        }

        int minDays = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if(canMakeBouquet(mid, bloomDay, m, k)) {
                right = mid - 1;
                minDays = mid;
            } else {
                left = mid + 1;
            }
        }

        return minDays;
    }

    private boolean canMakeBouquet(int mid, int[] bloomDay, int m, int k) {
        int count = 0;
        int numOfBouquets = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= mid) {
                count++;
            } else {
                count = 0;
            }

            if (count == k) {
                count = 0;
                numOfBouquets++;
            }
        }

        return numOfBouquets >= m;
    }
}