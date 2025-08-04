# Last updated: 8/4/2025, 4:50:32 PM
class Solution:
    def replaceElements(self, arr: List[int]) -> List[int]:
        if len(arr) == 1:
            arr[0] = -1
        
        for x in range(0, len(arr)):
            print(x, len(arr))
            if x == len(arr)-1:
                arr[x] = -1
            else:
                maxelem = arr[x+1]
                for y in arr[x+1:]:
                    if y > maxelem :
                        maxelem = y
                arr[x] = maxelem
        return (arr)