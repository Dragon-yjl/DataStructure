package binaryTree07_22;

import org.omg.CORBA.ARG_IN;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode 层序遍历二叉树  用List<List<Integer>>表示
 */

public class Solution {

    //用来打包层次和节点的
    static class NL{
        TreeNode node;
        int level;

        public NL(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

        if(root == null) {
            return list;
        }

        //吧打好包的节点和层数放入队列
        Queue<NL> queue = new LinkedList<>();
        queue.add(new NL(root,1));

        while (!queue.isEmpty()){
            //把NL队列里面的队首元素拿出来
            NL nl = queue.remove();

            TreeNode node = nl.node;
            int level = nl.level;


            //这里是控制放到那个内侧list 以及是否需要创建内侧list
            //当层数与外层list的size相等的时候 在外层list里面new一个ArrayList
            if(level == list.size()) {
                list.add(new ArrayList<>());
            }

            //把下一个节点放入新的内层list中
            List<Integer> innerList = list.get(level);
            innerList.add(node.v);

            //走到这里 继续层序遍历的流程
            if(node.left != null) {
                queue.add(new NL(node.left,level+1));
            }

            if(node.right != null) {

                queue.add(new NL(node.right,level+1));
            }
        }


        return list;
    }
 }
