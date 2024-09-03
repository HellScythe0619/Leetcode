/*
 * @lc app=leetcode id=225 lang=java
 *
 * [225] Implement Stack using Queues
 */

// @lc code=start

import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    /**
     * Two Queue to Stack
     * Time Complexity: O(N) for push()
     * 
     * runtime: 100% (0 ms)
     * memory: 82.15% (41.1 MB)
     */
    Queue<Integer> queue;
    Queue<Integer> reverseQueue;

    public MyStack() {
        queue = new LinkedList<>();
        reverseQueue = new LinkedList<>();
    }
    
    public void push(int x) {
        reverseQueue.add(x);
        while (!queue.isEmpty()) {
            reverseQueue.add(queue.remove());
        }

        Queue<Integer> temp = queue;
        queue = reverseQueue;
        reverseQueue = temp;
    }
    
    public int pop() {
        return queue.remove();
    }
    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

