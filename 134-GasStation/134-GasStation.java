class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        if sum(gas) < sum(cost): return -1

        curr_gain = 0
        ans = 0

        for i in range(len(gas)):
            curr_gain += gas[i] - cost[i]

            if curr_gain < 0:
                curr_gain = 0
                ans = i + 1


        return ans