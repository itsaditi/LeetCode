class MinStack {

    Stack<Integer> stack = new Stack<>();
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        stack.push(val);
        priorityQueue.add(val);
    }
    
    public void pop() {
        Integer topElement = stack.peek();
        priorityQueue.remove(topElement);
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
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