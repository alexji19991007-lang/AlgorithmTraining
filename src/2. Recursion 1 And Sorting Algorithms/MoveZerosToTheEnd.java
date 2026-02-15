// Given an array of integers, move all the 0s to the right end of the array.
// The relative order of the elements in the original array does not need to be maintained.

// Assumptions:
// The given array is not null.

// Examples:
// {1} --> {1}
// {1, 0, 3, 0, 1} --> {1, 3, 1, 0, 0} or {1, 1, 3, 0, 0} or {3, 1, 1, 0, 0}

public class MoveZerosToTheEnd {
    public static int[] moveZero(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        int i = 0, j = array.length - 1;
        while (i <= j) {
            if (array[i] != 0) {
                i++;
            } else if (array[j] == 0) {
                j--;
            } else {
                swap(array, i++, j--);
            }
        }
        return array;
    }

    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}