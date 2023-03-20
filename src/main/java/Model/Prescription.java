/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;

/**
 *
 * @author couni
 */
public class Prescription { // Phiếu nhận thuốc
    private int ID;
    private String PrescriptName;
    private int StaffID;
    private int PatientID;
    private Date ReceivedDate;
    private int Price;

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @return the PrescriptName
     */
    public String getPrescriptName() {
        return PrescriptName;
    }

    /**
     * @param PrescriptName the PrescriptName to set
     */
    public void setPrescriptName(String PrescriptName) {
        this.PrescriptName = PrescriptName;
    }

    /**
     * @return the StaffID
     */
    public int getStaffID() {
        return StaffID;
    }

    /**
     * @param StaffID the StaffID to set
     */
    public void setStaffID(int StaffID) {
        this.StaffID = StaffID;
    }

    /**
     * @return the PatientID
     */
    public int getPatientID() {
        return PatientID;
    }

    /**
     * @param PatientID the PatientID to set
     */
    public void setPatientID(int PatientID) {
        this.PatientID = PatientID;
    }

    /**
     * @return the ReceivedDate
     */
    public Date getReceivedDate() {
        return ReceivedDate;
    }

    /**
     * @param ReceivedDate the ReceivedDate to set
     */
    public void setReceivedDate(Date ReceivedDate) {
        this.ReceivedDate = ReceivedDate;
    }

    /**
     * @return the Price
     */
    public int getPrice() {
        return Price;
    }

    /**
     * @param Price the Price to set
     */
    public void setPrice(int Price) {
        this.Price = Price;
    }
    
    
}
