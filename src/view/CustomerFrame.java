package view;

import java.awt.event.*;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;
import com.jgoodies.forms.factories.*;
import dao.*;
import model.Order;
import model.OrderItem;
import until.DBUntils;
/*
 * Created by JFormDesigner on Thu Mar 14 17:04:44 CST 2024
 */



/**
 * @author 10468
 */
public class CustomerFrame extends JFrame {
    DBUntils dbUntils=new DBUntils();
    ProductDao productDao=new ProductDao();
    VendorDao vendorDao=new VendorDao();
    OrderDao orderDao=new OrderDao();
    OrderItemDao orderItemDao=new OrderItemDao();
    public CustomerFrame() {
        initComponents();
    }
    //还未调试
    private void SearchProductBytag(ActionEvent e) {
        Connection conn = null;
        try{     //Connect to the database and display the content
            conn=dbUntils.getCon();
            String search_tag=tag.getText();
            ResultSet r = productDao.get_product_by_tag(conn,search_tag);
            DefaultTableModel model = new DefaultTableModel();
            //这里我不知道你的数据库字段怎么加的，明天看看
            model.setColumnIdentifiers(new Object[]{ "product_name", "product_price","inventory","geographical_presence","Tag1","business_name"});
            while (r.next()) {
                Vector<Serializable> vector = new Vector<>();
                vector.add(r.getString(1));
                vector.add(r.getFloat(2));
                vector.add(r.getInt(3));
                vector.add(r.getString(4));
                vector.add(r.getString(5));
                vector.add(r.getString(6));
                model.addRow(vector);
            }
            table1.setModel(model);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private void SearchVendorName(ActionEvent e) {
        Connection conn = null;
        try{     //Connect to the database and display the content
            conn=dbUntils.getCon();
            String vendor_name=vendor_textfield.getText();
            ResultSet r = vendorDao.checkvendor(conn);
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(new Object[]{"vendor_id", "business_name", "feedback_score","geographical_presence"});
            while (r.next()) {
                Vector<Serializable> vector = new Vector<>();
                vector.add(r.getInt(1));
                vector.add(r.getInt(2));
                vector.add(r.getString(3));
                vector.add(r.getFloat(4));
                model.addRow(vector);
            }
            table1.setModel(model);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
//这个业务好复杂，明天再看看
    private void Buy(ActionEvent e) {
        //需要级联更新
        Connection conn = null;
        try{     //Connect to the database and display the content
            conn=dbUntils.getCon();
            //拿到复选框选择的商品记录，俺不会，交给你了

            //封装对象
            Order order=new Order();//靠你了
            OrderItem orderItem=new OrderItem();
            int insertresult=orderDao.add(conn,order);
            //如果成功插入就继续插订单项记录
            if (insertresult!=0){
                int r=orderItemDao.add(conn,orderItem);
                if (r!=0){
                    //成功
                   JOptionPane.showMessageDialog(null,"SUCCESS BUY");
                }
                else {
                    //失败则回滚
                    int fail=orderDao.delete(conn,order);
                    JOptionPane.showMessageDialog(null,"Fail to Process");
                }
            }
            else {
                JOptionPane.showMessageDialog(null,"Fail to Process");
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private void ViewHistory(ActionEvent e) {
        //查看历史纪录方法已经写好，不知道你要怎么填进去，你来你来
        PurchaseRecord PR = new PurchaseRecord();
        PR.setVisible(true);
    }

    private void ViewOngoingDeals(ActionEvent e) {
        //同上
        ViewOngoingDeals VOD = new ViewOngoingDeals();
        VOD.setVisible(true);
    }

    private void feedback(ActionEvent e) {
        Connection connection=null;
        try{
            connection=dbUntils.getCon();
            // 获取表格中vendor记录中的id，要你来看看怎么获取
            String vid=null;
            //应该分加和减吧,点击正向+feedback，负向-feedback
            String [] options={"positive","negative"};
            int feedbackOption=JOptionPane.showOptionDialog(null,"what feedback do you want to give","feedback",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
            if (feedbackOption==0){
                //给他加分
                int result= vendorDao.feedback_positive(connection,vid);
                if (result!=0){
                    JOptionPane.showMessageDialog(null,"Feedback Finish");
                }
            }
            //给他减分
            int r= vendorDao.feedback_negative(connection,vid);
            if (r!=0){
                JOptionPane.showMessageDialog(null,"Feedback Finish");

            }

        }catch (Exception ex) {
            throw new RuntimeException(ex);
        }


    }

    private void SearchProductName(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        DefaultComponentFactory compFactory = DefaultComponentFactory.getInstance();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        tag = new JFormattedTextField();
        title3 = compFactory.createTitle("Tag");
        button5 = new JButton();
        vendor_textfield = new JFormattedTextField();
        title4 = compFactory.createTitle("Vendor name");
        button6 = new JButton();
        title5 = compFactory.createTitle("Please enter the quantity purchased");
        formattedTextField5 = new JFormattedTextField();
        button7 = new JButton();
        button8 = new JButton();
        button9 = new JButton();
        button1 = new JButton();

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
        button5.setText("Search ");
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

        //---- button1 ----
        button1.setText("feedback");
        button1.addActionListener(e -> feedback(e));

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
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(23, 23, 23)
                                    .addComponent(title4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(vendor_textfield, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(36, 36, 36)
                                    .addComponent(title3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tag, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)))
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
                    .addGap(0, 70, Short.MAX_VALUE))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(147, 147, 147)
                    .addComponent(button6, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                    .addComponent(button1, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(104, Short.MAX_VALUE))
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
                                .addComponent(tag, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(title3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(button5)
                            .addGap(4, 4, 4)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(title4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(vendor_textfield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(button9)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(button1)))
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JScrollPane scrollPane1;
    private JTable table1;
    private JFormattedTextField tag;
    private JLabel title3;
    private JButton button5;
    private JFormattedTextField vendor_textfield;
    private JLabel title4;
    private JButton button6;
    private JLabel title5;
    private JFormattedTextField formattedTextField5;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
