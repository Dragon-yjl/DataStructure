package binaryTree;

import com.sun.xml.internal.ws.resources.WsservletMessages;
import sun.reflect.generics.tree.Tree;

public class TreeMethod {

    //求二叉树第K层的节点个数
    public static int sumKLevelNode(TreeNode root,int k ) {
        //1.root代表空树
        if(root == null) {
            return 0;
        } else if(k == 1){////2.root不是空树  但是k==1
            return 1;

        }else {
            //其他情况
            int leftTreeK_1 = sumKLevelNode(root.left,k-1);
            int rightTreeK_1 = sumKLevelNode(root.right,k-1);

            return leftTreeK_1 +rightTreeK_1;
        }


    }

    //求二叉树的高度
    public static int getHeight(TreeNode root) {
        if(root == null) {//1.空树
            return 0;
        }else if(root.left == null && root.right == null) {//2.只有一个根节点
            return 1;
        }else {//3.其他情况  可以合并第二步 return max（0,0）+1
          int leftTreeHeight = getHeight(root.left);
          int rightTreeHeight = getHeight(root.right);

          ///return (leftTreeHeight > rightTreeHeight ? leftTreeHeight : rightTreeHeight) +1;
          return Math.max(leftTreeHeight , rightTreeHeight) + 1;
        }
    }

    //给一棵树，一个val 在该树中找这个val，找到返回true
    public static boolean contains1 (TreeNode root,int val) {

        if(root == null) {
            //空树
            return false;
        }else {
            if(root.v == val) {
                //根里找到了，就没必要去左右子树找了
                return true;
            }else {
                //根里没找到
                boolean leftTreeContains = contains1(root.left,val);
                if(leftTreeContains) {
                    //代表在左子树找到了，就不用去右子树找了
                    return true;
                } else {
                    //左子树也没有找到
                    boolean rightTreeContains = contains1(root.right,val);
                    if(rightTreeContains) {
                        //右子树找到了
                        return true;
                    }else {
                        //右子树没找到哦
                        return false;
                    }
                }
            }
        }
    }


    //上面代码改进
    public static boolean contains2(TreeNode root,int val) {
        if(root == null) {
            return false;
        }
        //什么都不写等同于else
        if(root.v == val) {
            return true;
        }

        boolean left = contains2(root.left,val);
        if(left) {
            return true;
        }

        return contains2(root.right,val);
    }

    public static void main(String[] args) {

        TreeNode root = BuildTree .buildTree1();

        System.out.println("第1层，节点个数:" + sumKLevelNode(root,1));
        System.out.println("第2层，节点个数:" + sumKLevelNode(root,2));
        System.out.println("第3层，节点个数:" + sumKLevelNode(root,3));
        System.out.println("第4层，节点个数:" + sumKLevelNode(root,4));
        System.out.println("第5层，节点个数:" + sumKLevelNode(root,5));
        System.out.println("第6层，节点个数:" + sumKLevelNode(root,6));

        System.out.println(getHeight(root));

        System.out.println(contains1(root,'C'));

        System.out.println(contains1(root,'P'));

        System.out.println(contains2(root,'A'));

        System.out.println(contains2(root,'P'));
        System.out.println(contains2(null,'F'));

        System.out.println(contains2(new TreeNode('A'),'A'));

    }
}
