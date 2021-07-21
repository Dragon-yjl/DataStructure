package binaryTree07_21;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class TestDemo {

    //二叉树前序遍历返回所有节点的顺序表
    public List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if(root != null) {
            //根不为空，先把根的值放入list
            list.add(root.v);

            //遍历左子树的时候把左子树的节点放到list中
            List<Integer> leftTreeList = preOrderTraversal(root.left);
            list.addAll(leftTreeList);

            //遍历右子树的时候把所有节点放到list中
            List<Integer> rightTreeList = preOrderTraversal(root.right);
            list.addAll(rightTreeList);
        }
        return list;
    }


    //二叉树中序遍历返回所有节点的顺序表
    public List<Integer> inOrderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        if(root != null) {

            List<Integer> leftTreeList = inOrderTraversal(root.left);
            list.addAll(leftTreeList);

            list.add(root.v);

            List<Integer> rightTreeList = inOrderTraversal(root.right);
            list.addAll(rightTreeList);
        }

        return list;

    }

    //二叉树后序遍历返回所有节点的顺序表
    public List<Integer> postOrderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        if(root != null) {


            List<Integer> leftTreeList = postOrderTraversal(root.left);
            list.addAll(leftTreeList);

            List<Integer> rightTreeList = postOrderTraversal(root.right);
            list.addAll(rightTreeList);

            list.add(root.v);


        }
        return list;
    }

    public static void main(String[] args) {

        TreeNode root = BuildTree.buildTree1();

        TestDemo test = new TestDemo();
        System.out.println(test.preOrderTraversal(root));

        System.out.println(test.inOrderTraversal(root));

        System.out.println(test.postOrderTraversal(root));
    }
}
