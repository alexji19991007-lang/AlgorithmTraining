// Given a target integer T and an integer array A sorted in ascending order, find the index i in 
// A such that A[i] is closest to T.

// Assumptions
// There can be duplicate elements in the array, and we can return any of the indices with same value.

// Examples
// A = {1, 2, 3}, T = 2, return 1
// A = {1, 4, 6}, T = 3, return 1
// A = {1, 4, 6}, T = 5, return 1 or 2
// A = {1, 3, 3, 4}, T = 2, return 0 or 1 or 2

// Corner Cases
// What if A is null or A is of zero length? We should return -1 in this case.

// 0 1 2 3 4  5  6
// 1 3 5 7 10 11 14 --> target = 8
//       l r
//         m
//     

// when to end the loop: left pointer和right pointer贴在一起的时候，就要结束了 --> while (left < right - 1)
// 5 8 --> target = 6
// l r
public class ClosestInSortedArray {
    public int closest(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int left = 0;
        int right = array.length - 1;
        // 举一个edge case的例子来解释为什么这样的loop condition
        while (left < right - 1) { // 当left还没有和right贴在一起的时候，就可以继续进行loop
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }

        // return Math.abs(array[left] - target) >= Math.abs(array[right] - target) ? right : left;
        // ternary operater:
        // return 如果xxx成立 --> return a --> 反之 return b
        if (Math.abs(array[left] - target) >= Math.abs(array[right] - target)) {
            return right;
        }
    
        return left;
    }
}
