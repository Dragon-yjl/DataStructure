package leetCode_BinaryTree;

public class Solution {

    /**
     *  把一棵树用字符串穿起来
     * @param sb 输入一个字符串
     * @param node 输入一棵树的根节点
     */
    private void preOrder(StringBuilder sb,TreeNode node){
        if(node != null) {
            sb.append(node.v);

            if(node.left == null && node.right == null) {
                return;
            }else if(node.left != null && node.right == null) {
                sb.append("(");
                preOrder(sb,node.left);
                sb.append(")");
            }else {

                sb.append("(");
                preOrder(sb, node.left);
                sb.append(")");

                sb.append("(");
                preOrder(sb, node.right);
                sb.append(")");
            }
        }
    }

    /**
     * 把一棵树用字符串方式打印
     * @param t 输入树的根节点
     * @return 返回一个字符串
     */
    public String tree2str(TreeNode t) {

        if(t == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        preOrder(sb,t);
        return sb.toString();
    }

    public static void main(String[] args) {

        TreeNode n1 = new TreeNode(1);
//        TreeNode n2 = new TreeNode(2);
//        TreeNode n3 = new TreeNode(3);
//        TreeNode n4 = new TreeNode(4);
//
//        n1.left = n2;
//        n1.right = n3;
//        n2.right  = n4;

        Solution solution = new Solution();
        System.out.println(solution.tree2str(n1));
        System.out.println(solution.tree2str(null));
    }
}
