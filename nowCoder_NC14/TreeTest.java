package nowCoder_NC14;

import java.util.ArrayList;

public class TreeTest {

    public static void main(String[] args) {

        Solution s = new Solution();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = null;
        root.left.right= null;
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        ArrayList<ArrayList<Integer>> list = s.Print(root);
        System.out.println(list);
    }
}
