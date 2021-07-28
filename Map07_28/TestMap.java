package Map07_28;

import java.util.Map;
import java.util.TreeMap;

public class TestMap {


    public static void main(String[] args) {

        Map<String,String> m = new TreeMap<>();

        //put方法 插入key-value的键值对
        //如果key不存在 会将key-value插入到map中返回null
        m.put("林冲","豹子头");
        m.put("鲁智深","花和尚");
        m.put("武松","行者");
        m.put("宋江","及时雨");
        String str = m.put("李逵","黑旋风");
        System.out.println(str);//null
        System.out.println(m.size());//5
        System.out.println(m);
        //{宋江=及时雨, 李逵=黑旋风, 林冲=豹子头, 武松=行者, 鲁智深=花和尚}

        //put方法中key不能为空 但是value可以为空
        //key如果为空就会NullPointerException
        //比如  m.put(null,"无名")
        str = m.put("无名",null);
        System.out.println(m.size());//6
        System.out.println(m);
        //{宋江=及时雨, 无名=null, 李逵=黑旋风, 林冲=豹子头, 武松=行者, 鲁智深=花和尚}

        //如果key已经存在 会会使用value替换原来key所对应的value  返回旧的value
        str = m.put("李逵","铁牛");
        System.out.println(str);//黑旋风
        System.out.println(m);//{宋江=及时雨, 无名=null, 李逵=铁牛, 林冲=豹子头, 武松=行者, 鲁智深=花和尚}

        //get方法返回key所对应的value
        //如果key存在返回key所对应的value
        //如果key不存在 返回null
        System.out.println(m.get("鲁智深"));//花和尚
        System.out.println(m.get("史进"));//null

        //getOrDefault方法
        //如果key存在，返回与key对应的value，key不存在，返回后面的默认值
        System.out.println(m.getOrDefault("李逵", "铁牛"));//铁牛
        System.out.println(m.getOrDefault("史进", "九纹龙"));//九纹龙
        System.out.println(m.size());//6
        System.out.println(m);
        //{宋江=及时雨, 无名=null, 李逵=铁牛, 林冲=豹子头, 武松=行者, 鲁智深=花和尚}

        //containKey方法 检测key是否包含在map中 时间复杂度O(log(n))
        //按照红黑树的性质来进行查找
        //找到返回true 找不到返回false
        System.out.println(m.containsKey("林冲"));//true
        System.out.println(m.containsKey("九纹龙"));//false

        //containsValue 检测value是否包含在map中 时间复杂度O(n)
        //因为TreeMap是按照key进行组织的，因此查找value时就需要整体遍历
        //找到返回true 找不到返回false
        System.out.println(m.containsValue("豹子头"));//true
        System.out.println(m.containsValue("九纹龙"));//false

        System.out.println("==========");
        System.out.println(m);

        //打印所有的key
        //keySet是将map中所有的key放在Set中返回的
        //因为key不能重复 而且是有序的
        for(String s : m.keySet()) {
            System.out.println(s + " ");
        }
        System.out.println();
        //宋江
        //无名
        //李逵
        //林冲
        //武松
        //鲁智深

        //打印所有的value
        //value是将map中所有的value放在Collect的一个集合中返回的
        //因为value可以重复且没有顺序
        for(String s : m.values()) {
            System.out.println(s + " ");
        }
        System.out.println();
        //及时雨
        //null
        //铁牛
        //豹子头
        //行者
        //花和尚

        //打印所有的键值对
        //entrySet 将map中所有的键值对放在set中返回了
        for(Map.Entry<String,String> entry : m.entrySet()) {
            System.out.println(entry.getKey() + "-->" + entry.getValue());

        }
        System.out.println();
        //宋江-->及时雨
        //无名-->null
        //李逵-->铁牛
        //林冲-->豹子头
        //武松-->行者
        //鲁智深-->花和尚



    }
}
