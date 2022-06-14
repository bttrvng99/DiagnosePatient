/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author Trung
 */
public class Diagnosis {
    private String symptoms;
    private String Results;
    private String Conclusion;
    private String status;
    private int id;
    private Patient patient;
    private ArrayList<TestList> test_list;
    private ArrayList<PrescriptionList> pre_list;
    private Date register_date;
    
    public Diagnosis(){
        super();
        test_list = new ArrayList<TestList>();
        pre_list = new ArrayList<PrescriptionList>();
    }

    public ArrayList<TestList> getTest_list() {
        return test_list;
    }

    public void setTest_list(ArrayList<TestList> test_list) {
        this.test_list = test_list;
    }

    public ArrayList<PrescriptionList> getPre_list() {
        return pre_list;
    }

    public void setPre_list(ArrayList<PrescriptionList> pre_list) {
        this.pre_list = pre_list;
    }


    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getResults() {
        return Results;
    }

    public void setResults(String Results) {
        this.Results = Results;
    }

    public String getConclusion() {
        return Conclusion;
    }

    public void setConclusion(String Conclusion) {
        this.Conclusion = Conclusion;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Diagnosis(String symptoms, String Results, String Conclusion, String status, int id, Patient patient, ArrayList<TestList> test_list, ArrayList<PrescriptionList> pre_list, Date register_date) {
        this.symptoms = symptoms;
        this.Results = Results;
        this.Conclusion = Conclusion;
        this.status = status;
        this.id = id;
        this.patient = patient;
        this.test_list = test_list;
        this.pre_list = pre_list;
        this.register_date = register_date;
    }

    public Date getRegister_date() {
        return register_date;
    }

    public void setRegister_date(Date register_date) {
        this.register_date = register_date;
    }

}
