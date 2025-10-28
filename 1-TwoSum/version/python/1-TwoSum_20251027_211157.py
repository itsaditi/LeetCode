# Last updated: 10/27/2025, 9:11:57 PM
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hashMap = {}

        for i in range(0, len(nums)):
            hashMap[nums[i]] = i
        
        for i in range(0, len(nums)):
            diff = target - nums[i]
            if (diff in nums and hashMap[diff] != i):
                return [i, hashMap[diff]]

        return [0, 1]