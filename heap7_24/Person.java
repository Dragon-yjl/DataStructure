package heap7_24;

public class Person implements Comparable<Person> {

    int age;
    String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }


    @Override
    public int compareTo(Person o) {
        return -name.compareTo(o.name);
    }
}
