package generic_type;

import int_type712.List;

public class MyArrayList<E> implements List<E> {

    private E[] array;
    private int size;

    public MyArrayList() {
        //无法直接定义泛型数组 所以只能定义Object类型数组
        //然后强转
    }

    @Override
    public boolean add(Integer e) {
        return false;
    }

    @Override
    public void add(int index, Integer e) {

    }

    @Override
    public Integer remove(int index) {
        return null;
    }

    @Override
    public boolean remove(Integer e) {
        return false;
    }

    @Override
    public Integer get(int index) {
        return null;
    }

    @Override
    public Integer set(int index, Integer e) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Integer e) {
        return false;
    }

    @Override
    public int indexOf(Integer e) {
        return 0;
    }

    @Override
    public int lastIndexOf(Integer e) {
        return 0;
    }
}