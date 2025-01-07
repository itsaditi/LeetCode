class Solution {
    public String reverseWords(String s) {
        String[] splitString = s.trim().split(" ");
        Stack<String> stack = new Stack<>();

        StringBuilder result = new StringBuilder();

        for (String str: splitString) {
            if (str.trim().length() > 0) stack.add(str);
        }

        while(!stack.isEmpty()) {
            String poppedElem = stack.pop();
            if (poppedElem.trim().length() > 0) {
                result.append(poppedElem + " ");
            }
            
        }

        return result.toString().trim();
    }
}