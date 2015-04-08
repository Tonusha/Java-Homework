package homework.work9.dao.impl;

import homework.work9.dao.ReceiverDAO;
import homework.work9.entity.Expense;
import homework.work9.entity.Receiver;
import homework.work9.utils.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by miruk on 08.04.2015.
 */
public class JDBCReceiver implements ReceiverDAO {
    private static final String SQL_INSERT_RECEIVER = "INSERT INTO receivers (num,name) values (?,?);";
    private static final String SQL_GET_RECEIVER = "SELECT * FROM root.receivers";

    @Override
    public void addReceiver(Receiver receiver) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/root", "root", "admin123");
            preparedStatement = connection.prepareStatement(SQL_INSERT_RECEIVER);
            preparedStatement.setInt(1, receiver.getNum());
            preparedStatement.setString(2, receiver.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(preparedStatement, connection);
        }
    }

    @Override
    public List<Receiver> getReceiver() throws ClassNotFoundException {
        List<Receiver> receivers = null;
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/root", "root", "admin123");
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL_GET_RECEIVER);
            receivers = initRecervers(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(statement, resultSet, connection);
        }
        return receivers;

    }

    private List<Receiver> initRecervers(ResultSet resultSet) throws SQLException {
        List<Receiver> receivers = new ArrayList<Receiver>();
        while (resultSet.next()) {
            Receiver receiver = new Receiver();
            receiver.setNum(resultSet.getInt(1));
            receiver.setName(resultSet.getString(2));
            receivers.add(receiver);
        }
        return receivers;
    }


}
