package binaryTree;


public class TreeNode {

    int v;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        v = x;
    }


    public String toString() {
        return String.format("%c",v);
    }
}
