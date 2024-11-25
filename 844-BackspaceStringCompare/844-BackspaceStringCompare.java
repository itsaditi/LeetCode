class Solution {
    public boolean backspaceCompare(String s, String t) {
        String sBackspaceString = convertIntoBackspaceString(s);
        String tBackspaceString = convertIntoBackspaceString(t);
        
        return sBackspaceString.equals(tBackspaceString);
    }

    private String convertIntoBackspaceString(String str) {
        Stack<Character> stack = new Stack<>();
        int backspaceCounter = 0;

        for(Character ch: str.toCharArray()) {
            if (ch == '#' && !stack.isEmpty()) {
                stack.pop();
            } else if (ch == '#' && stack.isEmpty()) {
                continue;
            } else {
                stack.add(ch);
            }
        }
        return stack.toString();
    }
}