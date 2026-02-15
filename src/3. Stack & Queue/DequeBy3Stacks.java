import java.util.*;
// Java: Implement a deque by using three stacks. The queue should provide size(), isEmpty(), offerFirst(), 
// offerLast(), pollFirst(), pollLast(), peekFirst() and peekLast() operations. When the queue is empty, 
// pollFirst(), pollLast(), peekFirst() and peek() should return null.

public class DequeBy3Stacks {
    private Deque<Integer> leftHalf;
    private Deque<Integer> rightHalf;
    private Deque<Integer> buffer;

    public DequeBy3Stacks() {
        this.leftHalf = new LinkedList<>();
        this.rightHalf = new LinkedList<>();
        this.buffer = new LinkedList<>();
    }

    public void offerFirst(int element) {
    }

    public void offerLast(int element) {
    }

    public Integer pollFirst() {
        return -1;
    }

    public Integer pollLast() {
        return -1;
    }

    public Integer peekFirst() {
        return -1;
    }

    public Integer peekLast() {
        return -1;
    }

    public int size() {
        return -1;
    }

    public boolean isEmpty() {
        return false;
    }

    // 想一想怎么样move才能保证amortized time complexity最低
    private void move(Deque<Integer> source, Deque<Integer> destination) {
    }
}
