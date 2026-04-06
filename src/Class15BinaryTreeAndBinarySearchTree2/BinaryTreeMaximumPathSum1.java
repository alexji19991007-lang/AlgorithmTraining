package Class15BinaryTreeAndBinarySearchTree2;

// Given a binary tree in which each node contains an integer number. 
// Find the maximum possible sum from one leaf node to another leaf node. 
// If there is no such path available, return Integer.MIN_VALUE.

// Example
//          -15
//         /    \
//        2      11
//             /    \
//            6     14
// The maximum path sum is 6 + 11 + 14 = 31.

// Lowest Common Ancestor (LCA)

public class BinaryTreeMaximumPathSum1 {
    // private int globalMax; // it becomes a field owned by the class

    public int maxPathSum(TreeNode root) {
        int[] globalMax = new int[1];
        globalMax[0] = Integer.MIN_VALUE;
        maxPathGain(root, globalMax);
        return globalMax[0];
    }

    // 注意我们这里return的并不是最终答案，而是一条直上直下的path的gain.
    // 更准确一点说，是当前node左边直上直下path的gain & 当前node右边直上直下path的gain，然后取两者最大。
    // 最终答案是globalMax[0]来记录
    private int maxPathGain(TreeNode node, int[] globalMax) {
        if (node == null) {
            return 0;
        }
        //左右两边全都是null
        if (node.left == null && node.right == null) {
            return node.key;
        }
        // 当前node左边直上直下path的gain
        int leftGain = maxPathGain(node.left, globalMax);
        // 当前node右边直上直下path的gain
        int rightGain = maxPathGain(node.right, globalMax);
        if (node.left != null && node.right != null) {
            // Case 1: we create a new path and take the current node as the climax node
            int newPathSum = leftGain + rightGain + node.key;
            globalMax[0] = Math.max(globalMax[0], newPathSum);
            // Case 2: we don't create a new path
            return node.key + Math.max(leftGain, rightGain);
        }
        // 左右两边有一个是null
        // ternary operator
        return node.left == null ? rightGain + node.key : leftGain + node.key;
    }
}
