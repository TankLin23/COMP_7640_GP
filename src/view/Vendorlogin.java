/*
 * Created by JFormDesigner on Sat Mar 16 16:40:26 GMT+08:00 2024
 */

package view;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.util.Locale;
import javax.swing.*;
import com.jgoodies.forms.factories.*;
import dao.CustomerDao;
import dao.VendorDao;
import model.Customer;
import model.Vendor;
import until.StringUtil;
import until.DBUntils;

/**
 * @author XuYundi
 */
public class Vendorlogin extends JFrame {
    public Vendorlogin() {
        initComponents();
    }
    private VendorDao vendorDao=new VendorDao();
    private DBUntils dbUntils=new DBUntils();
    private void login(ActionEvent e) {
        //Get the ID number and password
        String VendorID = formattedTextField1.getText();
        char[] Vendorpassword = passwordField1.getPassword();
        String VendorpasswordString = new String(Vendorpassword);
        Locale.setDefault(Locale.ENGLISH);

        // Change the default locale for UIManager
        UIManager.put("OptionPane.yesButtonText", "Yes");
        UIManager.put("OptionPane.noButtonText", "No");
        UIManager.put("OptionPane.okButtonText", "OK");
        UIManager.put("OptionPane.cancelButtonText", "Cancel");

        // After connecting to the database, check whether the ID and password are correct
        //System.out.println(VendorID);
        //System.out.println(VendorpasswordString);
        if(StringUtil.isEmpty(VendorID)){
            JOptionPane.showMessageDialog(null,"ID cannot be null");
            return;
        }
        if (StringUtil.isEmpty(VendorpasswordString)){
            JOptionPane.showMessageDialog(null,"Password cannot be null");
            return;
        }
        Vendor vendor=new Vendor(VendorID,VendorpasswordString);
        Connection conn = null;
        try{
            //try to connect database
            conn=dbUntils.getCon();
            //verify the ID and password
            Vendor currentVendor= vendorDao.login(conn,vendor);
            if (currentVendor!=null){
                dispose();
                VendorFrame Vendor = new VendorFrame();
                Vendor.receiveValue(VendorID);
                Vendor.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(null, "The ID or password is incorrect");
                return;
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    private void Signin(ActionEvent e) {
        dispose();
        VendorSignin VS = new VendorSignin();
        VS.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        DefaultComponentFactory compFactory = DefaultComponentFactory.getInstance();
        title1 = compFactory.createTitle("Vendor Login");
        title2 = compFactory.createTitle("Vendor_ID");
        formattedTextField1 = new JFormattedTextField();
        title3 = compFactory.createTitle("PassWord");
        passwordField1 = new JPasswordField();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //---- button1 ----
        button1.setText("Login");
        button1.addActionListener(e -> login(e));

        //---- button2 ----
        button2.setText("Sign in");
        button2.addActionListener(e -> Signin(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(164, 164, 164)
                            .addComponent(title1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(74, 74, 74)
                            .addComponent(title2, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(formattedTextField1, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(74, 74, 74)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(title3, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0)
                                    .addComponent(passwordField1, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(button1)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                                    .addComponent(button2)))))
                    .addGap(81, 81, 81))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(55, 55, 55)
                    .addComponent(title1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(8, 8, 8)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(5, 5, 5)
                            .addComponent(title2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addComponent(formattedTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(5, 5, 5)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(title3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addComponent(passwordField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button1)
                        .addComponent(button2))
                    .addGap(53, 53, 53))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel title1;
    private JLabel title2;
    private JFormattedTextField formattedTextField1;
    private JLabel title3;
    private JPasswordField passwordField1;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
