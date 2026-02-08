// Given a target integer T, a non-negative integer K and an integer array A 
// sorted in ascending order, find the K closest numbers to T in A. 
// If there is a tie, the smaller elements are always preferred.

// Assumptions
// A is not null
// K is guranteed to be >= 0 and K is guranteed to be <= A.length

// Return
// A size K integer array containing the K closest numbers (not indices) in A, sorted in ascending order by the difference between the number and T. 

// Examples
// A = {1, 2, 3}, T = 2, K = 3, return {2, 1, 3} or {2, 3, 1}
// A = {1, 4, 6, 8}, T = 3, K = 3, return {4, 1, 6}

// 1 3 5 7 8 11 12 13 --> target = 9, k = 3 --> {7, 8, 10}, {8, 7, 10}
// 先找到closest element (之前做过的题目), then中心开花往两边找
// 找到了8，比较7和1 (i.e. 相邻的两个element)，虽然都相隔2，但是7是更小的element --> {8, 7}
// 
// 8 8 8 8 8 8 8 8 8 --> target = 9, k = 1 --> {8}

// 1 2 3 4 111 122 133 --> target 8, k = 5 --> {4, 3, 2, 1}
// l
// array[left] = array[-1] --> index out of bound exception

public class KClosetInSortedArray {
    public int[] kClosest(int[] array, int target, int k) {
        int[] res = new int[k]; // [0, 0, 0]
        if (array == null || array.length == 0 || k == 0) {
            return null;
        }
        int closest = closest(array, target); // closest是一个index --> 母题思维
        // 中心开花 <--- x --->
        res[0] = array[closest];
        int left = closest - 1;
        int right = closest + 1;
        int i = 1;
        int n = array.length;
        while (i < k && (left >= 0 || right < array.length)) {
            // 什么时候加右边的数字？
            // 1. 大前提是：右边还有数字 --> right < n
            // &&
            // 2. 在确保了1的情况下：
            //      2.1 如果左边没有数字了，我们只能加右边 --> left < 0
            //      ｜｜
            //      2.2 如果左边还有数字，并且右边的数字比左边的数字更接近target --> 比abs
            if (right < n && (left < 0 || Math.abs(array[left] - target) > Math.abs(array[right] - target))) {
                res[i] = array[right];
                i++;
                right++;
            } else {
                res[i] = array[left];
                i++;
                left--;
            }
        }
        return res;
    }

    // helper method
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
