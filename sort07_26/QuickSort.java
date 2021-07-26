package sort07_26;

public class QuickSort {

    //快速排序
    public static void quickSort(long[] array) {
          quickSortInternal(array,0,array.length-1);

    }


    public static void quickSortInternal(long[] array,int lowIndex,int highIndex) {

        //当区间内剩余0个或者1个数就可以退出
        //由于是左臂右闭区间 所以要后面的下标-前面的下标+1
        int size = highIndex - lowIndex +1;
        if(size <= 1) {
            return;
        }


        //选择其中一个数(选最左边的)--/array[lowIndex]
        //执行分割操作partition 小的方左面  大的放右面
        //keyIndex 是经过partition之后表示选出来的数所在的下标
        int keyIndex = partition(array,lowIndex,highIndex);
        //分别对左右区间进行相同的处理 --递归方法
        quickSortInternal(array,lowIndex,keyIndex-1);//左区间
        quickSortInternal(array,keyIndex+1,highIndex);//右区间
    }


    //partition分割操作
    //区间是array[lowIndex,highIndex]
    //1.选择array[lowIndex]作为特殊的数 key
    //2.主要遍历整个区间 和 选出来的ker作比较
    //3.保证 小于等于key的值放在左边 大于key的值放在右边
    public static int partition(long[] array,int lowIndex,int highIndex) {

        //选择合适的方法
        //1.Hover
        return partitionHover(array,lowIndex,highIndex);
    }


    private static int partitionHover(long[] array,int lowIndex,int highIndex) {
        int leftIndex = lowIndex;
        int rightIndex = highIndex;
        //选择最左边的一个值
        long key = array[lowIndex];
        //选择了最左边的值 就要从右边先走

        //停止循环条件 left == right
        //循环继续的条件 left< right
        while (leftIndex < rightIndex) {
            while (leftIndex < rightIndex && array[rightIndex] >= key) {
             rightIndex--;
            }
            //走到这里说明[rightIndex]遇到了比key小的值

            while (leftIndex < rightIndex && array[leftIndex] <= key) {
                leftIndex++;
            }
            //走到这里 说明[leftIndex] 遇到了比key大的
            //开始交换

            swap(array,leftIndex,rightIndex);


        }

        //然后把选中的最左边的key值与已经相遇的left或right交换

        swap(array,lowIndex,leftIndex);

        //他俩的值交换之后 left位置的值就是key值
        return leftIndex;
    }

    public static void swap(long[] array,int index1,int index2) {
      long t = array[index1];
      array[index1] = array[index2];
      array[index2] = t;
    }

    // 画图的时候，可以把几种情况都考虑到
    private static int partitionHover1(long[] array, int lowIndex, int highIndex) {
        int leftIndex = lowIndex;
        int rightIndex = highIndex;
        // 选择的数是最左边的一个
        long key = array[lowIndex];
        // 选择了最左边，从右边先走

        // 停止条件 leftIndex == rightIndex
        // 循环的继续的条件 leftIndex < rightIndex
        while (leftIndex < rightIndex) {

            while (leftIndex < rightIndex && array[rightIndex] >= key) {
                rightIndex--;
            }
            // 说明 [rightIndex] 遇到了小的了

            while (leftIndex < rightIndex && array[leftIndex] <= key) {
                leftIndex++;
            }
            // 说明 [leftIndex] 遇到了大的了

            swap(array, leftIndex, rightIndex);
        }

        swap(array, lowIndex, leftIndex);

        return leftIndex;
    }
}
