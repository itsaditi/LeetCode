class Solution {
    // Keep a map of course with a list of its pre-requiste
    HashMap<Integer, ArrayList<Integer>> prerequisteMap = new HashMap<>();

    // Set of completec courses
    HashSet<Integer> visiting = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0 ; i < numCourses ; i ++) {
            prerequisteMap.put(i, new ArrayList<>());
        }

        for (int i = 0 ; i < prerequisites.length ; i ++) {
            prerequisteMap.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        for (int i = 0 ; i < numCourses ; i ++) {
            if (!dfs(i)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs (int crs) {
        if (visiting.contains(crs)) {
            // Cycle detected
            return false;
        }

        if (!prerequisteMap.containsKey(crs)) {
            // Course has no pre-requiste
            return true;
        }

        visiting.add(crs);

        for (int pre: prerequisteMap.get(crs)) {
            if(!dfs(pre)) {
                return false;
            }
        }

        visiting.remove(crs);
        prerequisteMap.put(crs, new ArrayList<>());

        return true;
    }
}