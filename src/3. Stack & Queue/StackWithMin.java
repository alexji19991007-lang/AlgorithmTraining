import java.util.*;

// Enhance the stack implementation to support min() operation. min() should return the current minimum 
// value in the stack. If the stack is empty, min() should return -1.

// push(int element) - push the element to top
// pop() - return the top element and remove it, if the stack is empty, return -1
// top() - return the top element without remove it, if the stack is empty, return -1
// min() - return the current min value in the stack.

// What matters most here:
// 1. when did the current min came in? --> 这个min第一次进来之后，stack的size是多少
// 2

public class StackWithMin {
    private Deque<Integer> mStack;
    private Deque<Pair> minRecordStack;

    public StackWithMin() {
        this.mStack = new ArrayDeque<>();
        this.minRecordStack = new ArrayDeque<>();
    }

    public int pop() {
        if (mStack.isEmpty()) {
            return Integer.MIN_VALUE;
        }
        int curSize = mStack.size();
        int res = mStack.pollFirst();
        if (res == min() && minRecordStack.peekFirst().getValue() == curSize) {
            minRecordStack.pollFirst();
        }
        return res;
    }

    public void push(int element) {
        mStack.offerFirst(element);
        if (mStack.size() == 1) {
            minRecordStack.offerFirst(new Pair(element, mStack.size()));
        } else {
            Pair curMinPair = minRecordStack.peekFirst();
            int curMin = curMinPair.getKey();
            if (element < curMin) {
                minRecordStack.offerFirst(new Pair(element, mStack.size()));
            }
        }
    }

    public int top() {
        return mStack.isEmpty() ? Integer.MIN_VALUE : mStack.peekFirst();
    }

    public int min() {
        return mStack.isEmpty() ? Integer.MIN_VALUE : minRecordStack.peekFirst().getKey();
    }

    class Pair {
        private int key; // The current min
        private int value; // The size of the stack after the current min was first added to the stack.

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return this.key;
        }

        public int getValue() {
            return this.value;
        }
    }
}
