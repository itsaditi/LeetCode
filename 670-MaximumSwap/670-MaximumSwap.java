class Solution {
    public int maximumSwap(int num) {
        String str = String.valueOf(num);
        List<Integer> numArr = new ArrayList<>();

        for (Character ch : str.toCharArray()) {
            numArr.add(ch - '0');
        }

        for (int i = 0 ; i < numArr.size() ; i++) {
            int maxNum = i;
            for (int j = i ; j < numArr.size() ; j++) {
                if (numArr.get(j) >= numArr.get(maxNum))
                    maxNum = j;
            }
            if (i != maxNum && numArr.get(i) != numArr.get(maxNum)) {
                swap(numArr, i, maxNum);
                System.out.println("Swap " + numArr.get(i) + " with " + numArr.get(maxNum));
                break;
            }
        }
        System.out.println(numArr);
        int res = 0;
        int base = numArr.size() - 1;
        for (int i = 0; i < numArr.size() ; i++) {
            res += (numArr.get(i) * Math.pow(10, base));
            base--;
        }


        return res;
    }

    private void swap(List<Integer> numArr, int i, int j) {
        int temp = numArr.get(i);
        numArr.set(i, numArr.get(j));
        numArr.set(j, temp);
    }
}