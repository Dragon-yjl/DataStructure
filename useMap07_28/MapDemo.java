package useMap07_28;

import java.util.Map;
import java.util.TreeMap;

public class MapDemo {

    public static void main(String[] args) {

        //Map<K,V> K是key的类型 V是value的类型
        //把map想象成一个通讯录,key是姓名 value是电话号码
        //key表示
        Map<String,Integer> map = new TreeMap<>();

        //put将key-value映射关系放入map集合中
        //key以在集合中时，用新的关系替换老的关系
        Integer v = map.put("gm",123);
        System.out.println(v);//null 第一次放入，所以会打印null
        System.out.println(map);//{gm=123}

        v = map.put("gm",456);
        System.out.println(v);//123
        System.out.println(map);//{gm=456}

        //get通过key 获取对应的value
        //如果没有 返回null
        v = map.get("gm");//只是把它的值取出来而不是删除
        System.out.println(v);//456

        v = map.get("gm");
        System.out.println(v);//还是456  没有删除
        //get方法如果里面没有key  返回null

        //getOrDefault通过key获取相应的key
        //如果key不存在 返回defaultValue。不会修改集合本身
        v = map.getOrDefault("gb",999);
        System.out.println(v);//虽然打印999 但是这个映射关系并没有放进去

        //remove 删除key - value的映射关系
        //如果key存在返回value 不存在返回null
        v = map.remove("gn");
        System.out.println(v);//null// 删除里面没有的关系就返回null、

        v = map.remove("gm");
        System.out.println(v);//456删除有的关系，返回他的value值

        System.out.println(map);//{}

    }
}
