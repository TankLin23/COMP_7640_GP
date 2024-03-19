package dao;

import model.Customer;
import model.Vendor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VendorDao {


public int feedback_positive(Connection connection,String v_id)throws SQLException{
    String sql="update vendor set feedback_score=feedback_score+0.1 where vendor_id=?";
    PreparedStatement preparedStatement=connection.prepareStatement(sql);
    preparedStatement.setString(1,v_id);
    return preparedStatement.executeUpdate();
}
    public int feedback_negative(Connection connection,String v_id)throws SQLException{
        String sql="update vendor set feedback_score=feedback_score-0.1 where vendor_id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,v_id);
        return preparedStatement.executeUpdate();
    }

    //check the exit vendor
    public ResultSet checkvendor(Connection connection)throws Exception{
        String sql="select vendor_id, business_name, feedback_score, geographical_presence from vendor";
        PreparedStatement preparedStatement= connection.prepareStatement(sql);
        return preparedStatement.executeQuery();
    }

    public ResultSet getnewID(Connection connection, Vendor v)throws Exception{
        String sql="select vendor_id from vendor where business_name = ?";
        PreparedStatement preparedStatement= connection.prepareStatement(sql);
        preparedStatement.setString(1,v.getBusiness_name());
        return preparedStatement.executeQuery();
    }
    public Vendor login(Connection connection, Vendor vendor)throws Exception{
        Vendor resultvendor=null;
        String sql="select * from vendor where vendor_id=? and password=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1, vendor.getID());
        preparedStatement.setString(2, vendor.getPassword());
        ResultSet resultSet=preparedStatement.executeQuery();
        if (resultSet.next()){
            resultvendor=new Vendor();
            resultvendor.setID(resultSet.getString("vendor_id"));
            resultvendor.setBusiness_name(resultSet.getString("business_name"));
            resultvendor.setFeedback_score(resultSet.getDouble("feedback_score"));
            resultvendor.setGeographical_presence(resultSet.getString("geographical_presence"));
            resultvendor.setPassword(resultSet.getString("password"));

        }
        return resultvendor;
    }

    /**
     * add vendor
     * @param connection
     * @param v
     * @return
     * @throws SQLException
     */
    public int add(Connection connection , Vendor v) throws SQLException {
        String sql= "insert into Vendor values(null,?,?,?,?)";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,v.getBusiness_name());
        preparedStatement.setDouble(2,v.getFeedback_score());
        preparedStatement.setString(3,v.getGeographical_presence());
        preparedStatement.setString(4,v.getPassword());
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
