package view;

import java.awt.event.*;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Locale;
import java.util.Vector;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;
import com.jgoodies.forms.factories.*;
import dao.ProductDao;
import dao.VendorDao;
import model.Product;
import model.Vendor;
import until.DBUntils;
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
    private ProductDao productDao=new ProductDao();
    private DBUntils dbUntils=new DBUntils();
    private void SearchTag(ActionEvent e) {
        Locale.setDefault(Locale.ENGLISH);
        // Change the default locale for UIManager
        UIManager.put("OptionPane.yesButtonText", "Yes");
        UIManager.put("OptionPane.noButtonText", "No");
        UIManager.put("OptionPane.okButtonText", "OK");
        UIManager.put("OptionPane.cancelButtonText", "Cancel");
        String tag = formattedTextField1.getText();
        Connection conn = null;
        try{
            //try to connect database
            conn=dbUntils.getCon();
            ResultSet r = productDao.get_product_by_tag(conn,tag);
            DefaultTableModel model = (DefaultTableModel) table1.getModel();
            model.setRowCount(0);
            while(r.next()){
                Vector<Serializable> vector = new Vector<>();
                vector.add(r.getString(1));
                vector.add(r.getDouble(2));
                vector.add(r.getInt(3));
                vector.add(r.getString(4));
                vector.add(tag);
                vector.add(r.getString(5));
                vector.add(r.getDouble(6));
                model.addRow(vector);
            }
            table1.setModel(model);


        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }



    private void Buy(ActionEvent e) {

    }

    private void ViewHistory(ActionEvent e) {
        PurchaseRecord PR = new PurchaseRecord();
        PR.setVisible(true);
    }

    private void ViewOngoingDeals(ActionEvent e) {
        ViewOngoingDeals VOD = new ViewOngoingDeals();
        VOD.setVisible(true);
    }

    private void Refresh(ActionEvent e) {
        // TODO add your code here
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        DefaultComponentFactory compFactory = DefaultComponentFactory.getInstance();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        title3 = compFactory.createTitle("Tag");
        button5 = new JButton();
        title5 = compFactory.createTitle("Please enter the quantity purchased");
        formattedTextField5 = new JFormattedTextField();
        button7 = new JButton();
        button8 = new JButton();
        button9 = new JButton();
        formattedTextField1 = new JFormattedTextField();
        button1 = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "Product name", "Price", "Inventory", "Location", "Tag", "Vendor", "Feedback Score", "Buy"
                }
            ) {
                Class<?>[] columnTypes = new Class<?>[] {
                    Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Boolean.class
                };
                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    return columnTypes[columnIndex];
                }
            });
            scrollPane1.setViewportView(table1);
        }

        //---- button5 ----
        button5.setText("Search ");
        button5.addActionListener(e -> SearchTag(e));

        //---- button7 ----
        button7.setText("Buy");
        button7.addActionListener(e -> Buy(e));

        //---- button8 ----
        button8.setText("View History");
        button8.addActionListener(e -> ViewHistory(e));

        //---- button9 ----
        button9.setText("View ongoing deals");
        button9.addActionListener(e -> ViewOngoingDeals(e));

        //---- button1 ----
        button1.setText("Refresh");
        button1.addActionListener(e -> Refresh(e));

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
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(77, 77, 77)
                            .addComponent(title3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(formattedTextField1, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(140, 140, 140)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(button5, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                                .addComponent(button1, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))))
                    .addGap(69, 69, 69)
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
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
                    .addGap(8, 8, 8)
                    .addComponent(title5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(formattedTextField5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button7)
                        .addComponent(title3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(formattedTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button8)
                        .addComponent(button5))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button9)
                        .addComponent(button1))
                    .addContainerGap(37, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel title3;
    private JButton button5;
    private JLabel title5;
    private JFormattedTextField formattedTextField5;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JFormattedTextField formattedTextField1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
