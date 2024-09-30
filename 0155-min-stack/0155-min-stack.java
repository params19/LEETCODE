class MinStack {
    Stack<Integer> st;
    Stack<Integer> pre;
    public MinStack() {
        st = new Stack<>();
        pre = new Stack<>();
    }
    
    public void push(int val) {
        if(st.isEmpty())
        {
            st.push(val);
            pre.push(val);
        }
        else
        {
            st.push(val);
            pre.push(Math.min(val,pre.peek()));
        }
    }
    
    public void pop() {
        st.pop();
        pre.pop();
    }
    
    public int top() {
        int ele=st.peek();
        return ele;
    }
    
    public int getMin() {
        return pre.peek();
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