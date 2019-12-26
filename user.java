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

public class user extends userdbmodel {

  private static user users;
  private String username;
  private String password;
  private String country;
  private String gender;
  private String groupname;
  private Vector myuser;
  private Vector mymessage;
  private Vector mygroup_interface;
  private Vector mypost;

  /*
   * public Integer addfrienduser( userID) { return null; } public void login(
   * username, password) { }
   */
  protected user() throws SQLException {
    System.out.print("class user");
  }

  public void register(String name, String username, String password, String gender, String country)
      throws SQLException {
    this.username = usernames;
    this.password = passwords;
    this.gender = genders;
    this.country = countrys;
    userdbmodel regist = new userdbmodel();
    regist.save(name, username, password, gender, country);

  }

  public void validate() {
  }

  public static user returnuser() throws SQLException {
    if (users == null) {
      return new user();
    }
    return users;

  }

}