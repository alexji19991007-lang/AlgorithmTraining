// Given an array of elements, reorder it as follow:
// { N1, N2, N3, …, N2k } → { N1, Nk+1, N2, Nk+2, N3, Nk+3, … , Nk, N2k }
// { N1, N2, N3, …, N2k+1 } → { N1, Nk+1, N2, Nk+2, N3, Nk+3, … , Nk, N2k, N2k+1 }

// Try to do it IN PLACE. 就是不要创建一个新的array，在原有的题目给你的array上面操作

// Assumptions
// The given array is not null
// Examples
// { 1, 2, 3, 4, 5, 6} → { 1, 4, 2, 5, 3, 6 }
// { 1, 2, 3, 4, 5, 6, 7, 8 } → { 1, 5, 2, 6, 3, 7, 4, 8 } *** 请你用这个array来思考这个问题
// { 1, 2, 3, 4, 5, 6, 7 } → { 1, 4, 2, 5, 3, 6, 7 }

// 思路
// 就看{ 1, 2, 3, 4, 5, 6, 7, 8 }
// 
// 把原本的数组被分成：
// [0 1] [2 3] [4 5] [6 7]
// N1 N2 | N3 N4 | N5 N6 | N7 N8
//   A       B       C       D
// 你可以把这个问题想像成先reorder这个大array，也就是ABCD变成ACBD
// i.e. 原array --> N1 N2 | N5 N6 | N3 N4 | N7 N8

// 然后我们再把这个问题分成两个小问题：
// 小问题1: N1 N2 N5 N6 --> N1 N5 N2 N6
// 小问题2: N3 N4 N7 N8 --> N3 N7 N4 N8
//         A  B  C  D  --> A  C  B  D 本质上和原来的大问题都是ABCD变成ACBD的问题

// 总而言之，解决大一号问题的ABCD --> ACBD，然后把大一号问题分成左右两个小问题，再次解决小问题的ABCD --> ACBD

// Example: 如何解决最大一号问题的ABCD转化为ACBD：
// 第一步先把左半边 N3 N4 翻转变成 N4 N3
// 第二步把有半边 N5 N6 翻转变成 N6 N5
// 现在我们就有了 N4 N3 | N6 N5
// 然后把他们整体翻转 得到 N5 N6 | N3 N4
// 整体array变成N1 N2 | N5 N6 | N3 N4 | N7 N8
// 
// 以上同样的操作对 N1 N2 N5 N6 以及 N3 N4 N7 N8再做一遍 --> where recursion comes into play!!!
// 即可得到最终结果 N1 N5 | N2 N6 | N3 N7 | N4 N8
public class PerfectShuffle {
    public static int[] reorder(int[] array) {
        if (array.length % 2 == 0) {
            shuffleHelper(array, 0, array.length - 1);
        } else {
            shuffleHelper(array, 0, array.length - 2);
        }
        return array;
    }

    public static void shuffleHelper(int[] array, int left, int right) {
        // Recursion terminates when left neighbors right.
        if (left + 1 >= right) {
            return;
        }
        int size = right - left + 1;
        int mid = left + size / 2;
        int leftMid = left + size / 4;
        int rightMid = left + size * 3 / 4;
        reverseHelper(array, leftMid, mid - 1);
        reverseHelper(array, mid, rightMid - 1);
        reverseHelper(array, leftMid, rightMid - 1);
        // We ensure that the length from left to leftMid the same as that from right to rightMid
        // So the new right position should be "left + 2 * (leftMid - left) - 1"
        shuffleHelper(array, left, left + 2 * (leftMid - left) - 1);
        shuffleHelper(array, left + 2 * (leftMid - left), right);
    }

    public static void reverseHelper(int[] input, int left, int right) {
        if (left >= right) {
            return;
        }
        while (left < right) {
            swap(input, left++, right--);
        }
    }

    public static void swap(int[] input, int left, int right) {
        int temp = input[left];
        input[left] = input[right];
        input[right] = temp;
    }
}
