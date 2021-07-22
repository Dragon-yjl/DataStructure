package leetCode_BinaryTree;

public class TreeNode {

    int v;//为了方便查看
    TreeNode left;
    TreeNode right;

    public TreeNode(int v) {
        this.v = v;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "v=" + v +
                '}';
    }
}
