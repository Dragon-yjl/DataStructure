package binaryTree7_21;


import sun.font.TextRecord;
import sun.reflect.generics.tree.Tree;

import javax.smartcardio.TerminalFactory;

public class TreeMethod {

    //1.在树中找到val 返回第一次遇到的val所在的节点
    //2.如果没有找到，返回null
    public static TreeNode contains2(TreeNode root,int val) {

        if(root == null) {
            return null;
        }

        if(root.v == val) {
            return root;
        }

        TreeNode leftContains = contains2(root.left,val);
        //如何根据leftContains判断是否找到了
        //leftContains == null意味着没找到
        //leftContains ！= null 意味着找到了
        if(leftContains != null) {
            //在root为根的左子树中找到了
            return leftContains;
        }
        //左子树中没有找到
        return contains2(root.right,val);

    }

    //以root为根的二叉树中 找node节点
    //找到返回true
    public static boolean contains3(TreeNode root,TreeNode node) {
        if(root == null) {
            return false;
        }
        if(root == node) {
            return true;
        }

        boolean leftNode = contains3(root.left,node);

        if(leftNode) {
            return true;
        }

        return contains3(root.right,node);
    }

    public static void main(String[] args) {

//        TreeNode root = BuildTree.buildTree1();
//
//        TreeNode a = contains2(root,'A');
//        System.out.println(a);//TreeNode{A}
//        System.out.printf("%c%n",a.v);//A
//
//

        TreeNode root = BuildTree.buildTree1();
        System.out.println(contains3(root,root));//true

        TreeNode a = new TreeNode('A');
        System.out.println(contains3(root,a));//false
    }
}
