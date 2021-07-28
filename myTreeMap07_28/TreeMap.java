package myTreeMap07_28;


import java.time.temporal.Temporal;

public class TreeMap {

    TreeNode root;

    //TreeMap中的put方法相当于插入 如果有这个key就修改key的value,返回原来的value
    public Integer put(String key,Integer value) {

        if(root == null) {
            root = new TreeNode(key,value);
            return null;//因为原先没有key所以没有value
        }

        TreeNode cur = root;
        TreeNode parent = null;

        int com = 0;
        while (cur != null) {
            com = key.compareTo(cur.key);
            if (com == 0) {
                Integer oldValue = cur.value;
                cur.value = value;
                return oldValue;
            } else if (com < 0) {
                parent = cur;
                cur = cur.left;
            } else {
                parent = cur;
                cur = cur.right;
            }

            TreeNode node = new TreeNode(key, value);
            if (com < 0) {
                parent.left = node;
            } else {
                parent.right = node;
            }
        }

        return null;

    }

    //TreeMap中的get方法相当于查找，找到了返回这个key的value
    public Integer get (String key) {
        TreeNode cur = root;

        while (cur != null) {
            int com = key.compareTo(cur.key);
            if(com == 0) {
                return cur.value;
            }else if(com < 0) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }

        return null;
    }

    //TreeMap中的getDefault方法也是查找，找到了返回key的value 找不到返回defaultValue
     public Integer getDefault(String key,Integer defaultValue) {
//        TreeNode cur = root;

//        while (cur != null) {
            //法一
//            int com = key.compareTo(cur.key);
//            if(com == 0) {
//                return cur.value;
//            }else if(com < 0) {
//                cur = cur.left;
//            } else {
//                cur = cur.right;
//            }
//       }
//
//        return defaultValue;

            //法二
            Integer v = get(key);
            if(v != null) {
                return v;
            }

            return defaultValue;

    }

}
