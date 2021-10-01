package nowCoder_NC14;

//之字形层序遍历二叉树

import java.util.ArrayList;


public class Solution {

    /**
     * 之字形层序遍历二叉树
     * @param pRoot  传入二叉树头结点
     * @return  返回一个list 输入 {8,6,10,5,7,9,11}  输出[[8],[10,6],[5,7,9,11]]
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();//定义一个结果集
        if(pRoot == null) //判断根节点是否为空
            return res;

        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();///定义一个队列用来存放二叉树节点
        queue.add(pRoot);//把二叉树头结点放进队列里面
        int count = 1;//定义一个计数器，二叉树的层序遍历，奇数行打印，偶数行逆序打印，就是要得到的结果
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<Integer>();//定义一个list，存放每一层的节点的值
            int size = queue.size();//queue里面节点个数
            for(int i = 0;i < size;i++) {//循环遍历队列，也就是一层节点
                TreeNode node = queue.get(0);//node里面存放根节点
                queue.remove(0);//然后再把根节点删除
                if(count % 2 == 1) {//如果%2==1说明是奇数层
                    list.add(node.val);//正序加入list
                }else {
                    list.add(0,node.val);//偶数层 逆序加入list
                }

                if(node.left != null) queue.add(node.left);///如果node的左子树不为null，队列里面吧左子树加进去
                if(node.right != null) queue.add(node.right);///如果node的右子树不为null，队列里面就把右子树加进去
            }
            res.add(list);//吧一层list加入结果集
            count++;///下一层
        }


        return res;
    }

}
