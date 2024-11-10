class Solution {
        HashMap<String, List<String>> map = new HashMap<>();
        HashSet<String> visited = new HashSet<>();

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Stack<String> stack = new Stack<>();

        List<List<String>> res = new ArrayList<>();

        // Create graph 
        for (List<String> account: accounts) {
            String accountFirstEmail = account.get(1);

            for (int i = 2 ; i < account.size() ; i++) {
                String accountOtherEmail = account.get(i);

                if (!map.containsKey(accountFirstEmail)) {
                    map.put(accountFirstEmail, new ArrayList<>());
                }
                map.get(accountFirstEmail).add(accountOtherEmail);

                if(!map.containsKey(accountOtherEmail)) {
                    map.put(accountOtherEmail, new ArrayList<>());
                }
                map.get(accountOtherEmail).add(accountFirstEmail);
            }
        }

        // DFS
        for (List<String> account: accounts) {
            List<String> tempRes = new ArrayList<>();
            tempRes.add("0");

            for (int i = 1 ; i < account.size() ; i++) {
                if (!visited.contains(account.get(i))) {
                    // stack.add(account.get(i));

                    // while(!stack.empty()) {
                    //     String poppedEmail = stack.pop();
                    //     if (map.containsKey(poppedEmail)) {
                    //         for (String edges: map.get(poppedEmail)) {
                    //             if (!stack.contains(edges) && !visited.contains(poppedEmail)) stack.add(edges);
                    //         }

                    //         if (!visited.contains(poppedEmail)) visited.add(poppedEmail);
                    //         if (!tempRes.contains(poppedEmail)) tempRes.add(poppedEmail);
                    //     } else {
                    //         tempRes.add(poppedEmail);
                    //     }
                        
                    // }
                    dfs(tempRes, account.get(i));
                }
            }
            if (tempRes.size() > 1){
                Collections.sort(tempRes);
                tempRes.set(0, account.get(0));
                res.add(tempRes);
            }
        }

        return res;
    }

    // Use Recursion stack instead
    private void dfs(List<String> mergedAccount, String email) {
        visited.add(email);
        mergedAccount.add(email);

        if (!map.containsKey(email)) return;

        for (String connectedEmail: map.get(email)) {
            if (!visited.contains(connectedEmail)) {
                dfs(mergedAccount, connectedEmail);
            }
        }
    }
}