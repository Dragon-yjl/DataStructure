package arrayList7_12;

import java.util.ArrayList;
import java.util.List;

/**
 * 区分“容量” 和 “包含元素个数” 的区别
 */

public class ArrayListCapacityDemo {
    public static void main(String[] args) {

        //这个顺序表的起始容量是100
        //这个顺序表目前所包含的元素格式是0 size是0
        //顺序表的下标与容量无关 与元素个数size有关
        //get set add remove 都是跟元素个数有关size、
        List<String> list = new ArrayList<>(100);

        //因为size是0 所以数组下标越界异常
        list.set(98,"hello");

        //IndexOutOfBoundsException:
    }
}
