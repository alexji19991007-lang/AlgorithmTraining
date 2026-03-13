package Class9String1;

// Given a string, remove all leading/trailing/duplicated empty spaces.

// Assumptions:
// The given string is not null.

// Examples:
// “  a” --> “a”
// “   I     love MTV ” --> “I love MTV”

public class RemoveSpaces {
    public String removeSpaces(String input) {
        char[] array = input.toCharArray();
        int slow = 0;
        int fast = 0;
        while (fast < array.length) {
            // Case 1: if the current character is a space:
            //      1.1 fast == 0 --> fast++
            //      1.1 fast之前的也是space --> fast++
            // Case 2: 所有除了case1以外的情况 --> 把slow指向的东西变成fast指向的char --> slow++, fast++
            if (array[fast] == ' ' && (fast == 0 || array[fast - 1] == ' ')) {
                fast++;
            } else {
                array[slow++] = array[fast++];
            }
        }
        // 课后好好想一下为什么是slow - 1
        if (slow > 0 && array[slow - 1] == ' ') {
            slow--;
        }
        return new String(array, 0, slow);
    }
}
