class Solution {
    public int maxArea(int[] height) {
        int area = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int x = right - left;
            int y = Math.min(height[left], height[right]);
            area = Math.max((x * y), area);

            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }




        



        return area;

        // Brute Force - Time Limit Exceeded
        // for (int i = 0 ; i < height.length ; i ++) {
        //     for (int j = i + 1 ; j < height.length ; j ++) {
        //         int x = j - i;
        //         int y = Math.min(height[i], height[j]);
        //         area = Math.max((x * y) , area);
        //     }
        // }

    }
}