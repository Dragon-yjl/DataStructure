package nowcoder_BuildTree;


import java.util.ArrayList;
import java.util.List;

class TreeNode {
    char val;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(char val) {
        this.val = val;
    }
}

public class solution {



    /**
     * 构建二叉树
     * @param in 传入的是带空节点的前序遍历序列
     * @param out 是一个空的list
     * @return 构建的新的一颗二叉树的根
     */
    public static TreeNode buildTree (List<Character> in,List<Character> out) {

        if(in.isEmpty()) {
            //in里面没有序列 只能是空树
            //out 仍然是空的
            return null;
        }

        //in 不是Empty了
        //吧in里面的第一个元素取出来当根节点
        char rootVal = in.remove(0);
        if(rootVal == '#') {
            //剩下的就是in去除第一个元素‘#’
            //in 由于调用了remove 已经吧第一个元素下表为0 的取出来了
            out.addAll(in);

            //遇到#一定是空树
            return null;
        }

        //代码执行到这
        //rootVal一定不是# 构建不同的节点和以该节点为根的树
        TreeNode root = new TreeNode(rootVal);

        //构建root的左子树
        //这里的in因为刚才调用in.remove了 所以
        // 已经不包括第一个元素了
        List<Character> rightOut  = new ArrayList<>();
        TreeNode left = buildTree(in,rightOut);

        //构建root得右子树
        //这里的剩下的rightOut就是构建右子树用的序列
        //构建右子树剩下的序列就是构建这整棵树剩下的序列
        TreeNode right = buildTree(rightOut,out);

        root.left = left;
        root.right = right;

        return root;
    }

}
