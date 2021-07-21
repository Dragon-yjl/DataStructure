package balanced_Binary_Tree;

/**
 * 平衡二叉树
 */
public class Solution {

    public int getHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int leftTree = getHeight(root.left);
        int rightTree = getHeight(root.right);

        return Math.max(leftTree,rightTree)+1;

    }

    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }

        //先求左子树的高度，再求右子树的高度
        //如果相差大于1 说明不是平衡二叉树

        int leftTree = getHeight(root.left);
        int rightTree = getHeight(root.right);

        int diff = leftTree - rightTree;

        if(!(diff == -1 || diff == 0 || diff == 1)) {
            return false;
        }

        //代码走到这里表示左右子树相差绝对值<=1
        //那么这里一定可以返回true吗

        //return true;

        return isBalanced(root.left) && isBalanced(root.right);
    }


}
