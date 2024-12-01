class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] numOfDays = new int[temperatures.length];

        // Using monotonic decreasing stack
        Stack<int[]> stack = new Stack<>();

        for (int i = 0 ; i < temperatures.length ; i++) {

            while (!stack.isEmpty() && temperatures[i] > stack.peek()[1]) {
                int[] poppedElement = stack.pop();
                numOfDays[poppedElement[0]] = i - poppedElement[0];
            }
            stack.push(new int[]{i, temperatures[i]});
            
        }






        // Time Limit Exceeded
        // for (int i = 0 ; i < temperatures.length ; i++) {
        //     int currentTemp = temperatures[i];
        //     int nextIndex = i + 1;
        //     while (nextIndex < temperatures.length) {
        //         if (temperatures[nextIndex] - currentTemp > 0) {
        //             numOfDays[i] = nextIndex - i;
        //             break;
        //         }
        //         nextIndex++;
        //     }
        // }

        return numOfDays;

    }
}