package binaryTree7_20;

import sun.reflect.generics.tree.Tree;

import javax.swing.plaf.synth.SynthTextAreaUI;

public class TreeMethod7_20 {

    private static int n;
    //因为这个n同时要在几个方法中使用，所以定义静态全局变量
    //z整个类中都有效


    //返回root为根的树中，有多少个节点
    public static int sumTreeNodeSize(TreeNode root) {
        //int n = 0;//这里的n是局部变量，别的方法不能调用
        n = 0;//每次数之前，都要吧n归零

        preOrder(root);

        return n;
    }

    //前序遍历
    public static void preOrder(TreeNode root) {
        //前序会遍历两种节点
        //1.一个树的节点（root!= null） 2.没有节点（root == null）
        //我们只需要关注第一种情况，树的节点

        if(root != null) {
            //处理根节点 不需要打印
            n++;
            preOrder(root.left);
            preOrder(root.right);
        }

    }

    //根的个数+左子树的节点个数+右子树的节点个数
    public static int sumTreeNodeSize1(TreeNode root) {
        //传进来的root有两种可能情况：
        //1. root != null root指向了某个节点
        //2. root == null root 没有指向任何节点
        //我们下面的代码中 已经假设了根节点的个数一定是1了

        if(root == null) {//根节点为空
            //空树，一个节点没有
            return 0;

        }else {

            int rootNode = 1;//根的节点个数
            int leftTreeNode = sumTreeNodeSize1(root.left);//左子树的节点个数
            int rightTreeNode = sumTreeNodeSize1(root.right);//右子树的节点个数
            return rootNode + leftTreeNode + rightTreeNode;
        }
    }

    //返回叶子节点的个数
    private static int leftNode;
    public static int sumTreeLeafNodeSize (TreeNode root) {

        leftNode = 0;
        //注意每次计算叶子结点个数之前都要归零

        //使用前序遍历方式，经过每一个节点
        preOrder2(root);

        return leftNode;

    }

    private static void preOrder2 (TreeNode root) {

        if(root != null) {
            //先处理根节点
            //这个位置才是每个节点都要经过的
            //所以在这个位置 对root节点进行检查 单纯的吧root看成节点

            if(root.left == null && root.right == null) {
              leftNode++;
            }
            preOrder2(root.left);
            preOrder2(root.right);
        }

    }


    public static int sumTreeLeafNodeSize1(TreeNode root) {
        if(root == null) {
            //对一颗空树，求叶子结点个数
            //所以，结果为0
            return 0;
        }else if(root.left == null && root.right == null) {
            //root进一步代表的是一棵树
            //以root为根的一棵树
            //root这棵树的根没有左孩子，并且没有右孩子
            //所以这棵树只有一个节点

            //对于只有一个节点的树，求叶子节点个数
            //所以结果是1
            return 1;

        }else {
            //至少有一个以上的节点
            //整棵树的叶子节点数 = 左子树的叶子结点 + 右子树的叶子结点、
            int leftTreeNode = sumTreeLeafNodeSize1(root.left);
            int rightTreeNode = sumTreeLeafNodeSize1(root.right);

            return leftTreeNode + rightTreeNode;
        }
    }

    public static void main(String[] args) {

        TreeNode root = BuildTree.buildTree1();

//        int sum = sumTreeNodeSize(root);
//        System.out.println("树的节点个数 ："+sum);
//
//        int sum1 = sumTreeNodeSize1(root);
//        System.out.println("第二中方法树的节点个数" + sum1);


        //叶子结点个数
        int sum = sumTreeLeafNodeSize(root);
        System.out.println("叶子节点个数"+sum);

        int sum1 = sumTreeLeafNodeSize1(root);
        System.out.println("叶子节点个数"+sum1);

    }

}
