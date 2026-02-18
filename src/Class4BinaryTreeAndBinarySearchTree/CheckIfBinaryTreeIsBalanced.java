package Class4BinaryTreeAndBinarySearchTree;

public class CheckIfBinaryTreeIsBalanced {
    public boolean isBalanced(TreeNode root) {
        return false;
    }

    public int findHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(findHeight(root.left), findHeight(root.right)) + 1;
    }
}
