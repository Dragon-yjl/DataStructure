package treeAndLinked07_23;

public class Solution {

    private TreeNode head;//头结点
    private TreeNode last;//尾结点

    //尾插法
    //创建新节点
    private void add(TreeNode node) {
        TreeNode newNode = new TreeNode(node.v);

        if(last == null) {
            head = newNode;
        }else {
            last.right = newNode;
        }

        newNode.left = last;
        last = newNode;

    }

    //不创建新节点
    private void add1(TreeNode node) {

        if(last == null) {
            head = node;
        }else {
            last.right = node;
        }

        node.left = last;
        last = node;

    }

    //二叉搜索树的中序遍历一定会是有序的 左子树是比根节点小的值，右子树是比根节点大的值
    private void inOrder(TreeNode node) {
        if(node != null) {

            inOrder(node.left);

            //表示把而二叉搜索树有序打印一遍
            //System.out.println(node);
            
            //表示把二叉搜索树有序插入链表
            add1(node);
            //add 方法保证了每个节点都会被调用一次
            //而且调用的次序一定是有序的

            inOrder(node.right);
        }

    }

    public TreeNode Convert(TreeNode pRootOfTree) {

        //每次初始化
        head = last = null;
        //中序遍历的时候就吧节点都插入到链表中了
        inOrder(pRootOfTree);

        return head;
    }
}
