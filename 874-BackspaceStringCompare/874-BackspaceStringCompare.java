// Last updated: 8/4/2025, 4:50:49 PM
class Solution {
    // Time and space complexity - O(N)
    public boolean backspaceCompare(String s, String t) {
        String sBackspaceString = convertIntoBackspacedStringConstantSpace(s);
        System.out.println(sBackspaceString);
        String tBackspaceString = convertIntoBackspacedStringConstantSpace(t);
        
        return sBackspaceString.equals(tBackspaceString);
    }

    private String convertIntoBackspacedStringConstantSpace(String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0 ; i < str.length() ; i++) {
            if (str.charAt(i) == '#') {
                if (sb.length() != 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
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