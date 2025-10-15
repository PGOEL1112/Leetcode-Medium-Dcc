import java.util.*;
public class ValidateBst {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
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
    public static void main(String[] args) {
        ValidateBst obj = new ValidateBst();
        TreeNode root = obj.new TreeNode(0, null, null);
        boolean ans  = obj.isValidBST(root);
        System.out.println("IS THE GIVEN BINARY TREE A VALID BST :" +ans);
    }
}

