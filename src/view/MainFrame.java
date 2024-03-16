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
        System.out.println("Costomer");
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        title = new JLabel();
        Customer = new JButton();
        Vendor = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //---- title ----
        title.setText("Vendor-Customer Management System");

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

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(55, 55, 55)
                    .addComponent(title, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(83, Short.MAX_VALUE))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(43, 43, 43)
                    .addComponent(Customer)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                    .addComponent(Vendor, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                    .addGap(53, 53, 53))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addComponent(title, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
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
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
