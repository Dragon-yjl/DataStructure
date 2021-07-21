package same_Tree;

public class TreeNode {

    int v;
    TreeNode left;
    TreeNode right;

    public TreeNode(int v) {
        this.v = v;
    }

    public String toString() {
        return String.format("TreeNode{%c}",v);
    }
}
