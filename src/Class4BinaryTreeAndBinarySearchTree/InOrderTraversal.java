package Class4BinaryTreeAndBinarySearchTree;

import java.util.*;

public class InOrderTraversal {
    public List<Integer> inOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inHelper(root, res);
        return res;
    }

    public void inHelper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inHelper(root.left, res);
        res.add(root.key);
        inHelper(root.right, res);
    }
}
