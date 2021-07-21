package binaryTree7_22;

public class BuildTree {

    public static TreeNode buildTree1() {

        TreeNode a = new TreeNode('A');
        TreeNode b = new TreeNode('B');
        TreeNode c = new TreeNode('C');
        TreeNode d = new TreeNode('D');
        TreeNode e = new TreeNode('E');
        TreeNode f = new TreeNode('F');
        TreeNode g = new TreeNode('G');
        TreeNode h = new TreeNode('H');
        TreeNode i = new TreeNode('I');

        a.left = b;
        a.right = c;

        b.left = d;

        c.left = e;
        c.right = f;

        d.left = g;
        d.right = h;

        e.right = i;

        return a;
    }
}
