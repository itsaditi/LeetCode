class Solution {
    public int reverse(int x) {
        boolean isSigned = x < 0 ? true : false;
        List<Integer> nums = new ArrayList<>();

        int num = x;
        int reversedNum = 0;
        while (num != 0) {
            int remainder = num % 10;
            num = num / 10;
            nums.add(remainder);           
        }

        int pow = nums.size() - 1;
        for (int i = 0; i < nums.size(); i ++) {
            reversedNum += (nums.get(i) * Math.pow(10, pow));
            pow--;
        }

        if (reversedNum >= Integer.MAX_VALUE || reversedNum <= Integer.MIN_VALUE) {
            return 0;
        }

        return reversedNum;

    }
}