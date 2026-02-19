package Class4BinaryTreeAndBinarySearchTree;

// Determine if a given binary tree is binary search tree. There should no be duplicate keys in binary search tree.

// Assumptions:
// You can assume the keys stored in the binary search tree can not be Integer.MIN_VALUE or Integer.MAX_VALUE.

// Corner Cases:
// What if the binary tree is null? Return true in this case.

// 大问题: 以当前node为root，是否左边的所有数字都比他小，以及右边的所有数字都大于他
// 小一号问题: 左边的subtree是否为BST && 右边的subtree是否为BST
// 如果小一号问题满足的话，我只需要check当前node是否大于left child && 小于right child

public class IsBSTOrNot {
    public boolean isBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isBSTUntil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isBSTUntil(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.key <= min || root.key >= max) {
            return false;
        }
        return isBSTUntil(root.left, min, root.key) && isBSTUntil(root, root.key, max);
    }
}
