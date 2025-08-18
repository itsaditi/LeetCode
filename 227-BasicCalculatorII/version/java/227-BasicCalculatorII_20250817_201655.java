// Last updated: 8/17/2025, 8:16:55 PM
class Solution {
    public int calculate(String s) {
        s = s.trim();
        Stack<Integer> stack = new Stack<>();
        int currNum = 0;
        char operation = '+';
        int result = 0;

        for (int i = 0 ; i < s.length() ; i ++) {
            char character = s.charAt(i);
            if (Character.isDigit(character)) {
                currNum = (currNum * 10) + (character - '0');
            }

            if (!Character.isDigit(character) && !Character.isWhitespace(character) || i == s.length() - 1) {
                if (operation == ('+')) stack.push(currNum);
                else if (operation == ('-')) stack.push(-currNum);
                else if (operation == ('*')) stack.push(stack.pop() * currNum);
                else if (operation == ('/')) stack.push(stack.pop() / currNum);

                operation = character;
                currNum = 0;
            }
        }

        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}