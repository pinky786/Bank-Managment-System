package bank_management_system;
import java.sql.*;

public class conn {
    Connection c;
    Statement s;
    public conn(){

        try{
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","Aine@786");
            s=c.createStatement();

        }catch (Exception e){
            System.out.println(e);
        }
    }
}
