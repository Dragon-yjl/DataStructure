package arrayList7_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListDemo {

    public static void main(String[] args) {

        //构造了一个空的顺序表
        List<String> list1 = new ArrayList<>();

        //数组 转 List
        List<String> list2 = Arrays.asList(
                "我", "是","中","国","人",
                "我","爱","我","的","祖","国"
        );
        System.out.println(list2);

        //把原来的容器完全复制了一份
        List<String> str3 = new ArrayList<>(list2);
        System.out.println(list2);
    }

}
