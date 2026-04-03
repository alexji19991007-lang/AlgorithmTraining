package Classs14DynamicProgramming3;

// Given a matrix that contains only 1s and 0s, find the largest X shape which contains only 1s,
// with the same arm lengths and the four arms joining at the central point. Return the arm 
// length of the largest X shape.

// Assumptions
// The given matrix is not null, has size of N * M, N >= 0 and M >= 0.

// Examples
// { {0, 0, 0, 0},
//   {1, 1, 1, 1},
//   {0, 1, 1, 1},
//   {1, 0, 1, 1} }
// the largest X of 1s has arm length 2.

public class LargestXOf1s {
    public int largest(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[][] leftUp = leftUp(matrix, matrix.length, matrix[0].length);
        int[][] rightDown = rightDown(matrix, matrix.length, matrix[0].length);
        return merge(leftUp, rightDown, matrix.length, matrix[0].length);
    }

    public int merge(int[][] leftUp, int[][] rightDown, int R, int C) { 
        return -1;
    }

    public int[][] leftUp(int[][] matrix, int R, int C) { 
        return null;
    }

    public int[][] rightDown(int[][] matrix, int R, int C) { 
        return null;
    }

    public int getNumber(int[][] number, int x, int y, int R, int C) {
    if (x < 0 || x >= R || y < 0 || y >= C) {
      return 0;
    }
    return number[x][y];
  }
}
