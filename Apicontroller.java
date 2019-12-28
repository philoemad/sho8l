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
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Apicontroller {

  

   public static void main(String[] args) throws SQLException{
       System.out.print("if signup press 1 if login press 2");
       Scanner input = new Scanner(System.in);
       int number=input.nextInt();
    //userdbmodel conn=new userdbmodel();
       if (number==1){
       usercontroller a=usercontroller.returnuser();
       a.register(4, "w", "w", "w", "w", "w");}
       else if(number==2){
           Scanner logininput = new Scanner(System.in);
           System.out.print("enter username and pass");
           String username=logininput.next();
           String pass=logininput.next();
    usercontroller b=usercontroller.returnuser();
   b= b.login(username,pass);
       System.out.print("welcome choose funtion you want to upgrade user press 1");
       }else{
        System.out.print("failed");
       }
  
//closedgroup creategroup;
//creategroup.AddMember(null, null);
   
   }
}