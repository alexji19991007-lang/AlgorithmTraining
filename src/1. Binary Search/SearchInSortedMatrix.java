// 给定一个仅包含整数的二维矩阵，每行按升序排列。下一行的第一个元素大于（或等于）上一行的最后一个元素。

// 给定一个目标数字，返回该目标数字在矩阵中的位置。如果目标数字在矩阵中不存在，则返回 {-1, -1}。

// 比喻：

// 给定的矩阵不为空，且大小为N * M，其中N >= 0 且M >= 0。
// 例子：

// 矩阵 = { {1, 2, 3}, {4, 5, 7}, {8, 9, 10}}

// 目标 = 7，返回 {1, 2}

// target = 6，返回{-1，-1}表示目标数字在矩阵中不存在。

// n * m
// 1 2  3  4
// 5 6  7  8
// 9 10 11 12
// target = 7, return (1, 2)

// Method 1: 先找row再找column
// log(N) * log(M)

// Method 2: 把matrix拉成一条线，然后做classical binary search
//           5
// 1 2 3 4 5 6 7 8 9 10 11 12
// l                        r
// log(N * M) = log(N) + log(M)
// 难点在于：如何把matrix的坐标和拉直后的index对应起来
// left = 0
// right = n * m - 1
// mid = left + (right - left) / 2 要把这个转换成matrix里面的坐标
// rowNumber = mid / m
// colNumber = mid % m


public class SearchInSortedMatrix {
    public int[] search(int[][] matrix, int target) {
        int[] res = {-1, -1};
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int left = 0;
        int right = n * m - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int rowNumber = mid / m;
            int colNumber = mid % m; // mod
            if (matrix[rowNumber][colNumber] == target) {
                res[0] = rowNumber;
                res[1] = colNumber;
                return res;
            } else if (matrix[rowNumber][colNumber] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
}
