class PositionObj {
    List<Integer> closestPts = new ArrayList<>();
    List<Integer> farthestPts = new ArrayList<>();

    PositionObj(List<Integer> closestList, List<Integer> farthestList) {
        this.closestPts = closestList;
        this.farthestPts = farthestList;
    }
}

class Solution {

    /** OPTIMIZED - BINARY SEARCH **/
    // TC - O(n)
    public int[][] kClosest_BinarySearch(int[][] points, int k) {
        int n = points.length;
        double[] distance = new double[n];
        double low = 0, high = 0;

        List<Integer> remaining = new ArrayList<>();

        for (int i = 0 ; i < n ; i++) {
            distance[i] = (points[i][0] * points[i][0]) + (points[i][1] * points[i][1]);
            high = Math.max(high, distance[i]);
            remaining.add(i);
        }

        List<Integer> closestIndexes = new ArrayList<>();

        while (k > 0) {
            double mid = low + (high - low) / 2;

            PositionObj splitPoints = splitPoints(distance, remaining, mid);

            List<Integer> closerPts = splitPoints.closestPts;
            List<Integer> fartherPts = splitPoints.farthestPts;
            
            if (closerPts.size() <= k) {
                // All points in closerPts belongs to ans
                low = mid;
                remaining = fartherPts;
                
                // Update k because we have closerPt.size(), 
                // we need k - closerPt.size() more pts
                k -= closerPts.size();

                // Keep a record of indexs belonging to answe
                closestIndexes.addAll(closerPts);
            } else {
                high = mid;
                remaining = closerPts;
            }

        }

        int[][] ans = new int[closestIndexes.size()][2];
        for (int i = 0 ; i < closestIndexes.size() ; i++) {
            ans[i] = points[closestIndexes.get(i)];
        }

        return ans;

    }

    private PositionObj splitPoints(
        double[] distance,
        List<Integer> remaining,
        double mid
    ) {
        List<Integer> closePt = new ArrayList<>();
        List<Integer> farPt = new ArrayList<>();

        for (int i: remaining) {
            if (distance[i] <= mid) {
                closePt.add(i);
            } else {
                farPt.add(i);
            }
        }

        return new PositionObj(closePt, farPt);
    }

    public int[][] kClosest_UsingMaxHeap(int[][] points, int k) {
        // Using Priority Queue - TC - O(n log k) and SC - O(k)

        Queue<int[]> maxPQ = new PriorityQueue<>((a,b) -> b[2]-a[2]);
        ArrayList<int[]> resultArr = new ArrayList<>();

        for(int i = 0 ; i < points.length ; i ++) {
            int x = points[i][0];
            int y = points[i][1];
            int euclideanDist = (x * x) + (y * y);

            int[] entry = {x, y, euclideanDist};
            if (maxPQ.size() < k) {
                maxPQ.add(entry);
            } else if (euclideanDist < maxPQ.peek()[2]) {
                int[] polledEntry = maxPQ.poll();
                maxPQ.add(entry);
            }
        }

        for (int j = 0 ; j < k ; j ++) {
            int[] polledEntry = maxPQ.poll();
            int[] resEntry = {polledEntry[0], polledEntry[1]};
            resultArr.add(resEntry);
        }

        return resultArr.toArray(new int[k][2]);
    }

    public int[][] kClosest_UsingMax_Heap(int[][] points, int k) {
        // Using Priority Queue - TC - O(n log n) and SC - O(n)

        Queue<int[]> maxPQ = new PriorityQueue<>((a,b) -> a[2]-b[2]);
        ArrayList<int[]> resultArr = new ArrayList<>();

        for(int i = 0 ; i < points.length ; i ++) {
            int x = points[i][0];
            int y = points[i][1];
            int euclideanDist = (x * x) + (y * y);

            int[] entry = {x, y, euclideanDist};
            maxPQ.add(entry);
        }

        for (int j = 0 ; j < k ; j ++) {
            int[] polledEntry = maxPQ.poll();
            int[] resEntry = {polledEntry[0], polledEntry[1]};
            resultArr.add(resEntry);
        }

        return resultArr.toArray(new int[k][2]);

    }

    public int[][] kClosest(int[][] points, int k) {
        //BRUTE FORCE 
        // Time Complexity --> O(n) + O(nlogn)
        // Space Complexity --> O(n)
        ArrayList<int[]> resultArr = new ArrayList<>();
        int[][] res = new int[points.length][3];

        // Create res array which has 3-D array such that -
        //[[x, y, sqrt(x)+ sqrt(y)], ...] where third element is
        // the distance from the origin
        // Time Complexity --> O(n)
        for (int i = 0 ; i < points.length ; i ++) {
            int x = points[i][0];
            int y = points[i][1];

            res[i][0] = x;
            res[i][1] = y;
            
            res[i][2] = (x * x) + (y * y);
        }

        // Sort ress array by the last element such that
        // elements will be arranged in ascending to descending 
        // order of distance from origin
        // Time Complexity --> O(nlogn)
        Arrays.sort(res, (a,b)->(a[2]-b[2]));

        // Push required co-or to result array
        // Time Complexity --> O(k)
        for (int j = 0 ; j < k ; j ++) {
            int[] tempArr = new int [2];
            tempArr[0] = res[j][0];
            tempArr[1] = res[j][1];

            resultArr.add(tempArr);
        }
        

        return resultArr.toArray(new int[k][2]);
    }
}