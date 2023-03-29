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
public class BillPrescription { 

    // Phiếu nhận thuốc
    private int ID;
    private String PrescriptName;
    private int EmployeeID;
    private int PatientID;
    private Date CreateDate;
    private Date ReceivedDate;
    private int ToTalPrice;
    private int Note;
    /**
     * @return the CreateDate
     */
    public Date getCreateDate() {
        return CreateDate;
    }

    /**
     * @param CreateDate the CreateDate to set
     */
    public void setCreateDate(Date CreateDate) {
        this.CreateDate = CreateDate;
    }

    /**
     * @return the ToTalPrice
     */
    public int getToTalPrice() {
        return ToTalPrice;
    }

    /**
     * @param ToTalPrice the ToTalPrice to set
     */
    public void setToTalPrice(int ToTalPrice) {
        this.ToTalPrice = ToTalPrice;
    }


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
    public int getEmployeeID() {
        return EmployeeID;
    }

    /**
     * @param EmployeeID the StaffID to set
     */
    public void setEmployeeID(int EmployeeID) {
        this.EmployeeID = EmployeeID;
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
    public int getNote() {
        return Note;
    }

    /**
     * @param Note the Price to set
     */
    public void setNote(int Note) {
        this.Note = Note;
    }
    
    
}
