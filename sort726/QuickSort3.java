package sort726;

//快排在数据量较小的时候，使用插排比较快
//如果数据已经有序快排反而很慢
//优化 ：选择的特殊数字的方式
/**    1.随机选
 *     2.挑几个数，选大小为中间值得（三数取中）
 *  把相等的值特殊处理
 *
 */
public class QuickSort3 {

    /**
     * 快速排序
     * @param array 一个数组
     *   时间复杂度
     *   最好 O(n*log(n))
     *   最坏 O(n^2)
     *   平均  O(n*log(n))
     *   空间复杂度
     *    最好 O(log(n))
     *    最坏  O(n)
     *
     *     平均 O(log(n))
     *
     *    稳定性
     *     不具备稳定性
     *    时间：每做一层partition时间是O（n）
     *              一共多少层，看二叉树高度
     *              二叉树一般是log(n) 最坏n
     *    空间同理
     */

    public static void quickSort(long[] array) {

        quickSortInternal(array, 0, array.length - 1);

    }

    private static void quickSortInternal(long[] array,int lowIndex,int highIndex) {

        int size = highIndex - lowIndex +1;
        if(size <= 1) {
            return;
        }

        int keyIndex = partition(array,lowIndex,highIndex);

        quickSortInternal(array,lowIndex,keyIndex-1);
        quickSortInternal(array,keyIndex+1,highIndex);
    }

    private static int partition(long[] array, int lowIndex, int highIndex) {
        return partitionFrontBack(array,lowIndex,highIndex);
    }

    private static int partitionFrontBack(long[] array,int lowIndex,int highIndex) {
        //定义一个分开的下标指针  从第二个元素开始  第一个元素不用比较
        int separateIndex = lowIndex + 1;

        //i表示另一个指针，从头到尾遍历一遍
        for(int i = lowIndex+1;i <= highIndex; i++) {
            //那 i下标的元素跟第一个元素比较
            if(array[i] < array[lowIndex]) {
                swap(array, i, lowIndex);
                separateIndex++;
            }

        }
        //separateIndex走到了后面，然后跟lowIndex交换，这样小的元素都在前面，大的元素都在后面
        swap(array,lowIndex,separateIndex-1);

        return separateIndex-1;
    }


    public static void swap(long[] array,int index1,int index2) {
        long t = array[index1];
        array[index1] = array[index2];
        array[index2] = t;
    }
}
