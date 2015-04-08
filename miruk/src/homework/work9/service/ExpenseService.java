package homework.work9.service;

import homework.work9.dao.ExpenseDAO;
import homework.work9.dao.impl.JDBCExpense;
import homework.work9.entity.Expense;

import java.util.List;

/**
 * Created by miruk on 08.04.2015.
 */
public class ExpenseService {
    private ExpenseDAO expenseDAO = new JDBCExpense();

    public void addExpense(Expense expense) throws ClassNotFoundException {
        expenseDAO.addExpense(expense);
    }

    public List<Expense> getExpenses() throws ClassNotFoundException {
        return expenseDAO.getExpenses();
    }
}
