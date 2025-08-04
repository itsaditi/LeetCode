# Last updated: 8/4/2025, 4:50:44 PM
class Solution:
    def validMountainArray(self, arr: List[int]) -> bool:
        if len(arr) == 0:
            return False
        
        if len(arr) < 3 :
            return False
        i = 1
        while i < len(arr) and arr[i] > arr[i-1]:
            i += 1
        
        if i == 1 or i == len(arr):
            return False
        while i < len (arr) and arr[i] < arr[i-1]:
            i += 1
            
        print(i, len(arr))
        return i == len(arr)