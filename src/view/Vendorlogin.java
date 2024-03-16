/*
 * Created by JFormDesigner on Sat Mar 16 16:40:26 GMT+08:00 2024
 */

package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.jgoodies.forms.factories.*;

/**
 * @author XuYundi
 */
public class Vendorlogin extends JFrame {
    public Vendorlogin() {
        initComponents();
    }

    private void login(ActionEvent e) {
        // TODO add your code here
        //Get the ID number and password
        String VendorID = formattedTextField1.getText();
        char[] Vendorpassword = passwordField1.getPassword();
        String VendorpasswordString = new String(Vendorpassword);

        // After connecting to the database, check whether the ID and password are correct
        VendorFrame Vendor = new VendorFrame();
        System.out.println(VendorID);
        System.out.println(VendorpasswordString);
        Vendor.setVisible(true);
    }

    private void Signin(ActionEvent e) {
        // TODO add your code here
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
        contentPane.setLayout(null);
        contentPane.add(title1);
        title1.setBounds(new Rectangle(new Point(165, 85), title1.getPreferredSize()));
        contentPane.add(title2);
        title2.setBounds(75, 115, 65, 17);
        contentPane.add(formattedTextField1);
        formattedTextField1.setBounds(140, 110, 145, formattedTextField1.getPreferredSize().height);
        contentPane.add(title3);
        title3.setBounds(75, 155, 65, 17);
        contentPane.add(passwordField1);
        passwordField1.setBounds(140, 145, 145, passwordField1.getPreferredSize().height);

        //---- button1 ----
        button1.setText("Login");
        button1.addActionListener(e -> login(e));
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(75, 190), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("Sign in");
        button2.addActionListener(e -> Signin(e));
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(265, 190), button2.getPreferredSize()));

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
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
