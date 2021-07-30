package myHashTable;

import org.omg.PortableInterceptor.INACTIVE;

//使用拉链法解决哈希冲突
public class MyHashTable {

    //1.定义一个数组
    private Node[] array = new Node[11];
    //2.维护哈希表中的有的元素个数
    private int size;

    //插入  true表示key之前不在哈希表中
    //false表示key之前已经在哈希表中
    public boolean insert(Integer  key) {
        //1.吧对象转成int类型
        int hashValue = key.hashCode();
        ///2.把hashValue 转成合法的下标
        int index = hashValue % array.length;
        //3.遍历index位置处的链表 确定key 在不在元素中
        Node cur = array[index];//相当于链表头结点
        while (cur != null) {
            if(key.equals(cur.key)) {
                return false;
            }
            cur = cur.next;
        }

        //4.把key装入节点中 插入到链表中
        //头插尾插都可以
        Node node = new Node(key);
        node.next = array[index];
        array[index] = node;

        //5.维护元素个数
        size++;

        //6.通过维护负载因子 进而维护较低的冲突率
        if(size / array.length * 100>= 75) {

            //扩容
            addSize();
        }



        return true;
    }

    private void addSize() {

        Node[] newArray = new Node[array.length * 2];

        //搬原来的元素过来
        //不能直接按链表搬运 因为元素保存的下标和数组长度有关
        //数组长度变了，下标也会变
        //所以 需要把每个元素重新计算一下

        //遍历整个数组
        for(int i = 0;i < array.length;i++) {
            //遍历每条链表
            Node cur = array[i];
            while (cur != null) {
                //高效的办法是搬节点，但是写起来麻烦
                //我们使用复制节点 简单一点
                Integer key = cur.key;
                int hashValue = key.hashCode();
                int index = hashValue % newArray.length;

                //头插法 尾插也可以  头插简单
                Node node = new Node(key);
                node.next = newArray[index];
                newArray[index] = node;

                cur = cur.next;
            }
        }


        array = newArray;

    }


    //判断哈希表中有没有key
    public boolean contains(Integer key) {

        int hashValue = key.hashCode();

        int index = hashValue % array.length;

        Node cur = array[index];
        while (cur != null) {
            if(key.equals(cur.key)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

//    //哈希表中删除这个节点
//    public boolean remove(Integer key) {
//        //把对象转换为int类型
//        int hashValue = key.hashCode();
//        //找到key的下标
//        int index = hashValue % array.length;
//
//        if(array[index] == null) {
//            return false;
//        }
//        if(key.equals(array[index])) {
//            array[index] = null;
//            size--;
//            return true;
//        }
//        Node cur = array[index];
//        Node pre = null;
//        while (cur != null) {
//            pre = cur;
//            if(key.equals(cur.key)) {
//                pre.next = cur.next;
//                size--;
//                return true;
//            }
//
//            cur = cur.next;
//
//        }
//
//        return false;
//    }

    public boolean remove1(Integer key) {
        // hashCode()
        int hashValue = key.hashCode();
        // 得到合法下标
        int index = hashValue % array.length;

        Node preivous = null;
        Node current = array[index];
        while (current != null) {
            if (key.equals(current.key)) {
                // 删除
                if (preivous != null) {
                    preivous.next = current.next;
                } else {
                    // current 是这条链表的头节点
                    array[index] = current.next;
                }

                size--;
                return true;
            }

            preivous = current;
            current = current.next;
        }

        return false;
    }

}
