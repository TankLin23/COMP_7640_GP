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
        contentPane.setLayout(null);
        contentPane.add(title1);
        title1.setBounds(new Rectangle(new Point(150, 70), title1.getPreferredSize()));

        //---- label1 ----
        label1.setText("Customer_ID");
        contentPane.add(label1);
        label1.setBounds(40, 110, 75, 20);
        contentPane.add(formattedTextField1);
        formattedTextField1.setBounds(120, 105, 145, formattedTextField1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("PassWord");
        contentPane.add(label2);
        label2.setBounds(50, 150, 60, 17);

        //---- button1 ----
        button1.setText("Log in");
        button1.addActionListener(e -> login(e));
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(155, 185), button1.getPreferredSize()));
        contentPane.add(passwordField1);
        passwordField1.setBounds(120, 140, 145, passwordField1.getPreferredSize().height);

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
    private JLabel label1;
    private JFormattedTextField formattedTextField1;
    private JLabel label2;
    private JButton button1;
    private JPasswordField passwordField1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
