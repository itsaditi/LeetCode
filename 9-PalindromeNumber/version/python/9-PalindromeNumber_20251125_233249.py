# Last updated: 11/25/2025, 11:32:49 PM
class Solution:
    def isPalindrome(self, x: int) -> bool:
        if (x < 0):
            return False

        stack = []
        num = x
        while True:
            stack.append(int(num % 10))
            num = int(num / 10)
            if (num == 0):
                break

        i = len(stack) - 1
        newNum = 0
        while len(stack) != 0:
            # print(stack.pop(0))
            newNum += int(stack.pop(0) * (pow(10, i)))
            i -= 1


        return eq(newNum, x)