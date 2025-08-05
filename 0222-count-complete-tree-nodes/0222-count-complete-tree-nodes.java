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
    ArrayList<Integer> ls = new ArrayList<>();
    public int countNodes(TreeNode root) {
        ArrayList<Integer> ll = new ArrayList<>();
        ll=inorder(root);
        return ll.size();
    }
    public ArrayList<Integer> inorder(TreeNode root) {
        if(root!=null)
        {
            inorder(root.left);
            ls.add(root.val);
            inorder(root.right);
        }
        return ls;
    }
}