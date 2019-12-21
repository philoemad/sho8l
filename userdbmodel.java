/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;
/**2
 *
 * @author philo
 */
public class userdbmodel {
     static final String DB_URL =
      "jdbc:mysql://localhost:3306/social_network";
   static final String DB_DRV =
      "com.mysql.jdbc.Driver";
   static final String DB_USER = "root";
   static final String DB_PASSWD = "123456789";
       Connection connection = null;
      Statement statement = null;
      ResultSet resultSet = null;
    public userdbmodel() throws SQLException{
      
      

      try{
         connection=DriverManager.getConnection
            (DB_URL,DB_USER,DB_PASSWD);
         statement=connection.createStatement();
         resultSet=statement.executeQuery
            ("SELECT * FROM user");
         while(resultSet.next()){
            System.out.printf("%s\t%s\t%s\t%f\n",
            resultSet.getString(1),
            resultSet.getString(2),
            resultSet.getString(3),
            resultSet.getFloat(4));
         }

      }catch(SQLException ex){
      }/*finally{
         try {
            resultSet.close();
            statement.close();
            connection.close();
         } catch (SQLException ex) {
         }
      }*/
     
      
}
    public void save(int id,String names,String usernames,String passwords,String genders, String countrys) throws SQLException{
        PreparedStatement c=connection.prepareStatement("Insert into user values(?,?,?,?,?,?)");
      
        c.setInt(1, id);
        c.setString(2, names);
        c.setString(3, usernames);
        c.setString(4,passwords);
         c.setString(5,genders);
          c.setString(6,countrys);
        int i=c.executeUpdate();
        System.out.print("record inserted"+i);
    
    }
    
}
