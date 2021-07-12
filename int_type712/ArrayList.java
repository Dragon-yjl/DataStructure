package int_type712;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Arrays;

//自己仿写的java.util.List下的实现类
public class ArrayList implements  List{

    private int[] array;   //顺序表内部的数组
    private int size;     //顺序表内部的元素个数

    public ArrayList() {

        //初始容量是10个
        array = new int[10];
        //初始的元素个数还是0个
        size = 0;
    }

    public ArrayList(List other) {
        //TODO:留着后边再说

    }


    @Override
    //尾插法 平时 O（1）  需要扩容的话是O（n）
    //因为扩容少见所以时间复杂度叫做皮平均O(1)
    public boolean add(Integer e) {
        //扩容
        if(array.length == size) {
            //现在已经满了需要扩容
            ensureCapacity(array.length*2);
        }
        array[size++] = e;
        return true;
    }


    //调用玩这个方法后，保证容量一定是>=capacity
    public void ensureCapacity(int capacity) {

        //0.检查是否需要扩容  O(n)
        if(this.array.length >= capacity) {
            return;
        }


        //1.定义新的数组
        int[] newArray = new int[capacity];

        //2.进行搬家，从array数组搬到newArray数组中
        for(int i = 0; i < size;i++) {
            newArray[i] = this.array[i];
        }

        //不在关联老的数组array，关联新的newArray数组
        this.array = newArray;
    }

    @Override
    //按照下标插入 O（n）
    public void add(int index, Integer e) {
        //扩容
        if(array.length == size) {
            //现在已经满了需要扩容
            ensureCapacity(array.length*2);
        }

        //合法的下标[0,size]

        if(index<0 || index>size) {
            throw new IndexOutOfBoundsException("不合法的下标"+index);
        }
        //要把index及之后所有元素，全部往后搬移
        //为了保证元素不被覆盖，从后往前搬

        for(int i = size; i> index; i--) {
            array[i] = array[i-1];
        }
        //l两个效果是一样的,看i以谁为标准
//        for(int i = size-1;i>index;i--) {
//            array[i+1] =array[i];
//        }

        array[index] = e;
        size++;
    }

    @Override
    //按照下标删除 O(n)
    public Integer remove(int index) {

        //合法的下标[0,size-1]
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("不合法的下标"+index);
        }
        int e = array[index];
        //从前往后删除
       //[index+1,size-1)的元素，搬移到[index,size-1]的下标出
        for(int i = index+1;i <= size-1;i++) {
            array[i-1] = array[i];
        }
        size--;

        return e;
    }

    @Override
    //删除元素e  O（n）
    public boolean remove(Integer e) {
        for(int i = 0;i<size;i++) {
            if(array[i] == e) {
                remove(i);
                return true;//调用remove(index)
            }
        }
        return false;
    }

    @Override
    //获取index下标的值  O（1）
    public Integer get(int index) {

        //合法的下标[0,size-1]
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("不合法的下标"+index);
        }
        return array[index];
    }

    @Override
    //把index下标的值设置为e O(1)
    public Integer set(int index, Integer e) {

        //合法的下标[0,size-1]
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("不合法的下标"+index);
        }
        Integer old = array[index];
        array[index] = e;
        return old;
    }

    @Override
    //O(1)
    public int size() {
        return size;
    }

    @Override
    //O(n)
    public void clear() {
        //-1 暂时代表无效值
        Arrays.fill(array,-1);
        size = 0;

    }

    @Override
    //O(1)
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    //O(n)
    public boolean contains(Integer e) {
        return indexOf(e) != -1;
    }

    @Override
    //O(n)
    public int indexOf(Integer e) {
        for(int i = 0;i<size;i++) {
            if(array[i] == e) {
                return i;
            }
        }
        return -1;
    }

    @Override
    //O(n)
    public int lastIndexOf(Integer e) {
        for(int i = size-1; i > 0; i++) {
            if(array[i]  == e){
                return i;
            }
        }
        return -1;
    }
}
