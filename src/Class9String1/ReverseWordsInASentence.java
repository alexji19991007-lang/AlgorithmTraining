package Class9String1;


// Reverse the words in a sentence.

// Assumptions
// Words are separated by single space
// There are no heading or tailing white spaces

// Examples
// “I love Google” → “Google love I”

// Corner Cases
// If the given string is null, we do not need to do anything.


// 1. reverse the whole string
// 2. reverse each word in the string
public class ReverseWordsInASentence {
    public String reverseWords(String input) {
        char[] array = input.toCharArray();
        reverseHelper(array, 0, array.length - 1);
        int slow = 0, fast = 0;
        // 如何判断读完一个word了
        // 1. 遇到空格了
        // 2. 到结尾了
        if (fast == array.length - 1 || array[fast + 1] == ' ') {
            reverseHelper(array, slow, fast);
            fast += 2;
            slow = fast;
        } else {
            fast++;
        }
        return new String(array);
    }

    public void reverseHelper(char[] input, int left, int right) {
        if (left >= right) {
            return;
        }
        while (left < right) {
            swap(input, left++, right--);
        }
    }

    public void swap(char[] input, int left, int right) {
        char temp = input[left];
        input[left] = input[right];
        input[right] = temp;
    }
}

// 课后作业1：用stack写这道题
