package rebuild_Tree7_22;

//重建二叉树

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * 把数组转换为顺序表
     * @param array 输入一个整型数组
     * @return 输出一个顺序表
     */
    private List<Integer> intArrayToList(int[] array) {
        List<Integer> list = new ArrayList<>();

        for(int e : array) {
            list.add(e);
        }

        return list;
    }

    /**
     * 给出前序遍历和中序遍历 重建二叉树
     * @param preOrderList 输入前序遍历
     * @param inOrderList  输入中序遍历
     * @return 返回一个构建好的二叉树
     */
    private TreeNode buildTreeInternal(List<Integer> preOrderList,List<Integer> inOrderList) {

        //第一种情况
        if(preOrderList.isEmpty()) {
            return null;
        }
        //第二种情况
        //前序顺序表肯定不为空 把第一个元素作为根节点的值

        int rootVal = preOrderList.get(0);
        TreeNode root = new TreeNode(rootVal);

        //如果前序顺序表只有一个元素，返回这一个根节点的树的根节点
        if(preOrderList.size() == 1) {
            return root;
        }

        //第三种情况
        //找到中序遍历的list里面的根节点,获取他的下标
        //他的下标就是左子树的序列长度 保存为leftSize
        int leftSize = inOrderList.indexOf(rootVal);

        //开始切割
        //左子树的前序+右子树的前序
        //subList 方法左闭右开 所以要leftSize+1
        List<Integer> leftPre = preOrderList.subList(1,1+leftSize);
        List<Integer> rightPre = preOrderList.subList(1+leftSize,preOrderList.size());
        //左子树的中序+右子树的中序
        List<Integer> leftIn = inOrderList.subList(0,leftSize);
        List<Integer> rightIn = inOrderList.subList(leftSize+1,inOrderList.size());


        //最后再去构建左右子树
        root.left = buildTreeInternal(leftPre,leftIn);
        root.right = buildTreeInternal(rightPre,rightIn);


        return root;

    }

    public TreeNode buildTree(int[] preOrder,int[] inOrder) {
        //不检查preOrder.length == inOrder.length
        List<Integer> preOrderList = intArrayToList(preOrder);
        List<Integer> inOrderList = intArrayToList(inOrder);

        return buildTreeInternal(preOrderList,inOrderList);
    }


}
