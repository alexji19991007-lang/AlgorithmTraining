package Class15BinaryTreeAndBinarySearchTree2;

import java.util.*;

// Given the levelorder and inorder traversal sequence of a binary tree, 
// reconstruct the original tree.

// Assumptions
// The given sequences are not null and they have the same length
// There are no duplicate keys in the binary tree

// Examples
// levelorder traversal = {5, 3, 8, 1, 4, 11}
// inorder traversal = {1, 3, 4, 5, 8, 11}
// the corresponding binary tree is
//         5
//       /    \
//     3        8
//   /   \        \
// 1      4        11

public class ReconstructBinaryTreeWithLevelOrderAndInOrder {
    // 本身 or 单例？
    // 有static-->本身
    // 无static-->单例/instance
    private int state;

    public static void main(String[] args) {
        int[] x = new int[1];
        int[] y = new int[1];
        ReconstructBinaryTreeWithLevelOrderAndInOrder instance = new ReconstructBinaryTreeWithLevelOrderAndInOrder();
        instance.reconstruct(x, y);
    }

    public TreeNode reconstruct(int[] inOrder, int[] levelOrder) {
        // Build a map: value -> index in inorder
        // This helps us quickly determine whether a node belongs to left or right subtree
        Map<Integer, Integer> valueToInOrderIndex = new HashMap<>();
        for (int i = 0; i < inOrder.length; ++i) {
            valueToInOrderIndex.put(inOrder[i], i);
        }
        // Convert levelOrder array to a list (easier to manipulate)
        Queue<Integer> levelList = new ArrayDeque<>();
        for (int num : levelOrder) {
            levelList.add(num);
        }
        // Start recursion
        return helper(valueToInOrderIndex, levelList);
    }

    // 只要没有touch到这个class的state，那这个method就应该被标为static
    public static TreeNode helper(Map<Integer, Integer> valueToInOrderIndex, Queue<Integer> levelList) {
        // Base case: no nodes left
        if (levelList.isEmpty()) {
            return null;
        }

        // The FIRST element in level order is always the root
        int curValue = levelList.poll();
        TreeNode currentRoot = new TreeNode(curValue);
        Queue<Integer> leftSubtreeInOrder = new ArrayDeque<>();
        Queue<Integer> rightSubtreeInOrder = new ArrayDeque<>();
        // Partition remaining nodes into left/right using inorder positions
        for (int num : levelList) {
            int inOrderIndex = valueToInOrderIndex.get(num);
            // If index < current root index → belongs to left subtree
            if (inOrderIndex < valueToInOrderIndex.get(curValue)) {
                leftSubtreeInOrder.offer(num);
            } else {
                rightSubtreeInOrder.offer(num);
            }
        }
        // Recursively build left and right subtrees
        currentRoot.left = helper(valueToInOrderIndex, leftSubtreeInOrder);
        currentRoot.right = helper(valueToInOrderIndex, rightSubtreeInOrder);
        return currentRoot;
    }
}
