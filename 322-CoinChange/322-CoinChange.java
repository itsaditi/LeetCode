class Solution {

    public int coinChange(int[] coins, int amount) {
        int[] count = new int[amount];
        return checkCoin(coins, amount, count);
    }

    private int checkCoin(int[] coins, int amount, int[] count) {
        if (amount == 0) return 0;

        if (amount < 0) return -1;

        if (count[amount - 1] != 0) return count[amount - 1];

        int leastDiff = Integer.MAX_VALUE;

        for (int cn: coins) {
            int diff = checkCoin(coins, amount - cn, count);
            if (diff >= 0 && diff < leastDiff) {
                leastDiff = 1 + diff;
            }
        }

        count[amount - 1] = leastDiff == Integer.MAX_VALUE ? -1 : leastDiff;
        System.out.println(amount - 1 + " = " + leastDiff);

        return count[amount - 1];
    }
}