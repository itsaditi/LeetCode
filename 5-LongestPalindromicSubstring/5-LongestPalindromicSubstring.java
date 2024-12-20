class Solution {
    TreeMap<Integer, String> treeMap = new TreeMap<>(Collections.reverseOrder());

     public String longestPalindrome(String s) {
        for (int length = s.length(); length > 0; length--) {
            for (int start = 0; start <= s.length() - length; start++) {
                if (isPalindrome(s.substring(start, start + length))) {
                    return s.substring(start, start + length);
                }
            }
        }

        return "";
    }

    public String longestPalindrome2(String s) {
        if (s.length() == 1) return s;

        if (s.length() == 2) {
            return isPalindrome(s) ? s : String.valueOf(s.charAt(0));
        }

        recursion(s, "", 0);

        return treeMap.get(treeMap.firstKey());

    }
    // TLE
    private void recursion(String s, String tempStr, int index) {

        if (tempStr.length() >= 2 && isPalindrome(tempStr)) {

            treeMap.put(tempStr.length(), tempStr);
            return;
        }

        for (int i = index ; i < s.length() ; i++) {
            recursion(s, tempStr.concat(String.valueOf(s.charAt(i))), i + 1);
        }

        return;
    }

    // TLE
    public String longestPalindrome_BFS(String s) {
        if (s.length() == 1) return s;

        TreeMap<Integer, String> map = new TreeMap<>(Collections.reverseOrder());
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        while (!queue.isEmpty()) { // O(n)
            int index = queue.poll();

            for (int i = index + 1; i <= s.length() ; i++) { // O(n)
                String str = s.substring(index, i);
                if (isPalindrome(str)) {
                    map.put(str.length(), str);
                    queue.add(i);
                    System.out.println(map);
                }
            }
        }

        return map.get(map.firstKey());
    }

    private boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;

        while (left <= right) { // O(m / 2)
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left ++;
            right --;
        }

        return true;
    }
}