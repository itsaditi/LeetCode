class Solution {
    Set<String> res;
    int num = 0;

    char[] paranthesis = new char[]{'(', ')'};

    public List<String> generateParenthesis(int n) {
        num = n;
        res = new HashSet<>();
        createParanthesis("(", 1);


        return new ArrayList<>(res);
    }

    private void createParanthesis(String str, int opParanthesis) {
        if (str.length() == num * 2) {
            if (isValid(str))
                res.add(str);
            return;
        }
        // System.out.println(str);
        if (opParanthesis <= num) {
            for (Character bracket: paranthesis) {
                if (bracket == '(')
                    createParanthesis(str.concat("("), opParanthesis + 1);
                else if (bracket == ')'){
                    createParanthesis(str.concat(")"), opParanthesis);}
            }
        }

        return;

    }

    private boolean isValid(String str) {
        int leftBracket = 0;
        
        for (Character ch: str.toCharArray()) {
            if (ch == '(') leftBracket++;
            else if (ch == ')') leftBracket--;

            if (leftBracket < 0) return false;
        }

        return leftBracket == 0;

    }
}