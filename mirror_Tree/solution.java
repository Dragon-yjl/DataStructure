package mirror_Tree;

public class solution {

    //1.如果二叉树是空树  是镜像对称的
    //2.如果不是空树  只有它的左右子树互为镜像 才是镜像对称的


    public boolean isMirrorTree (TreeNode p,TreeNode q) {
        if(p == null && q == null) {
         return true;
        }

        if(p == null || q==null) {
            return false;
        }

        return p.v == q.v
                && isMirrorTree(p.left,q.right)
                && isMirrorTree(p.right,q.left);
        //p的左子树跟q的右子树互为镜像
        //p的右子树与q的左子树互为镜像
    }

    public boolean isSymmetric(TreeNode root) {

        if(root == null) {
            return true;
        }

        return isMirrorTree(root.left,root.right);
    }
}
