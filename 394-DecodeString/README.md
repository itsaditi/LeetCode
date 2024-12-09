Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

The test cases are generated so that the length of the output will never exceed 105.

 
Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"


Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"


Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"


 
Constraints:


	1 <= s.length <= 30
	s consists of lowercase English letters, digits, and square brackets '[]'.
	s is guaranteed to be a valid input.
	All the integers in s are in the range [1, 300].

 ## Note - 
 * Traverse through string and put every char in stack, unless you encounter closing bracket.
 * On encounterring closing bracket, do following -
   * Pop from stack, until top element is not an opening bracket, this will create a part of the string.
   * On encounterring opening bracket, stop and pop opening bracket from the stack.
   * Imp : It is imp to pop opening bracket.
   * While character is digit, pop from the stack, convert to int (by '4' - '0') and multiplying to base of 10 to the power. This will create ```n``` to repeat above popped string;
   * Then push characters of the string popped so far to the stack for ```n``` times.
* Pop every thing from the stack and generate string. Stack will return reverse of the answer, so use -
```
new StringBuilder(str).reverse().toString();
```

