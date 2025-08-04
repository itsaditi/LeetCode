# Last updated: 8/4/2025, 4:51:15 PM
class Solution:
    def thirdMax(self, nums: List[int]) -> int:
        nums = list(set(nums))
        x = 0
        nums.sort()
        
        if len(nums) < 3:
            return max(nums)
        
        while len(nums) > 0:
            maxnum = max(nums)
            nums.remove(maxnum)
            print(maxnum, nums)
            x += 1
            if x == 3:
                break
        
        return maxnum
            