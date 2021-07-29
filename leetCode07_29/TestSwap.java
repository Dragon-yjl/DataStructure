package leetCode07_29;

public class TestSwap {


    public static void main(String[] args) {

        Value v1 = new Value();
        Value v2 = new Value();

        v1.setVal(100);
        v2.setVal(200);

        System.out.println(v1.val+" "+ v2.val);

        swap1(v1,v2);

        System.out.println(v1.val+" "+ v2.val);

    }

    private static void swap1(Value v1, Value v2) {
        int t = v1.getVal();
        v1.setVal(v2.getVal());
        v2.setVal(t);
    }

    public static void swap(Value value1,Value value2) {
        int t = value1.val;
        value1.val = value2.val;
        value2.val = t;
    }

    public static void main1(String[] args) {

        Value value1 = new Value();
        Value value2 = new Value();

        value1.val = 10;
        value2.val = 20;

        System.out.println(value1.val+" "+value2.val);

        swap(value1,value2);

        System.out.println(value1.val+" " + value2.val);



    }
}
