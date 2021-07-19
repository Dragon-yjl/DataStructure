package queue7_19;

public class MyCircularQueue {

    private final int[] array;
    private int size;
    private int frontIndex;//队首元素下标
    private int realIndex;//队尾元素下标


    //循环队列的数组容量是K
    public MyCircularQueue(int k) {

        array = new int[k];
        size = 0;
        frontIndex = 0;
        realIndex = 0;

    }


    //吧value插入循环队列尾部
    //成功返回true
    //失败（容量满了）返回false
    public boolean enQueue(int value) {

        if(size == array.length) {
            return false;
        }
        //插入队尾
        array[realIndex] = value;
        size++;
        realIndex++;
        //如果队尾元素下标等于数组长度，从头开始循环·
        if(realIndex == array.length) {
            realIndex = 0;
        }
        return true;
    }

    //从循环队列队首删除一个元素
    //成功返回true 失败或者队列为空的时候返回false
    public boolean deQueue() {
        if(size == 0) {
            return false;
        }
        size--;
        frontIndex++;
        //队首元素下标往后走，如果走到数组长度，从头开始
        if(frontIndex == array.length) {
            frontIndex = 0;
        }
        return true;


    }

    //返回队首元素
    //如果队列是空的，返回-1
    public int Front() {
        if(size == 0) {
            return -1;
        }

        return array[frontIndex];

    }

    //返回队尾元素
    //如果队列是空的，返回-1
    public int Rear() {
        if(size == 0) {
            return -1;
        }
        int index = realIndex - 1;
        if(index == -1) {
            realIndex = array.length-1;
        }
        return array[realIndex];

    }

    public boolean isEmpty() {

         return size == 0;
    }

    public boolean isFull() {

        return size == array.length;
    }
}
