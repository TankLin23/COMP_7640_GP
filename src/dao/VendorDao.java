package dao;

import model.Vendor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VendorDao {

    public int add(Connection connection , Vendor v) throws SQLException {
        String sql= "insert into Vendor values(null,?,?,?)";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,v.getBusiness_name());
        preparedStatement.setDouble(2,v.getFeedback_score());
        preparedStatement.setString(3,v.getGeographical_presence());
        return preparedStatement.executeUpdate();
    }

    public int update(Connection connection,Vendor v)throws SQLException{
        String sql="update Vendor set business_name=?,feedback_score=?,geographical_presence=? where vendor_id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,v.getBusiness_name());
        preparedStatement.setDouble(2,v.getFeedback_score());
        preparedStatement.setString(3,v.getGeographical_presence());
        preparedStatement.setString(4,v.getID());
        return preparedStatement.executeUpdate();
    }

    public int delete(Connection connection,Vendor v)throws SQLException{
        String sql="delete from vendor where vendor_id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,v.getID());
        return preparedStatement.executeUpdate();
    }
}
