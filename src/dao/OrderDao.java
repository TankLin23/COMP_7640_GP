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
    public ResultSet getfeedback(Connection connection,int v_id)throws SQLException{
        String sql = "SELECT vendor.feedback_score FROM `order` JOIN vendor ON `order`.vendor_id = vendor.vendor_id WHERE `order`.vendor_id = ?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setInt(1,v_id);
        return preparedStatement.executeQuery();
    }
    public ResultSet getVhistory(Connection connection,int v_id)throws SQLException{
        String sql = "SELECT `order`.o_id,`order`.customer_id,`order`.status,`order`.vendor_name,`order`.quantity,`order`.price,`order`.product_name,vendor.feedback_score FROM `order` JOIN vendor ON `order`.vendor_id = vendor.vendor_id WHERE `order`.vendor_id = ? AND  `order`.status = 'unshipped'";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setInt(1,v_id);
        return preparedStatement.executeQuery();
    }
    public ResultSet getorderc(Connection connection,int c_id)throws SQLException{
        String sql="select * from `order` where customer_id = ? and status = 'unshipped'";
        PreparedStatement preparedStatement= connection.prepareStatement(sql);
        preparedStatement.setInt(1,c_id);
        return preparedStatement.executeQuery();
    }
    public ResultSet getorderch(Connection connection,int c_id)throws SQLException{
        String sql="select * from `order` where customer_id = ? and status = 'shipped' and feedback_status = 0";
        PreparedStatement preparedStatement= connection.prepareStatement(sql);
        preparedStatement.setInt(1,c_id);
        return preparedStatement.executeQuery();
    }
    public ResultSet getorderv(Connection connection,int v_id)throws SQLException{
        String sql="select * from `order` where vendor_id = ? and status = 'unshipped'";
        PreparedStatement preparedStatement= connection.prepareStatement(sql);
        preparedStatement.setInt(1,v_id);
        return preparedStatement.executeQuery();
    }
    public ResultSet getordervhistory(Connection connection,int v_id)throws SQLException{
        String sql="select * from `order` where vendor_id = ? and status = 'shipped'";
        PreparedStatement preparedStatement= connection.prepareStatement(sql);
        preparedStatement.setInt(1,v_id);
        return preparedStatement.executeQuery();
    }
    //add order record
    public int add(Connection connection, Order order)throws SQLException{
        String sql="insert into `order` values (null,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setInt(1,order.getC_id());
        preparedStatement.setString(2,order.getStatus());
        preparedStatement.setString(3,order.getV_name());
        preparedStatement.setInt(4,order.getV_id());
        preparedStatement.setInt(5,order.getQuantity());
        preparedStatement.setDouble(6,order.getPrice());
        preparedStatement.setString(7,order.getP_name());
        preparedStatement.setInt(8,order.getFeedbackStatus());
        return preparedStatement.executeUpdate();
    }

    //update the status
    public int update(Connection connection, int o_id, String status)throws SQLException{
        String sql="update `order` set status=? where o_id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,status);
        preparedStatement.setInt(2,o_id);
        return preparedStatement.executeUpdate();
    }
    public int updatefeedbackstatus(Connection connection, int o_id, int status)throws SQLException{
        String sql="update `order` set feedback_status=? where o_id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setInt(1,status);
        preparedStatement.setInt(2,o_id);
        return preparedStatement.executeUpdate();
    }
    //modify the order information
    public int modify(Connection connection, Order order)throws SQLException{
        String sql="update `order` set vendor_id=?,product_id=?,quantity=?,price=? where o_id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setInt(1,order.getV_id());
        preparedStatement.setString(2,order.getP_name());
        preparedStatement.setInt(3,order.getQuantity());
        preparedStatement.setDouble(4,order.getPrice());
        preparedStatement.setString(5,order.getID());
        return preparedStatement.executeUpdate();
    }

    public int delete(Connection connection,int o_id)throws SQLException{
        String sql="delete from `order` where o_id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setInt(1,o_id);
        return preparedStatement.executeUpdate();
    }




}
