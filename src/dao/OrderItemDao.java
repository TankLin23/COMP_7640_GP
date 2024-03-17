package dao;

import model.OrderItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderItemDao {
    public int add(Connection connection, OrderItem orderItem)throws SQLException{
        String sql="insert into orderitem values (null,?,?,?)";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,orderItem.getO_id());
        preparedStatement.setString(2,orderItem.getP_id());
        preparedStatement.setString(3,orderItem.getQuantity());
        return preparedStatement.executeUpdate();

    }

    public int update(Connection connection,OrderItem orderItem)throws SQLException{
        String sql="update orderitem set order_id=?,product_id=?,quantity=? where order_item_id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,orderItem.getO_id());
        preparedStatement.setString(2,orderItem.getP_id());
        preparedStatement.setString(3,orderItem.getQuantity());
        preparedStatement.setString(4,orderItem.getID());
        return preparedStatement.executeUpdate();
    }

    public int delete(Connection connection,OrderItem orderItem)throws SQLException{
        String sql="delete from orderitem where order_item_id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,orderItem.getID());
        return preparedStatement.executeUpdate();
    }
}
