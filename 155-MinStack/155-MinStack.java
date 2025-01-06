class MinStack {

	Stack<Integer> stack = new Stack<>();
	Stack<Integer> minStack = new Stack<>();

	public MinStack(){}

	public void push(int val) {
		stack.push(val);
		if (minStack.isEmpty()) {
			minStack.push(val);
			return;
		}
		if (val <= minStack.peek()) {
			minStack.push(val);
		}
	}

	public void pop() {
		int poppedElem = stack.pop();
		if (poppedElem == minStack.peek()) {
			minStack.pop();
		}
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

}


class MinStack__ {
    Stack<int[]> stack = new Stack<>();

    public MinStack__() {
        
    }
    
    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new int[]{val, val});
            return;
        }

        int min = Math.min(val, stack.peek()[1]);
        stack.push(new int[]{val, min});
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek()[0];
    }
    
    public int getMin() {
        return stack.peek()[1];
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