package homework.work9.entity;

/**
 * Created by miruk on 08.04.2015.
 */
public class Receiver {
    private int num;
    private String name;

    public Receiver(int num, String name) {
        this.num = num;
        this.name = name;
    }

    public Receiver() {

    }

    public void setNum(int num) {

        this.num = num;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {

        return num;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Receiver{" +
                "num=" + num +
                ", name='" + name + '\'' +
                '}';
    }
}
