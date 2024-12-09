class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        String result = "";

        for (int i = 0 ; i < s.length() ; i++) {
            Character currCh = s.charAt(i);
            if (currCh != ']') {
                stack.push(currCh);
            } else {
                List<Character> decodedString = new ArrayList<>();

                // Pop until [ is encounterred
                while (stack.peek() != '[') {
                    decodedString.add(stack.pop());
                }
                
                // Pop [
                stack.pop();
                int base = 1;
                int num = 0;

                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    num += (stack.pop() - '0') * base;
                    base *= 10;
                }

                String str = decodedString.toString().repeat(num);
                
                while (num > 0) {
                    for (int j = decodedString.size() - 1; j >= 0; j--) {
                        stack.push(decodedString.get(j));
                    }
                    num--;
                }
            }   
        }

        while(!stack.empty()) {
            result += stack.pop();
        }


        return new StringBuilder(result).reverse().toString();
    }
}