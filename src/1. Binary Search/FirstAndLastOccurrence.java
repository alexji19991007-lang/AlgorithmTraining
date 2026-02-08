// Given a target integer T and an integer array A sorted in ascending order, find the index of the first occurrence of T in A or return -1 if there is no such index.

// Assumptions
// There can be duplicate elements in the array.

// Examples
// A = {1, 2, 3}, T = 2, return 1
// A = {1, 2, 3}, T = 4, return -1
// A = {1, 2, 2, 2, 3}, T = 2, return 1

// Corner Cases
// What if A is null or A of zero length? We should return -1 in this case.

// 1 2 3 4 5 5 6 6 6 6 6 6 6 6 6 7 8 8 --> target = 6
//                       m

// Method 1: 用classical bs找到target，然后用for loop往前找到第一个，假设数组长度为n，target一共repeat了x次
// O(logn) + O(x)

// Method 2: 全部用binary search来做

// 6 6
// l r
public class FirstAndLastOccurrence {
    public int firstOccur(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;

        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                right = mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (array[left] == target) {
            return left;
        }
        if (array[right] == target) {
            return right;
        }
        return -1;
    }

    public int lastOccur(int[] array, int target) {
        return -1;
    }
}
