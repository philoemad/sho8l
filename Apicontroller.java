/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apicontroller;
import user.userdbmodel;
import user.user;
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
    user b=user.returnuser();
    b.register(3,"g","g", "g", "g", "g");
   
   
   }
}