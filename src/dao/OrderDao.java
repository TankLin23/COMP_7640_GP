package dao;

import model.Order;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class OrderDao {
    public int add(Connection connection, Order order)throws SQLException{
        String sql="insert into `order` values (null,?,?)";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,order.getC_id());
        preparedStatement.setString(2,order.getDate());
        return preparedStatement.executeUpdate();
    }

    public int update(Connection connection, Order order)throws SQLException{
        String sql="update `order` set customer_id=?,o_date=? where o_id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,order.getC_id());
        preparedStatement.setString(2,order.getDate());
        preparedStatement.setString(3,order.getID());
        return preparedStatement.executeUpdate();
    }

    public int delete(Connection connection,Order order)throws SQLException{
        String sql="delete from `order` where o_id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,order.getID());
        return preparedStatement.executeUpdate();
    }


}
