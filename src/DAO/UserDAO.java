/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.*;
import Model.User;

/**
 *
 * @author Trung
 */
public class UserDAO extends DAO{
    public UserDAO(){
        super();
    }
    public boolean checkLogin(User user){
        boolean result = false;
        String sql = "SELECT username FROM tbluser WHERE username = ? and password = ?";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                result = true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
