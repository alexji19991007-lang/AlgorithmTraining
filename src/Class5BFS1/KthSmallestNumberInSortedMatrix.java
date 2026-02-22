package Class5BFS1;

import java.util.PriorityQueue;

// Given a matrix of size N x M. For each row the elements are sorted in ascending order, and for each column the elements are also sorted in ascending order. Find the Kth smallest number in it.

// Assumptions

// the matrix is not null, N > 0 and M > 0
// K > 0 and K <= N * M
// Examples

// { {1, 3, 5,  7},

//   {2, 4, 8,  9},

//   {3, 5, 11, 15},

//   {6, 8, 13, 18} }

// the 5th smallest number is 4
// the 8th smallest number is 6

public class KthSmallestNumberInSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        boolean[][] visited = new boolean[numRows][numCols];
        PriorityQueue<Cell> minHeap = new PriorityQueue<>(k, (c1, c2) -> {
            // 注意这里c1.value & c2.value都是int，是primitive type，所以用==
            if (c1.value == c2.value) {
                return 0;
            }
            return c1.value < c2.value ? -1 : 1;
        });
        minHeap.offer(new Cell(0, 0, matrix[0][0]));
        for (int i = 0; i < k - 1; ++i) {
            Cell cur = minHeap.poll();
            if (cur.row + 1 < numRows && !visited[cur.row + 1][cur.col]) {
                minHeap.offer(new Cell(cur.row + 1, cur.col, matrix[cur.row + 1][cur.col]));
                visited[cur.row + 1][cur.col] = true;
            }
            if (cur.col + 1 < numCols && !visited[cur.row][cur.col + 1]) {
                minHeap.offer(new Cell(cur.row, cur.col + 1, matrix[cur.row][cur.col + 1]));
                visited[cur.row][cur.col + 1] = true;
            }
        }
        return minHeap.peek().value;
    }

    private class Cell {
        int row;
        int col;
        int value;

        public Cell(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }

}
