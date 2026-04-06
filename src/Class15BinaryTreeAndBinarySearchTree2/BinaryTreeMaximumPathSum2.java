package Class15BinaryTreeAndBinarySearchTree2;

// Given a binary tree in which each node contains an integer number. 
// Find the maximum possible sum from any node to any node (the start 
// node and the end node can be the same). 

// Assumptions
// ​The root of the given binary tree is not null

// Examples
//           -1
//         /    \
//        2      11
//             /    \
//            6     -14
// one example of paths could be -14 -> 11 -> -1 -> 2
// another example could be the node 11 itself
// The maximum path sum in the above binary tree is 6 + 11 + (-1) + 2 = 18

public class BinaryTreeMaximumPathSum2 {
    public int maxPathSum(TreeNode root) {
        int[] globalMax = new int[1];
        globalMax[0] = Integer.MIN_VALUE;
        maxPathGain(root, globalMax);
        return globalMax[0];
    }

    private int maxPathGain(TreeNode node, int[] globalMax) {
        if (node == null) {
            return 0;
        }
        // 回想一下subarray sum这道题。
        // 如果左边/右边直上直下的path的gain小于0的话，我们就不考虑那条path的gain了
        // 因为当前node is better by itself
        int leftGain = Math.max(0, maxPathGain(node.left, globalMax));
        int rightGain = Math.max(0, maxPathGain(node.right, globalMax));
        // Case 1: make a new path with the current node as the climax node
        int newPathSum = leftGain + rightGain + node.key;
        globalMax[0] = Math.max(newPathSum, globalMax[0]);
        // Case 2: do not make a new path
        return node.key + Math.max(leftGain, rightGain);
    }
}
