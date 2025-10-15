import java.util.*;

public class BinaryLevelOrder {
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

    public static void main(String[] args) {
        BinaryLevelOrder obj = new BinaryLevelOrder();
        TreeNode root = obj.new TreeNode(0, null, null);
        List<List<Integer>> ans = obj.levelOrder(root);
        System.out.println("The level order traversal of binary tree is :"+ans);
    }
}


