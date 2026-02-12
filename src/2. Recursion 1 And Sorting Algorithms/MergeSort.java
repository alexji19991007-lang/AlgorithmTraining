// Given an array of integers, sort the elements in the array in ascending order. 
// The merge sort algorithm should be used to solve this problem.

// Examples
// {1} is sorted to {1}
// {1, 2, 3} is sorted to {1, 2, 3}
// {3, 2, 1} is sorted to {1, 2, 3}
// {4, 2, -3, 6, 1} is sorted to {-3, 1, 2, 4, 6}

// Corner Cases
// What if the given array is null? In this case, we do not need to do anything.
// What if the given array is of length zero? In this case, we do not need to do anything.

// a[n] = 5,2,7,4,1,3,8,6
//                                  5,2,7,4,1,3,8,6                 time = O(1)
//                         5,2,7,4                  1,3,8,6         time = O(2)
//                     5,2         7,4           1,3       8,6      time = O(4)
//                  5      2     7     4       1     3    8   6     
// ===================================SEPARATION============================================
// Time complexity above the separation = 1 + 2 + 4 + … + n/2 = O(n)
// How many levels above the separation = log n
// ===================================SEPARATION============================================
//                     2,5         4,7           1,3       6,8      time = O(n)
//                         2,4,5,7                  1,3,6,8         time = O(n)
//                                  1,2,3,4,5,6,7,8                 time = O(n)
// How many levels below the separation = log n
// Time complexity below the separation = n + n + … + n = O(nlog(n))

// TOTAL Time = O(n) + O(nlog(n)) = O(log(n))
// TOTAL EXTRA space = n/2 + n/4 + n/8 + … + 2 + 1 = O(n) --> 看代码
public class MergeSort {
    public int[] mergeSort(int[] array) {
        // Write your solution here
        if (array == null || array.length <= 1) {
            return array;
        }
        mergeSortHelper(array, 0, array.length - 1);
        return array;
    }

    public static void mergeSortHelper(int[] array, int left, int right) {
        
    }

    // 如何merge two SORTED arrays? 谁⼩移谁
    // We need a temporary space (i.e, int[] result = new int[8];) to buffer the result
    // 1st half[4] = 5,2,7,4 → 2 4 5 7
    //                         i→
    // 2nd half[4] = 1,3,8,6 → 1 3 6 8
    //                         j→
    // --> result = [1,2,3,4,5,6,7,8]
    public static void merge(int[] array, int oneStart, int oneEnd, int twoStart, int twoEnd) {
        
    }

    // 课后作业: Given a string “A1B2C3D4”, how to convert it to another string “ABCD1234”
    // 自己写一个test case来测试。
}
