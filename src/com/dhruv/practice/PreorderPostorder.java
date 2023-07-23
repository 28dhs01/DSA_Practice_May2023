package com.dhruv.practice;

import java.util.HashMap;
import java.util.Map;

public class PreorderPostorder {
    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3} ;
        buildTree(inorder,postorder) ;
    }
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

        public static TreeNode buildTree(int[] inorder, int[] postorder) {
            Map<Integer , Integer> map = new HashMap<>() ;
            for( int i = 0 ; i<inorder.length ; i++ ){
                map.put(inorder[i],i) ;
            }
            return helper(inorder,postorder,0,inorder.length-1, 0, postorder.length-1,map) ;
        }
        static TreeNode helper(int[]inorder,int[]postorder,int inS, int inE, int ptS, int ptE ,Map<Integer , Integer> map){
            if( inS>inE ){
                return null ;
            }
            int val = postorder[ptE] ;
            int idx = map.get(val) ;
            TreeNode root = new TreeNode(val) ;
            root.left = helper(inorder,postorder, inS,idx-1 ,ptS, ptS+idx-inS-1 , map);
            root.right = helper(inorder,postorder, idx+1,inE, ptS+idx-inS, ptE-1, map);
            return root ;

        }

}
