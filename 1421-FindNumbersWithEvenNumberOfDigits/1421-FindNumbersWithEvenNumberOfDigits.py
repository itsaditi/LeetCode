# Last updated: 8/4/2025, 4:50:31 PM
class Solution:
    def findNumbers(self, nums: List[int]) -> int:
        evenDigit = 0
        for x in nums:
            currnum = x
            count = 0
            while currnum !=0:
                currnum = int(currnum / 10)
                count += 1
            if count % 2 == 0:
                evenDigit += 1
        
        # print(evenDigit)
        return evenDigit
                
            