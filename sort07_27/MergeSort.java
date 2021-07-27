package sort07_27;

public class MergeSort {

    /**
     * 归并排序
     * @param array 输入一个数组 进行排序
     *    时间复杂度 O(n*log(n))
     *    空间复杂度O(n)
     */
    public static void mergeSort(long[] array) {

        //左闭右开区间
        mergeSortInternal(array,0,array.length);
    }

    //左闭右开区间 array[lowIndex,highIndex)
    public static void mergeSortInternal(long[] array,int lowIndex,int highIndex) {

        int size = highIndex - lowIndex;//*左闭右开不用+1
        if( size <= 1) {
         return;
        }

        int middleIndex = (lowIndex + highIndex) / 2;
        //左区间 [lowIndex, middleIndex)
        //右区间[middleIndex, highIndex)
        mergeSortInternal(array,lowIndex,middleIndex);
        mergeSortInternal(array,middleIndex,highIndex);

        //左右两个区间都有序了
        //合并两个有序区间
        merge(array,lowIndex,middleIndex,highIndex);
    }


    private static void merge(long[] array,int lowIndex,int middleIndex,int highIndex) {
        int size = highIndex - lowIndex;
        long[] extraArray = new long[size];

        int leftIndex = lowIndex;
        int rightIndex = middleIndex;
        int extraIndex = 0;

        //只要两个数组都有元素循环就可以继续
        while (leftIndex < middleIndex && rightIndex < highIndex) {
            if(array[leftIndex] <= array[rightIndex]) {
                extraArray[extraIndex++] = array[leftIndex++];


            }else {
                extraArray[extraIndex++] = array[rightIndex++];


            }

        }

        //一个数组空了 另一个数组还有元素、

        if(leftIndex < middleIndex) {
            while (leftIndex < middleIndex) {
                extraArray[extraIndex++] = array[leftIndex++];
            }
        }else {
            while (rightIndex < highIndex) {
                extraArray[extraIndex++] = array[rightIndex++];
            }
        }

        //最后，把数据从新数组在同一搬回去
        //新数组[0,size)
        //搬回去的下表范围[lowIndex,highIndex)
        for(int i = 0;i < size;i++) {
            array[i+lowIndex] = extraArray[i];
        }
    }
}
