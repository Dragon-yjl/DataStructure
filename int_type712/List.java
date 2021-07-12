package int_type712;


//自己仿写的java.util.List下的 List接口
public interface List {

    //Integer表示元素  int表示下标
    boolean add(Integer e);
    void add(int index, Integer e);

    //根据下标删除
    Integer remove (int index);
    //删除第一个遇到的元素
    boolean remove (Integer e);

    Integer get(int index);
    Integer set(int index, Integer e);

    int size();
    void clear();
    boolean isEmpty();

    boolean contains(Integer e);
    int indexOf(Integer e);
    int lastIndexOf(Integer e);



}
