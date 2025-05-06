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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> ll=new ArrayList<>();
        ll=store(root, ll);
        Collections.sort(ll);
        return ll.get(k-1);
    }
    public List<Integer> store(TreeNode root, List<Integer> ll)
    {
        if(root==null){
            return ll;
        }
        ll.add(root.val);
        store(root.left,ll);
        store(root.right,ll);
        return ll;
    }
}