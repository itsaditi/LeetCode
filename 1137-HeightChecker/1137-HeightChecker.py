# Last updated: 8/4/2025, 4:50:34 PM
class Solution:
    def heightChecker(self, heights: List[int]) -> int:
        targetArr = sorted(heights)
        count = 0
        for x in range(0, len(heights)):
            if heights[x] != targetArr [x]:
                count += 1
        
        return count
        