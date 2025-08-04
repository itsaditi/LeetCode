# Last updated: 8/4/2025, 4:51:09 PM
class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
#         [1,0,1,1,0,1]
        window = 0
        answer = 0
        if len(nums) == 0:
            return 0
        
        for x in range(0, len(nums)):
            if nums[x] == 1:
               window += 1
            else:
                answer = max(window, answer)
                window = 0
            # print(window, windowsarr)
            
        return max(window, answer)
                
                    
        