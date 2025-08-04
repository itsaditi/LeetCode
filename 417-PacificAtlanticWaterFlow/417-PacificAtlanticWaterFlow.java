// Last updated: 8/4/2025, 4:51:14 PM
class Solution {

    int[][] DIRECTIONS = new int[][]{{0, 1}, {-1, 0}, {1, 0},  {0, -1}};
    int n = 0, m = 0;
    
    /****** BFS (Iteratively using Queue) ******/  
    // TC - O(n * m) and SC - O(n * m)
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        n = heights.length;
        m = heights[0].length;

        List<List<Integer>> res = new ArrayList<>();

        // Edge Case #1
        if (n == 1 && m == 1) {
            res.add(Arrays.asList(new Integer[]{0, 0}));
            return res;
        }

        Queue<Pair<Integer, Integer>> pacificQueue = new LinkedList<>();
        Queue<Pair<Integer, Integer>> atlanticQueue = new LinkedList<>();

        Set<Pair<Integer, Integer>> pacificVisited = new HashSet<>();
        Set<Pair<Integer, Integer>> atlanticVisited = new HashSet<>();

        for (int i = 0 ; i < m ; i++) {
            pacificQueue.offer(new Pair(0, i));
            atlanticQueue.offer(new Pair(n -1, i));
        }

        for (int i = 0; i < n ; i++) {
            pacificQueue.offer(new Pair(i, 0));
            // 0=5, 1=5, 2=5
            atlanticQueue.offer(new Pair(i, m - 1));
        }

        bfs(heights, pacificQueue, pacificVisited);
        bfs(heights, atlanticQueue, atlanticVisited);

        System.out.println(pacificVisited);
        System.out.println(atlanticVisited);

        if (pacificVisited.size() <= atlanticVisited.size()) {
            traverseSet(pacificVisited, atlanticVisited, res);
        } else {
            traverseSet(atlanticVisited, pacificVisited, res);
        }
        
        return res;
    }

    private void bfs(
        int[][] heights,
        Queue<Pair<Integer, Integer>> queue,
        Set<Pair<Integer, Integer>> visited
    ) {

        while (!queue.isEmpty()) {
            Pair cell = queue.poll();

            if (visited.contains(cell)) continue;

            visited.add(cell);
            int r = (int) cell.getKey();
            int c = (int) cell.getValue();

            for (int[] direction: DIRECTIONS) {
                int newRow = direction[0] + r;
                int newCol = direction[1] + c;

                if (isValid(newRow, newCol)) {

                    if (visited.contains(new Pair(newRow, newCol))) continue;

                    if (heights[newRow][newCol] >= heights[r][c]) {
                        queue.add(new Pair(newRow, newCol));
                    }
                }
                
            }
        }   
        return;
    }

    /****** DFS (Using Recursion Stack) ******/  
    // TC - O(n * m) and SC - O(n * m)
    public List<List<Integer>> pacificAtlanticUsingDFS(int[][] heights) {
        n = heights.length;
        m = heights[0].length;

        List<List<Integer>> res = new ArrayList<>();


        // Edge case - 
        if (n == 1 && m == 1) {
            res.add(Arrays.asList(new Integer[]{0, 0}));
            return res;
        }

        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        Set<Pair<Integer, Integer>> visitedAl = new HashSet<>();

        for (int i = 0 ; i < m ; i++) {
            // Top pacific Ocean 0=1, 0=2, 0=3,...0=m-1
            dfs(heights, 0, i, visited);

            // Bottom Altantic Ocean 4=0, 4=1, 4=2... n-1=m-1
            dfs(heights, n - 1, i, visitedAl);
        }


        // Left Pacific Ocean
        for (int i = 0 ; i < n ; i++) {
            // Left Pacific Ocean - 0=0, 1=0, 2=0,... n-1=0
            dfs(heights, i, 0, visited);

            // Right Atlantic Ocean - 0=5, 1=5, 2=5,... n-1=m-1
            dfs(heights, i, m - 1, visitedAl);
        }
        
        if (visited.size() <= visitedAl.size()) {
            traverseSet(visited, visitedAl, res);
        } else {
            traverseSet(visitedAl, visited, res);
        }
            

        return res;
    }


    private void dfs(int[][]heights, int r, int c, Set<Pair<Integer, Integer>> visited) {
        if (visited.contains(new Pair(r,c))) return;

        visited.add(new Pair(r, c));

        for (int[] direction: DIRECTIONS) {
            int newRow = r + direction[0];
            int newCol = c + direction[1];
            
            if (isValid(newRow, newCol) && isValid(r, c)) {
                if (heights[newRow][newCol] >= heights[r][c]) {
                    dfs(heights, newRow, newCol, visited);
                }
            }
        }

        return;
    }

    private void traverseSet(
        Set<Pair<Integer, Integer>> set1,
        Set<Pair<Integer, Integer>> set2,
        List<List<Integer>> res
    ) {

        for (Pair pair: set1) {
            if (set2.contains(pair)) {
                res.add(Arrays.asList(new Integer[]{(Integer)pair.getKey(), (Integer)pair.getValue()}));
            }
        }
        return;
    }

    private boolean isValid(int i, int j) {
        return (i >= 0 && i < n) && (j >= 0 && j < m);
    }
    

}