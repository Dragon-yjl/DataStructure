package binary_Search_Tree;

public class BSTree {

    private Node root;

    ///构造一颗空树
    public BSTree () {
        root = null;
    }

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



    public static void main(String[] args) {


        BSTree bsTree = new BSTree();


        boolean search = bsTree.search(6);

        System.out.println(search);

    }
}
