// Last updated: 8/15/2025, 6:55:20 PM
class Solution {
    public void rotate(int[] nums, int k) {
        int[] res = new int[nums.length];

        for (int i = 0 ; i < nums.length; i ++) {
            System.out.println(i + " " + (i + k ) % nums.length);
            int newIndex = (i + k) % nums.length;
            res[newIndex] = nums[i];
        }

        for (int i = 0 ; i < nums.length; i ++) {
            nums[i] = res[i];
        }
    }
}

/**.
[0,1,2,3,4,5,6]
[1,2,3,4,5,6,7]
[5,6,7,1,2,3,4]
0 -> 0 + 3
1 -> 1 + 3
 */