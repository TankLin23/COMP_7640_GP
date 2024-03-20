package dao;

import model.Order;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class OrderDao {
    //check history record
    public ResultSet checkhistory(Connection connection,String c_id)throws SQLException{
        String sql="select * from (`order` join product on `order`.product_id=product.product_id) where customer_id=? and status=1";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,c_id);
        return preparedStatement.executeQuery();
    }
    //check ongoing records
    public ResultSet checkongoing(Connection connection,String c_id)throws SQLException{
        String sql="select * from (`order` join product on `order`.product_id=product.product_id) where customer_id=? and status=0";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,c_id);
        return preparedStatement.executeQuery();
    }

    //add order record
    public int add(Connection connection, Order order)throws SQLException{
        String sql="insert into `order` values (null,?,?,?,?,?,?)";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,order.getC_id());
        preparedStatement.setInt(2,order.getStatus());
        preparedStatement.setString(3,order.getV_id());
        preparedStatement.setString(4,order.getP_id());
        preparedStatement.setInt(5,order.getQuantity());
        preparedStatement.setInt(6,order.getPrice());
        return preparedStatement.executeUpdate();
    }

    //update the status
    public int update(Connection connection, String o_id)throws SQLException{
        String sql="update `order` set status=1 where o_id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,o_id);
        return preparedStatement.executeUpdate();
    }

    //modify the order information
    public int modify(Connection connection, Order order)throws SQLException{
        String sql="update `order` set vendor_id=?,product_id=?,quantity=?,price=? where o_id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,order.getV_id());
        preparedStatement.setString(2,order.getP_id());
        preparedStatement.setInt(3,order.getQuantity());
        preparedStatement.setInt(4,order.getPrice());
        preparedStatement.setString(5,order.getID());
        return preparedStatement.executeUpdate();
    }

    public int delete(Connection connection,Order order)throws SQLException{
        String sql="delete from `order` where o_id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,order.getID());
        return preparedStatement.executeUpdate();
    }




}
