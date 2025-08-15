// Last updated: 8/15/2025, 6:05:15 PM
class Parantheses {
    char ch;
    int index;

    Parantheses(char ch, int index) {
        this.ch = ch;
        this.index = index;
    }
}

class Solution {
    public int longestValidParentheses(String s) {
        boolean[] isValid = new boolean[s.length()];
        Stack<Parantheses> stack = new Stack<>();
        int windowSize = 0;
        int longestString = 0;

        for (int i = 0 ; i < s.length() ; i++) {
            char ch = s.charAt(i);
            if (ch == '(' || stack.isEmpty()) {
                stack.push(new Parantheses(ch, i));
            } else if (ch == ')') {
                Parantheses top = stack.peek();
                if (top.ch == '(') {
                    stack.pop();
                    isValid[top.index] = true;
                    isValid[i] = true;
                }
            }
        }

        for (boolean val: isValid) {
            if (val) {
                windowSize++;
            } else {
                longestString = Math.max(longestString, windowSize);
                windowSize = 0;
            }
            
            longestString = Math.max(longestString, windowSize);
        }

        return longestString;
    }
}