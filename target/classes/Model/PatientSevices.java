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
public class PatientSevices {
    private int ID;
    private int SevicesID;
    private int BillSevicesID;
    private Date StartDate;
    private Date EndDate;
    private String Decription;
    private String Result;
    private String Note;

    
    
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
     * @return the SevicesID
     */
    public int getSevicesID() {
        return SevicesID;
    }

    /**
     * @param SevicesID the SevicesID to set
     */
    public void setSevicesID(int SevicesID) {
        this.SevicesID = SevicesID;
    }

    /**
     * @return the StartDate
     */
    public Date getStartDate() {
        return StartDate;
    }

    /**
     * @param StartDate the StartDate to set
     */
    public void setStartDate(Date StartDate) {
        this.StartDate = StartDate;
    }

    /**
     * @return the EndDate
     */
    public Date getEndDate() {
        return EndDate;
    }

    /**
     * @param EndDate the EndDate to set
     */
    public void setEndDate(Date EndDate) {
        this.EndDate = EndDate;
    }

    /**
     * @return the Decription
     */
    public String getDecription() {
        return Decription;
    }

    /**
     * @param Decription the Decription to set
     */
    public void setDecription(String Decription) {
        this.Decription = Decription;
    }

    /**
     * @return the Result
     */
    public String getResult() {
        return Result;
    }

    /**
     * @param Result the Result to set
     */
    public void setResult(String Result) {
        this.Result = Result;
    }

    /**
     * @return the Note
     */
    public String getNote() {
        return Note;
    }

    /**
     * @param Note the Note to set
     */
    public void setNote(String Note) {
        this.Note = Note;
    }

    /**
     * @return the BillSevicesID
     */
    public int getBillSevicesID() {
        return BillSevicesID;
    }

    /**
     * @param BillSevicesID the BillSevicesID to set
     */
    public void setBillSevicesID(int BillSevicesID) {
        this.BillSevicesID = BillSevicesID;
    }
    
    
}
