package Class5BFS1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

//                  10
//                /     \
//               5       6
//             /   \    /  \
//            2     7  3    9
// result: [[10], [5, 6], [2, 7, 3, 9]]
public class GetKeysLayerByLayer {
    public List<List<Integer>> layerByLayer(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<TreeNode> q = new ArrayDeque<>();
        // discover root
        q.offer(root);
        while (!q.isEmpty()) {
            List<Integer> curLevel = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                TreeNode cur = q.poll();
                curLevel.add(cur.key);
                // expand/explore the node
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            result.add(curLevel);
        }
        return result;
    }
}