package view;

import java.awt.event.*;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Vector;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.DefaultTableModel;

import com.jgoodies.forms.factories.*;
import dao.OrderDao;
import dao.ProductDao;
import dao.VendorDao;
import model.Product;
import model.Vendor;
import until.DBUntils;
/*
 * Created by JFormDesigner on Fri Mar 15 16:38:41 CST 2024
 */



/**
 * @author 10468
 */
public class VendorFrame extends JFrame {
    public VendorFrame() {
        initComponents();
    }
    private String vid;
    private ProductDao productDao=new ProductDao();
    private DBUntils dbUntils=new DBUntils();

    public void receiveValue(String value) { // To get the vendor_id from login
        this.vid = value;
    }
    private void Add(ActionEvent e){ // add new product
        Locale.setDefault(Locale.ENGLISH);
        // Change the default locale for UIManager
        UIManager.put("OptionPane.yesButtonText", "Yes");
        UIManager.put("OptionPane.noButtonText", "No");
        UIManager.put("OptionPane.okButtonText", "OK");
        UIManager.put("OptionPane.cancelButtonText", "Cancel");
        Connection conn = null;
        String productname = productnametext.getText();
        String quantityofproduct = quantitytext.getText();
        String price = pricetext.getText();
        String tag1 = tag1textfield.getText();
        String tag2 = tag2text.getText();
        String tag3 = tag3text.getText();
        if(productname == null ||quantityofproduct==null||price==null||tag1==null||tag2==null||tag3==null){
            JOptionPane.showMessageDialog(null, "Null is not allowed!");
            return;
        }
        int quantity = Integer.parseInt(quantityofproduct);
        double p =Double.parseDouble(price);
        Product product = new Product(this.vid,productname,p,tag1,tag2,tag3,quantity);
        try{
            //try to connect database
            conn=dbUntils.getCon();
            productDao.add(conn,product);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    private void Vieworder(ActionEvent e) {
        // TODO add your code here
        VendorOrder VO = new VendorOrder();
        VO.receiveValue(Integer.parseInt(vid));
        VO.setVisible(true);
    }

    private void viewproduct(ActionEvent e) { // vendor view products which belong themselves
        Connection conn = null;
        try{     //Connect to the database and display the content
            conn=dbUntils.getCon();
            ProductDao Query = new ProductDao();
            ResultSet r = Query.checkprocuct(conn,this.vid);
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(new Object[]{"product_id", "vendor_id", "product_name", "product_price","Tag1","Tag2","Tag3","product_quantity"});
            while (r.next()) {
                Vector<Serializable> vector = new Vector<>();
                vector.add(r.getInt(1));
                vector.add(r.getInt(2));
                vector.add(r.getString(3));
                vector.add(r.getFloat(4));
                vector.add(r.getString(5));
                vector.add(r.getString(6));
                vector.add(r.getString(7));
                vector.add(r.getInt(8));
                model.addRow(vector);
            }
            table1.setModel(model);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private void Historicalrecord(ActionEvent e) {
        Vhistory VH = new Vhistory();
        VH.receiveValue(Integer.parseInt(vid));
        VH.setVisible(true);
    }

    private void update(ActionEvent e) {
        if(formattedTextField7.getText()==null||formattedTextField8.getText()==null||formattedTextField9.getText()==null){
            JOptionPane.showMessageDialog(null, "Null is not allowed!");
            return;
        }
        int pid = Integer.parseInt(formattedTextField7.getText());
        double price = Double.parseDouble(formattedTextField8.getText());
        int quantity = Integer.parseInt(formattedTextField9.getText());
        Connection conn = null;
        try{     //Connect to the database and display the content
            conn=dbUntils.getCon();
            productDao.updatepriceandquantity(conn,pid,price,quantity);
            ProductDao Query = new ProductDao();
            ResultSet r = Query.checkprocuct(conn,this.vid);
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(new Object[]{"product_id", "vendor_id", "product_name", "product_price","Tag1","Tag2","Tag3","product_quantity"});
            while (r.next()) {
                Vector<Serializable> vector = new Vector<>();
                vector.add(r.getInt(1));
                vector.add(r.getInt(2));
                vector.add(r.getString(3));
                vector.add(r.getFloat(4));
                vector.add(r.getString(5));
                vector.add(r.getString(6));
                vector.add(r.getString(7));
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
        button1 = new JButton();
        button2 = new JButton();
        title2 = compFactory.createTitle("Product name");
        productnametext = new JFormattedTextField();
        title3 = compFactory.createTitle("Quantity of product");
        quantitytext = new JFormattedTextField();
        title4 = compFactory.createTitle("Unit price of product");
        pricetext = new JFormattedTextField();
        button3 = new JButton();
        title1 = compFactory.createTitle("Tag1");
        tag1textfield = new JFormattedTextField();
        title5 = compFactory.createTitle("Tag2");
        tag2text = new JFormattedTextField();
        title6 = compFactory.createTitle("Tag3");
        tag3text = new JFormattedTextField();
        button4 = new JButton();
        title7 = compFactory.createTitle("product_id");
        formattedTextField7 = new JFormattedTextField();
        title8 = compFactory.createTitle("new price");
        formattedTextField8 = new JFormattedTextField();
        title9 = compFactory.createTitle("new quantity");
        textArea1 = new JTextArea();
        formattedTextField9 = new JFormattedTextField();
        button5 = new JButton();
        title10 = compFactory.createTitle("Please enter the value you want to change below");

        //======== this ========
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }

        //---- button1 ----
        button1.setText("Add");
        button1.addActionListener(e -> Add(e));

        //---- button2 ----
        button2.setText("View order");
        button2.addActionListener(e -> Vieworder(e));

        //---- button3 ----
        button3.setText("View Product");
        button3.addActionListener(e -> viewproduct(e));

        //---- button4 ----
        button4.setText("Historical record");
        button4.addActionListener(e -> Historicalrecord(e));

        //---- button5 ----
        button5.setText("update");
        button5.addActionListener(e -> update(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(11, 11, 11)
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addGroup(contentPaneLayout.createParallelGroup()
                                                .addGroup(contentPaneLayout.createSequentialGroup()
                                                    .addGap(21, 21, 21)
                                                    .addComponent(title2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(32, 32, 32)
                                                    .addComponent(productnametext, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(contentPaneLayout.createSequentialGroup()
                                                    .addComponent(title4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(pricetext, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(contentPaneLayout.createSequentialGroup()
                                                    .addGap(1, 1, 1)
                                                    .addComponent(title3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(quantitytext, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)))
                                            .addGap(31, 31, 31)
                                            .addGroup(contentPaneLayout.createParallelGroup()
                                                .addComponent(title6, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(title1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(title5, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                                            .addGap(31, 31, 31)
                                            .addGroup(contentPaneLayout.createParallelGroup()
                                                .addComponent(tag1textfield, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(tag3text, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(tag2text, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
                                            .addGap(18, 18, 18)
                                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addComponent(title7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addGap(10, 10, 10)
                                            .addComponent(formattedTextField7, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
                                            .addGap(29, 29, 29)
                                            .addComponent(title8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(formattedTextField8, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(title9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(formattedTextField9, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(24, 24, 24)
                                    .addComponent(title10, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(153, 153, 153)
                                    .addComponent(textArea1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 53, Short.MAX_VALUE))
                                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                                            .addComponent(button5, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                                            .addGap(0, 0, Short.MAX_VALUE)
                                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(button2, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                                                .addComponent(button3, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                                                .addComponent(button4, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))))
                                    .addGap(32, 32, 32))))
                        .addComponent(scrollPane1, GroupLayout.Alignment.TRAILING))
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(button3, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(button2, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(button4))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(title2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(productnametext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(title1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tag1textfield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addGap(13, 13, 13)
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(title3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(quantitytext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(title5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tag2text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(pricetext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(title4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addComponent(tag3text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(title6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                                .addComponent(button1, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(textArea1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(title10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(button5)
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(title7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(formattedTextField7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(title8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(formattedTextField8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(title9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(formattedTextField9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(31, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    private JButton button2;
    private JLabel title2;
    private JFormattedTextField productnametext;
    private JLabel title3;
    private JFormattedTextField quantitytext;
    private JLabel title4;
    private JFormattedTextField pricetext;
    private JButton button3;
    private JLabel title1;
    private JFormattedTextField tag1textfield;
    private JLabel title5;
    private JFormattedTextField tag2text;
    private JLabel title6;
    private JFormattedTextField tag3text;
    private JButton button4;
    private JLabel title7;
    private JFormattedTextField formattedTextField7;
    private JLabel title8;
    private JFormattedTextField formattedTextField8;
    private JLabel title9;
    private JTextArea textArea1;
    private JFormattedTextField formattedTextField9;
    private JButton button5;
    private JLabel title10;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
