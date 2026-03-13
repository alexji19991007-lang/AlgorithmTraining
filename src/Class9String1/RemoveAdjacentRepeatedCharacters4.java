package Class9String1;

import java.util.ArrayDeque;
import java.util.Deque;

// Repeatedly remove all adjacent, repeated characters in a given string from left to right.
// No adjacent characters should be identified in the final string.

// Examples
// "abbbaaccz" → "aaaccz" → "ccz" → "z"
// "aabccdc" → "bccdc" → "bdc"
public class RemoveAdjacentRepeatedCharacters4 {
    public String deDup(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }
        char[] array = input.toCharArray();
        int slow = 1, fast = 1;
        while (fast < array.length) {
            if (array[slow - 1] != array[fast]) {
                array[slow++] = array[fast++];
            } else {
                slow--;
                while (fast < array.length && array[fast] == array[slow]) {
                    fast++;
                }
            }
        }
        
        return new String(array, 0, slow);
    }

    // if (mStack.isEmpty()) {
    //     mStack.offerFirst(cur); --> 这个已经被slow = 1 & fast = 1考虑到了
    //     fast++;
    // } else if (mStack.peekFirst() != cur) {
    //     mStack.offer(cur); --> array[slow] = array[fast]; slow++; fast++;
    //     fast++;
    // } else {
    //     char duplicate = mStack.pollFirst(); --> slow--; 然后duplicate就被slow指着了
    //     while (fast < array.length && array[fast] == duplicate) {
    //         fast++;
    //     }
    // }

    // 规律：
    // 1. 如果stack是empty的 --> 放进去
    // 2. 如果stack不是empty的 && 手里拿的和stack顶端不同 --> 放进去
    // 3. 如果stack不是empty的 && 手里拿的和stack顶端相同 --> 不放进去，并且把stack顶端pop出来，并且移动fast pointer直到手里拿的和stack顶端pop出来的东西不一样为止
    public String deDupWithStack(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }
        Deque<Character> mStack = new ArrayDeque<>();
        char[] array = input.toCharArray();
        int fast = 0;
        while (fast < array.length) {
            char cur = array[fast];
            // if (mStack.isEmpty()) {
            //     mStack.offerFirst(cur);
            //     fast++;
            // } else if (mStack.peekFirst() != cur) {
            //     mStack.offer(cur);
            //     fast++;
            // } else {
            //     char duplicate = mStack.pollFirst();
            //     while (fast < array.length && array[fast] == duplicate) {
            //         fast++;
            //     }
            // }
            if (!mStack.isEmpty() && mStack.peekFirst() == cur) {
                while (fast < array.length && array[fast] == cur) {
                    fast++;
                }
                mStack.pollFirst();
            } else {
                mStack.offerFirst(cur);
                fast++;
            }
        }
        int ansLen = mStack.size();
        int i = ansLen - 1;
        while (!mStack.isEmpty()) {
            array[i--] = mStack.pollFirst();
        }
        return new String(array, 0, ansLen);
    }
}
