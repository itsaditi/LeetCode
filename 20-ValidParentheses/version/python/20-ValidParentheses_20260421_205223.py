# Last updated: 4/21/2026, 8:52:23 PM
1class Solution:
2    def isValid(self, s: str) -> bool:
3        if (len(s) in [0, 1]):
4            return False
5
6        stack = []
7        hashMap = {')': '(', ']': '[', '}': '{'}
8
9        for ch in s:
10            if len(stack) == 0 or ch not in hashMap:
11                stack.append(ch)
12            else:
13                # Closing Paranthese found
14                poppedCh = stack.pop()
15                if (hashMap[ch] != poppedCh):
16                    return False
17
18        return len(stack) == 0
19