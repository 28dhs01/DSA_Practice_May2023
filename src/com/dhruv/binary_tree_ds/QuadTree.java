package com.dhruv.binary_tree_ds;

public class QuadTree {

// Definition for a QuadTree node.
public static void main(String[] args) {
    int[][]grid = new int[][]
//            {{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},
//                    {1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0}};
            {
                    {0,0,0,1},
                    {0,0,1,0},
                    {1,1,1,1},
                    {1,1,1,1}
            } ;
    construct(grid) ;
}
static class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};



        public static Node construct(int[][] grid) {
            int rSize = grid.length ;
            int cSize = grid[0].length ;
            Node rootNode = new Node() ;
            int sr = 0 ;
            int sc = 0 ;
            buildTree(rootNode,sr,sc,grid, grid.length);
            return rootNode ;
        }
        static Node buildTree(Node root, int rs, int cs, int[][] grid,int gridSize){
            if( gridSize == 1 ){
                Node node = new Node();
                if( grid[rs][cs] == 1 ){
                    node.val = true ;
                }else{
                    node.val = false ;
                }
                node.isLeaf = true ;
                return node ;
            }
            Node topLeft = buildTree(root,rs,cs,grid,gridSize/2) ;
            Node topRight = buildTree(root,rs,cs+gridSize/2,grid,gridSize/2);
            Node bottomLeft = buildTree(root,rs+gridSize/2,cs,grid,gridSize/2) ;
            Node bottomRight = buildTree(root,rs+gridSize/2,cs+gridSize/2,grid,gridSize/2) ;
            if( topLeft.val == topRight.val && bottomLeft.val == bottomRight.val && topLeft.val == bottomLeft.val &&
                topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf ){
                boolean val = false ;
                if( grid[rs][cs] == 1){
                    val = true ;
                }
                return new Node(val,true) ;
            }
            return new Node(true,false,topLeft,topRight,bottomLeft,bottomRight);
        }

}
