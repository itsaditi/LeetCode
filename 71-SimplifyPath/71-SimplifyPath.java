class Solution {
    public String simplifyPath(String path) {
        String[] splitPath = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String str: splitPath) {
            str = str.trim();
            if ((!str.equals("..") && !str.equals(".") && !str.isEmpty())) {
                stack.add(str);
            } else if (str.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else if (str.equals(".")) {
                continue;
            }
        }

        if (stack.isEmpty()) return "/";

        String result = "";
        while (!stack.isEmpty()) {
            String pop = stack.pop();

            if (!pop.isEmpty()) {
                result = "/" + pop.concat(result);
            }
        }

        return result.length() == 0 ? "/" : result;
    }
}