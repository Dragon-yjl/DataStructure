package jdkSort7_27;

import java.util.*;

//使用jdk提供得数组排序方式
public class JdkArraySort {

    private static String[] names = {"张三","李四",
            "王五","赵六","田七",
            "高博","顾陌","顾奈",
            "顾北","顾楠"};

    private static Person[] creatPersonArray() {

        Person[] personArray = new Person[10];

        for(int i = 0;i < 10;i++) {

            personArray[i] =  new Person();
        }

        List<String> nameListOld = Arrays.asList(names);
        //实现老的一个list，所以有些方法不能用 所以在传到新的ArrayList
        List<String> nameList = new ArrayList<>(nameListOld) ;
        Collections.shuffle(nameList);//洗牌

        //随机赋值
        Random random = new Random();
        for(int i = 0;i < 10;i++) {
            personArray[i].name = nameList.remove(0);
            personArray[i].age = random.nextInt(30)+5;
            personArray[i].height = random.nextInt(100)+100;
            personArray[i].weight = random.nextInt(100)+100;
        }

       return personArray;
    }

    public static void main(String[] args) {

        Person[] personArray = creatPersonArray();

        System.out.println(Arrays.toString(personArray));

        Arrays.sort(personArray, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.age - o2.age;
            }
        });


        System.out.println(Arrays.toString(personArray));

    }
}
