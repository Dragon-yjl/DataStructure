package heap7_24;

//自己实现优先级队列 利用数据结构的堆
public class MyPriorityQueue {
    private static Integer[] array;
    private int size;

    MyPriorityQueue() {

        //简单起见 不考虑扩容
        array = new Integer[100];
        size = 0;
    }

    public Integer element() {
        if(size == 0) {
            throw new RuntimeException("空了");
        }

        return array[0];
    }

    public Integer remove() {
        if(size == 0) {
            throw new RuntimeException("空了");
        }

        int e = array[0];
        array[0] = array[size - 1];
        size--;

        //向下调整之后e的·值就是最上面最小的值了
        adjustDown(0);

        return e;

    }

    //O(logn)
    public void add(Integer e) {
        array[size] = e;
        size++;
        adjustUp(size-1);
    }

    private void adjustDown(int index) {

        while (true) {
            int leftIndex = index * 2 + 1;
            if(leftIndex >= size) {
                return;
            }

            int rightIndex = leftIndex + 1;
            int minIndex = leftIndex;
            if(rightIndex < size && array[rightIndex] < array[leftIndex] ) {
                minIndex = rightIndex;
            }

            if(array[index] < array[minIndex])  {
                return;
            }

            int t = array[index];
            array[index] = array[minIndex];
            array[minIndex] = t;


            index = minIndex;
        }
    }

    //向上调整
    public static void adjustUp(int index) {

        while (true) {
            //1.判断index是不是树的根，如果是调整结束
            if(index == 0) {
                break;
            }
            //2.如果不是 找到index的父节点
            int parentIndex = (index - 1) /2;
            //3.比较父节点与index的值
            //4.只要父节点的值<=index的值 调整结束
            if(array[parentIndex] <= array[index]) {
                break;
            }
            //5.如果> index的值 交换父节点和index位置的值
            int t = array[parentIndex];
            array[parentIndex] = array[index];
            array[index] = t;
            //66.把父节点看做是index、继续循环

            index = parentIndex;

        }
    }
}
