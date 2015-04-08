package homework.work9.main;

import homework.work9.entity.Expense;
import homework.work9.service.ExpenseService;

import java.util.List;

/**
 * Created by miruk on 08.04.2015.
 */
public class ExpenseMain {
    public static void main(String[] args) throws ClassNotFoundException {
        Expense newExpense = new Expense(6, "2011-6-5", 2, 1000);
        ExpenseService expenseService = new ExpenseService();
        expenseService.addExpense(newExpense);
        List<Expense> expenses = expenseService.getExpenses();
        for (Expense expense : expenses) {
            System.out.println("expense = " + expense);
        }
    }
}
