# Last updated: 8/4/2025, 4:51:08 PM
class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        # [1, 0, 1, 1, 0]
        
        longestseq = 0
        right, left = 0 ,0 
        numsOfZeros = 0
        while right < len(nums) :
            if nums[right] == 0:
                numsOfZeros += 1
            
            while numsOfZeros == 2:
                if nums[left] == 0:
                    numsOfZeros -= 1
                left += 1
            
            longestseq = max(longestseq, right - left + 1)
            
            right += 1
        
        return longestseq
                    