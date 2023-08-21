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
    public int diameterOfBinaryTree(TreeNode root) {//need to find the max of three diameters 
        // one of left to root to right 
        //one in the left subtree only
        //one in the right subtree only

        if (root == null) {//base case
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 0;
        }


        int leftdiameter=diameterOfBinaryTree(root.left);
        int rightdiameter=diameterOfBinaryTree(root.right);

        int mid=height(root.left)+ height(root.right);//not +2 because what if root only has one on left and no more nodes then the answer would be 2 and not 1 hence would be wrong 
        if(root.left!=null)
        {
            mid++;
        }
        if(root.right!=null)
        {
            mid++;
        }

        int max=Math.max(leftdiameter,Math.max(rightdiameter,mid));

        return max;

    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 0;
        }

        return 1 + Math.max(height(root.left), height(root.right));
    }
}
