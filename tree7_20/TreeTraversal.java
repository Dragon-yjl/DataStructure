package tree7_20;

import sun.reflect.generics.tree.Tree;

public class TreeTraversal {

    //对root为根的树的遍历
    //遍历的对象是树 不是节点
    //虽然我们的形参看起来是节点 但实际上是以该节点为根的树
    //为了节点，我们只进行节点的值得打印

    //前序遍历，先序遍历
    public static void preTraversal(TreeNode root) {

        //以下的前提，该树不是空树（根节点存在）

        if(root != null) {


            ///1.首先处理根节点
            System.out.printf("%c ",root.v);
            ///2.按照前序的方式，递归处理该节点的左子树
            preTraversal(root.left);
            ///3.按照前序的方式，递归处理该节点的右子树
            preTraversal(root.right);
        }else {
            //该树是孔数，什么都不处理
        }
    }


    //中序遍历
    public static void inTraversal(TreeNode root) {

        if(root != null) {
            //1.中序遍历左子树
            inTraversal(root.left);
            //2.处理根节点
            System.out.printf("%c ",root.v);
            //3.中序遍历右子树
            inTraversal(root.right);
        }
    }



    //后序遍历
    public static void postTraversal(TreeNode root) {

        if(root != null) {
            postTraversal(root.left);
            postTraversal(root.right);
            System.out.printf("%c ",root.v);
        }
    }

    public static void main(String[] args) {

        //先构造节点
        TreeNode a = new TreeNode('A');
        TreeNode b = new TreeNode('B');
        TreeNode c = new TreeNode('C');
        TreeNode d = new TreeNode('D');
        TreeNode e= new TreeNode('E');
        TreeNode f = new TreeNode('F');
        TreeNode g = new TreeNode('G');
        TreeNode h = new TreeNode('H');
        TreeNode i = new TreeNode('I');
        TreeNode j = new TreeNode('J');

        //把节点之间的关系，按照树的图连接起来
        a.left = b;
        a.right = c;

        b.left = d;
        b.right = null;

        c.left = e;
        c.right = f;

        d.left = null;
        d.right = g;

        e.left = null;
        e.right = null;

        f.left = h;
        f.right = i;

        g.left = j;
        g.right = null;

        h.left = null;
        h.right = null;

        i.left = null;
        i.right =null;

        j.left = null;
        j.right = null;

        System.out.println("前序遍历");
        preTraversal(a);
        System.out.println();

        System.out.println("中序遍历");
        inTraversal(a);
        System.out.println();

        System.out.println("后序遍历");
        postTraversal(a);
        System.out.println();

    }

}
