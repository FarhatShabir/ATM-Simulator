
package atm.samu;

/**
 *
 * @author Farhat Shabir
 */
import java.sql.*;

public class conn {
Connection c;
Statement s;
public conn(){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        c=DriverManager.getConnection("jdbc:mysql://localhost:3306/aem","root","");
        s=c.createStatement();
    }
    catch(Exception e){
        System.out.println(e);
    }
}
}
