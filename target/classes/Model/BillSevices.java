/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author couni
 */
public class BillSevices {
    private int ID;
    private int MedicalExamintionID;
    private int EmployeeID;
    private Date BillDate;
    private int Price;

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * @return the MedicalExamintionID
     */
    public int getMedicalExamintionID() {
        return MedicalExamintionID;
    }

    /**
     * @param MedicalExamintionID the MedicalExamintionID to set
     */
    public void setMedicalExamintionID(int MedicalExamintionID) {
        this.MedicalExamintionID = MedicalExamintionID;
    }

    /**
     * @return the EmployeeID
     */
    public int getEmployeeID() {
        return EmployeeID;
    }

    /**
     * @param EmployeeID the EmployeeID to set
     */
    public void setEmployeeID(int EmployeeID) {
        this.EmployeeID = EmployeeID;
    }

    /**
     * @return the BillDate
     */
    public Date getBillDate() {
        return BillDate;
    }

    /**
     * @param BillDate the BillDate to set
     */
    public void setBillDate(Date BillDate) {
        this.BillDate = BillDate;
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
