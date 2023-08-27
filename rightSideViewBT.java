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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        if(root==null)
        {
            return ans;
        }
        int level=height(root)+1;
        for(int i=0;i<level;i++)
        {
            ans.add(-999);
        }
        preOrder(root,1,ans);

        return ans;
    }

    public int height(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        if(root.left==null && root.right==null)
        {
            return 0;
        }
        return 1+Math.max(height(root.left),height(root.right));
    }

     public void preOrder(TreeNode root,int level,List<Integer> ans)
     {
         if(root==null)
         {
             return;
         }
         ans.set(level-1,root.val);
         preOrder(root.left,level+1,ans);
         preOrder(root.right,level+1,ans);

     }
}














// class Solution {
//     public List<Integer> rightSideView(TreeNode root) {
//         List<Integer> ans=new ArrayList<>();
//         TreeNode temp=null;
//         if(root==null)
//         {
//             return ans;
//         }
//         if(root.left!=null)
//         {
//             temp=root.left;
//         }
//         rightboundary(root,ans,1,temp);
//         return ans;
//     }
//     public void rightboundary(TreeNode root,List<Integer> ans,int count, TreeNode temp) {
//         if (root == null) {
//             nthlevel(temp,count-1,ans);
//             return;
//         }
//         ans.add(root.val);
//         count++;
//         if (root.right != null) {
//             rightboundary(root.right,ans,count,temp);
//         } else if(root.left!=null) {
//             rightboundary(root.left,ans,count,temp);
//         }
//         else
//         {   
//             nthlevel(temp,count-1,ans);
//             return;
//         }
//     }

//     public void leftboundary(TreeNode root,List<Integer> ans) {
//         if (root == null) {
//             return;
//         }
//         if (root.right == null && root.left == null) {
//             ans.add(root.val);
//             return;
//         }
//         ans.add(root.val);
//         if (root.right != null) {
//             leftboundary(root.right,ans);
//         } else if(root.left!=null) {
//             leftboundary(root.left,ans);
//         }
//     }

//     public void nthlevel(TreeNode root, int n,List<Integer> ans) {
//         if (root == null) {
//             return;
//         }
//         if (n == 1) {
//             leftboundary(root, ans);
//         }
//         if(root.right!=null)
//         nthlevel(root.right, n - 1, ans);
//         else
//         nthlevel(root.left,n-1,ans);
//     }
// }
