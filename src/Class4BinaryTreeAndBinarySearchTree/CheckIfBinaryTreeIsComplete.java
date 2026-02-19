package Class4BinaryTreeAndBinarySearchTree;

import java.util.*;

public class CheckIfBinaryTreeIsComplete {
    public boolean isCompleted(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 以下范式要熟练掌握
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (q.peek() != null) {
            TreeNode cur = q.poll();
            q.offer(cur.left);
            q.offer(cur.right);
        }

        // 检查剩下的queue里面是不是全都是null
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur != null) {
                return false;
            }
        }
        return true;
    }
}
