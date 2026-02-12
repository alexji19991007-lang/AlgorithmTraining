// Given an array of integers, sort the elements in the array in ascending order. The selection sort algorithm should be used to solve this problem.

// Examples
// {1} is sorted to {1}
// {1, 2, 3} is sorted to {1, 2, 3}
// {3, 2, 1} is sorted to {1, 2, 3}
// {4, 2, -3, 6, 1} is sorted to {-3, 1, 2, 4, 6}

// Corner Cases
// What if the given array is null? In this case, we do not need to do anything.
// What if the given array is of length zero? In this case, we do not need to do anything.

public class SelectionSort {
    public int[] selectionSort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            // i = 1;
            swap(array, i, minIndex);
        }
        return array;
    }

    // int, double, bool, long, float --> primitive types
    // int[], Integer, Double, List<>, Deque<>
    public static void swap(int[] array, int a, int b) {
        int temp = array[a]; // save a
        array[a] = array[b];
        array[b] = temp;
    }


    // Time: O(n^2)
    // iteration i = 0: inner (0..n-1) = n
    // iteration i = 1: inner n-1 (1..n-1) = n - 1
    // iteration i = 2: inner n-2 (2..n-1) = n - 2
    // iteration i = 3: inner n-3 (3..n-1) = n - 3
    // .....
    // 1+2+3+4+..+n = n(n+1)/2 -> n^2 → O(n^2)
    // Space: O(1)
}
