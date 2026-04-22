# Last updated: 4/21/2026, 8:52:27 PM
class Solution:
    def fizzBuzz(self, n: int) -> List[str]:
        res = []
        print(self.compute(15))
        for i in range(0, n):
            num = i + 1
            res.append(self.compute(num))
        
        return res

    
    def compute(self, num: int) -> str:
        map = [(3, "Fizz"), (5, "Buzz")]
        res_str = ""

        for index in range(0, len(map)):
            divisor = map[index][0]
            if num % divisor == 0:
                res_str += map[index][1]
        
        if not res_str:
            return str(num)

        return res_str
