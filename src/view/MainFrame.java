package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Thu Mar 14 14:51:02 CST 2024
 */



/**
 * @author 10468
 */
public class MainFrame extends JFrame {
    public MainFrame() {
        initComponents();

    }


    private void CustomerMouseClicked(MouseEvent e) {
        // TODO add your code here
        Customerlogin Customer = new Customerlogin();
        Customer.setVisible(true);
    }

    private void Vendor(ActionEvent e) {
        // TODO add your code here
        Vendorlogin Vendor = new Vendorlogin();
        Vendor.setVisible(true);
        dispose();
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        title = new JLabel();
        Customer = new JButton();
        Vendor = new JButton();
        title2 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();

        //---- title ----
        title.setText("    Vendor-Customer Management System");

        //---- Customer ----
        Customer.setText("Customer");
        Customer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CustomerMouseClicked(e);
            }
        });

        //---- Vendor ----
        Vendor.setText("Vendor");
        Vendor.addActionListener(e -> Vendor(e));

        //---- title2 ----
        title2.setText("              Please select your identity");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(43, 43, 43)
                    .addComponent(Customer)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                    .addComponent(Vendor, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                    .addGap(53, 53, 53))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(63, 63, 63)
                    .addComponent(title, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(73, Short.MAX_VALUE)
                    .addComponent(title2, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
                    .addGap(65, 65, 65))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(17, 17, 17)
                    .addComponent(title, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                    .addComponent(title2, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                    .addGap(32, 32, 32)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(Customer)
                        .addComponent(Vendor))
                    .addGap(36, 36, 36))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel title;
    private JButton Customer;
    private JButton Vendor;
    private JLabel title2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
