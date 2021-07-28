package myTreeMap07_28;

import sun.reflect.generics.tree.Tree;

public class TestMyTreeMap {

    public static void main(String[] args) {
        TreeMap treeMap = new TreeMap();

        Integer v = treeMap.put("cpx",123);
        System.out.println(v);//null
        v = treeMap.put("cpx",456);
        System.out.println(v);//123


        System.out.println(treeMap.get("cpx"));//456
        System.out.println(treeMap.get("gb"));//null
        System.out.println(treeMap.getDefault("cpx",999));//456
        System.out.println(treeMap.getDefault("gb", 666));//666

    }
}
