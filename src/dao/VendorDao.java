package dao;

import model.Vendor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VendorDao {

    //check the exit vendor
    public ResultSet checkvendor(Connection connection)throws Exception{
        String sql="select vendor_id, business_name, feedback_score, geographical_persence from vendor";
        PreparedStatement preparedStatement= connection.prepareStatement(sql);
        return preparedStatement.executeQuery();
    }

    /**
     * add vendor
     * @param connection
     * @param v
     * @return
     * @throws SQLException
     */
    public int add(Connection connection , Vendor v) throws SQLException {
        String sql= "insert into Vendor values(null,?,?,?)";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,v.getBusiness_name());
        preparedStatement.setDouble(2,v.getFeedback_score());
        preparedStatement.setString(3,v.getGeographical_presence());
        return preparedStatement.executeUpdate();
    }

    /**
     * update vendor information
     * @param connection
     * @param v
     * @return
     * @throws SQLException
     */
    public int update(Connection connection,Vendor v)throws SQLException{
        String sql="update Vendor set business_name=?,feedback_score=?,geographical_presence=? where vendor_id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,v.getBusiness_name());
        preparedStatement.setDouble(2,v.getFeedback_score());
        preparedStatement.setString(3,v.getGeographical_presence());
        preparedStatement.setString(4,v.getID());
        return preparedStatement.executeUpdate();
    }

    /**
     * delete vendor record
     * @param connection
     * @param v
     * @return
     * @throws SQLException
     */
    public int delete(Connection connection,Vendor v)throws SQLException{
        String sql="delete from vendor where vendor_id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,v.getID());
        return preparedStatement.executeUpdate();
    }
}
