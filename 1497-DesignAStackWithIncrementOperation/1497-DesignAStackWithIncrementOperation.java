// Last updated: 8/4/2025, 4:50:29 PM
class CustomStack {

    List<Integer> stack;
    int maxSz;
    public CustomStack(int maxSize) {
        stack = new ArrayList<>();
        maxSz = maxSize;
    }
    
    public void push(int x) {
        if (stack.size() < maxSz) {
            stack.add(x);
        }
    }
    
    public int pop() {
        if (stack.isEmpty()) return -1;

        int poppedElement = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);

        return poppedElement;
    }
    
    public void increment(int k, int val) {
        int count = k >= stack.size() ? stack.size() : k;

        for (int i = 0 ; i < count; i++) {
            stack.set(i, stack.get(i) + val);
        }

    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */