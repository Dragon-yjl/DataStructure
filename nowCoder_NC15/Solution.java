package nowCoder_NC15;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树层序遍历
 * 1、定义队列，先放入根节点
 * 2、队列不为空时，循环
 * 3、定义level_len表示当前队列的长度，就是当前层节点个数，用于控制for循环的次数
 * 4、定义level，用于接收当前层节点的数值
 * 5、for循环中，首先将队首位置节点设为根节点，然后将此节点的值加入level。判断左右孩子是否为空，不为空则加入队列。
 * 6、将level加入返回结果中。
 */

public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        if(root == null) {
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (! queue.isEmpty()) {
            ArrayList<Integer> res = new ArrayList<>();
            int n = queue.size();
            for(int i = 0;i < n;i++) {
                TreeNode node = queue.poll();
                if(node != null)
                    res.add(node.val);
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            list.add(res);
        }

        return list;
    }
}
