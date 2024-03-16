package until;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Databese connect class
 */
public class DBUntils {
    private String DBURL="jdbc:mysql://localhost:3306/vendor_customer?useUnicode=true&characterEncoding=UTF8";//数据库地址
    private String DBUserName="root";
    private String DBPassword="123456";
    private String JDBCName="com.mysql.cj.jdbc.Driver";

    /**
     * 获取数据库连接
     * @return
     * @throws Exception
     */
    public Connection getCon()throws Exception{
        Class.forName(JDBCName);
        Connection con = DriverManager.getConnection(DBURL,DBUserName,DBPassword);
        return con;
    }

    /**
     * close the DB conection
     * @param connection
     * @return
     * @throws Exception
     */
    public void closeCon(Connection connection)throws Exception{
        if(connection!=null){
            connection.close();
        }
    }

    public static void main(String[] args) {
        DBUntils dbUntil=new DBUntils();
        try {
            dbUntil.getCon();
            System.out.println("数据库连接成功");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("数据库连接失败");
        }

    }
}
