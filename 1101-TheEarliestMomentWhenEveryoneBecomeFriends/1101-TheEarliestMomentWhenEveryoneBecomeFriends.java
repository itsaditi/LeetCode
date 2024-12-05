class Solution {
    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, (a, b) -> Integer.compare(a[0], b[0]));
        int count = n;
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        
        for (int[] log : logs) {
            if (find(parent, log[1]) != find(parent, log[2])) {
                parent[find(parent, log[1])] = log[2];
                count--;
            }
            if (count == 1) return log[0];
        }
        return -1;
    }
    
    private int find(int[] p, int f) {
        if (p[f] == -1) return f;
        return find(p, p[f]);
    }
}