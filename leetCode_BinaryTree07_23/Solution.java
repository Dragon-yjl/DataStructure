package leetCode_BinaryTree07_23;

import sun.reflect.generics.tree.Tree;

public class Solution {

    private boolean search(TreeNode root,TreeNode t) {
        if(root == null) {
            return false;
        }

        if(root == t) {
            return true;
        }

        if(search(root.left,t)) {
            return true;
        }

        return search(root.right,t);

    }

    /**
     *  对于有根树的p q 求他俩最近的公共祖先
     * @param root  输入树的根
     * @param p   输入p节点
     * @param q   输入q节点
     * @return  返回公共的祖先节点
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == p || root == q) {
            //其中一个节点就是该书的根
            //另一个节点必然在子树中
            //最近的公共祖先只能是根
            return root;
        }

        boolean pInLeft = search(root.left,p);
        boolean qInLeft = search(root.left,q);

        if(pInLeft && qInLeft) {
            return lowestCommonAncestor(root.left,p,q);
        }

        if(!pInLeft && !qInLeft) {
            return lowestCommonAncestor(root.right,p,q);
        }

        return root;

    }

}
