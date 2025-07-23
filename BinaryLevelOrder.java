import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

public class BinaryLevelOrder {
    class Solution {
    public int levels(TreeNode root){
        if(root==null) return 0;
        return 1+Math.max(levels(root.left),levels(root.right));
    }
    public void nthlevels(TreeNode root ,int levels , int lvl , List<Integer> arr){
        if(root==null) return ;
        if(levels==lvl) arr.add(root.val);
        nthlevels(root.left,levels+1,lvl,arr);
        nthlevels(root.right,levels+1,lvl,arr);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        int lvl=levels(root);
        for(int i=0; i<lvl;i++){
            List<Integer> arr = new ArrayList<>();
            nthlevels(root,0,i,arr);
            ans.add(arr);
        }
        return ans;
    }
}
}
