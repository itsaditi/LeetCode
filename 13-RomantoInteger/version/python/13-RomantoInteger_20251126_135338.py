# Last updated: 11/26/2025, 1:53:38 PM
1class Solution:
2    def romanToInt(self, s: str) -> int:
3        """
4        IV - 5
5        IX - 10
6        XL = 50
7        XC = 100
8        CD = 500
9        CM = 10000
10        """
11        doubleNumerals = {
12            'I': {'V': 4, 'X': 9},
13            'X': {'L': 40, 'C': 90},
14            'C': {'D': 400, 'M': 900}
15        }
16
17        resultNum = 0
18        index = 0
19        while index < len(s):
20            if (s[index] in doubleNumerals):
21                if index + 1 < len(s) and (s[index + 1] in doubleNumerals[s[index]]):
22                    resultNum += doubleNumerals[s[index]][s[index + 1]]
23                    index += 2
24                else:
25                    resultNum += self.getNumericValueForSingleNumeral(s[index])
26                    index += 1
27            else:
28                resultNum += self.getNumericValueForSingleNumeral(s[index])
29                index += 1
30
31        return resultNum
32
33    def getNumericValueForSingleNumeral(self, val: str) -> int:
34        singleNumerals = {
35            'I': 1,
36            'V': 5,
37            'X': 10,
38            'L': 50,
39            'C': 100,
40            'D': 500,
41            'M': 1000
42        }
43        return singleNumerals[val]
44