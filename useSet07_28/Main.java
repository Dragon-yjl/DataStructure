package useSet07_28;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        Set<String> set = new TreeSet<>();

        System.out.println(set.add("apple"));
        System.out.println(set.add("peach"));
        System.out.println(set.add("banana"));
        System.out.println(set.add("orange"));

        System.out.println(set.size());
        System.out.println(set);//[apple, banana, orange, peach]
        //按照首字母中序打印

        System.out.println(set.add("apple"));
        System.out.println(set.contains("watermelon"));
        System.out.println(set.contains("apple"));


        System.out.println(set.remove("watermelon"));
        System.out.println(set.remove("apple"));
        System.out.println(set);

        set.clear();
        System.out.println(set.isEmpty());//true
        System.out.println(set.size());//0

        System.out.println(set.add("西瓜"));
        System.out.println(set.add("黄瓜"));
        System.out.println(set.add("南瓜"));
        System.out.println(set.add("北瓜"));
        System.out.println(set.add("冬瓜"));
        System.out.println(set.add("地瓜"));

        //迭代器遍历
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String fruit = iterator.next();
            System.out.println(fruit);
        }

        System.out.println();
        for(String fruit : set ) {
            System.out.println(fruit);
        }
    }
}
