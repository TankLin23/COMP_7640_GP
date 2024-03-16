/*
 * Created by JFormDesigner on Sat Mar 16 16:21:47 GMT+08:00 2024
 */

package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.jgoodies.forms.factories.*;

/**
 * @author XuYundi
 */
public class Customerlogin extends JFrame {
    public Customerlogin() {
        initComponents();
    }

    private void login(ActionEvent e) {
        // TODO add your code here
        //Get the ID number and password
        String CustomerID = formattedTextField1.getText();
        char[] password = passwordField1.getPassword();
        String passwordString = new String(password);

        // After connecting to the database, check whether the ID and password are correct
        CustomerFrame Customer = new CustomerFrame();
        System.out.println(CustomerID);
        System.out.println(passwordString);
        Customer.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        DefaultComponentFactory compFactory = DefaultComponentFactory.getInstance();
        title1 = compFactory.createTitle("Customer login");
        label1 = new JLabel();
        formattedTextField1 = new JFormattedTextField();
        label2 = new JLabel();
        button1 = new JButton();
        passwordField1 = new JPasswordField();

        //======== this ========
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Customer_ID");

        //---- label2 ----
        label2.setText("PassWord");

        //---- button1 ----
        button1.setText("Log in");
        button1.addActionListener(e -> login(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(149, 149, 149)
                            .addComponent(title1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(39, 39, 39)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                            .addGap(5, 5, 5)
                            .addComponent(formattedTextField1, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(49, 49, 49)
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(passwordField1, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(160, 160, 160)
                            .addComponent(button1)))
                    .addGap(164, 164, 164))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(40, 40, 40)
                    .addComponent(title1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(5, 5, 5)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
                        .addComponent(formattedTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(5, 5, 5)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(label2))
                        .addComponent(passwordField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(55, 55, 55)
                    .addComponent(button1)
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel title1;
    private JLabel label1;
    private JFormattedTextField formattedTextField1;
    private JLabel label2;
    private JButton button1;
    private JPasswordField passwordField1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
