package dao;

import model.Customer;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDao {

    public ResultSet get_product_by_tag(Connection connection,String tag)throws Exception{
        String sql="select * from product join vendor on product.vendor_id=vendor.vendor_id where tag1=? or tag2=? or tag3=?";
        PreparedStatement preparedStatement= connection.prepareStatement(sql);
        preparedStatement.setString(1,tag);
        preparedStatement.setString(2,tag);
        preparedStatement.setString(3,tag);
        return preparedStatement.executeQuery();
    }
    public ResultSet checkprocuct(Connection connection, String vendor_id)throws Exception{
        String sql="select * from product where vendor_id = ?";
        PreparedStatement preparedStatement= connection.prepareStatement(sql);
        preparedStatement.setString(1,vendor_id);
        return preparedStatement.executeQuery();
    }
    public int add(Connection connection , Product product) throws SQLException {
        String sql="insert into Product values(null,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,product.getVendor_ID());
        preparedStatement.setString(2,product.getName());
        preparedStatement.setDouble(3,product.getPrice());
        preparedStatement.setInt(4,product.getQuantity());
        preparedStatement.setString(5,product.getTag1());
        preparedStatement.setString(6,product.getTag2());
        preparedStatement.setString(7,product.getTag3());
        return preparedStatement.executeUpdate();
    }

    public int delete(Connection connection,Product p)throws SQLException{
        String sql="delete from Product where product_id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,p.getID());
        return preparedStatement.executeUpdate();
    }


    public int update(Connection connection,Product p)throws SQLException{
        String sql="update Product set name=?,listed_price=?,tag1=?,tag2=?,tag3=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,p.getName());
        preparedStatement.setDouble(2,p.getPrice());
        preparedStatement.setString(3,p.getTag1());
        preparedStatement.setString(4,p.getTag2());
        preparedStatement.setString(5,p.getTag3());
        return preparedStatement.executeUpdate();
    }
}
