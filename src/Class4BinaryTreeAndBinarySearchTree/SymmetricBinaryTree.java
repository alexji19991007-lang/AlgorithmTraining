package Class4BinaryTreeAndBinarySearchTree;

// Check if a given binary tree is symmetric.
// Symmetric
//                   10
//                /     \
//               5       5
//             /   \    /  \
//            2     7  7    2

// Symmetric
//                  10
//                /     \
//               5       5
//             /   \   /   \
//            2    x   x    2

// Asymmetric
//                   10
//                /     \
//               5       5
//             /   \    /  \
//            2     7  2    7


public class SymmetricBinaryTree {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) {
            return true;
        }
        
        // r1和r2不一样了
        if (r1 == null || r2 == null || r1.key != r2.key) {
            return false;
        }

        return isMirror(r1.left, r2.right) && isMirror(r1.right, r2.left);
    }
}
