package homework.work9.dao;

import homework.work9.entity.Expense;

import java.util.List;

public interface ExpenseDAO {
    void addExpense(Expense expense) throws ClassNotFoundException;

    List<Expense> getExpenses() throws ClassNotFoundException;
}
