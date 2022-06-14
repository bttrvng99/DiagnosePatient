/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.io.Serializable;
/**
 *
 * @author Trung
 */
public class PrescriptionList {
    private int quantity;
    private Prescription prescription;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public PrescriptionList() {
    }

    public PrescriptionList(int quantity, Prescription prescription) {
        this.quantity = quantity;
        this.prescription = prescription;
    }
    
}
