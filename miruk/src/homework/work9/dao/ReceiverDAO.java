package homework.work9.dao;

import homework.work9.entity.Expense;
import homework.work9.entity.Receiver;

import java.util.List;

/**
 * Created by miruk on 08.04.2015.
 */
public interface ReceiverDAO {
    void addReceiver(Receiver receiver) throws ClassNotFoundException;

    List<Receiver> getReceiver() throws ClassNotFoundException;
}
