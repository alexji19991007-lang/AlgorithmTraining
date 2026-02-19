package Class4BinaryTreeAndBinarySearchTree;

// 大问题: 以当前node为root，这个tree的高度是多少
// 小一号问题: 1. 以当前node的left child为root，这个left subtree的高度为多少。
//            2. 以当前node的right child为root，这个right subtree的高度为多少。
// base case: 如果当前的left right child都是null，return 1
public class HeightOfBinaryTree {
    public int findHeight(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(findHeight(root.left), findHeight(root.right)) + 1;
    }

    // Time: O(n) where n is the total number of nodes in the tree
    // Space: O(n) --> 拉成了一条线
}