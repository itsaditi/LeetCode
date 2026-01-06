// Last updated: 1/5/2026, 10:54:43 PM
1class MinStack {
2    
3    Stack<int[]> stack;
4
5    public MinStack() {
6        stack = new Stack<>(); //[val, min(val, prevVal)]
7    }
8    
9    public void push(int val) {
10        if (stack.isEmpty()) {
11            int[] pushVal = {val, val};
12            stack.push(pushVal);
13            return;
14        }
15
16        int[] pushVal = {val, Math.min(stack.peek()[1], val)};
17        stack.push(pushVal);
18        return;
19    }
20    
21    public void pop() {
22        stack.pop();
23    }
24    
25    public int top() {
26        return stack.peek()[0];
27    }
28    
29    public int getMin() {
30        return stack.peek()[1];
31    }
32}
33
34/**
35 * Your MinStack object will be instantiated and called as such:
36 * MinStack obj = new MinStack();
37 * obj.push(val);
38 * obj.pop();
39 * int param_3 = obj.top();
40 * int param_4 = obj.getMin();
41 */