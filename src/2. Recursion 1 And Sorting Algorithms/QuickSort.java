// 假设有一群小朋友，Amy Bob Cindy David Ella 他们以字母顺序身高从低到高。
// 有一天他们打乱了顺序 Bob David Cindy Ella Amy，需要让他们重新按身高排。
// 我选择David作为pivot，所有比David高的人排他后面去，比他矮的人排他前面去
// David as piviot --> Bob Cindy Ella David Amy --> 我们发现David已经回到了他正确的位置！！！！

// Initial state: [1, 9, 8, 5, 3]
// Say pivot = 5
// principle: iterate over the whole array, and put all numbers smaller than 5 to the left, 
//            then put 5 following (all numbers larger than 5 are already on 5’s right hand).

// 1. 把pivot 5和最后一个数字3交换 --> [1, 9, 8, 3, 5]
// 2. 两个挡板 i j ,三个区域 a) b) c) 的思想：
//      [0 ... i): i的左侧（不包含i）全都是比pivot小的数字
//      [i ... j): i和j中间为为探索的区域
//      (j ... n-1]: j的右侧（不包含j) 全都是比pivot大的数字
// 
// State 1
// 1    9    8    3    5
// i              j         current number a[i] = 1 < 5, no need to change, just i++
//
// State 2
// 1    9    8    3    5
//      i         j         current number a[i] = 9 > 5, swap a[i] with a[j], then j--, i STAYS THE SAME (WHY?)
// 
// State 3
// 1    3    8    9    5
//      i    j              current number a[i] = 3 < 5, no need to change, just i++
// 
// State 4
// 1    3    8    9    5
//          i j             current number a[i] = 8 > 5, swap a[i] with a[j], then j--, i STAYS THE SAME
// 
// State 5
// 1    3    8    9    5
//      j    i              j < i, stop and swap the last element with a[i]
// 
// State 6
// 1    3    5    9    8
//      j    i              now 5 is in its correct position
// 
// The steps above are called PARTITION
// 
// Recursion:
//      Select a random number as pivot and partition, get the final index of the pivot
//      Quick sort all numbers to the left of the pivot 
//      Quick sort all numbers to the right of the pivot

public class QuickSort {
    public int[] quickSort(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        quickSortHelper(array, 0, array.length - 1);
        return array;
    }

    public static void quickSortHelper(int[] arr, int begin, int end) {
        
    }

    public static int partition(int[] array, int begin, int end) {
        return -1;
    }

    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}

// What is the worst case scenario for quick sort?
// What is the best case scenario for quick sort?
// 课后作业：Quick sort的time & space complexity
