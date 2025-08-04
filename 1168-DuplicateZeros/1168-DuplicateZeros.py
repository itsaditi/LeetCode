# Last updated: 8/4/2025, 4:50:34 PM
class Solution:
    def duplicateZeros(self, arr: List[int]) -> None:
        """
        Do not return anything, modify arr in-place instead.
        """
        # print(arr)
        x = 0
        while x < len(arr)-1 :
            if arr[x] == 0 :
                for y in range(len(arr)-1, x+1, -1):
                    arr[y] = arr[y-1]
                arr[x+1] = 0
                x +=1
            # print(arr)
            x += 1
                