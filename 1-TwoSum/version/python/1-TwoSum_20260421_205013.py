# Last updated: 4/21/2026, 8:50:13 PM
1class Solution:
2    def twoSum(self, nums: List[int], target: int) -> List[int]:
3        index_map = {}
4        for i in range(0, len(nums)):
5            index_map[nums[i]] = i
6        
7        for i in range(0, len(nums)):
8            diff = target - nums[i]
9            val = index_map.get(diff)
10
11            if i != val and val is not None:
12                return [i, val]
13
14        return [0, 1]
15        