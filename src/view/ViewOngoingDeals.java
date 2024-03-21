/*
 * Created by JFormDesigner on Sat Mar 16 19:41:00 GMT+08:00 2024
 */

package view;

import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Locale;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.*;
import com.jgoodies.forms.factories.*;
import dao.OrderDao;
import model.Customer;
import until.DBUntils;
/**
 * @author XuYundi
 */
public class ViewOngoingDeals extends JFrame {
    public ViewOngoingDeals() {
        initComponents();
    }
    private DBUntils dbUntils=new DBUntils();
    private  int c_id;
    public void receiveValue(int value) { // To get the vendor_id from login
        this.c_id = value;
    }
    private OrderDao orderDao = new OrderDao();
    private void Cancelpurchase(ActionEvent e) {
        Connection conn = null;
        try{ //Cancel unshipped orders
            //try to connect database
            conn=dbUntils.getCon();
            int columnIndex0 = 0;
            int columnIndex8 = 8;
            int rowCount = table1.getRowCount();
            for (int i = 0; i < rowCount; i++) {
                Object value8 = table1.getValueAt(i, columnIndex8);
                if(value8 == null){continue;}
                int value0 = (int) table1.getValueAt(i, columnIndex0);
                orderDao.delete(conn,value0);
                JOptionPane.showMessageDialog(null, "Cancel successfully");
            }

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private void showalldeals(ActionEvent e) {
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
            DefaultTableModel model = (DefaultTableModel) table1.getModel();
            model.setRowCount(0);
            ResultSet r = orderDao.getorderc(conn,c_id);
            while(r.next()){
                Vector<Serializable> vector = new Vector<>();
                vector.add(r.getInt(1));
                vector.add(r.getInt(2));
                vector.add(r.getString(3));
                vector.add(r.getString(4));
                vector.add(r.getInt(5));
                vector.add(r.getInt(6));
                vector.add(r.getDouble(7));
                vector.add(r.getString(8));
                model.addRow(vector);
            }


        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private void Refresh(ActionEvent e) {
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
            DefaultTableModel model = (DefaultTableModel) table1.getModel();
            model.setRowCount(0);
            ResultSet r = orderDao.getorderc(conn,c_id);
            while(r.next()){
                Vector<Serializable> vector = new Vector<>();
                vector.add(r.getInt(1));
                vector.add(r.getInt(2));
                vector.add(r.getString(3));
                vector.add(r.getString(4));
                vector.add(r.getInt(5));
                vector.add(r.getInt(6));
                vector.add(r.getDouble(7));
                vector.add(r.getString(8));
                model.addRow(vector);
            }
            JOptionPane.showMessageDialog(null, "Refresh successfully");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        DefaultComponentFactory compFactory = DefaultComponentFactory.getInstance();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        title1 = compFactory.createTitle("Please select the order you want to cancel");
        button2 = new JButton();
        button3 = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "Order_ID", "Customer_ID", "Status", "Vendor_name", "Vendor_ID", "Quantity", "Price", "Product_name", "Select"
                }
            ) {
                Class<?>[] columnTypes = new Class<?>[] {
                    Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Boolean.class
                };
                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    return columnTypes[columnIndex];
                }
            });
            scrollPane1.setViewportView(table1);
        }

        //---- button1 ----
        button1.setText("Cancel purchase");
        button1.addActionListener(e -> Cancelpurchase(e));

        //---- button2 ----
        button2.setText("Show all orders");
        button2.addActionListener(e -> showalldeals(e));

        //---- button3 ----
        button3.setText("Refresh");
        button3.addActionListener(e -> Refresh(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(4, 4, 4)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 700, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(105, 105, 105)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(title1, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                            .addGap(39, 39, 39))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addComponent(button3, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(button2, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button1)
                            .addGap(147, 147, 147))))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(title1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button1)
                        .addComponent(button2))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(button3)
                    .addContainerGap(19, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    private JLabel title1;
    private JButton button2;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
