// Last updated: 8/4/2025, 4:50:45 PM
class Solution {
    public int minAreaRect(int[][] points) {
        int minArea = Integer.MAX_VALUE;

        HashMap<Integer, Set<Integer>> map = new HashMap<>();

        for (int[] point: points) {
            if (!map.containsKey(point[0])) {
                map.put(point[0], new HashSet<>());
            }

            map.get(point[0]).add(point[1]);
        }

        for (int[]p1: points) {
            for (int[]p2: points) {
                if (p1[0] != p2[0] && p1[1] != p2[1]) {
                    if (
                        map.get(p1[0]).contains(p2[1]) &&
                        map.get(p2[0]).contains(p1[1])
                    ) {
                        int area = Math.abs(p1[0] - p2[0]) * Math.abs(p1[1] - p2[1]);
                        minArea = Math.min(area, minArea);
                    }
                }
            }
        }

        return minArea == Integer.MAX_VALUE ? 0 : minArea;
    }
}