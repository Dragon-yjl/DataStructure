package myTerrSet7_28;

import java.util.Iterator;

public class TreeNodeIterator implements Iterator<Integer> {
    private TreeNode node;

    TreeNodeIterator(TreeNode root) {
        node = root;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Integer next() {
        return null;
    }
}
