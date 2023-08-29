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
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length != inorder.length)
        {
            return null;
        }
        if(preorder.length==0 || inorder.length==0)
        {
            return null;
        }
        return helper(preorder, inorder, inorder.length-1, 0, preorder.length-1, 0);
    }

    public TreeNode helper(int[] preorder, int[] inorder, int inhigh, int inlow, int prehigh, int prelow)
    {
        if(prelow>prehigh)
        {
            return null;
        }
        TreeNode root=new TreeNode(preorder[prelow]);
        int index=inlow;
        while(inorder[index]!=preorder[prelow])
        {
            index++;
        }
        int leftsize=index-inlow;
        root.left=helper(preorder, inorder, index-1, inlow, leftsize+prelow, prelow+1);
        root.right=helper(preorder, inorder, inhigh, index+1, prehigh, leftsize+prelow+1 );

        return root;
    }
}
