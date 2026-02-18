package Class4BinaryTreeAndBinarySearchTree;

import java.util.*;

public class PostOrderTraversal {
    public List<Integer> postOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postHelper(root, res);
        return res;
    }

    public void postHelper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        postHelper(root.left, res);
        postHelper(root.right, res);
        res.add(root.key);
    }
}
