import java.util.*;

// Java: Implement a queue by using two stacks. The queue should provide 
// size(), isEmpty(), offer(), poll() and peek() operations. When the queue 
// is empty, poll() and peek() should return null.

// Assumptions
// The elements in the queue are all Integers.
// size() should return the number of elements buffered in the queue.
// isEmpty() should return true if there is no element buffered in the queue, false otherwise.

// YOU MUST ONLY USE STACK METHODS WHEN USING DEQUE

// 🧠 Core Concept
//      A stack reverses order.
//      If you reverse something twice, you get the original order.
//      That’s the entire trick.

// 1. Offer 1, 2, 3 --> push all to s1
// s1 [1, 2, 3
// s2 [

// 2. Poll() --> first pop all from s1 to s2 and then pop from s2
// s1 [
// s2 [3, 2, 1 --> pop 1


public class QueueBy2Stacks {
    private Deque<Integer> in; // Stack 1
    private Deque<Integer> out; // Stack 2

    public QueueBy2Stacks() {
        this.in = new ArrayDeque<>();
        this.out = new ArrayDeque<>();
    }

    public Integer poll() {
        move();
        return out.pollFirst();
    }

    public void offer(int element) {
        in.offerFirst(element);
    }

    public Integer peek() {
        move();
        return out.peekFirst();
    }

    public int size() {
        return in.size() + out.size();
    }

    public boolean isEmpty() {
        return in.isEmpty() && out.isEmpty();
    }

    private void move() {
        if (!out.isEmpty()) {
            return;
        }
        while (!in.isEmpty()) {
            out.offerFirst(in.pollFirst());
        }
    }
}

// Time Complexity:
// offer(): O(1)
// poll() / peek(): Amortized O(1) --> 前人栽树，后人乘凉
// Each element:
//      Goes into in once
//      Moves to out once
//      Gets removed once
// So over many operations, cost averages to O(1).
// Worst-case single call: O(n)
// Average: O(1)

// n^100 + n^99 + 1 --> polynomial time
// 2^n + 1 --> exponential time

// Space Complexity: O(1)
