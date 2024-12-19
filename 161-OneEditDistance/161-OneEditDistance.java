class Solution:
    def isOneEditDistance(self, s: str, t: str) -> bool:
        m, n = len(s), len(t)
        
        if abs(m - n) > 1:
            return False
        
        def f(i: int, j: int, edited: bool):
            while i < m or j < n:    
                if i < m and j < n and s[i] == t[j]:
                    i += 1
                    j += 1
                elif not edited:
                    return f(i, j + 1, True) or f(i + 1, j + 1, True) or f(i + 1, j, True)
                else:
                    return False
            return edited
        
        return f(0, 0, False)