package myTerrSet7_28;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class TreeSet implements Set<Integer> {

    private TreeNode root;
    private int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
    //1.要把object类型的o转成comparable支持的类型
        Comparable<Integer> comparable = (Comparable<Integer>)o;

        TreeNode cur = root;
        while (cur != null) {
            int com = comparable.compareTo(cur.key);
            if(com == 0) {
                return true;
            }else if(com < 0) {
                cur = cur.left;
            }else {
                cur = cur.right;
            }
        }

        return false;
    }

    @Override
    public Iterator<Integer> iterator() {


        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Integer integer) {

        if(root == null) {
            root = new TreeNode(integer);
            size++;
            return true;
        }
        TreeNode cur = root;
        TreeNode parent = null;

        int com = 0;
        while (cur != null) {
            com = integer.compareTo(cur.key);
            if(com == 0) {
                return false;
            }else if(com < 0) {
                parent = cur;
                cur = cur.left;
            }else {
                parent = cur;
                cur = cur.right;
            }
        }

        TreeNode node = new TreeNode(integer);
        if(com < 0) {
           parent.left = node;
        }else {
            parent.right = node;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

        root = null;
        size = 0;
    }
}
