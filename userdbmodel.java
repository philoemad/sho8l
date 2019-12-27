
package user;

import java.util.Vector;
import java.sql.*;

public class userdbmodel {
   
   static final String DB_URL = "jdbc:mysql://localhost:3306/social_network";
   static final String DB_DRV = "com.mysql.jdbc.Driver";
   static final String DB_USER = "root";
   static final String DB_PASSWD = "123456789";
   Connection connection = null;
   Statement statement = null;
   ResultSet resultSet = null;


   public userdbmodel() throws SQLException {

      try {
         connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
         statement = connection.createStatement();
         resultSet = statement.executeQuery("SELECT * FROM user");
         while (resultSet.next()) {
            System.out.printf("%s\t%s\t%s\t%f\n", resultSet.getString(1), resultSet.getString(2),
                  resultSet.getString(3), resultSet.getFloat(4));
         }

      } catch (SQLException ex) {
      }

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
   public void login(String name, String password) throws SQLException {
      PreparedStatement c = connection.prepareStatement("SELECT * from user WHERE username = ? and password = ?)");

      c.setString(1, name);
      c.setString(2, password);
      ResultSet i = c.executeQuery();
      if(i.next())
      {
         username = i.getString("username");
         password = i.getString("password");
         country = i.getString("country");
         name = i.getString("name");
         gender = i.getString("gender");
      }
      System.out.print("record inserted" + i);

   }

   public void makeRequest(String sender, String receiver) throws SQLException {

      PreparedStatement c = connection.prepareStatement("INSERT INTO requests(sender, receiver) VALUES(?,?)");

      c.setString(1, sender);
      c.setString(2, receiver);
      int i = c.executeUpdate();
      System.out.print("record inserted" + i);

   }



   public void addFriend(String first, String second) throws SQLException {

      PreparedStatement c = connection.prepareStatement("INSERT INTO friends(first, second) VALUES(?,?)");
      PreparedStatement d = connection.prepareStatement("DELETE FROM requests WHERE (sender = ? AND receiver = ?) OR (sender = ? AND receiver = ?)");

      
      d.setString(1, first);
      d.setString(2, second);
      d.setString(3, second);
      d.setString(4, first);
      
      c.setString(1, first);
      c.setString(2, second);
      int i = c.executeUpdate();
      d.executeUpdate();
      System.out.print("record inserted" + i);


   }

   public void declineRequest(String first, String second) throws SQLException {

      PreparedStatement d = connection.prepareStatement("DELETE FROM requests WHERE (sender = ? AND receiver = ?) OR (sender = ? AND receiver = ?)");

      
      d.setString(1, first);
      d.setString(2, second);
      d.setString(3, second);
      d.setString(4, first);
      
      int i = d.executeUpdate();
      System.out.print("record inserted" + i);


   }

   public Vector<String> getRequests(String username) throws SQLException {

      PreparedStatement c = connection.prepareStatement("SELECT sender FROM requests where receiver = ?");

      Vector<String> req = new Vector<String>();

      c.setString(1, username);
      int i = c.executeQuery();

      while (resultSet.next()) {
         req.add(resultSet.username);
      }

      return req;
   }

   public Vector<String> searchUsers(String uname) {
      
      PreparedStatement c = connection.prepareStatement("SELECT username FROM user where username = ?");

      Vector<String> users = new Vector<String>();

      c.setString(1, uname);
      resultSet = c.executeQuery();
      while (resultSet.next()) {
         users.add(resultSet.username);
      }

      return users;

   }


////////////////login///////////////////////////////
 public  usercontroller validatelogin(String name,String pass) throws SQLException{
         resultSet=statement.executeQuery("SELECT * FROM user where username='"+name+"'and password='"+pass+"'");
  usercontroller data=usercontroller.returnuser();
 int count=0;
         while(resultSet.next()){
            
          data.id =resultSet.getInt(1);
          data.name= resultSet.getString(2);
           data.username= resultSet.getString(3);
           data.password= resultSet.getString(4);
           data.gender= resultSet.getString(5);
            data.country=resultSet.getString(6);
            System.out.print("loged succes");
            
            count++;
             
        
        
    
    }if(count==0){
          System.out.print("loged failed");}
         return data;
    
    
    
}

}
