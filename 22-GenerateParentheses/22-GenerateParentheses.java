class Solution {
    Set<String> res;
    int num = 0;

    char[] paranthesis = new char[]{'(', ')'};

    // Generate all possible paranthesis and check its validity once length 
    // of string is num * 2

    // TC - O((2^(2n)) * n)
    // * We are generating all possible strings of length 2n. At each character, 
    //   we have two choices: choosing ( or ), which means there are a total of 2^(2n)
    // * For each string of length 2n, we need to iterate through each character to 
    //   verify it is a valid combination of parentheses, which takes an average of O(n) time.
    //   unique strings.
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