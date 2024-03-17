package view;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;
import com.jgoodies.forms.factories.*;
/*
 * Created by JFormDesigner on Thu Mar 14 17:04:44 CST 2024
 */



/**
 * @author 10468
 */
public class CustomerFrame extends JFrame {
    public CustomerFrame() {
        initComponents();
    }

    private void SearchProductName(ActionEvent e) {
        // TODO add your code here
    }

    private void SearchVendorName(ActionEvent e) {
        // TODO add your code here
    }

    private void Buy(ActionEvent e) {
        // TODO add your code here
    }

    private void ViewHistory(ActionEvent e) {
        PurchaseRecord PR = new PurchaseRecord();
        PR.setVisible(true);
    }

    private void ViewOngoingDeals(ActionEvent e) {
        ViewOngoingDeals VOD = new ViewOngoingDeals();
        VOD.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        DefaultComponentFactory compFactory = DefaultComponentFactory.getInstance();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        formattedTextField3 = new JFormattedTextField();
        title3 = compFactory.createTitle("Product name");
        button5 = new JButton();
        formattedTextField4 = new JFormattedTextField();
        title4 = compFactory.createTitle("Vendor name");
        button6 = new JButton();
        title5 = compFactory.createTitle("Please enter the quantity purchased");
        formattedTextField5 = new JFormattedTextField();
        button7 = new JButton();
        button8 = new JButton();
        button9 = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                },
                new String[] {
                    "Product name", "Price", "Inventory", "Location", "Tag", "Vendor", "Buy"
                }
            ) {
                Class<?>[] columnTypes = new Class<?>[] {
                    Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Boolean.class
                };
                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    return columnTypes[columnIndex];
                }
            });
            scrollPane1.setViewportView(table1);
        }

        //---- button5 ----
        button5.setText("Search product name");
        button5.addActionListener(e -> SearchProductName(e));

        //---- button6 ----
        button6.setText("Search vendor name");
        button6.addActionListener(e -> SearchVendorName(e));

        //---- button7 ----
        button7.setText("Buy");
        button7.addActionListener(e -> Buy(e));

        //---- button8 ----
        button8.setText("View History");
        button8.addActionListener(e -> ViewHistory(e));

        //---- button9 ----
        button9.setText("View ongoing deals");
        button9.addActionListener(e -> ViewOngoingDeals(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
                    .addContainerGap())
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(button5, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
                            .addGap(91, 91, 91))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(title3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(formattedTextField3, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(title4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(formattedTextField4, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)))
                            .addGap(58, 58, 58)))
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(title5, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE)
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                .addComponent(formattedTextField5, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(button7))
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(button9, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                .addComponent(button8, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))))
                    .addGap(0, 75, Short.MAX_VALUE))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(147, 147, 147)
                    .addComponent(button6, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(413, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(title3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(formattedTextField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(button5)
                            .addGap(4, 4, 4)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(title4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(formattedTextField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(button6))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(8, 8, 8)
                            .addComponent(title5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(formattedTextField5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(button7))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(button8)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(button9)))
                    .addContainerGap(23, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JScrollPane scrollPane1;
    private JTable table1;
    private JFormattedTextField formattedTextField3;
    private JLabel title3;
    private JButton button5;
    private JFormattedTextField formattedTextField4;
    private JLabel title4;
    private JButton button6;
    private JLabel title5;
    private JFormattedTextField formattedTextField5;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
