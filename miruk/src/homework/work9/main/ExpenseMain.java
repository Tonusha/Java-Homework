package homework.work9.main;

import homework.work9.entity.Expense;
import homework.work9.service.ExpenseService;

import java.util.List;

/**
 * Created by miruk on 08.04.2015.
 */
public class ExpenseMain {
    public static void main(String[] args) throws ClassNotFoundException {
        Expense newExpense = new Expense(8, "2011-9-5", 9, 77900);
        ExpenseService expenseService = new ExpenseService();
        expenseService.addExpense(newExpense);
        List<Expense> expenses = expenseService.getExpenses();
        for (Expense expense : expenses) {
            System.out.println("expense = " + expense);
        }
    }
}
