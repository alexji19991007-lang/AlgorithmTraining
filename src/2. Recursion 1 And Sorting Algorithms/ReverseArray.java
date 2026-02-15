// 给你一个array[1, 2, 3, 4, 5, 6]
// 请你把他反转过来【6, 5, 4, 3, 2, 1]
// 用recursion和non-recursion两种方式写。

public class ReverseArray {
    public static int[] reverseArray(int[] array, int i, int j) {
        if (array == null || array.length == 0)
            return array;

        if (i >= j)
            return array;
        
        swap(array, i, j);
        return reverseArray(array, i + 1, j - 1);
    }

    public static int[] reverseArray2(int[] array) {
        if (array == null || array.length == 0)
            return array;

        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            swap(array, i, j);
            i++;
            j--;
        }
        return array;
    }
    
    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
