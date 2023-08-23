/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p==root || q==root)
        {
            return root;
        }

        boolean left=search(root.left,p);
        boolean right=search(root.right,q);

        if(left && right)
        {
            return root;
        }

        if(left && !right)
        {
            return lowestCommonAncestor(root.left,p,q);
        }

        if(!left && right)
        {
            return lowestCommonAncestor(root.right,p,q);
        }

        return root;

    }

    public boolean search(TreeNode root, TreeNode i)
    {
        if(root==null)
        {
            return false;
        }

        if(i==root)
        {
            return true;
        }

        return search(root.left, i) || search(root.right,i);
    }
}
