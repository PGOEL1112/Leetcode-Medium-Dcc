import java.util.HashMap;
import java.util.Map;

import javax.swing.tree.TreeNode;

public class DiamterOfBinaryTree {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

        TreeNode(int val, TreeNode left , TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static int levels(TreeNode root, Map<TreeNode,Integer> dp){
        if(root==null) return 0;
        if(dp.containsKey(root)) return dp.get(root);
        int leftLevels = levels(root.left, dp);
        int rightLevels = levels(root.right, dp);
        dp.put(root, 1 + Math.max(leftLevels, rightLevels));
        return dp.get(root);
    }

    public static int diameter(TreeNode root, Map<TreeNode,Integer> dp){
        if(root==null) return 0;
        int myDia = levels(root.left,dp) + levels(root.right,dp);
        int leftDia = diameter( root.left, dp);
        int rightDia = diameter(root.right, dp);
        return Math.max(myDia, Math.max(leftDia, rightDia));
    }

    public static int diamterOfBinaryTree(TreeNode root){
        Map<TreeNode,Integer> dp = new HashMap<>();
        return diameter(root,dp);
    }

    public static void main(String[] args) {
        // Initialize Tree with value 1,2,3,4,5
        TreeNode root = new TreeNode(1); 
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        int  result = diamterOfBinaryTree(root);
        System.out.println("THE RESULT IS : " + result);
    }
}
