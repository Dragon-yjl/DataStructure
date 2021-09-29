package nowCoder_NC15;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;

public class TreeTest {

    public static void main(String[] args) {

        Solution solution = new Solution();

        TreeNode root = new TreeNode(1);
        root.left.val = 2;
        root.right = null;
        ArrayList<ArrayList<Integer>> arrayLists = solution.levelOrder(root);

        System.out.println(arrayLists);
    }
}
