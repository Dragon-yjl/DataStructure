package nowCoder_NC62;


/**
 * 平衡二叉树
 */
public class Solution {

    boolean flag;//定义一个标记
    public boolean IsBalanced_Solution(TreeNode root) {

        if(root == null) {//如果root为null，返回true
            return true;
        }
        flag = true;//吧flag的值设置为true
        getDepth(root);//把root传进去，求高度
        return flag;

    }


    public int getDepth(TreeNode root) {
        if(root == null) {//如果root为null，高度是0
            return 0;
        }

        int left = getDepth(root.left);//求左子树的高度
        int right = getDepth(root.right);//递归求右子树的高度
        if(Math.abs(left - right) > 1) {//如果left-right的绝地值大于1
            flag = false;//让flag为false
            return -1;//说明不是平衡二叉树
        }

        return Math.max(left,right) + 1;//该树的高度，为left和right的最大值+1
    }
}
