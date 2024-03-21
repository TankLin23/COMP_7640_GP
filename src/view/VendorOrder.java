/*
 * Created by JFormDesigner on Sat Mar 16 19:34:50 GMT+08:00 2024
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
import until.DBUntils;

/**
 * @author XuYundi
 */
public class VendorOrder extends JFrame {
    public VendorOrder() {
        initComponents();
    }
    private DBUntils dbUntils=new DBUntils();
    private  int v_id;
    public void receiveValue(int value) { // To get the vendor_id from login
        this.v_id = value;
    }

    private void Delivergoods(ActionEvent e) {
        String status = "shipped";
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
                orderDao.update(conn,value0,status);
            }
            DefaultTableModel model = (DefaultTableModel) table1.getModel();
            model.setRowCount(0);
            ResultSet r = orderDao.getorderv(conn,v_id);
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
            JOptionPane.showMessageDialog(null, "Deliver successfully");
        }catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private void Viewactivetradingorders(ActionEvent e) {
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
            ResultSet r = orderDao.getorderv(conn,v_id);
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
        try{
            //try to connect database
            conn=dbUntils.getCon();
            Locale.setDefault(Locale.ENGLISH);
            // Change the default locale for UIManager
            UIManager.put("OptionPane.yesButtonText", "Yes");
            UIManager.put("OptionPane.noButtonText", "No");
            UIManager.put("OptionPane.okButtonText", "OK");
            UIManager.put("OptionPane.cancelButtonText", "Cancel");
            DefaultTableModel model = (DefaultTableModel) table1.getModel();
            model.setRowCount(0);
            ResultSet r = orderDao.getorderv(conn,v_id);
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
    private OrderDao orderDao = new OrderDao();
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        DefaultComponentFactory compFactory = DefaultComponentFactory.getInstance();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        button2 = new JButton();
        button4 = new JButton();
        title1 = compFactory.createTitle("Please check the order to be shipped in the table");

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

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
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(20, 10, 615, 205);

        //---- button1 ----
        button1.setText("Deliver goods");
        button1.addActionListener(e -> Delivergoods(e));
        contentPane.add(button1);
        button1.setBounds(415, 265, 125, 45);

        //---- button2 ----
        button2.setText("View active trading orders");
        button2.addActionListener(e -> Viewactivetradingorders(e));
        contentPane.add(button2);
        button2.setBounds(85, 235, 165, 45);

        //---- button4 ----
        button4.setText("Refresh");
        button4.addActionListener(e -> Refresh(e));
        contentPane.add(button4);
        button4.setBounds(85, 285, 165, 45);
        contentPane.add(title1);
        title1.setBounds(330, 220, 300, 50);

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
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    private JButton button2;
    private JButton button4;
    private JLabel title1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
