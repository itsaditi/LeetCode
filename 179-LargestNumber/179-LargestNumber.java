class Solution {
    public String largestNumber(int[] nums) {

        // Using Max heap 
        PriorityQueue<String> maxHeap = new PriorityQueue(
            new Comparator<String>() {
                @Override
                public int compare(String first, String second) {
                    return (second + first).compareTo(first + second);
                }
            }
        );
        
        int i = 0;
        for (int num: nums) {
            maxHeap.add(String.valueOf(num));
            i++;
        }
        String res = "";

        if (maxHeap.peek().equals("0")) return "0";

        while (!maxHeap.isEmpty()) {
            String poppedElement = maxHeap.poll();            
            res += poppedElement;
        }
        return res;
    }

    /* BUILT-IN SORTING FUNCTION */
    /*
    public String largestNumber(int[] nums) {

        // Built-in sorting function
        
        String[] numStr = new String[nums.length];
        int i = 0;
        for (int num: nums) {
            numStr[i] = String.valueOf(num);
            i++;
        }
        Arrays.sort(numStr, (a,b) -> (b + a).compareTo(a + b)); // O(n log n) Quick Sort

        if (numStr[0].equals("0")) return "0";
        String res = "";

        for (String num: numStr) {
            res += num;
        }
        return res;
    }
    */
}