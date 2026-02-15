package Class4BinaryTreeAndBinarySearchTree;
import java.util.*;

public class PreOrderTraversal {
    public List<Integer> preOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preHelper(root, res);
        return res;
    }

    public void preHelper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.key);
        preHelper(root.left, res);
        preHelper(root.right, res);
    }
}