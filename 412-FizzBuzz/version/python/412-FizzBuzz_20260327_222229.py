# Last updated: 3/27/2026, 10:22:29 PM
1class Solution:
2    def fizzBuzz(self, n: int) -> List[str]:
3        res = []
4        print(self.compute(15))
5        for i in range(0, n):
6            num = i + 1
7            res.append(self.compute(num))
8        
9        return res
10
11    
12    def compute(self, num: int) -> str:
13        map = [(3, "Fizz"), (5, "Buzz")]
14        res_str = ""
15
16        for index in range(0, len(map)):
17            divisor = map[index][0]
18            if num % divisor == 0:
19                res_str += map[index][1]
20        
21        if not res_str:
22            return str(num)
23
24        return str(res_str)
25