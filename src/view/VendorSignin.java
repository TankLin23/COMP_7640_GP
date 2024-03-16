/*
 * Created by JFormDesigner on Sat Mar 16 16:56:07 GMT+08:00 2024
 */

package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.jgoodies.forms.factories.*;

/**
 * @author XuYundi
 */
public class VendorSignin extends JFrame {
    public VendorSignin() {
        initComponents();
    }

    private void QueryVendorIDList(ActionEvent e) {
        // TODO add your code here
        //Query the Vendor ID list after connecting to the database
    }

    private void submit(ActionEvent e) {
        // TODO add your code here
        // Commit to the database after connecting to the database
        String NewVendorID = formattedTextField1.getText();
        char[] NewVendorpassword = passwordField1.getPassword();
        String NewVendorpasswordString = new String(NewVendorpassword);
        System.out.println(NewVendorID);
        System.out.println(NewVendorpasswordString);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        DefaultComponentFactory compFactory = DefaultComponentFactory.getInstance();
        button1 = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        title1 = compFactory.createTitle("Your New ID");
        formattedTextField1 = new JFormattedTextField();
        title2 = compFactory.createTitle("Your PassWord");
        passwordField1 = new JPasswordField();
        button2 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- button1 ----
        button1.setText("Querying existing VendorID");
        button1.addActionListener(e -> QueryVendorIDList(e));
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(255, 165), button1.getPreferredSize()));

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(10, 5, 440, 150);
        contentPane.add(title1);
        title1.setBounds(20, 230, 75, title1.getPreferredSize().height);
        contentPane.add(formattedTextField1);
        formattedTextField1.setBounds(105, 225, 125, formattedTextField1.getPreferredSize().height);
        contentPane.add(title2);
        title2.setBounds(10, 265, 100, 17);
        contentPane.add(passwordField1);
        passwordField1.setBounds(105, 260, 125, passwordField1.getPreferredSize().height);

        //---- button2 ----
        button2.setText("submit");
        button2.addActionListener(e -> submit(e));
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(255, 240), button2.getPreferredSize()));

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
    private JButton button1;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel title1;
    private JFormattedTextField formattedTextField1;
    private JLabel title2;
    private JPasswordField passwordField1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
