package homework.work9.entity;

/**
 * Created by miruk on 08.04.2015.
 */
public class Expense {
    private int num;
    private String paydate;
    private int receiver;
    private int value;

    public Expense(int num, String paydate, int receiver, int value) {
        this.num = num;
        this.paydate = paydate;
        this.receiver = receiver;
        this.value = value;
    }

    public Expense() {
    }

    public int getNum() {
        return num;
    }

    public String getPaydate() {
        return paydate;
    }

    public int getReceiver() {
        return receiver;
    }

    public int getValue() {
        return value;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setPaydate(String paydate) {
        this.paydate = paydate;
    }

    public void setReceiver(int receiver) {
        this.receiver = receiver;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "num=" + num +
                ", paydate='" + paydate + '\'' +
                ", receiver=" + receiver +
                ", value=" + value +
                '}';
    }
}
