package sort;

import java.util.Arrays;
import java.util.Random;

public class InsertSort {

    public static void insertSort (long[] array) {
      // 数据一共有array.length 个
      //所以，子操作就要执行多少次
      for(int i = 0; i < array.length - 1;i++) {
          //前面是有序区间[0,i+1) ,
          // 因为要循环array.length-1次，说明第一个元素就是有序的
          //后面是无序区间(i+1,array.length]
          //抓出来的数是array[i+1]
          long key = array[i+1];

          int j = i;
          //那key跟有序区间的每个数进行从后往前比较
          for(;j >= 0;j--) {
             //j就是需要跟key比较的数
              if(key < array[j] ) {
                  //吧array[j]往后移一位
                  array[j+1] = array[j];
              }else{//key>=array[j]
                  break;
              }
          }
          array[j+1] = key;

      }
    }

    //测试四种情况
    //1.随机乱序
    //2.已经有序
    //3.已经逆序
    //4.完全相等
    //测试不同规模的数据量


    //随随机顺序
    public static long[] buildRandomArray() {
        Random random = new Random(20201028);
        long[] array = new long[10];
        for(int i = 0;i < 10;i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }


    //有序数组
    public static long[] buildOrderArray() {
        long[] array = buildRandomArray();
        Arrays.sort(array);
        return array;
    }

    public static void swap(long[] array,int i ,int j) {
        long t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    //逆序数组
    private static long[] buildReverseArray() {
        long[] array = buildOrderArray();
        swap(array,0,9);
        swap(array,1,8);
        swap(array,2,7);
        swap(array,3,6);
        swap(array,4,5);

        return array;
    }

    private static long[] buildSameArray() {
        long[] array = new long[10];
        for(int i = 0;i< 10;i++) {
            array[i] = 9;
        }
        return array;
    }

    public static void main(String[] args) {

        long[]  a1 = buildSameArray();
        System.out.println("排序前");
        System.out.println(Arrays.toString(a1));


        insertSort(a1);
        System.out.println("排序后");
        System.out.println(Arrays.toString(a1));


    }
}
