package build_Tree07_22;

import build_Tree07_22.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


class TreeNode {
    char val;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(char val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return String.format("TreeNode{%c}",val);
    }
}

public class TestDemo {


    /**
     * 构建二叉树
     * @param in 传入的是带空节点的前序遍历序列
     * @param out 是一个空的list
     * @return 构建的新的一颗二叉树的根
     */
    public static TreeNode buildTree (List<Character> in, List<Character> out) {

        if(in.isEmpty()) {
            //in里面没有序列 只能是空树
            //out 仍然是空的
            return null;
        }

        //in 不是Empty了
        //吧in里面的第一个元素取出来当根节点
        char rootVal = in.remove(0);
        if(rootVal == '#') {
            //剩下的就是in去除第一个元素‘#’
            //in 由于调用了remove 已经吧第一个元素下表为0 的取出来了
            out.addAll(in);

            //遇到#一定是空树
            return null;
        }

        //代码执行到这
        //rootVal一定不是# 构建不同的节点和以该节点为根的树
        TreeNode root = new TreeNode(rootVal);

        //构建root的左子树
        //这里的in因为刚才调用in.remove了 所以
        // 已经不包括第一个元素了
        //所以新建一个list 里面都是除了第一个元素之外的元素
        List<Character> rightOut  = new ArrayList<>();
        TreeNode left = buildTree(in,rightOut);//left就是构建好的左子树

        //right 从空的 变成了构建左子树剩余的部分

        //构建root得右子树
        //这里的剩下的rightOut就是构建右子树用的序列
        //构建右子树剩下的序列就是构建这整棵树剩下的序列
        TreeNode right = buildTree(rightOut,out);//right就是构建好的右子树

        //把左右子树连接到根节点上
        root.left = left;
        root.right = right;

        return root;
    }

    /**
     * 字符串转化为顺序表
     * @param s  输入一个字符串
     * @return   输出转换后的顺序表
     */
    public static List stringToList(String s) {
        List<Character> list = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            list.add(ch);
        }

        return list;
    }


    public static void inOrder(TreeNode root) {
        if(root != null) {

            inOrder(root.left);

            System.out.printf("%c",root.val);

            inOrder(root.right);
        }

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        List<Character> in = stringToList(s);

        ArrayList<Character> out = new ArrayList<>();

        TreeNode root = buildTree(in,out);

        inOrder(root);
    }
}
