package Class15BinaryTreeAndBinarySearchTree2;

// Given a binary tree in which each node contains an integer number. 
// Find the maximum possible path sum from a leaf to root.

// Assumptions
// The root of given binary tree is not null.

// Examples
//         10
//      /      \
//     -2      7
//    /   \
//   8    -4

// The maximum path sum is 10 + 7 = 17.
public class BinaryTreeMaximumPathSum4 {
    public int maxPathSumLeafToRoot(TreeNode root) {
        int[] globalMax = new int[1];
        // We can update the maxSum only when we reach the leaf node
        globalMax[0] = Integer.MIN_VALUE;
        maxPathGain(root, globalMax, 0);
        return globalMax[0];
    }

    // Case 1: left right both null, i.e. we have reached the leaf node
    //      Update maxSum with Math.max(0, curSum)
    // Case 2: left right at least one not null, i.e. this is not the leaf node
    //      recursion on left
    //      recursion on right
    //      No need to return information to the previous levels
    private void maxPathGain(TreeNode node, int[] globalMax, int curSum) {
        if (node.left == null && node.right == null) {
            globalMax[0] = Math.max(globalMax[0], curSum + node.key);
        }
        if (node.left != null) {
            maxPathGain(node.left, globalMax, curSum + node.key);
        }
        if (node.right != null) {
            maxPathGain(node.right, globalMax, curSum + node.key);
        }
    }
}
