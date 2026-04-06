package Class15BinaryTreeAndBinarySearchTree2;

// Given the postorder traversal sequence of a binary search tree, reconstruct the original tree.

// Assumptions
// The given sequence is not null
// There are no duplicate keys in the binary search tree

// Examples
// postorder traversal = {1, 4, 3, 11, 8, 5}
// the corresponding binary search tree is
//         5
//       /    \
//     3        8
//   /   \        \
//  1      4       11


public class ReconstructBinarySearchTreeWithPostOrder {
    // 1. 从右往左看，我们每次先construct right subtree then left subtree
    // 2. 对于每一个subtree来说，他都有一个minimum value，如果我们碰到的node小于这个min value了，
    //    说明我们要从construct right转换到construct left了。
    public TreeNode reconstruct(int[] post) {
        // index[0] means which node we are currently looking at.
        int[] index = new int[1];
        index[0] = post.length - 1;
        return helper(post, index, Integer.MIN_VALUE);
    }

    private TreeNode helper(int[] postOrder, int[] index, int min) {
        // 1. All elements used
        // 2. Current value violates BST constraint (i.e. current value < min)
        if (index[0] < 0 || postOrder[index[0]] <= min) {
            return null;
        }
        // The current element is the root of the subtree
        TreeNode currentRoot = new TreeNode(postOrder[index[0]]);
        index[0]--;
        // IMPORTANT:
        // Since we are traversing postorder from right to left:
        // Order becomes: root -> right subtree -> left subtree

        // First construct the RIGHT subtree
        // All values in the right subtree must be > root.key
        currentRoot.right = helper(postOrder, index, currentRoot.key);
        
        // Then construct the LEFT subtree
        // Values must be between (min, root.key)
        currentRoot.left = helper(postOrder, index, min);
        return currentRoot;
    }
}
