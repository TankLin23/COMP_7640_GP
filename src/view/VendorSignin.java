/*
 * Created by JFormDesigner on Sat Mar 16 16:56:07 GMT+08:00 2024
 */

package view;

import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import model.Customer;
import until.DBUntils;
import com.jgoodies.forms.factories.*;
import dao.VendorDao;
import model.Vendor;

/**
 * @author XuYundi
 */

public class VendorSignin extends JFrame {
    public VendorSignin() {
        initComponents();
    }
    private DBUntils dbUntils=new DBUntils();
    private void QueryVendorIDList(ActionEvent e) throws Exception {

    }

    private void submit(ActionEvent e) {
        int flag = 0; // If the bussiness name is the same, set it to 1 to avoid database entry
        // The new Vendor registers and saves the data to the database
        Connection conn = null;
        try{     //Connect to the database and display the content
            conn=dbUntils.getCon();
            VendorDao Query = new VendorDao();
            ResultSet r = Query.checkvendor(conn);
            String Businessname = formattedTextField2.getText();
            char[] NewVendorpassword = passwordField1.getPassword();
            String NewVendorpasswordString = new String(NewVendorpassword);
            String location = formattedTextField3.getText();
            double feedbackscore = 1.0;
            VendorDao Queryexist = new VendorDao();
            ResultSet record = Queryexist.checkvendor(conn);
            while (record.next()){
                String temp = record.getString(2);
                if (temp.equals(Businessname)){ // Check whether the business name is the same
                    dispose();
                    dialog1.setLocationRelativeTo(null);
                    dialog1.setModal(true);
                    dialog1.setVisible(true);
                    flag = 1;
                    break;
                }
            }
            if(flag != 1){
                Vendor vendor = new Vendor(Businessname,feedbackscore,location,NewVendorpasswordString);
                Queryexist.add(conn,vendor); // Store the new registration information in the database
                ResultSet recordofbusinessname = Queryexist.getnewID(conn,vendor);
                dispose();
                if(recordofbusinessname.next()){ // Display ID
                    String mid = String.valueOf(recordofbusinessname.getInt(1));
                    textField1.setText(mid);
                }
                dispose();
                dialog2.setLocationRelativeTo(null);
                dialog2.setModal(true);
                dialog2.setVisible(true);
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    private void Queryexistvendor(ActionEvent e) {
        //Query the Vendor  list
        Connection conn = null;
        try{     //Connect to the database and display the content
            conn=dbUntils.getCon();
            VendorDao Query = new VendorDao();
            ResultSet r = Query.checkvendor(conn);
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(new Object[]{"vendor_id", "business_name", "feedback_score", "geographical_presence"});
            while (r.next()) {
                Vector<Serializable> vector = new Vector<>();
                vector.add(r.getInt(1));
                vector.add(r.getString(2));
                vector.add(r.getFloat(3));
                vector.add(r.getString(4));
                model.addRow(vector);
            }
            table1.setModel(model);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    private void backtoVendorSignin(ActionEvent e) { // If the business name is repeated, the registration page is displayed again
        dialog1.setVisible(false);
        VendorSignin VS = new VendorSignin();
        VS.setVisible(true);
    }

    private void gotoVendorLogin(ActionEvent e) {
        dialog2.setVisible(false);
        Vendorlogin vl = new Vendorlogin();
        vl.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        DefaultComponentFactory compFactory = DefaultComponentFactory.getInstance();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        title2 = compFactory.createTitle("Your PassWord");
        passwordField1 = new JPasswordField();
        button2 = new JButton();
        button1 = new JButton();
        title3 = compFactory.createTitle("Your business name");
        formattedTextField2 = new JFormattedTextField();
        title4 = compFactory.createTitle("Your location");
        formattedTextField3 = new JFormattedTextField();
        dialog1 = new JDialog();
        title5 = compFactory.createTitle("business name duplication");
        button3 = new JButton();
        dialog2 = new JDialog();
        title6 = compFactory.createTitle("Congratulations on your registration, your ID is:");
        button4 = new JButton();
        textField1 = new JTextField();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(10, 5, 440, 150);
        contentPane.add(title2);
        title2.setBounds(15, 220, 100, 17);
        contentPane.add(passwordField1);
        passwordField1.setBounds(125, 215, 125, passwordField1.getPreferredSize().height);

        //---- button2 ----
        button2.setText("submit");
        button2.addActionListener(e -> submit(e));
        contentPane.add(button2);
        button2.setBounds(275, 245, 110, button2.getPreferredSize().height);

        //---- button1 ----
        button1.setText("Search existing vendors");
        button1.addActionListener(e -> Queryexistvendor(e));
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(160, 165), button1.getPreferredSize()));
        contentPane.add(title3);
        title3.setBounds(new Rectangle(new Point(0, 255), title3.getPreferredSize()));
        contentPane.add(formattedTextField2);
        formattedTextField2.setBounds(125, 250, 125, 30);
        contentPane.add(title4);
        title4.setBounds(new Rectangle(new Point(20, 290), title4.getPreferredSize()));
        contentPane.add(formattedTextField3);
        formattedTextField3.setBounds(125, 285, 125, 30);

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

        //======== dialog1 ========
        {
            var dialog1ContentPane = dialog1.getContentPane();
            dialog1ContentPane.setLayout(null);
            dialog1ContentPane.add(title5);
            title5.setBounds(60, 55, 200, title5.getPreferredSize().height);

            //---- button3 ----
            button3.setText("OK");
            button3.addActionListener(e -> backtoVendorSignin(e));
            dialog1ContentPane.add(button3);
            button3.setBounds(new Rectangle(new Point(100, 95), button3.getPreferredSize()));

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < dialog1ContentPane.getComponentCount(); i++) {
                    Rectangle bounds = dialog1ContentPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = dialog1ContentPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                dialog1ContentPane.setMinimumSize(preferredSize);
                dialog1ContentPane.setPreferredSize(preferredSize);
            }
            dialog1.pack();
            dialog1.setLocationRelativeTo(dialog1.getOwner());
        }

        //======== dialog2 ========
        {
            var dialog2ContentPane = dialog2.getContentPane();
            dialog2ContentPane.setLayout(null);
            dialog2ContentPane.add(title6);
            title6.setBounds(15, 35, 280, 30);

            //---- button4 ----
            button4.setText("OK");
            button4.addActionListener(e -> gotoVendorLogin(e));
            dialog2ContentPane.add(button4);
            button4.setBounds(new Rectangle(new Point(110, 120), button4.getPreferredSize()));
            dialog2ContentPane.add(textField1);
            textField1.setBounds(45, 70, 215, textField1.getPreferredSize().height);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < dialog2ContentPane.getComponentCount(); i++) {
                    Rectangle bounds = dialog2ContentPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = dialog2ContentPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                dialog2ContentPane.setMinimumSize(preferredSize);
                dialog2ContentPane.setPreferredSize(preferredSize);
            }
            dialog2.pack();
            dialog2.setLocationRelativeTo(dialog2.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel title2;
    private JPasswordField passwordField1;
    private JButton button2;
    private JButton button1;
    private JLabel title3;
    private JFormattedTextField formattedTextField2;
    private JLabel title4;
    private JFormattedTextField formattedTextField3;
    private JDialog dialog1;
    private JLabel title5;
    private JButton button3;
    private JDialog dialog2;
    private JLabel title6;
    private JButton button4;
    private JTextField textField1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
