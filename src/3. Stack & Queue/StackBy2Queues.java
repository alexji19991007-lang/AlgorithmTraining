import java.util.*;

// Implement a stack containing integers using queue(s). The stack should 
// provide push(x), pop(), top() and isEmpty() operations.
// In java: if the stack is empty, then top() and pop() will return null.

public class StackBy2Queues {
    private Queue<Integer> q1;
    private Queue<Integer> q2;
    /** Initialize your data structure here. */
    public StackBy2Queues() {
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
    }

    /** Removes the element on top of the stack and returns that element. */
    public Integer pop() {
        return -1;
    }

    /** Get the top element. */
    public Integer top() {
        return -1;
    }

    /** Returns whether the stack is empty. */
    public boolean isEmpty() {
        return false;
    }
}
