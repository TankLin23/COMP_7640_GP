package dao;

import model.Customer;
import model.Vendor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * the operation class in customer entity
 */
public class CustomerDao {

public Customer login(Connection connection,Customer customer)throws Exception{
    Customer resultcustomer=null;
    String sql="select * from customer where custmoer_id=? and password=?";
    PreparedStatement preparedStatement=connection.prepareStatement(sql);
    preparedStatement.setString(1, customer.getID());
    preparedStatement.setString(2, customer.getPassword());
    ResultSet resultSet=preparedStatement.executeQuery();
    if (resultSet.next()){
        resultcustomer=new Customer();
        resultcustomer.setID(resultSet.getString("id"));
        resultcustomer.setContact_number(resultSet.getString("contact_number"));
        resultcustomer.setShipping_details(resultSet.getString("shipping_details"));
        resultcustomer.setPassword(resultSet.getString("password"));

    }
    return resultcustomer;
}

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
    public int delete(Connection connection, Customer c)throws SQLException{
        String sql="delete from vendor where customer_id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,c.getID());
        return preparedStatement.executeUpdate();
    }
}
