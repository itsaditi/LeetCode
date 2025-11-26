# Last updated: 11/26/2025, 2:08:12 PM
1class Solution:
2    def longestCommonPrefix(self, strs: List[str]) -> str:
3
4        def isEqualAcrossArray(index: int) -> bool:
5            ch = strs[0][index]
6
7            for i in range(1, len(strs)):
8                if not eq(ch, strs[i][index]):
9                    return False
10
11            return True
12
13        def getSmallestString() -> str:
14            smallestString = strs[0]
15            for i in range(1, len(strs)):
16                if (len(strs[i]) < len(smallestString)):
17                    smallestString = strs[i]
18            return smallestString
19
20        if (eq(len(strs), 1)):
21            return strs[0]
22
23        smallestString = getSmallestString()
24        prefix = ""
25
26        for i in range(0, len(smallestString)):
27            if (not isEqualAcrossArray(i)):
28                break
29            
30            prefix += smallestString[i]
31
32        return prefix
33
34
35