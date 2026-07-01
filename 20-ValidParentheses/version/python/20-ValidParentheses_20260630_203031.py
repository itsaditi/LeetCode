# Last updated: 6/30/2026, 8:30:31 PM
1class Solution:
2    def isValid(self, s: str) -> bool:
3        stack = []
4        closing_paranthese = [")", "}", "]"]
5        closing_opening_match = {")":"(", "}":"{", "]":"["}
6
7
8        for ltr in s:
9            if ltr in closing_paranthese and len(stack) > 0:
10                popped_ltr = stack.pop()
11
12                if popped_ltr != closing_opening_match.get(ltr):
13                    return False
14            else:    
15                stack.append(ltr)
16        
17        return len(stack) == 0
18            
19
20        
21        