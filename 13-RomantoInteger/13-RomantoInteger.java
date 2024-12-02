class Solution:
    def romanToInt(self, s: str) -> int:
        h = {"I": 1, "V":5, "X":10, "L":50, "C":100, "D":500, "M":1000, "Z":0}
        total = 0
        s = s + 'Z'
        for i in range(len(s)-1):
            if h[s[i]] < h[s[i+1]]:
                total -= h[s[i]]
            else:
                total += h[s[i]]
        return total
                    