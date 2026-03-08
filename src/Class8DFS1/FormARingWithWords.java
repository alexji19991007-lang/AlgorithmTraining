package Class8DFS1;

// Given an array of strings, find if the strings can be concatenated to form a ring. 
// The two strings s1 and s2 can be concatenated iff the the last char of s1 is identical 
// to the first char of s2. The first char of the first string in the array must be identical 
// to the last char of the last string. The ring must contain every string in the input once and only once.

// Assumptions:
// The given array is not null or empty.
// None of the strings in the array is null or empty.

// Examples:
// input = {"aaa", "bbb", "baa", "aab"}, return true since it can be re-arranged to {"aaa", "aab", "bbb"  and "baa"}
// input = {"aaa", "bbb"}, return false
public class FormARingWithWords {
    public boolean formRing(String[] input) {
        return false;
    }

    public void swap(String[] input, int one, int two) {
        String temp = input[one];
        input[one] = input[two];
        input[two] = temp;
    }
}
