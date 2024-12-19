class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // DP 
        boolean[] memo = new boolean[s.length() + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        while (!queue.isEmpty()) {
            int start = queue.poll();
            if (start == s.length()) return true;
            for (int i = start + 1 ; i <= s.length() ; i++) {
                if (memo[i]) continue;
                if (wordDict.contains(s.substring(start, i))) {
                    memo[i] = true;
                    queue.add(i);
                }
            }
        }
        
        return false;
    }

    public boolean wordBreak2(String s, List<String> wordDict) {
        // BFS 
        // Time Complexity - O(N^2)
        // Space Complexity - O(N)
        Set<String> word = new HashSet<>(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] seen = new boolean[s.length() + 1];
        queue.add(0);

        while (!queue.isEmpty()) {
            int start = queue.poll();
            if (start == s.length()) {
                return true;
            }

            for (int end = start + 1; end <= s.length() ; end ++) {
                if(seen[end]) {
                    continue;
                }

                if(word.contains(s.substring(start, end))) {
                    seen[end] = true;
                    queue.add(end);
                }
            }
            
        }
        return false;

        // Uncomment below line for Top Down Approach
        // return topDownWordBreak(s, new HashSet<>(wordDict), 0, new boolean[s.length()]);
    }

    // Top down approach
    // Time Complexity - O(n^3) (Recursion, For loop, Substring) |  Space Complexity- O(n)
    // Exceeding Time Limit
    // private boolean topDownWordBreak(String s, Set<String> wordDict, int start, boolean[] cache) {
    //     if (start == s.length()) {
    //         return true;
    //     }

    //     if (cache[start]) {
    //         return cache[start];
    //     }

    //     for (int end = start + 1 ; end <= s.length() ; end++) {
    //         if (wordDict.contains(s.substring(start, end)) && topDownWordBreak(s, wordDict, end, cache)) {
    //             return cache[start] = true;
    //         }
    //     }
    //     return cache[start] = false;
    // }
}