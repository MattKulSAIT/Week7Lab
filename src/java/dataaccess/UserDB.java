/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.util.ArrayList;
import models.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
/**
 *
 * @author mdkul
 */
//this has to be able to do everything with uses 
public class UserDB {
    public void UserDB(){
    ArrayList<User> users = new ArrayList<>();
    }
    
    public List<User> getall(){
        RoleDB roledb = new RoleDB();
        List<User> users = new ArrayList<>();
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "SELECT * FROM user";
        
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
                while(rs.next()){
                    String email = rs.getString(1);
                    String fname = rs.getString(2);
                    String lname = rs.getString(3);
                    String pass = rs.getString(4);
                    int rolenum = rs.getInt(5);
                    Role role = roledb.getRole(rolenum);
                    User user = new User(email,fname,lname,pass,role);
                    users.add(user);
                }
        }
        catch(Exception e){
            
        }
        finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        return users;
    }
    
    public void add(User user)throws Exception{
        
    }
}
