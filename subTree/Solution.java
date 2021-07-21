package subTree;

/**
 * 判断一个树里面是否包含另一个树的子树
 */

public class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }

        if(p == null || q == null) {
            return false;
        }

        return p.v == q.v
                && isSameTree(p.left,q.left)
                && isSameTree(p.right,q.right);
    }

    public boolean search(TreeNode root, TreeNode t) {
        if(root == null) {
            return false;
        }

        //在root为根的树中，查找t这个节点，只要求节点的值相同
        //没找到意味着以root为根的树中一定没有以t为根的子树
        //找到了 检查找到这个节点为根的树是否和 t为根的树相等
        //如果不相等，接着找

        //先找根节点
        if(root.v == t.v) {
            if(isSameTree(root,t)) {
                return true;
            }
        }

        //根节点照完了找根的左子树
        if(search(root.left,t)) {
            return true;
        }

        //左子树照完了找右子树
        return search(root.right,t);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        return search(root,subRoot);
    }
}
