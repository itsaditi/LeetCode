// Last updated: 7/20/2025, 8:15:29 PM
class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<int[]> tempResult = new ArrayList<>();

        for (int[] info: restaurants) {
            int id = info[0];
            int rating = info[1];
            int veganFri = info[2];
            int price = info[3];
            int distance = info[4];
            if (price <= maxPrice && distance <= maxDistance) {
                if (veganFriendly == 1 ) {
                    if (veganFri == 1)
                        tempResult.add(new int[]{id, rating});
                } else {
                    tempResult.add(new int[]{id, rating});
                }
            }
        }

        tempResult.sort((a,b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(b[1], a[1]);
            } else {
                return Integer.compare(b[0], a[0]);
            }
        });

        List<Integer> result = new ArrayList<>();

        for (int[] id: tempResult) {
            result.add(id[0]);
        }

        return result;

    }
}