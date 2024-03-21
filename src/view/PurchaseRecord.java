/*
 * Created by JFormDesigner on Sat Mar 16 19:38:38 GMT+08:00 2024
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
import dao.VendorDao;
import until.DBUntils;
/**
 * @author XuYundi
 */
public class PurchaseRecord extends JFrame {
    public PurchaseRecord() {
        initComponents();
    }
    private VendorDao vendorDao = new VendorDao();
    private OrderDao orderDao = new OrderDao();
    private  int c_id;
    public void receiveValue(int value) { // To get the vendor_id from login
        this.c_id = value;
    }
    private void Viewrecord(ActionEvent e) { // Displays orders that have not yet been evaluated but have been shipped
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
            ResultSet r = orderDao.getorderch(conn,c_id);
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

    private void goodfeedback(ActionEvent e) {
        double score = 0.1;
        int s = 1;
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
            int columnIndex4 = 4;
            int columnIndex8 = 8;
            int rowCount = table1.getRowCount();
            for (int i = 0; i < rowCount; i++) {
                Object value8 = table1.getValueAt(i, columnIndex8);
                if(value8 == null){continue;}
                int value0 = (int) table1.getValueAt(i, columnIndex0);
                int value4 = (int) table1.getValueAt(i, columnIndex4);
                ResultSet r = orderDao.getfeedback(conn,value4);
                if(r.next()){
                   double temp = r.getDouble(1);
                   double newscore = temp + score;
                   vendorDao.updatefeedback(conn,newscore,value4);
                   orderDao.updatefeedbackstatus(conn,value0,s);
                }
            }
            DefaultTableModel model = (DefaultTableModel) table1.getModel();
            model.setRowCount(0);
            ResultSet r = orderDao.getorderch(conn,c_id);
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
            JOptionPane.showMessageDialog(null, "Feedback successfully");

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private void badfeedback(ActionEvent e) {
        double score = -0.1;
        int s = 1;
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
            int columnIndex4 = 4;
            int columnIndex8 = 8;
            int rowCount = table1.getRowCount();
            for (int i = 0; i < rowCount; i++) {
                Object value8 = table1.getValueAt(i, columnIndex8);
                if(value8 == null){continue;}
                int value0 = (int) table1.getValueAt(i, columnIndex0);
                int value4 = (int) table1.getValueAt(i, columnIndex4);
                ResultSet r = orderDao.getfeedback(conn,value4);
                if(r.next()){
                    double temp = r.getDouble(1);
                    double newscore = temp + score;
                    vendorDao.updatefeedback(conn,newscore,value4);
                    orderDao.updatefeedbackstatus(conn,value0,s);
                }
            }
            DefaultTableModel model = (DefaultTableModel) table1.getModel();
            model.setRowCount(0);
            ResultSet r = orderDao.getorderch(conn,c_id);
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
            JOptionPane.showMessageDialog(null, "Feedback successfully");

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private DBUntils dbUntils=new DBUntils();
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        DefaultComponentFactory compFactory = DefaultComponentFactory.getInstance();
        menuBar1 = new JMenuBar();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        title1 = compFactory.createTitle("Please select Record and rate");
        scrollPane2 = new JScrollPane();
        textPane1 = new JTextPane();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);
        setJMenuBar(menuBar1);

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
        scrollPane1.setBounds(10, 10, 740, 290);

        //---- button1 ----
        button1.setText("View record");
        button1.addActionListener(e -> Viewrecord(e));
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(155, 320), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("good feedback");
        button2.addActionListener(e -> goodfeedback(e));
        contentPane.add(button2);
        button2.setBounds(535, 335, 115, button2.getPreferredSize().height);

        //---- button3 ----
        button3.setText(" bad feedback");
        button3.addActionListener(e -> badfeedback(e));
        contentPane.add(button3);
        button3.setBounds(535, 370, 115, 30);
        contentPane.add(title1);
        title1.setBounds(505, 300, 190, 45);

        //======== scrollPane2 ========
        {

            //---- textPane1 ----
            textPane1.setText("Tips: The basic score is 1, the positive review is increased by 0.1, and the bad review is decreased by 0.1");
            scrollPane2.setViewportView(textPane1);
        }
        contentPane.add(scrollPane2);
        scrollPane2.setBounds(310, 315, 180, 105);

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
    private JMenuBar menuBar1;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JLabel title1;
    private JScrollPane scrollPane2;
    private JTextPane textPane1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
