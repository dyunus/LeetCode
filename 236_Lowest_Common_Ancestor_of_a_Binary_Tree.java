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
        Stack<TreeNode> stack = new Stack<TreeNode>(); //used to traverse the binary tree
        Map<TreeNode,TreeNode> parent = new HashMap<>(); //store parents of each node
        parent.put(root,null); 
        stack.push(root);
        
        while(!(parent.containsKey(p) &&  parent.containsKey(q))){ //keep going until both p and q's parents are known 
            TreeNode node = stack.pop();
            if(node.left != null){ //if node has a left child
                parent.put(node.left,node); //store that node is parent of its left child
                stack.push(node.left); //add left child to visit
            }
            if(node.right != null){
                parent.put(node.right,node); //store that node is a parent of its right child
                stack.push(node.right); //add right child to visit 
            }
        }
        
        Set<TreeNode> pAncestor = new HashSet<>(); //store P's ancestors
        while(p != null){ //store all of p's parents up until root 
            pAncestor.add(p); 
            p = parent.get(p);
        }
        
        while(!pAncestor.contains(q)){ //traverse q's parents starting from itself and return when the node is also an ancestor of p
            q = parent.get(q);
        }
        return q;
        //if p itself is the LCA of p&q, q will eventually become p and will be returned
        //if q itself is the LCA of p&q, loop will not be entered and q will be returned
    }
}
