package binaryRT;

public class BST {

    private Node root;

    //构造一颗空树
    public BST() {
        root = null;
    }

/**
 * 时间复杂度 最好和平均 O(log(n)) 最坏 O(n)
 *   通过平衡树 解决搜索树最坏的情况
 *   二叉搜索树的平衡树（AVL树 + 红黑树）
 *   AVL树 高度不会太夸张 所以时间复杂度h是log(n) 不会退化到O(n)
 *
 *   搜索树的平衡树（B-树家族） ----MySQL
 */

    /**
     * 二叉搜索树的查找
     * @param key  要查找的key值
     * @return  找到返回true
     */
    public boolean search(Integer key) {

        //当root== null 进不去循环 直接返回false
        Node cur = root;

        while (cur != null) {
            int res = key.compareTo(cur.key);
            if(res == 0) {
                return true;
            }else if(res < 0) {
                cur = cur.left;
            }else {
                cur = cur.right;
            }
        }

        return false;
    }


    /**
     *二叉搜索树的插入
     * @param key 输入要插入的key值 有可能已经存在
     *
     *   相当于二叉搜索树的查找，找到那个使cur== null 的
     *            位置，然后进行插入 ，所以要定义一个双亲结点
     *            跟链表插入的的prev前驱一样
     */
    public void insert(Integer key) {

        if(root ==  null) {
            root = new Node(key);
            return;
        }
        //始终保持parent就是cur的双亲节点
        Node cur = root;
        Node parent = null;

        int res =  0 ;//记录 比较后的值 方便循环完了
        // 之后知道是插入到左子树还是右子树
        while (cur != null) {
            res = key.compareTo(cur.key);
            if(res == 0) {
                throw new RuntimeException("BST中不允许出现相同的key");
            }else if(res < 0) {
                parent = cur;
                cur = cur.left;
            }else {
                parent = cur;
                cur = cur.right;
            }
        }

        //走到这里·cur = null
        //parent 就是要插入节点的双亲结点
        Node node = new Node(key);
        if(res < 0) {
            parent.left = node;
        }else {
            parent.right = node;
        }


    }



    /**
     * 删除二叉搜索树中的某个节点
     * @param key 要删除的节点值
     * @return  删除成功返回true
     *
     * 分四种情况：
     * 1.删除的是叶子结点
     * 2.删除的不是叶子，只有左孩子
     * 3.删除的不实叶子，只有右孩子
     * 4.删除的节点·有两孩子
     */
    public boolean remove(Integer key) {

        //1.查找要删除的key所在的节点 记作node
        // node的双亲结点 记作parent
        Node parent = null;
        Node cur = root;

        while (cur != null) {
            int cmp = key.compareTo(cur.key);
            if(cmp == 0) {//代表已经找到了要删除的节点，开始删除
                removeIntrenal(cur,parent);
                return true;
            }else if(cmp < 0) {
                parent = cur;
                cur = cur.left;
            }else {
                parent = cur;
                cur = cur.right;
            }
        }

        return false;
    }

    private void removeIntrenal(Node node,Node parent) {
        //1.是叶子节点，两边都为空
        if(node.left == null && node.right == null) {
            //如果该叶子结点是头结点
            if(node == root) {
                root = null;
            }else if(node == parent.left) {//如果该节点是左孩子
                parent.left = null;
            }else {//如果该节点是右孩子
                parent.right = null;
            }
            //2.该节点只有左孩子
        } else if(node.left != null && node.right == null) {
            //如果这个只有左孩子的节点是头结点
            if(node == root) {
                root = node.left;
                //如果这个只有左孩子的节点是他父亲的左孩子
            }else if(node == parent.left) {
                parent.left = node.left;
            }else {//这个只有左孩子的节点是他父亲的右孩子
                parent.right = node.left;
            }
            //3.该节点只有右孩子
        }else if(node.left == null && node.right != null) {///警告是因为前两种情况下node.right 一定不为空
            //如果这个只有右孩子的节点是头结点
            if(node == root) {
                root = node.right;
                //如果这个只有右孩子的节点是他父亲的左孩子
            }else if(node == parent.left) {
                parent.left = node.right;
            }else {//这个只有右孩子的节点是他父亲的右孩子
                parent.right = node.right;
            }
            //4.该节点既有左孩子又有右孩子
            //使用替换法删除,使用node 的左子树中的最大值所在的节点代替，
            // 记作ghost ghost的双亲记作ghostParent，也可用node右子树中的最小值替换
        }else {
            Node ghostParent = node;
            Node ghost = node.left;///因为要找左子树中的最大值
            //一路往右进行查找 直到 ghost.right = null
            while (ghost.right != null) {
                ghostParent = ghost;
                ghost = ghost.right;
            }

            //走到这里 表示找到了node左子树中最大值 ghost
            //1.开始替换 把左子树中最大的值ghost.key赋给node.key
            node.key = ghost.key;
            //2.删除ghost节点（ghost节点的右孩子一定 == null）
            if(node == ghostParent) {//表示要删除的节点的左孩子只有左孩子
                //所以ghost就是node.left且这个ghost的双亲结点就是要删除的节点本身
                ghostParent.left = ghost.left;
            }else {//表示要删除的节点的左孩子有右孩子
                ghostParent.right = ghost.left;
            }

        }
    }
}
