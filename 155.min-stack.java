/*
 * @lc app=leetcode id=155 lang=java
 *
 * [155] Min Stack
 */

// @lc code=start

import java.util.Stack;

class MinStack {
    /**
     * 使用 兩個 stack，防止當前最小值pop之後失去最小值。
     * minStack將記錄沿途push與pop操作當下的最小值。
     */
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        // 當stack為空時，stack和minStack直接塞值。
        if (stack.size() == 0) {
            stack.push(val);
            minStack.push(val);
        } else {
            stack.push(val);
            int min = minStack.peek();
            // 當前紀錄的最小值大於push值，則以push值記錄當下最小值
            if (min > val) {
                minStack.push(val);
            } else {
                minStack.push(min);
            }
        }
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
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
// @lc code=end

