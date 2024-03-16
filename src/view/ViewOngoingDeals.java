/*
 * Created by JFormDesigner on Sat Mar 16 19:41:00 GMT+08:00 2024
 */

package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author XuYundi
 */
public class ViewOngoingDeals extends JFrame {
    public ViewOngoingDeals() {
        initComponents();
    }

    private void Cancelpurchase(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }

        //---- button1 ----
        button1.setText("Cancel purchase");
        button1.addActionListener(e -> Cancelpurchase(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(4, 4, 4)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 700, GroupLayout.PREFERRED_SIZE))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(509, 509, 509)
                    .addComponent(button1))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
                    .addGap(30, 30, 30)
                    .addComponent(button1))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
