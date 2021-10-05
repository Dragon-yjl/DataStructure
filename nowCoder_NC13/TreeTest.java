package nowCoder_NC13;

import sun.reflect.generics.tree.Tree;

public class TreeTest {

    public static void main(String[] args) {

        Solution s = new Solution();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        int i = s.maxDepth(root);
        System.out.println(i);
    }
}
