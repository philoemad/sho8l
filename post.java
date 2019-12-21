/*import java.util.Vector;

public class post {

  public String postcontent;

  public Integer userID;

    public Vector  myuser;
    public Vector  myapicontroller;
   

 /* public void write_post( postcontent,  userID) {
  }

  public void comment_post() {
  }
*/
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;
/**
 *
 * @author philo
 */
public class post {
        private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    public   post() {
        String url = "jdbc:mysql://localhost:3306/social_network"; //Database -> db_java
        String user = "root";
        String pass = "123456789";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pass);
            System.out.println("Connection Successful");
            conn.close();
        }catch (Exception ex){
            System.out.println("Error" + ex);
        }
    }
    
}