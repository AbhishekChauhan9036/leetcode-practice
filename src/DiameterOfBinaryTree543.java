/**
 * Given a binary tree, you need to compute the length of the diameter of the
 * tree. The diameter of a binary tree is the length of the longest pathbetween
 * any two nodes in a tree. This path may or may not pass through the root.
 *
 * Example:
 * Given a binary tree
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 *
 * Note: The length of path between two nodes is represented by the number of
 * edges between them.
 *
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class DiameterOfBinaryTree543 {
    public int diameterOfBinaryTree(TreeNode root) {
        return helper(root)[0];
    }

    private int[] helper(TreeNode root) {
        if (root == null) return new int[]{0, 0};

        int[] l = helper(root.left);
        int[] r = helper(root.right);

        return new int[]{Math.max(Math.max(l[0], r[0]), l[1] + r[1]), Math.max(l[1], r[1]) + 1};
    }

}
