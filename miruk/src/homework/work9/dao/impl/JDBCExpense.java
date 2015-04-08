package homework.work9.dao.impl;

import homework.work9.dao.ExpenseDAO;
import homework.work9.entity.Expense;
import homework.work9.utils.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by miruk on 08.04.2015.
 */
public class JDBCExpense implements ExpenseDAO{

    private static final String SQL_INSERT_EXPENSES = "INSERT INTO expenses (num,paydate,receiver,value) values (?,?,?,?)";
    private static final String SQL_GET_EXPENSES = "SELECT * FROM root.expenses";


    @Override
    public void addExpense(Expense expense) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc_5.1.5");
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Miruk", "root", "admin123");
            preparedStatement = connection.prepareStatement(SQL_INSERT_EXPENSES);
            preparedStatement.setInt(1, expense.getNum());
            preparedStatement.setString(2, expense.getPaydate());
            preparedStatement.setInt(3, expense.getReceiver());
            preparedStatement.setInt(4, expense.getValue());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(preparedStatement, connection);
        }
    }

    @Override
    public List<Expense> getExpenses() throws ClassNotFoundException {
        List<Expense> expenses = null;
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/root", "root", "admin123");
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL_GET_EXPENSES);
            expenses = initExpenses(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(statement, resultSet, connection);
        }
        return expenses;
    }


    private List<Expense> initExpenses(ResultSet resultSet) throws SQLException {
        List<Expense> expenses = new ArrayList<Expense>();
        while (resultSet.next()) {
            Expense expense = new Expense();
            expense.setNum(resultSet.getInt(1));
            expense.setPaydate(resultSet.getString(2));
            expense.setReceiver(resultSet.getInt(3));
            expense.setValue(resultSet.getInt(4));
            expenses.add(expense);
        }
        return expenses;
    }
}
