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
        public List<Integer> inorderTraversal(TreeNode root) {

            List<Integer> l = new ArrayList<>();
            if (root == null)
                return l;

            Stack<TreeNode> st = new Stack<>();

            if (root != null)
                st.push(root);

            while (st.size() > 0)
            {
                TreeNode temp = st.peek();
                if (temp.left != null) {
                    st.push(temp.left);
                    temp.left=null;//do dry run to understand
                } else { 
                    l.add(temp.val);
                    st.pop();
                    if (temp.right != null) {
                        st.push(temp.right);
                    }
                }
            }
            return l;
        }
    }
