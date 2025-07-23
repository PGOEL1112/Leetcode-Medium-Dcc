import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

public class ValidateBst {
    class Solution {
    public void Inorder(TreeNode root , List<Integer> arr){
        if(root==null) return;
        Inorder(root.left,arr);
        arr.add(root.val);
        Inorder(root.right,arr);
    }
    public boolean isValidBST(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        Inorder(root,arr);
        for(int i=1;i<arr.size() ; i++){
            if(arr.get(i)<=arr.get(i-1)) return false;
        }
        return true;
        
    }
}
}
