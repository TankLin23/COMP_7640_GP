package dao;

import model.Customer;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductDao {
    public int add(Connection connection , Product product) throws SQLException {
        String sql="insert into Product values(null,?,?,?,?,?,?)";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,product.getVendor_ID());
        preparedStatement.setString(2,product.getName());
        preparedStatement.setDouble(3,product.getPrice());
        preparedStatement.setString(4,product.getTag1());
        preparedStatement.setString(5,product.getTag2());
        preparedStatement.setString(6,product.getTag3());
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
