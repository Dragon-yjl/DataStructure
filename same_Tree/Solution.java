package same_Tree;

import sun.reflect.generics.tree.Tree;

public class Solution {
    public boolean isSameTree(TreeNode p,TreeNode q) {
        if(p == null && q == null) {
            return true;
        }

        if(p == null || q == null) {
            return false;
        }


        return p.v == q.v
                && isSameTree(p.left,q.left)
                &&isSameTree(p.right,q.right);
    }
}
