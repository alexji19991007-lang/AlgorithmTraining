package Class11BestFSAndDFS2;

import java.util.PriorityQueue;

// Given a matrix of size N x M. For each row the elements are sorted in ascending order, and for each column the elements are also sorted in ascending order.
// Find the Kth smallest number in it.

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

// We need to keep track of which cell has been visited --> HashSet or 2-d boolean array
// We also need to know what is the actual number in the cell and put them in a priority queue.
public class KthSmallestNumberInSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        boolean[][] visited = new boolean[numRows][numCols];
        PriorityQueue<Cell> minHeap = new PriorityQueue<>(k, (c1, c2) -> {
            if (c1.value == c2.value) {
                return 0;
            }
            return c1.value < c2.value ? -1 : 1;
        });
        minHeap.offer(new Cell(0, 0, matrix[0][0]));
        for (int i = 0; i < k - 1; i++) {
            Cell curCell = minHeap.poll();
            if (curCell.row + 1 < numRows && !visited[curCell.row + 1][curCell.col]) {
                minHeap.offer(new Cell(curCell.row + 1, curCell.col, matrix[curCell.row + 1][curCell.col]));
                visited[curCell.row + 1][curCell.col] = true;
            }
            if (curCell.col + 1 < numCols && !visited[curCell.row][curCell.col + 1]) {
                minHeap.offer(new Cell(curCell.row, curCell.col + 1, matrix[curCell.row][curCell.col + 1]));
                visited[curCell.row][curCell.col + 1] = true;
            }
        }
        // O(k * log(2k))
        return minHeap.peek().value;
    }

    // By doing this we can eliminate the need for another HashMap.
    private final class Cell {
        final int row;
        final int col;
        final int value;

        public Cell(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }
}
