# Last updated: 11/25/2025, 10:27:19 AM
class Solution:
    def getAnswer(self, i) -> str:
        config = [(3, "Fizz"), (5, "Buzz")]
        result = ""
        for k, v in config:
            if i % k == 0:
                result += v

        if not result:
            result = i

        return str(result)

    def fizzBuzz(self, n: int) -> List[str]:
        answer = []

        for i in range(1, n + 1):
            answer.append(self.getAnswer(i))

        return answer
