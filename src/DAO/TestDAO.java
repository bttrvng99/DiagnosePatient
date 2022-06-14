/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.*;
import java.util.ArrayList;
import Model.Test;
/**
 *
 * @author Trung
 */
public class TestDAO extends DAO{
    public ArrayList<Test> SearchTest(String key){
        ArrayList<Test> test = new ArrayList<Test>();
        String sql = "SELECT * from tbltest WHERE name LIKE ?";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%"+key+"%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Test t = new Test();
                t.setId(rs.getInt("id"));
                t.setName(rs.getString("name"));
                t.setCost(rs.getFloat("cost"));
                t.setRoom_num(rs.getInt("booth_num"));
                test.add(t);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return test;
    }
    
    public Test getTestbyID(int key){
        Test result = null;
        String sql = "SELECT * FROM tbltest WHERE id = ?";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, key);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Test t = new Test();
                t.setId(rs.getInt("id"));
                t.setName(rs.getString("name"));
                t.setCost(rs.getFloat("cost"));
                t.setRoom_num(rs.getInt("booth_num"));
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
    public ArrayList<Test> getAllTest(){
        ArrayList<Test> result = new ArrayList<Test>();
        String sql = "SELECT * from tbltest";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Test t = new Test();
                t.setId(rs.getInt("id"));
                t.setName(rs.getString("name"));
                t.setCost(rs.getFloat("cost"));
                t.setRoom_num(rs.getInt("booth_num"));
                result.add(t);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
