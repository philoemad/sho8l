/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apicontroller;
import user.userdbmodel;
import user.usercontroller;
import group.closedgroup;
import group.opengroup;
import chat.groupchat;
/**
 *
 * @author philo
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Apicontroller {

  

   public static void main(String[] args) throws SQLException{
       
    //userdbmodel conn=new userdbmodel();
    usercontroller b=usercontroller.returnuser();
   b= b.login("g","g");
  
//closedgroup creategroup;
//creategroup.AddMember(null, null);
   
   }
}