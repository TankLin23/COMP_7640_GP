package dao;

import model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * the operation class in customer entity
 */
public class CustomerDao {

    /**
     * add customer
     * @param connection
     * @param c
     * @return update row number
     */
    public int add(Connection connection ,Customer c) throws SQLException {
        String sql="insert into Customer values(null,?,?)";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,c.getContact_number());
        preparedStatement.setString(2,c.getShipping_details());
        return preparedStatement.executeUpdate();
    }
    /**
     * update customer
     * @param connection
     * @param c
     * @return update row number
     */
    public int update_Customer(Connection connection,Customer c) throws SQLException {
        String sql="update Cutomer set contact_number=?,shipping_details=? where customer_id=? ";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1, c.getContact_number());
        preparedStatement.setString(2,c.getShipping_details());
        preparedStatement.setString(3,c.getID());
        return preparedStatement.executeUpdate();
    }
}
