package binaryTree7_22;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的层序遍历
 */

public class TreeLevelOrder {
    public static void levelOrderTraversal(TreeNode root) {
        //队列的元素类型是树的节点

        if(root == null) {
            return;
            //对于一颗空树，层序遍历，没什么东西
        }

        Queue<TreeNode> queue = new LinkedList<>();

        //1.先把根节点放到队列里面
        queue.add(root);

        //有可能出现吧null放进队列的情况
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            //这个node节点就是我们层序遍历时要经过的节点
            //通过打印观察结果
            //还要考虑node= null 的情况
            System.out.print(node.v);

            //把该node节点的左右孩子放入队列
            if(node.left != null) {
                queue.add(node.left);
            }

            if(node.right != null) {
                queue.add(node.right);
            }


        }


    }


    //完全二叉树 可以吧null的节点放入队列中
    public static boolean isCompleteTree(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (true) {
            //代码根本不用考虑queue empty 的情况，肯定是先遇到null退出循环
            TreeNode node = queue.remove();
            if(node == null) {
                //在遇到node== null之前，不可能出现queue.isEmpty()的情况
                break;
            }

            //不需要打印
            //直接把左右孩子插入队列中 （不管是不是null）

            queue.add(node.left);
            queue.add(node.right);

        }

        //检查队列中，是不是全是null
        //检查的方式 就是挨个取出来看一下
        //All(null)

        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if(node == null) {
                //一个节点为null 不能说明是完全二叉树
            }else {
                //一个节点不为null 就可以说明不是完全二叉树
                return false;
            }
        }


        return true;
    }

    public static void main(String[] args) {

        TreeNode root = BuildTree.buildTree1();

        levelOrderTraversal(root);
    }
}
