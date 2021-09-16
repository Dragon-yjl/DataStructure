package binaryTree_0916;


import java.time.temporal.Temporal;
import java.util.LinkedList;


public class LevelOrder
{
    public static class TreeNode{
        int val;
        TreeNode left=null;
        TreeNode right=null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void levelIterator(TreeNode root) {
        if(root == null)
        {
            return ;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode current = null;
        queue.offer(root);//将根节点入队
        while(!queue.isEmpty())
        {
            current = queue.poll();//出队队头元素并访问
            System.out.print(current.val +"-->");
            if(current.left != null)//如果当前节点的左节点不为空入队
            {
                queue.offer(current.left);
            }
            if(current.right != null)//如果当前节点的右节点不为空，把右节点入队
            {
                queue.offer(current.right);
            }
        }

    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(9);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(7);

        levelIterator(root);

    }

}
