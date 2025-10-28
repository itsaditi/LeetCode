# Last updated: 10/27/2025, 9:30:47 PM
class Solution:
    def isValid(self, s: str) -> bool:
        if (len(s) == 1 or len(s) == 0): 
            return False

        stack = []
        closingParanthese = [')', ']', '}']
        hashMap = {')': '(', ']': '[', '}': '{'}

        for ch in s:
            if len(stack) == 0 or ch not in closingParanthese:
                stack.append(ch)
            else:
                # Closing Paranthese found
                poppedCh = stack.pop()
                if (hashMap[ch] != poppedCh):
                    return False

        return len(stack) == 0
