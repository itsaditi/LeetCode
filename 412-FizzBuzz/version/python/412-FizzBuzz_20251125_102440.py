# Last updated: 11/25/2025, 10:24:40 AM
class Solution:
    def getAnswer(self, i) -> str:
        if i % 3 == 0 and i % 5 == 0:
            return "FizzBuzz"
        if i % 3 == 0:
            return "Fizz"
        elif i % 5 == 0:
            return "Buzz"
        else:
            return str(i)

    def fizzBuzz(self, n: int) -> List[str]:
        answer = []

        for i in range(1, n + 1):
            answer.append(self.getAnswer(i))

        return answer
