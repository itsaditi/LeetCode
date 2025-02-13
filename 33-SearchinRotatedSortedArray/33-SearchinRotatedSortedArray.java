class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;

        // Find the index of the pivot element (the smallest element)
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[n - 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // Binary search over elements on the pivot element's left
        int answer = binarySearch(nums, 0, left - 1, target);
        if (answer != -1) {
            return answer;
        }

        // Binary search over elements on the pivot element's right
        return binarySearch(nums, left, n - 1, target);
    }

    // Binary search over an inclusive range [left_boundary ~ right_boundary]
    private int binarySearch(
        int[] nums,
        int leftBoundary,
        int rightBoundary,
        int target
    ) {
        int left = leftBoundary, right = rightBoundary;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}

class Solution2 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] < nums[n - 1]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        int leftHalf = binarySearch(nums, 0, left - 1, target);

        if (leftHalf != -1) {
            return leftHalf;
        } 
        
        return binarySearch(nums, left, nums.length - 1, target);
    }
    // 0,1,2,3,4,5 
    private int binarySearch(int[] nums, int startIndex, int endIndex, int target) {
        while (startIndex <= endIndex) {
            int mid = (startIndex + endIndex) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                startIndex = mid + 1;
            } else {
                endIndex = mid - 1;
            }
        }

        return -1;
    }
}


// 1,2,3,4,5,6,7,0
// 6,7,0,1,2,3,4,5
// 4,5,6,7,0,1,2