package Class4BinaryTreeAndBinarySearchTree;

// 大问题：以当前node为root，这个tree是否balanced
// 小一号问题：当前node的left subtree是否balanced && right subtree是否balanced。
public class CheckIfBinaryTreeIsBalanced {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return Math.abs(findHeight(root.left) - findHeight(root.right)) <= 1 
            && 
            isBalanced(root.left) && isBalanced(root.right);
    }

    public int findHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(findHeight(root.left), findHeight(root.right)) + 1;
    }

    // Time complexity: O(nlogn) if balanced. O(n^2) in worst case like a linked list.
    // Space Time: O(n) where n is the total number of nodes in the tree, when every node has only 1 child node, like a linked list.
}
