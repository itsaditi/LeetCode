# Last updated: 8/4/2025, 4:50:47 PM
class Solution:
    def sortArrayByParity(self, A: List[int]) -> List[int]:
        # [3, 1, 2, 4]  [2, 1, 3, 4] [4, 2, 1, 3] 0, 1 3, 2 
        # 0 < x < (len(A)/2) - 1
        # (len(A)/2) < lastElem < len(A)-1
        # if A[x] % 2 != 0 and A[lastElem] % 2 ==0: swap [2, 1, 3, 4] and x++ and lastElem ++
        i, j = 0, len(A) - 1
        
        while i < j:
            print(A[i], A[j], A[i] % 2, A[j] % 2)
            if A[i] % 2 > A[j] % 2 :
                A[i] , A[j] = A[j], A[i]
            
            if A[i] % 2 == 0 : i += 1
            if A[j] % 2 == 1 : j -= 1
            
        
        return A