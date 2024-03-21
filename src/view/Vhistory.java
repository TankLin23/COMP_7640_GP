/*
 * Created by JFormDesigner on Thu Mar 21 15:00:27 GMT+08:00 2024
 */

package view;

import dao.OrderDao;
import until.DBUntils;

import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Locale;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author XuYundi
 */
public class Vhistory extends JFrame {
    public Vhistory() {
        initComponents();
    }
    private DBUntils dbUntils=new DBUntils();
    private OrderDao orderDao = new OrderDao();
    private int vid;
    public void receiveValue(int value) { // To get the vendor_id from VendorFrame
        this.vid = value;
    }
    private void check(ActionEvent e) {
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
            ResultSet r = orderDao.getVhistory(conn,vid);
            while(r.next()){
                Vector<Serializable> vector = new Vector<>();
                vector.add(r.getInt(1));
                vector.add(r.getInt(2));
                vector.add(r.getString(3));
                vector.add(r.getString(4));
                vector.add(vid);
                vector.add(r.getInt(5));
                vector.add(r.getDouble(6));
                vector.add(r.getString(7));
                vector.add(r.getDouble(8));
                model.addRow(vector);
            }


        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        scrollPane2 = new JScrollPane();
        textPane1 = new JTextPane();

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
                    "Order_ID", "Customer_ID", "Status", "Vendor_name", "Vendor_ID", "Quantity", "Price", "Product_name", "Feedback_score_now"
                }
            ));
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(10, 5, 650, 185);

        //---- button1 ----
        button1.setText("check");
        button1.addActionListener(e -> check(e));
        contentPane.add(button1);
        button1.setBounds(425, 230, button1.getPreferredSize().width, 40);

        //======== scrollPane2 ========
        {

            //---- textPane1 ----
            textPane1.setText("Tips: The basic score is 1, the positive review is increased by 0.1, and the bad review is decreased by 0.1");
            scrollPane2.setViewportView(textPane1);
        }
        contentPane.add(scrollPane2);
        scrollPane2.setBounds(230, 210, 150, 95);

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
    private JScrollPane scrollPane2;
    private JTextPane textPane1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
