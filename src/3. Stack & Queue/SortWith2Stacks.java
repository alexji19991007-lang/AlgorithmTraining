// Given an array that is initially unstored in one stack, sort it with one additional stacks (total 2 stacks).
// After sorting the original stack should contain the sorted integers and from top to bottom the integers are 
// sorted in ascending order.

// Assumptions:
// The given stack is not null.
// There can be duplicated numbers in the give stack.

// Requirements:
// No additional memory, time complexity = O(n ^ 2).

// input: [2, 5, 7, 3, 7 --> top of stack
// buffer: [
// Step 1: 
//      1.1 Pop all elements from input & push into buffer
//      1.2 Keep track of the max number in this pass and the count
//          input: [
//          buffer: [7, 3, 7, 5, 2
//          curMax = 7, maxCount = 2

// Step 2: 
//      2.1 Push maxCount number of curMax back into input 
//          input: [7, 7
//          buffer: [7, 3, 7, 5, 2
//      2.2 Pop all elements from buffer back to input but ignore curMax
//          input: [7, 7, 2, 5, 3
//          buffer: [

// Step 3: 
//      3.1 Pop elements from input & push into buffer, STOP when we meet the previous max (prevMax)
//      3.2 Keep track of the max number in this pass and the count
//          input: [7, 7
//          buffer: [3, 5, 2
//          curMax = 5, maxCount = 1

// Step 4: 
//      2.1 Push maxCount number of curMax back into input 
//          input: [7, 7, 5
//          buffer: [3, 5, 2
//      2.2 Pop all elements from buffer back to input but ignore curMax
//          input: [7, 7, 5, 2, 3
//          buffer: [

// ......


import java.util.*;

public class SortWith2Stacks {
    public void sort(Deque<Integer> s1) {
        if (s1 == null || s1.size() <= 1) {
            return;
        }
        Deque<Integer> s2 = new ArrayDeque<>();
        sortHelper(s1, s2);
    }

    public void sortHelper(Deque<Integer> input, Deque<Integer> buffer) {
        int prevMax = Integer.MIN_VALUE;
        while (input.peekFirst() < prevMax) { // 外层for loop是用来控制最终sort完成的
            int curMax = Integer.MIN_VALUE; // 找curMax，用Integer.MIN_VALUE; // 如果找curMin，用Integer.MAX_VALUE;
            int curMaxCount = 0;
            while (!input.isEmpty() && input.peekFirst() < prevMax) {
                int cur = input.pollFirst();
                if (cur > curMax) {
                    curMax = cur;
                    curMaxCount = 1;
                } else if (cur == curMax) {
                    curMaxCount++;
                }
                buffer.offerFirst(cur);
            }
            while (curMaxCount > 0) {
                input.offerFirst(curMax);
                curMaxCount--;
            }
            while (!buffer.isEmpty()) {
                int temp = buffer.pollFirst();
                if (temp != curMax) {
                    input.offerFirst(temp);
                }
            }
            prevMax = curMax;
        }
    }
}
