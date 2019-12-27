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
public class usercontroller {
public int id;
  public String username;
public String name;
    public String password;

  public String country;

  public String gender;

  public String groupname;
 private static usercontroller users;

    public Vector  myuser;
    public Vector  mymessage;
 
    public Vector  mygroup_interface;
   
    public Vector  mypost;
    
 /* public Integer addfrienduser( userID) {
  return null;
  }

  public void login( username,  password) {
  }*/
  protected usercontroller()  throws SQLException {
     
  }
  
  
  ////////////////////////////////////////register///////////////////////////////
  public void register(int id,String names,String usernames,String passwords,String genders, String countrys) throws SQLException {
     
      userdbmodel regist=new userdbmodel();
      regist.save(id,names,usernames ,passwords,genders,countrys);
      System.out.print("succesfully registed");
      
      
  }
////////////////////////////////////////////login//////////////////////////////////////////////
  public usercontroller login(String name,String password) throws SQLException {
     userdbmodel loginusers=new userdbmodel();
     usercontroller logeduser;
     logeduser=loginusers.validatelogin(name, password); 
      return logeduser;
  }
  ////////////////////////////singlton principale/////////////////////////////////////////////
  public static  usercontroller returnuser()  throws SQLException {
      if(users==null){
            return  new usercontroller();}
      return users;
  
  }

}