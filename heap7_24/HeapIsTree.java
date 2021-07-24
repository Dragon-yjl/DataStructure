package heap7_24;

public class HeapIsTree {
    public static void adjustDown(int[] array, int size, int index) {

        while (true) {
            //1.判断index位置是不是叶子结点
            int leftIndex = 2 * index + 1;//表示index左孩子下标
            if (leftIndex >= size) {//说明没有左孩子 直接返回、
                return;

            }

            //2.找到最小的孩子位置的下标
            int minIndex = leftIndex;//左孩子
            int rightIndex = leftIndex + 1;//右孩子
            if (rightIndex < size && array[rightIndex] < array[leftIndex]) {
                //存在右孩子 并且右孩子的值小于左孩子

                minIndex = rightIndex;
            }

            //3.比较最小孩子的值  和index 位置的值
            if (array[index] <= array[rightIndex]) {
                //index 位置的值 小于右孩子位置的值 不用交换
                return;
            }

            //4,交换
            int t = array[index];
            array[index] = array[rightIndex];
            array[rightIndex] = t;


            //5.把最小的孩子视为index  继续循环
            index = minIndex;
        }
    }

}
