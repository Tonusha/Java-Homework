package homework.work9.service;

import homework.work9.dao.ExpenseDAO;
import homework.work9.dao.ReceiverDAO;
import homework.work9.dao.impl.JDBCExpense;
import homework.work9.dao.impl.JDBCReceiver;
import homework.work9.entity.Expense;
import homework.work9.entity.Receiver;

import java.util.List;

/**
 * Created by miruk on 08.04.2015.
 */
public class ReceiverService {
    private ReceiverDAO receiverDAO = new JDBCReceiver();

    public void addReceiver(Receiver receiver) throws ClassNotFoundException {
        receiverDAO.addReceiver(receiver);
    }

    public List<Receiver> getReceivers() throws ClassNotFoundException {
        return receiverDAO.getReceiver();
    }
}
