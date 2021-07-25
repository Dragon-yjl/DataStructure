package sort07_25;

import java.util.Arrays;

public class HeapSort {

    /**
     * 堆排序
     * @param  array 传入一个数组
     *   时间复杂度
     *   最好/最坏/平均  O(n*log(n))
     *   空间复杂度
     *    最好 /最坏/平均  O(1)
     *    不具备稳定性
     */
    public static void heapSort(long[] array) {
        //1.建大堆
        creatHeap(array,array.length);

        //2.进行选择的过程 一共需要array.length-1组
        for(int i = 0;i < array.length-1;i++) {
            //无序区间：[0,array.length-i)
            swap(array,0,array.length-i-1);
            //交换之后 无序区间[0,array.length-i-1)
            //向下调整
            adjustDown(array,array.length-i-1,0);
        }
    }


    //向下调整
    private static void adjustDown(long[] array,int size,int index) {
        //只要左孩子下标小于size表示有左孩子 非叶子结点
        while (2 * index+1 < size) {
            int maxIndex = 2 * index+1;//maxIndex存的是左孩子的下标
            //如果右孩子存在 且右孩子的值大于左孩子的值
            if(maxIndex + 1 < size && array[maxIndex+1] > array[maxIndex] ) {
                maxIndex++;//表示右孩子就是最大的值
            }

            //如果给出的下标的值大于最大的孩子的值 就说明不用调整
            if(array[index] >= array[maxIndex]) {
                break;
            }

            //否则 需要调整 把index位置的值跟maxIndex值交换
            swap(array,index,maxIndex);
            //在吧maxIndex的值赋给index继续循环向下调增
            index = maxIndex;
        }
    }

    //建堆
    public static void creatHeap(long[] array,int size) {

        for(int i = (size - 2);i >= 0;i--) {
            adjustDown(array,size,i);
        }
    }

    public static void swap(long[] array,int i, int j) {
        long t = array[i];
        array[i] = array[j];
        array[j] = t;
    }


    public static void main(String[] args) {
        long[] array ;

        array = new long[]{6,3,9,6,1,3,8,0,4,5,2};

        heapSort(array);

        System.out.println(Arrays.toString(array));
    }
}
