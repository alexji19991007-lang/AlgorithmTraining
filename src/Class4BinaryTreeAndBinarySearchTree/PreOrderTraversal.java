package Class4BinaryTreeAndBinarySearchTree;
import java.util.*;

// 大问题：traverse the entire tree in pre-order (i.e. self-first, then left, finally right)
// 小问题：If I know the asnwer of the pre-order traversal of my:
//            left subtree --> [l_1, l_2, l_3, ..., l_n]
//            right subtree --> [r_1, r_2, r_3, ..., r_m]
//        Suppose myself if s_1, then the final solution must be:
//        [s_1, l_1, l_2, l_3, ..., l_n, r_1, r_2, r_3, ..., r_m]
public class PreOrderTraversal {
    public List<Integer> preOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preHelper(root, res);
        return res;
    }

    public void preHelper(TreeNode root, List<Integer> res) {
        // Trick: base case usually refers to the null ChildNode below the leaf node.
        if (root == null) {
            return;
        }
        res.add(root.key); // get s_1
        preHelper(root.left, res); // get [l_1, l_2, l_3, ..., l_n]
        preHelper(root.right, res); // get [r_1, r_2, r_3, ..., r_m]
    }
}