class MinStack {

    Stack<Integer> minStack = new Stack<>();
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

    int minElement = Integer.MAX_VALUE;

    public MinStack() {
        
    }
    
    public void push(int val) {
        minStack.push(val);
        priorityQueue.add(val);
    }
    
    public void pop() {
        Integer topElement = minStack.peek();
        priorityQueue.remove(topElement);
        minStack.pop();
    }
    
    public int top() {
        return minStack.peek();
    }
    
    public int getMin() {
        return priorityQueue.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */