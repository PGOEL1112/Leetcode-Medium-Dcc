import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

public class RightSideView {
    class Solution {
    public int level(TreeNode root){
        if(root==null) return 0;
        return 1+Math.max(level(root.left),level(root.right));
    }
    public void preorder(TreeNode root , int level,List<Integer> ans){
        if(root==null) return;
        ans.set(level,root.val);
        preorder(root.left,level+1,ans);
        preorder(root.right,level+1,ans);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        int n = level(root);
        for(int i = 0; i<n ;i++){
            ans.add(i);
        }
        preorder(root,0,ans);
        return ans;
    }
}
}
