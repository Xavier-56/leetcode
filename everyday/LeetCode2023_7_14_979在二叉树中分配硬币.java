package everyday;

import publicClass.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class LeetCode2023_7_14_979在二叉树中分配硬币 {
    int move = 0;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return move;
    }
    public int dfs(TreeNode root) {
        int moveleft = 0;
        int moveright = 0;
        if (root == null) {
            return 0;
        }
        if (root.left != null) {
            moveleft = dfs(root.left);
        }
        if (root.right != null) {
            moveright = dfs(root.right);
        }
        move += Math.abs(moveleft) + Math.abs(moveright);
        return moveleft + moveright + root.val - 1;
    }
}
