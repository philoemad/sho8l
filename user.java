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
import java.util.Vector;

/**
 *
 * @author philo
 */
public class user extends userdbmodel{

  public String username;

    public String password;

  public String country;

  public String gender;

  public String groupname;
 private static user users;

    public Vector  myuser;
    public Vector  mymessage;
 
    public Vector  mygroup_interface;
   
    public Vector  mypost;
    
 /* public Integer addfrienduser( userID) {
  return null;
  }

  public void login( username,  password) {
  }*/
  protected user()  throws SQLException {
   System.out.print("class user");}
  public void register(int id,String names,String usernames,String passwords,String genders, String countrys) throws SQLException {
      this.username=usernames;
      this.password=passwords;
      this.gender=genders;
      this.country=countrys;
      userdbmodel regist=new userdbmodel();
      regist.save( id, names, usernames, passwords, genders,  countrys);
      
      
  }

  public void validate() {
  }
  public static  user returnuser()  throws SQLException {
      if(users==null){
            return  new user();}
      return users;
  
  }

}