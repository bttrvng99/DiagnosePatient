/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.*;
import java.util.ArrayList;
import Model.Patient;
/**
 *
 * @author Trung
 */
public class PatientDAO extends DAO{
    public ArrayList<Patient> searchPatient(String key){
        ArrayList<Patient> result = new ArrayList<Patient>();
        String sql = "SELECT * FROM tblpatient WHERE name LIKE ?";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + key + "%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Patient p = new Patient();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setAddress(rs.getString("address"));
                p.setPhone_num(rs.getString("phone_num"));
                p.setSex(rs.getInt("sex"));
                p.setBirth_date(rs.getDate("birth_date"));
                result.add(p);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
    
    public Patient getPatientByID(int key){
        Patient pa = null;
        String sql = "SELECT * FROM tblpatient WHERE id =?";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, key);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                pa = new Patient();
                pa.setId(rs.getInt("id"));
                pa.setName(rs.getString("name"));
                pa.setAddress(rs.getString("address"));
                pa.setPhone_num(rs.getString("phone_num"));
                pa.setSex(rs.getInt("sex"));
                pa.setBirth_date(rs.getDate("birth_date"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return pa;
    }
    
    public ArrayList<Patient> getAllPatient(){
        ArrayList<Patient> result = new ArrayList<Patient>();
        String sql = "SELECT * FROM tblpatient";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Patient p = new Patient();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setAddress(rs.getString("address"));
                p.setPhone_num(rs.getString("phone_num"));
                p.setSex(rs.getInt("sex"));
                p.setBirth_date(rs.getDate("birth_date"));
                result.add(p);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
