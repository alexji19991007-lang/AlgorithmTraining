// Given a integer array of unknown size, where the numbers in the dictionary are sorted in ascending order, 
// determine if a given target integer is in the dictionary. Return the index of target in A, return -1 if 
// target is not in A.

// Assumptions
// UnknownSizeArray array is not null
// UnknownSizeArray.get(i) will return null(Java) if index i is out of bounds

// Examples
// A = {1, 2, 5, 9, ......}, T = 5, return 2
// A = {1, 2, 5, 9, 12, ......}, T = 122, return ?
//      l
// r = 1 --> 2 --> 4 --> 8 --> 16 --> 32 --> 64 --> 128*
// r = 1 --> 10 --> 100 --> 1000 --> 10000 --> 100000

// Step 1: 确定右边界
//      r从1开始，每次*2，直到r对应的数字大于target为止or对应的数字是null了
// Step 2: Classical bs.

// 追加问题：右边界的搜寻过程中，每次*2比较好还是*10比较好？

// 定性分析：
// To jump out (i.e. 确认右边界): 10 times is better
// +
// To jump in (i.e. classical bs): 2 times is better since the over-shot is shorter for 2 times

// 定量分析：         2 times      -      10 times
// To jump out      log_2(n)            log_10(n)
// To jump in       log_2(2n)           log_2(10n)
// 2 times - 10 times = log_2(n) + log_2(2n) - (log_10(n) + log_2(10n)) = a

import java.util.ArrayList;
import java.util.List;

public class SearchInUnknownSizeSortedArray {
    public int search(UnknownSizeArray array, int target) {
        // 等于说array.length == 0
        if (array.get(0) == null) {
           return -1;
        }
        // 如果index 0正好是答案了，直接return 0.
        if (array.get(0) != null && array.get(0) == target) {
           return 0;
        }
        // Step 1: 确认右边界
        int end = 1;
        while (array.get(end) != null && array.get(end) < target) {
           end *= 2;
        }

        // Step 2: 进行classical binary search
        int left = 0, right = end;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array.get(mid) == null || array.get(mid) > target) {
                right = mid - 1;
            } else if (array.get(mid) < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    static class UnknownSizeArray {
        private List<Integer> _myList;
        
        public UnknownSizeArray(int size) {
            _myList = new ArrayList<>(size);
        }

        public Integer get(int index) {
            if (index >= _myList.size() || index < 0) {
                return null;
            }

            return _myList.get(index);
        }
    }
}