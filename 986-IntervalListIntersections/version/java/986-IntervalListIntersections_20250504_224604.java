// Last updated: 5/4/2025, 10:46:04 PM
class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        // Arrays.sort(firstList, (a,b) -> a[0] - b[0]);
        // Arrays.sort(secondList, (a,b) -> a[0] - b[0]);

        if (firstList.length == 0 || secondList.length == 0) return new int[0][0];

        int n = firstList.length, m = secondList.length;
        List<int[]> result = new ArrayList<>();

        for (int i = 0 ; i < n ; i ++) {
            for (int j = 0 ; j < m ; j ++) {
                // Interval [a, b] intersects with [c, d] if b >= c and a <= d
                if (firstList[i][1] >= secondList[j][0] && firstList[i][0] <= secondList[j][1]) {
                    int high = Math.max(firstList[i][0], secondList[j][0]);
                    int low = Math.min(firstList[i][1], secondList[j][1]);
                    int[] intersection = new int[]{high, low};
                    result.add(intersection);

                }
            }
        }

        return result.toArray(new int[result.size()][2]);
    }
}