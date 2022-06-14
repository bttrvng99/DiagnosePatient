/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Date;
/**
 *
 * @author Trung
 */
public class Patient implements Serializable{
    private int id;
    private String name;
    private Date birth_date;
    private int sex;
    private String address;
    private String phone_num;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public Patient(int id, String name, Date birth_date, int sex, String address, 
            String phone_num, Date register_date, PrescriptionList prescription_list, TestList test_list) {
        this.id = id;
        this.name = name;
        this.birth_date = birth_date;
        this.sex = sex;
        this.address = address;
        this.phone_num = phone_num;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }


    public Patient() {
    }

}
