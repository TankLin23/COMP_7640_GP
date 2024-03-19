package view;

import java.awt.event.*;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.DefaultTableModel;

import com.jgoodies.forms.factories.*;
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
        Connection conn = null;
        String productname = formattedTextField3.getText();
        String quantityofproduct = formattedTextField4.getText();
        String price = formattedTextField5.getText();
        String tag1 = formattedTextField1.getText();
        String tag2 = formattedTextField2.getText();
        String tag3 = formattedTextField6.getText();
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

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        DefaultComponentFactory compFactory = DefaultComponentFactory.getInstance();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        button2 = new JButton();
        title2 = compFactory.createTitle("Product name");
        formattedTextField3 = new JFormattedTextField();
        title3 = compFactory.createTitle("Quantity of product");
        formattedTextField4 = new JFormattedTextField();
        title4 = compFactory.createTitle("Unit price of product");
        formattedTextField5 = new JFormattedTextField();
        button3 = new JButton();
        title1 = compFactory.createTitle("Tag1");
        formattedTextField1 = new JFormattedTextField();
        title5 = compFactory.createTitle("Tag2");
        formattedTextField2 = new JFormattedTextField();
        title6 = compFactory.createTitle("Tag3");
        formattedTextField6 = new JFormattedTextField();

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
        button2.setText("View orderv");
        button2.addActionListener(e -> Vieworder(e));

        //---- button3 ----
        button3.setText("View Product");
        button3.addActionListener(e -> viewproduct(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(13, 13, 13)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addGroup(contentPaneLayout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(title2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)
                                        .addComponent(formattedTextField3, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(title1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                        .addComponent(title4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(formattedTextField5, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(title6, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(title3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(formattedTextField4, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(title5, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(formattedTextField2, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                                    .addComponent(formattedTextField1, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
                                .addComponent(formattedTextField6, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(button3, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                                .addComponent(button2, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)))
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
                            .addGap(28, 28, 28)
                            .addComponent(button2, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 30, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addComponent(button1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(formattedTextField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(title1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(formattedTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(title2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(formattedTextField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(title5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(formattedTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(title3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(title4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(formattedTextField5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(title6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(formattedTextField6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
                            .addContainerGap(28, Short.MAX_VALUE))))
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
    private JFormattedTextField formattedTextField3;
    private JLabel title3;
    private JFormattedTextField formattedTextField4;
    private JLabel title4;
    private JFormattedTextField formattedTextField5;
    private JButton button3;
    private JLabel title1;
    private JFormattedTextField formattedTextField1;
    private JLabel title5;
    private JFormattedTextField formattedTextField2;
    private JLabel title6;
    private JFormattedTextField formattedTextField6;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
