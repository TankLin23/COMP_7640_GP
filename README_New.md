
# Read me

Our project aims to provide a platform with a range of core functionalities to meet the users’ needs.


## Environment



Java Environment: `JDK11`

MySql Environment: `MYSQL 8.3`



## Demo

For this project we recommend using IDEA to open， and then, you should alter the username and password of your MYSQL setting in src/until/DBUntils:

```bash
    public class DBUntils {
        private String DBURL="jdbc:mysql://localhost:3306/vendor_customer?useUnicode=true&characterEncoding=UTF8";
        private String DBUserName="root";
        private String DBPassword="123456";
        private String JDBCName="com.mysql.cj.jdbc.Driver";
        …………………………}
```     
Then, you should execute the SQL in the project to import the database of this project.

(Tips: database name: vendor_customer)

Finally, please ensure your MYSQL service is open and you can just start the project.
