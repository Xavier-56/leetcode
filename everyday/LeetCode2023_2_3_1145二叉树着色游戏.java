package everyday;

import publicClass.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
public class LeetCode2023_2_3_1145二叉树着色游戏 {
    int x, lSize, rSize, n2;

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        this.x = x;
        dfs(root);
        n2 = Math.max(Math.max(lSize, rSize), n - 1 - lSize - rSize);
        if (n2 > n - n2) return true;
        else return false;
    }

    public int dfs(TreeNode node) {
        if (node == null)
            return 0;
        int ls = dfs(node.left);
        int rs = dfs(node.right);
        if (node.val == x) {
            lSize = ls;
            rSize = rs;
        }
        return ls + rs + 1;
    }
}
