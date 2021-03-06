package binaryTree7_20;

public class BuildTree {

    public static TreeNode buildTree1() {


            //先构造节点
            TreeNode a = new TreeNode('A');
            TreeNode b = new TreeNode('B');
            TreeNode c = new TreeNode('C');
            TreeNode d = new TreeNode('D');
            TreeNode e = new TreeNode('E');
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
            i.right = null;

            j.left = null;
            j.right = null;

            return a;
    }
}
