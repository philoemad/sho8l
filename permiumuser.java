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
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
/**
 *
 * @author philo
 */
public class permiumuser extends usercontroller {
    public permiumuser()throws SQLException{}
  public  List<String> upgradesuser = new ArrayList<>();
    
    public void upgradeuser(int fees ,usercontroller b){
    if (fees==99){
    upgradesuser.add(b.name);}
    else {System.out.print("failed");}
    }
    public boolean checkuserupgarde(String name){
         for(String str: upgradesuser) {
        if (str.contains(name)) {
            return true;
        }
    }
        return false;
}
    public void createadd(usercontroller b){
   boolean check=checkuserupgarde(b.name);}
}
