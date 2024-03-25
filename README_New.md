
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
![725df695d71307093e00ca76e312173](https://github.com/TankLin23/COMP_7640_GP/assets/148514713/0dd7e321-0d18-4008-828d-b39e6e313857)
![42819df66b07eb574ea4109c349316f](https://github.com/TankLin23/COMP_7640_GP/assets/148514713/5a243bfc-ab94-4657-8a64-499acc382e8f)


Finally, please ensure your MYSQL service is open and you can just start the project.
![f8116bacb7c5086fd2ceb0eb72933a6](https://github.com/TankLin23/COMP_7640_GP/assets/148514713/16f45cd1-5c38-4bd3-9294-b4e444f2ac6b)
### vendor interface
Users can enter into a vendor management interface to select the existing vendors or onboard new 
vendors by clicking "Sign in" button. 
![image](https://github.com/TankLin23/COMP_7640_GP/assets/148514713/20585a6d-e7aa-400c-927b-8bb7d1236207)

Next, users can login to the specific vendor account to browse the products information. In this process, users can introduce new products to the vendor’s catalogue and modify the product information as well.
![image](https://github.com/TankLin23/COMP_7640_GP/assets/148514713/7b624c1f-2ff5-4424-ac4b-8d0cabb307f8)
### customer interface
Returning to the customer interface, users can search for products based on tags and make purchases. After purchasing, product quantity will decrease and users can check their deals history which is also showed in the vendor interface. Before shipment, users can process for purchase cancelling and the cancelling records will be both changed in customer and vendor interface. Cancellation is not allowed after shipment.
![image](https://github.com/TankLin23/COMP_7640_GP/assets/148514713/36c8b133-0953-45b6-a79d-a30bbf8b270c)
Besides, we have provided a rating function for customers so that vendor scan see the feedback score for each order in the history records.
![image](https://github.com/TankLin23/COMP_7640_GP/assets/148514713/f03e63c9-6d8e-4385-9f2b-93b401837794)





