package Class5BFS1;

import java.util.*;

// Find the K smallest numbers in an unsorted integer array A. The returned numbers should be in ascending order.

// Assumptions
// A is not null
// K is >= 0 and smaller than or equal to size of A
// Return an array with size K containing the K smallest numbers in ascending order

// Examples
// A = {3, 4, 1, 2, 5, 8, 9, 10, 12}, K = 3, the 3 smallest numbers are {1, 2, 3}

// Method 1: Sort the array and get the first k elements. --> O(nlog(n) + k)
//
// TC using min heap: 1. Heapify all elements O(n);
//                    2. Call poll() k times to get k smallest elements O(k * log(n))
//                    O(n + k * log(n))
// TC using max heap: 1. Call insert k times O(k * log(k));
//                    2. Iterate over the remaining n - k elements one by one O((n-k) * 2 * log(k))
//                    O(k * log(k) + (n - k) * 2 * log(k)) = O((n-k) * log(k))
public class KSmallestInUnsortedArray {
    public static void main(String[] args) {
       int[] arr = {2, 3, 1, 4, 5, 8, 6, 7};
       System.out.println(Arrays.toString(kSmallest(arr, 3)));
    }

    public static int[] kSmallest(int[] array, int k) {
        if (array.length == 0 || k == 0) {
            return new int[0];
        }
        Queue<Integer> maxHeap = new PriorityQueue<>(k, (a, b) -> {
            if (a.equals(b)) {
                return 0;
            }
            return a > b ? -1 : 1;
        });
        for (int i = 0; i < array.length; ++i) {
            if (i < k) {
                maxHeap.offer(array[i]);
            } else if (array[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.offer(array[i]);
            }
        }
        int[] res = new int[k];
        for (int i = k - 1; i >= 0; --i) {
            res[i] = maxHeap.poll();
        }
        return res;
    }

    // 用minHeap写一遍
}
