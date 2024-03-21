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
import dao.OrderDao;
import dao.ProductDao;
import dao.VendorDao;
import model.Order;
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
    private int cid;
    public void receiveValue(int value) { // To get the vendor_id from login
        this.cid = value;
    }
    private ProductDao productDao=new ProductDao();
    private OrderDao orderDao = new OrderDao();


    private DBUntils dbUntils=new DBUntils();

 //   public static boolean isNumber(Object obj) { //Determine whether the input is a number
        //return obj instanceof Number;
   // }
    private void SearchTag(ActionEvent e) { // search Tag
        Locale.setDefault(Locale.ENGLISH);
        // Change the default locale for UIManager
        UIManager.put("OptionPane.yesButtonText", "Yes");
        UIManager.put("OptionPane.noButtonText", "No");
        UIManager.put("OptionPane.okButtonText", "OK");
        UIManager.put("OptionPane.cancelButtonText", "Cancel");
        String tag = formattedTextField1.getText();
        if(tag == null){
            JOptionPane.showMessageDialog(null, "Tag is null,Please enter Tag");
            return;
        }
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
                vector.add(r.getInt(6));
                vector.add(r.getDouble(7));
                vector.add(r.getInt(8));
                model.addRow(vector);
            }
            table1.setModel(model);


        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }



    private void Buy(ActionEvent e) {
        String status = "unshipped";
        int feedbackStatus = 0;
        Connection conn = null;
        Locale.setDefault(Locale.ENGLISH);
        // Change the default locale for UIManager
        UIManager.put("OptionPane.yesButtonText", "Yes");
        UIManager.put("OptionPane.noButtonText", "No");
        UIManager.put("OptionPane.okButtonText", "OK");
        UIManager.put("OptionPane.cancelButtonText", "Cancel");
        try{
            //try to connect database
            conn=dbUntils.getCon();
            int columnIndex0 = 0;
            int columnIndex1 = 1;
            int columnIndex2 = 2;
            int columnIndex3 = 3;
            int columnIndex4 = 4;
            int columnIndex5 = 5;
            int columnIndex6 = 6;
            int columnIndex7 = 7;
            int columnIndex8 = 8;
            int columnIndex9 = 9;
            int columnIndex10 =10;
            int rowCount = table1.getRowCount();
            for (int i = 0; i < rowCount; i++) {
                int flag = 0;
                Object value9 = table1.getValueAt(i, columnIndex9);
                if(value9==null){continue;}
                if((boolean)value9){
                    Object value0 = table1.getValueAt(i, columnIndex0);
                    Object value1 = table1.getValueAt(i, columnIndex1);
                    Object value2 = table1.getValueAt(i, columnIndex2);
                    Object value3 = table1.getValueAt(i, columnIndex3);
                    Object value4 = table1.getValueAt(i, columnIndex4);
                    Object value5 = table1.getValueAt(i, columnIndex5);
                    Object value6 = table1.getValueAt(i, columnIndex6);
                    Object value7 = table1.getValueAt(i, columnIndex7);
                    Object value8 = table1.getValueAt(i, columnIndex8);
                    int value10 = (int) table1.getValueAt(i, columnIndex10);
                    if((int)value2 < value10){ // Determine if the quantity exceeds the inventory
                        JOptionPane.showMessageDialog(null, "Purchase quantity exceeds stock quantity please re-enter or Please enter quantity");
                        return;
                    }
                    else{
                        double temp = (int)value10 * (double)value1;
                        Order order = new Order(this.cid,status,(String) value5,(int) value6,(String) value0,(int) value10,temp,feedbackStatus);
                        orderDao.add(conn,order); // update order
                        flag = (int)value2-(int)value10;
                        productDao.updateinventory(conn,flag,(int)value8);// update inventory
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Successful purchase");
            //return;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private void ViewHistory(ActionEvent e) {
        PurchaseRecord PR = new PurchaseRecord();
        PR.receiveValue(cid);
        PR.setVisible(true);
    }

    private void ViewOngoingDeals(ActionEvent e) {
        ViewOngoingDeals VOD = new ViewOngoingDeals();
        VOD.receiveValue(this.cid);
        VOD.setVisible(true);
    }

    private void Refresh(ActionEvent e) {
        // TODO add your code here
    }

    private void refresh(ActionEvent e) { // refresh table
        Locale.setDefault(Locale.ENGLISH);
        // Change the default locale for UIManager
        UIManager.put("OptionPane.yesButtonText", "Yes");
        UIManager.put("OptionPane.noButtonText", "No");
        UIManager.put("OptionPane.okButtonText", "OK");
        UIManager.put("OptionPane.cancelButtonText", "Cancel");
        String tag = formattedTextField1.getText();
        if(tag == null){
            JOptionPane.showMessageDialog(null, "Tag is null,Please enter Tag");
            return;
        }
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
                vector.add(r.getInt(6));
                vector.add(r.getDouble(7));
                vector.add(r.getInt(8));
                model.addRow(vector);
            }
            table1.setModel(model);


        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        DefaultComponentFactory compFactory = DefaultComponentFactory.getInstance();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        title3 = compFactory.createTitle("Tag");
        button5 = new JButton();
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
                    "Product name", "Price", "Inventory", "Location", "Tag", "Vendor", "Vendor ID", "Feedback Score", "Product_id", "Buy", "Quantity"
                }
            ) {
                Class<?>[] columnTypes = new Class<?>[] {
                    Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Boolean.class, Integer.class
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
        button1.addActionListener(e -> refresh(e));

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
                    .addGap(127, 127, 127)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(button9, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                        .addComponent(button8, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                        .addComponent(button7, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                    .addGap(0, 104, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
                    .addGap(31, 31, 31)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(title3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(formattedTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button7))
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
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JFormattedTextField formattedTextField1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
