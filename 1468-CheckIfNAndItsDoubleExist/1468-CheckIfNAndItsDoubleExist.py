# Last updated: 8/4/2025, 4:50:30 PM
class Solution:
    def checkIfExist(self, arr: List[int]) -> bool:
        if len(arr) == 0:
            return False
        
        for x in range(0, len(arr)):
            for y in range(0, len(arr)):
                if arr[x] == 2 * arr[y] and x!=y:
                    print(arr[x], arr[y])
                    return True
        
        return False