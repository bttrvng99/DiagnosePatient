/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.*;
import java.util.ArrayList;
import Model.Prescription;

/**
 *
 * @author Trung
 */
public class PrescriptionDAO extends DAO{
    public ArrayList<Prescription> SearchPrescription(String key){
        ArrayList<Prescription> result = new ArrayList<Prescription>();
        String sql = "SELECT * FROM tblprescription WHERE name like ?";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "&"+key+"&");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Prescription p = new Prescription();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setPrice(rs.getFloat("price"));
                p.setInfo(rs.getString("info"));
                result.add(p);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
    
    public Prescription getPrescriptionbyID(int key){
        Prescription pc = null;
        String sql = "SElECT * FROM tblprescription WHERE id =?";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, key);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Prescription p = new Prescription();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setPrice(rs.getFloat("price"));
                p.setInfo(rs.getString("info"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return pc;
    }
    
    public ArrayList<Prescription> getAllPrescription(){
        ArrayList<Prescription> result = new ArrayList<Prescription>();
        String sql = "SELECT * FROM tblprescription";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Prescription p = new Prescription();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setPrice(rs.getFloat("price"));
                p.setInfo(rs.getString("info"));
                result.add(p);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
