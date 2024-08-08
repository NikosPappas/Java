/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registrationform;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;
import java.sql.ResultSet;
/**
 *
 * @author nikos-pappas
 */
public class UserDAO {
    public static Connection getConnection(){
        Connection con=null;
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mariadb://localhost:3306/register","nikos-pappas","123456");
            return con;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
    public static int save(User user){
        int status=0;
        try(Connection connection=UserDAO.getConnection()){
            try(
            PreparedStatement ps=connection.prepareStatement("INSERT INTO user(first_name,last_name,birthdate,email,phone_number,username,password)"
                    + "VALUES(?,?,?,?,?,?,?);")){
            ps.setString(1, user.getFirst_name());
            ps.setString(2,user.getLast_name());
            ps.setString(3, user.getBirthdate());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getPhone_number());
            ps.setString(6, user.getUsername());
            ps.setString(7, user.getPassword());
            status=ps.executeUpdate();
            }
        }
            
        catch(Exception e){
        }
        return status;
    }
    public static int update(User user){
        int status=0;
        try(Connection connection=UserDAO.getConnection()){
        try(PreparedStatement ps=connection.prepareStatement(
                "UPDATE user SET first_name=?,last_name=?,email=?,phone_number=?,password=? WHERE username=?;")){
            ps.setString(1, user.getFirst_name());
            ps.setString(2,user.getLast_name());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPhone_number());
            ps.setString(5, user.getPassword());
            ps.setString(6, user.getUsername());
            status=(int)ps.executeUpdate();
        }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return status;
    }
    public static int deleteUser(String username,String email,String password){
        int status=0;
        try(Connection connection=UserDAO.getConnection()){
            try(var ps=connection.prepareStatement("DELETE FROM user WHERE username=? AND email=? AND password=?;")){
            ps.setString(1, username);
            ps.setString(2, email);
            ps.setString(3, password);
            status=ps.executeUpdate();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return status;
    }
    public static List<User> getAllUsers(){
        List<User> users=new ArrayList<User>();
        try(Connection connection=UserDAO.getConnection()){
            try(var ps=connection.prepareStatement("SELECT * FROM user;")){
            try(var rs=ps.executeQuery()){
            while(rs.next()){
                User user=new User();
                user.setId(rs.getInt("user_id"));
                user.setFirst_name(rs.getString("first_name"));
                user.setLast_name(rs.getString("last_name"));
                user.setBirthdate(rs.getString("birthdate"));
                user.setEmail(rs.getString("email"));
                user.setPhone_number(rs.getString("phone_number"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                users.add(user);
            }
            }
            }
        }
        catch(Exception e){
            
        }
        return users;
    }
    public static boolean userExists(String username){
        boolean exists=false;
        int ret=-1;
            try(Connection connection=UserDAO.getConnection()){
            try(PreparedStatement ps=connection.prepareStatement("SELECT *FROM user WHERE username=?")){
            ps.setString(1,username);
            exists=ps.execute();
          }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return exists;
    }
    public static int login(String username,String password){
        int status=0;
        try(Connection connection=UserDAO.getConnection()){
            try(PreparedStatement ps=connection.prepareStatement("SELECT * FROM user WHERE username=? AND password=?;")){
                ps.setString(1, username);
                ps.setString(2, password);
                boolean ret=ps.execute();
                if(ret==true){
                    status=1;
                    return status;
                }
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
            return status;
    }
    
}
