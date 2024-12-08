class Solution {
    public int maxLength(int[] ribbons, int k) {
        int givenMaxLengthRibbon = 0;

        for (int ribbon: ribbons) {
            givenMaxLengthRibbon = Math.max(givenMaxLengthRibbon, ribbon);
        }

        int left = 0;
        int right = givenMaxLengthRibbon;

        while (left < right) {
            int mid = left + (int) Math.ceil((double) (right - left) / 2);
            // int mid = (left + right + 1) / 2;

            if (checkLength(ribbons, k, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    private boolean checkLength(int[] ribbons, int k, int len) {
        int count = 0;

        for (int i = 0 ; i < ribbons.length ; i++) {
            if (ribbons[i] >= len) {
                int diff = ribbons[i];
                count += (ribbons[i] / len);

                if (count >= k) return true;
                /*
                while (diff >= 0) {
                    diff -= len;
                    if (diff >= 0) count++;

                    if (count >= k) return true;
                }
                */
            }
        }

        return count >= k;

    }
}