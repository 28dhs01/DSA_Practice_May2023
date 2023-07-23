package com.dhruv.binary_tree_ds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CustomTree {
    public static void main(String[] args) {
        TreeNode root = null;
        root = buildTree(root) ;
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        System.out.println(list);
    }
    static TreeNode buildTree(TreeNode root){
        Scanner sc = new Scanner(System.in) ;
        System.out.println("enter data for root");
        int rootVal = sc.nextInt() ;
        if( rootVal == -1 ){
            return null;
        }
        root = new TreeNode(rootVal) ;
        System.out.println("enter data for left of root ");
        root.left = buildTree(root.left) ;
        System.out.println("enter data for right of root ");
        root.right = buildTree(root.right) ;
        return root ;
    }
    static void inorder(TreeNode root, List<Integer> list){
        if( root == null ){
            return;
        }
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
}
class  TreeNode {
    int val ;
    TreeNode left ;
    TreeNode right ;
    TreeNode(int val){
        this.val = val ;
        this.left = null ;
        this.right = null ;
    }
}
