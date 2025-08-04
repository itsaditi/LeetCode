// Last updated: 8/4/2025, 4:50:26 PM
class Solution {
    public int kthFactor(int n, int k) {
        if (n <= 2) return n;

        List<Integer> factors = new ArrayList<>();
        for (int i = 1; i <= n ; i++) {
            if (n % i == 0) factors.add(i);
        }

        if (k >= n || k > factors.size()) return -1;


        return factors.get(k - 1);
    }
}