/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import Model.Diagnosis;
import Model.PrescriptionList;
import Model.TestList;
import Model.Patient;
/**
 *
 * @author Trung
 */
public class DiagnosisDAO extends DAO{
    
    public void addDiagnosis(Diagnosis d){
        String sqlAddDiagnosis = "INSERT INTO tbldiagnosis values(?,?,?,?,?,?, ?);";
        String sqlAddTest = "INSERT INTO tbltestlist values (?,?);";
        String sqlAddPrescription = "INSERT INTO tblprescriptionlist values(?,?,?);";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try{
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sqlAddDiagnosis, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, d.getId());
            ps.setInt(2, d.getPatient().getId());
            ps.setString(3, d.getSymptoms());
            ps.setString(4, d.getResults());
            ps.setString(5, d.getConclusion());
            ps.setString(6, d.getStatus());
            ps.setString(7, sdf.format(d.getRegister_date()));
            ps.executeUpdate();
            ResultSet generated_keys = ps.getGeneratedKeys();
            if(generated_keys.next()){
//                d.setId(generated_keys.getInt(1));
                for(TestList tl: d.getTest_list()){
                    ps = conn.prepareStatement(sqlAddTest, Statement.RETURN_GENERATED_KEYS);
                    ps.setInt(1, d.getId());
                    ps.setInt(2, tl.getTest().getId());
                    ps.executeUpdate();
                }
                for(PrescriptionList pl: d.getPre_list()){
                    ps = conn.prepareStatement(sqlAddPrescription, Statement.RETURN_GENERATED_KEYS);
                    ps.setInt(1, d.getId());
                    ps.setInt(2, pl.getPrescription().getId());
                    ps.setInt(3, pl.getQuantity());
                    ps.executeUpdate();
                }
            }
        } catch(Exception e){
            try{
                conn.rollback();
                System.out.println("Something's wrong!");
            } catch(Exception ex){
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try{
                
            } catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }
    
    public int GetDiagnosisID(){
        int d_id = 0;
        String sql = "SELECT count(*) FROM tbldiagnosis;";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                d_id = rs.getInt("count(*)");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return d_id;
    }
}
